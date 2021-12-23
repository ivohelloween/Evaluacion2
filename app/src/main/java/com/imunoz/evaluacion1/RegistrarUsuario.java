package com.imunoz.evaluacion1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class RegistrarUsuario extends AppCompatActivity {

    private TextView titulo, texto;
    private Cuenta cuentaNueva;
    private Button textoUbicacion;
    private ImageView fotito;
    private ArrayList<Noticias> listaNoticias;
    private Foto foto;
    private Ubicacion ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        titulo = findViewById(R.id.entradaFecha);
        texto = findViewById(R.id.entradaHora);

        textoUbicacion = findViewById(R.id.textoUbicacion);
        fotito = findViewById(R.id.fotografia2);

        listaNoticias = new ArrayList<Noticias>();

    }

    public void CrearUsuario(View view){

  /*



        if(error>0){
            Toast.makeText(RegistrarUsuario.this, "Debe completar campos requeridos", Toast.LENGTH_LONG).show();
        }else{
            cuentaNueva = new Cuenta(entradaNombre.getText().toString(), entradaApellido.getText().toString());
            Intent intent = new Intent(this, OpcionesReserva.class);
            intent.putExtra("cuenta", cuentaNueva);
            startActivity(intent);
        }
*/

        int error = 0;
        if(titulo.getText().toString().equals("")){
            error++;
        }
        if(texto.getText().toString().equals("")){
            error++;
        }
        if(ubicacion==null){
            error++;
        }

        if(foto==null){
            error++;
        }
        if(error>0){
            Toast.makeText(RegistrarUsuario.this, "Debe completar campos requeridos", Toast.LENGTH_LONG).show();
        }else{
            Noticias n = new Noticias();
            n.setFoto(foto);
            n.setUbicacion(ubicacion);
            n.setTitulo(titulo.getText().toString());
            n.setTexto(texto.getText().toString());
            listaNoticias.add(n);
            Toast.makeText(RegistrarUsuario.this, "Noticia Agregada "  , Toast.LENGTH_LONG).show();


        }



    }




    public void BuscarUbicacion(View view){
        Intent intent = new Intent(this, MapsActivity.class);

        intent.putExtra("ubicacion", new Ubicacion());

        startActivityForResult(intent, 100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                ubicacion = (Ubicacion) data.getSerializableExtra("ubicacion");
                if(ubicacion!=null){
                    textoUbicacion.setText("Ubicación seleccionada: "+ubicacion.GetLatitudLongitud());
                }

            }
        }
        if(requestCode == 200){
            if(resultCode == RESULT_OK){

                foto = (Foto) data.getSerializableExtra("foto");
                if(foto.getBitmap()!=null){
                    fotito.setImageBitmap(foto.getBitmap().getBitmap() );
                }


            }
        }



    }


    public void IngresarFoto(View view) {
        Intent intent = new Intent(this, CargarFoto.class);
        startActivityForResult(intent, 200);

    }

    public void ListarNoticias(View view) {

        StringBuilder str = new StringBuilder();
        if(listaNoticias.size()==0){
            Toast.makeText(RegistrarUsuario.this, "No hay noticias ingresadas.", Toast.LENGTH_LONG).show();
        }else {

            Intent intent = new Intent(this, ListarReservas.class);
            intent.putExtra("noticias", listaNoticias);
            startActivity(intent);
        }
    }
}