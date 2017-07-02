package com.climper.docenciaapp.ui.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.adpater.RecyclerView_Modulo;
import com.climper.docenciaapp.ui.model.Course;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class modulo_fragment extends Fragment {
    private RecyclerView_Modulo myAdapter;
    private RecyclerView myRecyclerView;
    private LinearLayoutManager myLayoutManager;
    private ArrayList results = new ArrayList<Course>();

    public modulo_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_modulo, container, false);
        myRecyclerView = (RecyclerView) root.findViewById(R.id.RV_Modulo);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(myLayoutManager);

        InsertarDatos();

        return root;
    }

    private void InsertarDatos(){
        results.add(new Course(R.drawable.curso_1, "curso 10",1));
        results.add(new Course(R.drawable.curso_1, "curso 20",1));
        results.add(new Course(R.drawable.curso_1, "curso 30",1));
        results.add(new Course(R.drawable.curso_1, "curso 40",1));
        MostrarDatos();
    }

    private void MostrarDatos(){
        //myAdapter = new RecyclerView_Modulo(results, getContext()); // <------- constructor
        //myRecyclerView.setAdapter(myAdapter);
    }



}
