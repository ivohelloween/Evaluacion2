package com.imunoz.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class OpcionesReserva extends AppCompatActivity {
    private Button botonReloj;
    private TextView textoHora;
    private TextView tipoCancha;
    private int hora, minuto;
    private TextView etiqueta;
    DatePicker calendarioSpinner;
    private Cuenta nuevo;
    ArrayList<Reserva> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_reserva);
        botonReloj = findViewById(R.id.botonReloj);
        textoHora = findViewById(R.id.etiquetaHora);
        etiqueta = findViewById(R.id.etiquetaIntent);
        tipoCancha = findViewById(R.id.entradaTipoCancha);


        lista = new ArrayList<Reserva>();
        calendarioSpinner = findViewById(R.id.calendarioSpinner);
        Calendar calendario = Calendar.getInstance();

        nuevo = (Cuenta) getIntent().getSerializableExtra("cuenta");
        etiqueta.setText("Reserva Hora: "+ nuevo.getNombre()+" "+nuevo.getApellido());

        calendarioSpinner.updateDate(calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH));




    }



    private String NombreMes(int mes){
        switch(mes){
            case 1:
                return "ENE";
            case 2:
                return "FEB";
            case 3:
                return "MAR";
            case 4:
                return "ABR";
            case 5:
                return "MAY";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AGO";
            case 9:
                return "SEP";
            case 10:
                return "OCT";
            case 11:
                return "NOV";
            case 12:
                return "DIC";
            default:
                return "ENE";
        }
    }



    public void ReservarHora(View view) {
        int error = 0;
        if(textoHora.getText().toString().equals("")){
            error++;
        }
        if(tipoCancha.getText().toString().equals("")){
            error++;
        }


        if(error>0){
            Toast.makeText(OpcionesReserva.this, "Debe completar campos requeridos", Toast.LENGTH_LONG).show();
        }else{
            String fecha = calendarioSpinner.getDayOfMonth()+" - "+NombreMes(calendarioSpinner.getMonth()+1)+" - "+calendarioSpinner.getYear();
            Log.d("myTag", fecha);
            Log.d("myTag", textoHora.getText().toString());
            Log.d("myTag", tipoCancha.getText().toString());
            StringBuilder str = new StringBuilder();

            str.append("Los datos de su reserva son:");
            str.append("\nFecha: "+fecha);
            str.append("\nHora: "+textoHora.getText().toString());
            str.append("\nTipoCancha: "+tipoCancha.getText().toString());

            new AlertDialog.Builder(this)

                    .setTitle("Confirmación de reserva")
                    .setMessage(str.toString())
                    .setCancelable(true)

                    .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Reserva r = new Reserva();
                            r.setHora(textoHora.getText().toString());
                            r.setFecha(fecha);
                            r.setTipoCancha(tipoCancha.getText().toString()); //Corregi a las 17:25

                            lista.add(r);
                            nuevo.setListaReservas(lista);

                            Toast.makeText(OpcionesReserva.this, "Registro ingresado com éxito.", Toast.LENGTH_LONG).show();
                            //finish();
                        }
                    })

                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    })

                    .create()
                    .show();


        }





    }

    public void seleccionarHora(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int horaSeleccionada, int minutoSeleccinado) {
                hora = horaSeleccionada;
                minuto = minutoSeleccinado;

                //botonReloj.setText(hora+":"+minuto);
                botonReloj.setText(String.format(Locale.getDefault(), "%02d:%02d", hora, minuto));

                if(hora > 12){
                    textoHora.setText((hora-12)+":"+minuto+" PM");
                } else {
                    textoHora.setText(hora+":"+minuto+" AM");
                }

                Toast.makeText(OpcionesReserva.this, "La hora es: "+hora+":"+minuto, Toast.LENGTH_LONG).show();
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hora, minuto,false);
        timePickerDialog.show();
    }

    public void verReservas(View view) {
        StringBuilder str = new StringBuilder();
        if(lista.size()==0){
            Toast.makeText(OpcionesReserva.this, "El usuario no tiene reservas.", Toast.LENGTH_LONG).show();
        }else{


            Intent intent = new Intent(this, ListarReservas.class);
            intent.putExtra("reservas", lista);
            startActivity(intent);






        }



    }
}