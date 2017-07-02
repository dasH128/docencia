package com.climper.docenciaapp.ui.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.adpater.RecyclerView_Modulo;
import com.climper.docenciaapp.ui.adpater.RecyclerView_Tema;
import com.climper.docenciaapp.ui.model.Course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Diplo_Curso_Temas extends AppCompatActivity {
    private RecyclerView_Tema myAdapter;
    private RecyclerView myRecyclerView;
    private LinearLayoutManager myLayoutManager;
    private ArrayList results = new ArrayList<Course>();
    private String idmodulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplo_curso_temas);

        Bundle parametros = this.getIntent().getExtras();
        idmodulo = parametros.getString("idmodulo");

        showToolbar("Temas", true);
        myRecyclerView = (RecyclerView) findViewById(R.id.RV_Temas);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(getApplication());
        myRecyclerView.setLayoutManager(myLayoutManager);
        InsertarDatos();
    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        getSupportActionBar().setDisplayShowHomeEnabled(upButton);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Log.e("flecha"," BACK");
        return false;
    }

    private void InsertarDatos(){
        String URL= "http://climper.com.pe/APIv2.0/ListTemas.php?id_curso="+idmodulo;
        Log.d("T - url temas ", URL);

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest req1 = new JsonArrayRequest(URL, new Response.Listener<JSONArray>(){

            @Override
            public void onResponse(JSONArray response) {

                try {
                    for(int i=0;i<response.length();i++){
                        JSONObject JsonTema = (JSONObject) response.get(i);
                        String nombre = JsonTema.getString("descripcion");
                        String id = JsonTema.getString("id");
                        Log.d("nombre ", nombre);
                        results.add(new Course(nombre,R.drawable.id_img_diplomado,id));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MostrarDatos();
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("gigi bad", error.toString());

            }
        });

        queue.add(req1);
    }

    private void MostrarDatos(){
        myAdapter = new RecyclerView_Tema(results,getApplicationContext() ,this); // <------- constructor
        myRecyclerView.setAdapter(myAdapter);
    }
}
