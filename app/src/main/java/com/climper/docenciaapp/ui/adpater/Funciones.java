package com.climper.docenciaapp.ui.adpater;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.climper.docenciaapp.ui.model.BdHelper;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by SistemaJ on 01/06/2017.
 */

public class Funciones {
    private SQLiteDatabase db;
    BdHelper helper;

    public int Ope1 (int o1){
        int Devolver1=0;
        switch (o1){
            case 1:Devolver1=0;
                break;
            case 2:Devolver1=31;
                break;
            case 3:Devolver1=59;
                break;
            case 4:Devolver1=90;
                break;
            case 5:Devolver1=120;
                break;
            case 6:Devolver1=151;
                break;
            case 7:Devolver1=181;
                break;
            case 8:Devolver1=212;
                break;
            case 9:Devolver1=243;
                break;
            case 10:Devolver1=273;
                break;
            case 11:Devolver1=304;
                break;
            case 12:Devolver1=334;
                break;
        }
        return Devolver1;
    }

    public int Ope2(int o2){
        int Date_M=0;
        if(0<o2&o2<32){
            Date_M=1;
        }if(31<o2&o2<60){
            Date_M=2;
        }if(59<o2&o2<91){
            Date_M=3;
        }if(90<o2&o2<121){
            Date_M=4;
        }if(120<o2&o2<152){
            Date_M=5;
        }if(151<o2&o2<182){
            Date_M=6;
        }if(181<o2&o2<213){
            Date_M=7;
        }if(212<o2&o2<244){
            Date_M=8;
        }if(243<o2&o2<274){
            Date_M=9;
        }if(273<o2&o2<305){
            Date_M=10;
        }if(304<o2&o2<335){
            Date_M=11;
        }if(334<o2&o2<366){
            Date_M=12;
        }
        return Date_M;
    }

    public int CalcularDiasFaltantes(String v1,String v2,String v3){
        int DiasF=0;

        int d=Integer.parseInt(v1);
        int m=Integer.parseInt(v2);
        int a=Integer.parseInt(v3);
        Calendar c = new GregorianCalendar();
        int dA=c.get(Calendar.DAY_OF_MONTH);
        int mA=c.get(Calendar.MONTH)+1;
        int aA=c.get(Calendar.YEAR);
        int N1=dA+Ope1(mA);
        int N2=365-(d+Ope1(m));
        if(aA==a){
            DiasF=365-(N1+N2);
        }else if(a>aA){
            DiasF=(365-N1)+(365-N2);
        }

        return DiasF;
    }

    public int TransMeses(int variable){
        int ResiduoMes=(variable%7);
        int DatoMesM=(variable-ResiduoMes)/7;

        return DatoMesM;
    }

    public String TransformarMes(String mes){

        int Num_mes=0;
        Num_mes=Integer.parseInt(mes);
        String Mes="";
        switch (Num_mes){

            case 1:Mes="Enero";
                break;
            case 2:Mes="Febrero";
                break;
            case 3:Mes="Marzo";
                break;
            case 4:Mes="Abril";
                break;
            case 5:Mes="Mayo";
                break;
            case 6:Mes="Junio";
                break;
            case 7:Mes="Julio";
                break;
            case 8:Mes="Agosto";
                break;
            case 9:Mes="Septiembre";
                break;
            case 10:Mes="Octubre";
                break;
            case 11:Mes="Noviembre";
                break;
            case 12:Mes="Diciembre";
                break;
        }
        return Mes;
    }

    public int TransformarMesenNumero (String m){
        int Mes=0;

        if (m.equals("Enero")){
            Mes=1;
        }else if (m.equals("Febrero")){
            Mes=2;
        }else if (m.equals("Marzo")){
            Mes=3;
        }else if (m.equals("Abril")){
            Mes=4;
        }else if (m.equals("Mayo")){
            Mes=5;
        }else if (m.equals("Junio")){
            Mes=6;
        }else if (m.equals("Julio")){
            Mes=7;
        }else if (m.equals("Agosto")){
            Mes=8;
        }else if (m.equals("Octubre")){
            Mes=9;
        }else if (m.equals("Noviembre")){
            Mes=10;
        }else if (m.equals("Diciembre")){
            Mes=11;
        }else if (m.equals("Septiembre")){
            Mes=12;
        }
        return Mes;
    }

