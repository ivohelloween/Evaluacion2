package com.imunoz.evaluacion1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarUsuario extends AppCompatActivity {

    private TextView entradaNombre, entradaApellido, entradaContraseña;
    private Cuenta cuentaNueva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        entradaNombre = findViewById(R.id.entradaFecha);
        entradaApellido = findViewById(R.id.entradaHora);
        entradaContraseña = findViewById(R.id.entradaTipoCancha);




    }

    public void CrearUsuario(View view){
        int error = 0;
        if(entradaNombre.getText().toString().equals("")){
            error++;
        }
        if(entradaApellido.getText().toString().equals("")){
            error++;
        }
        if(entradaContraseña.getText().toString().equals("")){
            error++;
        }

        if(error>0){
            Toast.makeText(RegistrarUsuario.this, "Debe completar campos requeridos", Toast.LENGTH_LONG).show();
        }else{
            cuentaNueva = new Cuenta(entradaNombre.getText().toString(), entradaApellido.getText().toString());
            Intent intent = new Intent(this, OpcionesReserva.class);
            intent.putExtra("cuenta", cuentaNueva);
            startActivity(intent);
        }


    }

}