package com.imunoz.evaluacion1;

import java.io.Serializable;
import java.util.ArrayList;

public class Cuenta implements Serializable {

    private String nombre;
    private String apellido;
    private ArrayList<Reserva> listaReservas= new ArrayList<Reserva>();
    //private ArrayList<>

    public Cuenta(){
        this.nombre = "";
        this.apellido = "";
    }

    public Cuenta(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
}