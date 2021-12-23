package com.imunoz.evaluacion1;

import java.io.Serializable;

public class Noticias implements Serializable {
    private String titulo;
    private String texto;
    private Ubicacion ubicacion;
    private Foto foto;

    public Noticias(String titulo, String texto, Ubicacion ubicacion, Foto foto) {
        this.titulo = titulo;
        this.texto = texto;
        this.ubicacion = ubicacion;
        this.foto = foto;
    }


    public Noticias() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
}
