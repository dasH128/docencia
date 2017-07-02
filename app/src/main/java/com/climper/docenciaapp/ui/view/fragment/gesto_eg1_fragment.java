package com.climper.docenciaapp.ui.view.fragment;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.adpater.Funciones;
import com.climper.docenciaapp.ui.model.BdHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class gesto_eg1_fragment extends Fragment {
    private CalendarView calendarView;
    private Button btnIngresarFecha;
    private int dia=0;
    private int mes=0;
    private int anio=0;
    Funciones Ope = new Funciones();

    public gesto_eg1_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gesto_eg1, container, false);
        calendarView = (CalendarView) view.findViewById(R.id.calendarview_fur);
        CalendarView.OnDateChangeListener myCalendarView = new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                dia=dayOfMonth;
                mes=month+1;
                anio=year;
            }
        };
        calendarView.setOnDateChangeListener(myCalendarView);

        btnIngresarFecha = (Button) view.findViewById(R.id.btn_save_fecha_fur);
        btnIngresarFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dia==0 && mes==0 && anio==0)
                    Toast.makeText(getContext()," Ingrese una fecha porfavor", Toast.LENGTH_SHORT).show();
                else {

                    int NAF=dia+Ope.Ope1(mes);
                    int SAF=(NAF+280);

                    int Cd=0,Cm=0,Ca=0;

                    if (SAF>365){
                        int Calc=(SAF-365);
                        Cm=Ope.Ope2(Calc);
                        Cd=(Calc-Ope.Ope1(Cm));
                        Ca=anio+1;
                        mostrarT(Cd, Cm, Ca);//saveFecha(Cd, Cm, Ca);
                    }else if(SAF<=365){
                        Cm=Ope.Ope2(SAF);
                        Cd=(SAF-Ope.Ope1(Cm));
                        Ca=anio;
                        mostrarT(Cd, Cm, Ca);//saveFecha(Cd, Cm, Ca);
                    }
                }
            }
        });

        calendarView.setFirstDayOfWeek(3);
        return view;
    }

    private void mostrarT(int d, int m, int a){
        String egsemana="", semanas="";
        int ResultD;
        ResultD=Ope.CalcularDiasFaltantes(d+"", m+"", a+"");
        semanas=(Ope.TransMeses(ResultD)+"");
        int ValEGSemana= 40-(Integer.parseInt(semanas));
        egsemana=(ValEGSemana)+"";

        Toast.makeText(getContext(),"La EG Actual por semana es de: "+egsemana,Toast.LENGTH_SHORT).show();
    }

    void saveFecha(int d, int m, int a){
        SQLiteDatabase db;
        BdHelper helper = new BdHelper(gesto_eg1_fragment.super.getContext(),BdHelper.DB_NAME,null,BdHelper.DB_SCHEME_VERSION);
        db=helper.getWritableDatabase();
        db.execSQL("UPDATE datos SET dia='"+d+"' , mes='"+m+"' , anio='"+a+"' WHERE descripcion='logueo'");
        helper.close();

        android.support.v4.app.FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.main_content_gesto, new gesto_inform_fragment());
        trans.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        trans.addToBackStack(null);
        trans.commit();
    }
}
