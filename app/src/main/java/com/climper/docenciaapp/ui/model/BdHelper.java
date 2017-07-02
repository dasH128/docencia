package com.climper.docenciaapp.ui.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SistemaJ on 31/05/2017.
 */

public class BdHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "docenciaclimper.sqlite";
    public static final int DB_SCHEME_VERSION = 1;
    public static final String TABLE_NAME = "datos";
    public static final String CN_ID = "_id";
    public static final String CN_DIA = "dia";
    public static final String CN_MES = "mes";
    public static final String CN_ANIO = "anio";
    public static final String CN_IDUSER = "iduser";
    public static final String CN_NOMBRE_USER = "nombreuser";
    public static final String CN_CODIGO = "codigo";
    public static final String CN_ESTADO = "activo";
    public static final String CN_NOMBRE_BEBE = "nombrebebe";
    public static final String CN_DESCRIPCION = "descripcion";

    public static final String CREATE_TABLE ="create table "+TABLE_NAME+" ("+CN_ID+" integer primary key autoincrement, "
            +CN_DIA+" text not null, "
            +CN_MES+" text not null,"
            +CN_ANIO+" text not null,"
            +CN_IDUSER+" text not null,"
            +CN_NOMBRE_USER+" text not null,"
            +CN_CODIGO+" text not null,"
            +CN_NOMBRE_BEBE+" text not null,"
            +CN_DESCRIPCION+" text not null,"
            +CN_ESTADO+" text);";

    public BdHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
