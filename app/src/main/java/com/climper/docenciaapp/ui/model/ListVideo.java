package com.climper.docenciaapp.ui.model;

/**
 * Created by SistemaJ on 23/06/2017.
 */

public class ListVideo {
    private int vfoto;
    private String vdescripcion;
    private String vcod;

    public ListVideo(int vfoto, String vdescripcion, String vcod) {
        this.vfoto = vfoto;
        this.vdescripcion = vdescripcion;
        this.vcod = vcod;
    }

    public int getVfoto() {
        return vfoto;
    }

    public void setVfoto(int vfoto) {
        this.vfoto = vfoto;
    }

    public String getVdescripcion() {
        return vdescripcion;
    }

    public void setVdescripcion(String vdescripcion) {
        this.vdescripcion = vdescripcion;
    }

    public String getVcod() {
        return vcod;
    }

    public void setVcod(String vcod) {
        this.vcod = vcod;
    }

}
