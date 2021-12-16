package com.imunoz.evaluacion1;

import java.io.Serializable;

public class Reserva implements Serializable {
    private String fecha;
    private String hora;
    private String tipoCancha;

    public Reserva() {
        this.fecha = "";
        this.hora =  "";
        this.tipoCancha =  "";
    }



    public Reserva(String fecha, String hora, String tipoCancha) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipoCancha = tipoCancha;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoCancha() {
        return tipoCancha;
    }

    public void setTipoCancha(String tipoCancha) {
        this.tipoCancha = tipoCancha;
    }
}
