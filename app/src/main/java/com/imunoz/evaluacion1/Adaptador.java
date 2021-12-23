package com.imunoz.evaluacion1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder>{
    public ArrayList<Noticias> noticias;
    public Adaptador(ArrayList<Noticias> noticias){
        this.noticias = noticias;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta, parent, false);
        return new ViewHolder(view).enlaceAdaptador(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.foto.setImageResource(R.drawable.ic_launcher_background);
        holder.titulo.setText(noticias.get(position).getTitulo() );
        holder.texto.setText(noticias.get(position).getTexto());
        holder.tipoCancha.setText(noticias.get(position).getUbicacion().GetLatitudLongitud());
        holder.foto.setImageBitmap(noticias.get(position).getFoto().getBitmap().getBitmap() );


       // holder.texto.setText(reservas.get(position).getTipoCancha());


        holder.noticias = noticias.get(position);

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.foto.getContext(), "asdf", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView titulo, texto,tipoCancha;
        private Button botonNumero, botonEliminar;
        private Noticias noticias;
        private Adaptador adaptador;

        public ViewHolder(View itemView){
            super(itemView);

            foto = itemView.findViewById(R.id.foto);
            titulo = itemView.findViewById(R.id.titulo);
            texto = itemView.findViewById(R.id.texto);
            tipoCancha = itemView.findViewById(R.id.tipoCancha);
            botonNumero = itemView.findViewById(R.id.botonNumeros);
            botonEliminar = itemView.findViewById(R.id.botonEliminar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Evento click sobre item", Toast.LENGTH_LONG).show();
                }
            });

            botonNumero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    StringBuilder sb =new StringBuilder();
                    sb.append("----Noticia----");
                    sb.append("\n Titulo:"+adaptador.noticias.get(getAdapterPosition()).getTitulo());
                    sb.append("\n Texto:"+adaptador.noticias.get(getAdapterPosition()).getTexto());
                    sb.append("\n  Ubicacion:"+adaptador.noticias.get(getAdapterPosition()).getUbicacion().GetLatitudLongitud());

                    Toast.makeText(view.getContext(), sb.toString(), Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(view.getContext(), MostrarNoticia.class);
                    intent.putExtra("noticia", adaptador.noticias.get(getAdapterPosition()));
                    view.getContext().startActivity(intent);

                }
            });

            botonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adaptador.noticias.remove(getAdapterPosition());
                    adaptador.notifyItemRemoved(getAdapterPosition());
                    adaptador.notifyItemRangeChanged(getAdapterPosition(), adaptador.noticias.size());
                }
            });

        }

        public ViewHolder enlaceAdaptador(Adaptador a){
            this.adaptador = a;
            return this;
        }
    }

}
