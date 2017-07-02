package com.climper.docenciaapp.ui.view.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.adpater.Funciones;
import com.climper.docenciaapp.ui.adpater.RecyclerView_Course;
import com.climper.docenciaapp.ui.adpater.RecyclerView_Gesto;
import com.climper.docenciaapp.ui.model.BdHelper;
import com.climper.docenciaapp.ui.model.Course;
import com.climper.docenciaapp.ui.model.GestoInform;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class gesto_inform_fragment extends Fragment {
    ArrayList results = new ArrayList<GestoInform>();
    private RecyclerView_Gesto myAdapter;
    private RecyclerView myRecyclerView;
    private LinearLayoutManager myLayoutManager;
    private SQLiteDatabase db;


    public gesto_inform_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gesto_inform, container, false);

        myRecyclerView = (RecyclerView) view.findViewById(R.id.RV_GestoInfo);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(myLayoutManager);

        InsertarDatos();

        return view;
    }

    private void InsertarDatos(){
        /*results.add(new GestoInform("EG Actual por semana",egsemana));
        results.add(new GestoInform("Fecha de Parto Vaginal",parto));
        results.add(new GestoInform("Fecha de Parto por Cesaria",parto2));
        results.add(new GestoInform("EG Actual por mes",egmes));
        results.add(new GestoInform("Meses Faltantes",meses+" meses"));
        results.add(new GestoInform("Dias Faltantes",dias+" dias restantes"));
        results.add(new GestoInform("Semanas Faltantes",semanas+" semanas restantes"));
        results.add(new GestoInform("Zigno Zodiacal",zigno));
        results.add(new GestoInform("Año Chino",añoChino));
        results.add(new GestoInform("Elemento",elemento));
        results.add(new GestoInform("Estacion",estacion));*/
        results.add(new GestoInform("Fecha de Parto Vaginal","izi"));
        MostrarDatos();
    }

    private void MostrarDatos(){
        myAdapter = new RecyclerView_Gesto(results, getContext()); // <------- constructor
        myRecyclerView.setAdapter(myAdapter);
    }


}