package com.imunoz.evaluacion1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MostrarNoticia extends AppCompatActivity {
    private Noticias noticia;
    private TextView titulo, texto,entradaUbicacion;
    private Cuenta cuentaNueva;
    private Button textoUbicacion;
    private ImageView fotito;
    private ArrayList<Noticias> listaNoticias;
    private Foto foto;
    private Ubicacion ubicacion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_noticia);

        noticia = (Noticias) getIntent().getSerializableExtra("noticia");

        titulo = findViewById(R.id.entradaFecha);
        texto = findViewById(R.id.entradaHora);
        textoUbicacion = findViewById(R.id.textoUbicacion);
        fotito = findViewById(R.id.fotografia2);
        entradaUbicacion= findViewById(R.id.entradaUbicacion);
        titulo.setText(noticia.getTitulo());
        texto.setText(noticia.getTexto());
        //textoUbicacion.setText(noticia.getUbicacion().GetLatitudLongitud());
        fotito.setImageBitmap(noticia.getFoto().getBitmap().getBitmap() );
        entradaUbicacion.setText( noticia.getUbicacion().GetLatitudLongitud());



    }

    public void mostrarMap(View view) {

        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("ubicacion", noticia.getUbicacion());
        startActivityForResult(intent, 100);


    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                //ubicacion = (Ubicacion) data.getSerializableExtra("ubicacion");


            }
        }




    }


}