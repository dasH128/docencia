package com.climper.docenciaapp.ui.model;

/**
 * Created by SistemaJ on 01/06/2017.
 */

public class Course {
    private int cfoto;
    private String cName;
    private int idcurso;



    public Course(int cfoto, String cName, int idcurso) {
        this.cfoto = cfoto;
        this.cName = cName;
        this.idcurso = idcurso;
    }

    public Course(String cName, int cfoto, String idcurso) {
        this.cfoto = cfoto;
        this.cName = cName;
        this.idcurso = Integer.parseInt(idcurso) ;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getCfoto() {
        return cfoto;
    }

    public void setCfoto(int cfoto) {
        this.cfoto = cfoto;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