    public String ZignoZodiacal(int dia, int mes){
        String Zigno="";

        switch (mes){
            case 1:
                if(dia>=21){
                    Zigno="Acuario";
                }else {
                    Zigno="Capricornio";
                }
                break;
            case 2:
                if(dia>=19){
                    Zigno="Piscis";
                }else {
                    Zigno="Acuario";
                }
                break;
            case 3:
                if(dia>=21){
                    Zigno="Aries";
                }else {
                    Zigno="Piscis";
                }
                break;
            case 4:
                if(dia>=21){
                    Zigno="Tauro";
                }else {
                    Zigno="Aries";
                }
                break;
            case 5:
                if(dia>=22){
                    Zigno="Géminis";
                }else {
                    Zigno="Tauro";
                }
                break;
            case 6:
                if(dia>=21){
                    Zigno="Cáncer";
                }else {
                    Zigno="Géminis";
                }
                break;
            case 7:
                if(dia>=23){
                    Zigno="Leo";
                }else {
                    Zigno="Cáncer";
                }
                break;
            case 8:
                if(dia>=23){
                    Zigno="Virgo";
                }else {
                    Zigno="Leo";
                }
                break;
            case 9:
                if(dia>=23){
                    Zigno="Libra";
                }else {
                    Zigno="Virgo";
                }
                break;
            case 10:
                if(dia>=23){
                    Zigno="Escorpio";
                }else {
                    Zigno="Libra";
                }
                break;
            case 11:
                if(dia>=22){
                    Zigno="Sagitario";
                }else {
                    Zigno="Escorpio";
                }
                break;
            case 12:
                if(dia>=22){
                    Zigno="Capricornio";
                }else {
                    Zigno="Sagitario";
                }
                break;
        }

        return Zigno;
    }

    public String Estacion(int EDia,int EMes){
        String LaEstacion="";
        Log.i("Fecha estacion", EDia + " y " + EMes);
        if(20>EDia){
            Log.i("IF",EDia+" y "+EMes);
            if(0<EMes&EMes<4){
                LaEstacion="Verano";
            }else if(3<EMes&EMes<7){
                LaEstacion="Otoño";
            }else if(6<EMes&EMes<10){
                LaEstacion="Invierno";
            }else if(9<EMes&EMes<13){
                LaEstacion="Primavera";
            }
        }else {
            Log.i("Else",EDia+" y "+EMes);
            //if (1 < EMes & EMes < 3 & EMes == 12) {
            if (EMes == 1 || EMes == 2 || EMes == 12) {
                LaEstacion = "Verano";
            } else if (2 < EMes & EMes < 6) {
                LaEstacion = "Otoño";
            } else if (5 < EMes & EMes < 9) {
                LaEstacion = "Invierno";
            } else if (8 < EMes & EMes < 12) {
                LaEstacion = "Primavera";
            }
        }
        return LaEstacion;
    }

    public String AñoChino(String año,String mes){
        int TransAño= Integer.parseInt(año);
        int TransMes= Integer.parseInt(mes);
        String AñoChino="";

        int Var=TransAño%12;
        switch (Var){
            case 0:
                if(TransMes==1){
                    AñoChino="Cabra";
                }else{
                    AñoChino="Mono";
                }
                break;
            case 1:
                if(TransMes==1){
                    AñoChino="Mono";
                }else{
                    AñoChino="Gallo";
                }
                break;
            case 2:
                if(TransMes==1){
                    AñoChino="Gallo";
                }else{
                    AñoChino="Perro";
                }
                break;
            case 3:
                if(TransMes==1){
                    AñoChino="Perro";
                }else{
                    AñoChino="Cerdo";
                }
                break;
            case 4:
                if(TransMes==1){
                    AñoChino="Cerdo";
                }else{
                    AñoChino="Rata";
                }
                break;
            case 5:
                if(TransMes==1){
                    AñoChino="Rata";
                }else{
                    AñoChino="Buey";
                }
                break;
            case 6:
                if(TransMes==1){
                    AñoChino="Buey";
                }else{
                    AñoChino="Tigre";
                }
                break;
            case 7:
                if(TransMes==1){
                    AñoChino="Tigre";
                }else{
                    AñoChino="Conejo";
                }
                break;
            case 8:
                if(TransMes==1){
                    AñoChino="Conejo";
                }else{
                    AñoChino="Dragón";
                }
                break;
            case 9:
                if (TransMes==1){
                    AñoChino="Dragón";
                }else {
                    AñoChino="Serpiente";
                }
                break;
            case 10:
                if(TransMes==1){
                    AñoChino="Serpiente";
                }else{
                    AñoChino="Caballo";
                }
                break;
            case 11:
                if(TransMes==1){
                    AñoChino="Caballo";
                }else{
                    AñoChino="Cabra";
                }
                break;
        }
        return AñoChino;
    }

