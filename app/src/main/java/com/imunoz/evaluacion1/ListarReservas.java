package com.imunoz.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarReservas extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adaptador adaptador;
    private ArrayList<Noticias> noticias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_reservas);

        noticias = (ArrayList<Noticias>) getIntent().getSerializableExtra("noticias");

        adaptador = new Adaptador(noticias);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);



    }
}