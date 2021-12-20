package com.imunoz.evaluacion1;

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
    public ArrayList<Reserva> reservas;
    public Adaptador(ArrayList<Reserva> reservas){
        this.reservas = reservas;
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
        holder.titulo.setText(reservas.get(position).getFecha()  );
        holder.texto.setText(reservas.get(position).getHora());
        holder.tipoCancha.setText(reservas.get(position).getTipoCancha());

       // holder.texto.setText(reservas.get(position).getTipoCancha());


        holder.reserva = reservas.get(position);

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.foto.getContext(), "asdf", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return reservas.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView titulo, texto,tipoCancha;
        private Button botonNumero, botonEliminar;
        private Reserva reserva;
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
                    sb.append("----Reserva----");
                    sb.append("\n Fecha:"+adaptador.reservas.get(getAdapterPosition()).getFecha());
                    sb.append("\n Hora:"+adaptador.reservas.get(getAdapterPosition()).getHora());
                    sb.append("\n Tipo cancha:"+adaptador.reservas.get(getAdapterPosition()).getTipoCancha());




                    Toast.makeText(view.getContext(), sb.toString(), Toast.LENGTH_LONG).show();



                }
            });

            botonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adaptador.reservas.remove(getAdapterPosition());
                    adaptador.notifyItemRemoved(getAdapterPosition());
                    adaptador.notifyItemRangeChanged(getAdapterPosition(), adaptador.reservas.size());
                }
            });

        }

        public ViewHolder enlaceAdaptador(Adaptador a){
            this.adaptador = a;
            return this;
        }
    }

}