    public String sesaria(int q1,int q2,int q3){
        int n1=0,n2=0,n3=0,L1=0,L2=0;
        if(q1<15){

            if(q2==1){
                L1=(q3-1);
                L2=(12);
            }else{
                L1=(q3);
                L2=(q2-1);
            }
            int qq1 =EnviarM(q2);
            n1=(qq1+q1-14 );
            n2=(L2);
            n3=(L1);

        }else if (q1>14){
            n1=(q1-14);
            n2=q2;
            n3=q3;
        }
        String M=TransformarMes((n2)+"");
        String DevolverF=(n1+" de "+M+" del "+n3);
        return DevolverF;
    }

    public int EnviarM(int gg){
        int NumMes=0;
        switch (gg){
            case 1:
                NumMes=(31);
                break;
            case 2:
                NumMes=(31);
                break;
            case 3:
                NumMes=(28);
                break;
            case 4:
                NumMes=(31);
                break;
            case 5:
                NumMes=(30);
                break;
            case 6:
                NumMes=(31);
                break;
            case 7:
                NumMes=(30);
                break;
            case 8:
                NumMes=(31);
                break;
            case 9:
                NumMes=(31);
                break;
            case 10:
                NumMes=(30);
                break;
            case 11:
                NumMes=(31);
                break;
            case 12:
                NumMes=(30);
                break;
        }
        return NumMes;
    }

    public String Elemento(int x1){
        String Valorx="";

        switch (x1){
            case 0:
                Valorx="Metal";
                break;
            case 1:
                Valorx="Metal";
                break;
            case 2:
                Valorx="Agua";
                break;
            case 3:
                Valorx="Agua";
                break;
            case 4:
                Valorx="Madera";
                break;
            case 5:
                Valorx="Madera";
                break;
            case 6:
                Valorx="Fuego";
                break;
            case 7:
                Valorx="Fuego";
                break;
            case 8:
                Valorx="Tierra";
                break;
            case 9:
                Valorx="Tierra";
                break;
        }
        return Valorx;
    }

    public String MesFaltante(int dfaltante, int año){
        String MesFaltante="";
        Calendar MF = new GregorianCalendar();
        int dM=MF.get(Calendar.DAY_OF_MONTH);
        int mM=MF.get(Calendar.MONTH)+1;
        int aM=MF.get(Calendar.YEAR);

        if (aM==año){
            if(dfaltante>=mM){
                MesFaltante=(dfaltante-mM)+"";
            }else {
                MesFaltante=" ";
            }
        }else if (aM!=año){
            int lastY= 12-mM;
            MesFaltante=(lastY+dfaltante)+"";
        }
        return MesFaltante;
    }

    public int ValidarFechaCita(int d, int m, int a, int t){
        int ret=0;
        Calendar FAct = new GregorianCalendar();
        int dA=FAct.get(Calendar.DAY_OF_MONTH);
        int mA=FAct.get(Calendar.MONTH)+1;
        int aA=FAct.get(Calendar.YEAR);
        int diasA = dA + Ope1(mA);
        int diasV = d  + Ope1(m);
        Log.i("Fecha Actual ",dA+" "+mA+" "+aA);
        Log.i("Fecha Actual en dias ",diasA+"");
        Log.i("-------------","----------------");
        Log.i("Fecha Validada ",d+" "+m+" "+a);
        Log.i("Fecha Validada en dias ",diasV+"");
        if(diasA+t>=diasV){
            ret = 1; // rango permitido
        }
        return ret;
    }

    public int ValidarUser(Context context){

        helper = new BdHelper(context, BdHelper.DB_NAME, null, BdHelper.DB_SCHEME_VERSION);
        db = helper.getReadableDatabase();
        Cursor fila = db.rawQuery("SELECT iduser FROM datos WHERE activo ='activo'", null);
        int IDUSER;
        if(fila.moveToFirst()){
            int bd_id=Integer.parseInt(fila.getString(0));
            IDUSER = bd_id; // id del usuario logueado
        }else{
            IDUSER=0;       //no hay paciente logueado
        }
        return IDUSER;
    }

    public String MesAbreviado(String fecha){
        String d,mes= " ";
        //String Fecha_API = informMedico.get(position).getImFecha();
        d = fecha.substring(8,10);
        //m = fecha.substring(5,7);
        //a = fecha.substring(0,4);

        switch (Integer.parseInt(fecha.substring(5,7))){
            case 1:mes  = "ENE"; break;
            case 2:mes  = "FEB"; break;
            case 3:mes  = "MAR"; break;
            case 4:mes  = "ABR"; break;
            case 5:mes  = "MAY"; break;
            case 6:mes  = "JUN"; break;
            case 7:mes  = "JUL"; break;
            case 8:mes  = "AGO"; break;
            case 9:mes  = "SEPT";break;
            case 10:mes = "OCT"; break;
            case 11:mes = "NOV"; break;
            case 12:mes = "DIC"; break;
        }
        String returnfecha = d+" de "+mes;
        return returnfecha;
    }

}
