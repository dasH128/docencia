package com.climper.docenciaapp.ui.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
import com.climper.docenciaapp.ui.model.Course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Diplo_Curso_Modulo extends AppCompatActivity {
    private RecyclerView_Modulo myAdapter;
    private RecyclerView myRecyclerView;
    private LinearLayoutManager myLayoutManager;
    private ArrayList results = new ArrayList<Course>();
    private String idcurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplo_curso_modulo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle parametros = this.getIntent().getExtras();
        idcurso = parametros.getString("id");

        /*final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_left);
            ab.setDisplayHomeAsUpEnabled(true);
        }*/
        showToolbar("Cursos", true);

        myRecyclerView = (RecyclerView) findViewById(R.id.RV_Course_diplo);
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
        String Url = "http://climper.com.pe/APIv2.0/ListaModulos.php?id_curso="+idcurso;
        Log.d("T - url modulo ", Url);

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest req1 = new JsonArrayRequest(Url, new Response.Listener<JSONArray>(){

            @Override
            public void onResponse(JSONArray response) {

                try {
                    for(int i=0;i<response.length();i++){
                        JSONObject JsonModulo = (JSONObject) response.get(i);
                        String nombre = JsonModulo.getString("fullname");

                        if(JsonModulo.getString("id").equals("27")){
                            results.add(new Course(nombre,R.drawable.modulo_5_9,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("28")){
                            results.add(new Course(nombre,R.drawable.modulo_5_10,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("29")){
                            results.add(new Course(nombre,R.drawable.modulo_5_11,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("30")){
                            results.add(new Course(nombre,R.drawable.modulo_5_12,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("44")){
                            results.add(new Course(nombre,R.drawable.modulo_5_13,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("32")){
                            results.add(new Course(nombre,R.drawable.modulo_5_14,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("37")){
                            results.add(new Course(nombre,R.drawable.modulo_5_15,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("33")){
                            results.add(new Course(nombre,R.drawable.modulo_5_16,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("34")){
                            results.add(new Course(nombre,R.drawable.modulo_5_17,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("35")){
                            results.add(new Course(nombre,R.drawable.modulo_5_18,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("42")){
                            results.add(new Course(nombre,R.drawable.modulo_6_19,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("45")){
                            results.add(new Course(nombre,R.drawable.modulo_6_20,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("39")){
                            results.add(new Course(nombre,R.drawable.modulo_7_21,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("16")){
                            results.add(new Course(nombre,R.drawable.modulo_7_22,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("11")){
                            results.add(new Course(nombre,R.drawable.modulo_8_23,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("48")){
                            results.add(new Course(nombre,R.drawable.modulo_8_24,JsonModulo.getString("id")));
                            //listado.add(new lista_entrada05(R.drawable.a_8_24,curso+"","DURACIÓN : 4 días                   CREDITAJE : 2 "));
                        }else if(JsonModulo.getString("id").equals("2")){
                            results.add(new Course(nombre,R.drawable.img_m_1,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("3")){
                            results.add(new Course(nombre,R.drawable.img_m_2,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("4")){
                            results.add(new Course(nombre,R.drawable.img_m_3,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("5")){
                            results.add(new Course(nombre,R.drawable.img_m_4,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("6")){
                            results.add(new Course(nombre,R.drawable.img_m_5,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("7")){
                            results.add(new Course(nombre,R.drawable.img_m_6,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("8")){
                            results.add(new Course(nombre,R.drawable.img_m_7,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("9")){
                            results.add(new Course(nombre,R.drawable.img_m_8,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("49")){
                            results.add(new Course(nombre,R.drawable.img_m_1,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("50")){
                            results.add(new Course(nombre,R.drawable.img_m_2,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("51")){
                            results.add(new Course(nombre,R.drawable.img_m_3,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("52")){
                            results.add(new Course(nombre,R.drawable.img_m_4,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("53")){
                            results.add(new Course(nombre,R.drawable.img_m_5,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("54")){
                            results.add(new Course(nombre,R.drawable.img_m_6,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("55")){
                            results.add(new Course(nombre,R.drawable.img_m_7,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("56")){
                            results.add(new Course(nombre,R.drawable.img_m_8,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("57")){
                            results.add(new Course(nombre,R.drawable.img_m_1,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("58")){
                            results.add(new Course(nombre,R.drawable.img_m_2,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("59")){
                            results.add(new Course(nombre,R.drawable.img_m_3,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("60")){
                            results.add(new Course(nombre,R.drawable.img_m_4,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("61")){
                            results.add(new Course(nombre,R.drawable.img_m_5,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("62")){
                            results.add(new Course(nombre,R.drawable.img_m_6,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("63")){
                            results.add(new Course(nombre,R.drawable.img_m_7,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("64")){
                            results.add(new Course(nombre,R.drawable.img_m_8,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("65")){
                            results.add(new Course(nombre,R.drawable.img_m_1,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("66")){
                            results.add(new Course(nombre,R.drawable.img_m_2,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("67")){
                            results.add(new Course(nombre,R.drawable.img_m_3,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("68")){
                            results.add(new Course(nombre,R.drawable.img_m_4,JsonModulo.getString("id")));
                        }else if(JsonModulo.getString("id").equals("69")){
                            results.add(new Course(nombre,R.drawable.img_m_5,JsonModulo.getString("id")));
                        }else{
                            results.add(new Course(nombre,R.drawable.id_img_diplomado,JsonModulo.getString("id")));
                        }

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
        myAdapter = new RecyclerView_Modulo(results,getApplicationContext() ,this); // <------- constructor
        myRecyclerView.setAdapter(myAdapter);
    }
}
