package com.climper.docenciaapp.ui.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.climper.docenciaapp.ui.adpater.RecyclerView_Video;
import com.climper.docenciaapp.ui.adpater.RecyclerView_Tema;
import com.climper.docenciaapp.ui.model.Course;
import com.climper.docenciaapp.ui.model.ListVideo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
public class Diplo_Curso_Video extends AppCompatActivity {
    private RecyclerView_Video myAdapter;
    private RecyclerView myRecyclerView;
    private LinearLayoutManager myLayoutManager;
    private ArrayList results = new ArrayList<ListVideo>();
    private String idtema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplo_curso_video);

        Bundle parametros = this.getIntent().getExtras();
        idtema = parametros.getString("id");

        showToolbar("Videos", true);

        myRecyclerView = (RecyclerView) findViewById(R.id.RV_Video);
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
        String URL= "http://climper.com.pe/APIv2.0/ListVideos.php?id_tema="+idtema;
        Log.d("T - url videos ", URL);

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest req1 = new JsonArrayRequest(URL, new Response.Listener<JSONArray>(){

            @Override
            public void onResponse(JSONArray response) {

                try {
                    for(int i=0;i<response.length();i++){
                        JSONObject JsonListaVideo = (JSONObject) response.get(i);
                        String nombre = JsonListaVideo.getString("descripcion");
                        String codvideo = JsonListaVideo.getString("video");

                        results.add(new ListVideo(R.drawable.ic_video, nombre, codvideo));
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
        myAdapter = new RecyclerView_Video(results,getApplicationContext(),this); // <------- constructor
        myRecyclerView.setAdapter(myAdapter);
    }
}
