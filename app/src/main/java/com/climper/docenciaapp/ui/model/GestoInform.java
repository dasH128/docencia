package com.climper.docenciaapp.ui.model;

/**
 * Created by SistemaJ on 01/06/2017.
 */

public class GestoInform {
    String valor;
    String nombre;

    public GestoInform(String valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
