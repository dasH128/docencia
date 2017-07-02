package com.climper.docenciaapp.ui.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.adpater.RecyclerView_Course;
import com.climper.docenciaapp.ui.model.Course;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class course_fragment extends Fragment {
    private RecyclerView_Course myAdapter;
    private RecyclerView myRecyclerView;
    private LinearLayoutManager myLayoutManager;
    private ArrayList results = new ArrayList<Course>();

    public course_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_course, container, false);
        myRecyclerView = (RecyclerView) root.findViewById(R.id.RV_Course);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(myLayoutManager);

        InsertarDatos();
        return root;
    }

    private void InsertarDatos(){
        results.add(new Course(R.drawable.curso_1, "Diplomado de Ecografia General con Mencion en Obstetricia y Ginecologia",2));
        results.add(new Course(R.drawable.curso_2, "Diplomado de Emergencias Obstetricas y Perinatales",3));
        results.add(new Course(R.drawable.curso_5, "Diplomado de Ecografía Obstétrica de Alto Nivel",13));
        results.add(new Course(R.drawable.curso_6, "Diplomado de Cuidados Críticos intensivos en Neonatología",14));
        results.add(new Course(R.drawable.curso_7, "Curso de Ecografía Obstétrica",6));
        results.add(new Course(R.drawable.curso_8, "Curso de Ginecología",7));
        results.add(new Course(R.drawable.curso_9, "Curso de Obstetrícia",8));
        results.add(new Course(R.drawable.curso_9, "Curso de Ecografía de Adulto",10));

        MostrarDatos();
    }

    private void MostrarDatos(){
        myAdapter = new RecyclerView_Course(results, getContext()); // <------- constructor
        myRecyclerView.setAdapter(myAdapter);
    }

}
