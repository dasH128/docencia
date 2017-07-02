package com.climper.docenciaapp.ui.adpater;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.model.Course;
import com.climper.docenciaapp.ui.view.activity.Diplo_Curso_Detalle;
import com.climper.docenciaapp.ui.view.activity.Diplo_Curso_Temas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import static android.support.v4.content.ContextCompat.startActivity;

//1 import static android.support.v4.content.ContextCompat.startActivity;
//2 import static android.support.v4.app.ActivityCompat.startActivity;
/**
 * Created by SistemaJ on 02/06/2017.
 */

public class RecyclerView_Modulo extends  RecyclerView.Adapter<RecyclerView_Modulo.ViewHolder>{
    private ArrayList<Course> course;
    private Context context;
    private Activity activity;
    private Funciones Ope = new Funciones();

    private Bundle parametros = new Bundle();
    public RecyclerView_Modulo(ArrayList<Course> course, Context context, Activity activity) {
        this.course = course;
        this.context = context;
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.subCourse_imagen_item);
            name = (TextView) itemView.findViewById(R.id.subcourse_nombre_item);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = course.get(getPosition()).getIdcurso();
            ValidarModulo(""+id);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_subcurso,parent,false);
        ViewHolder VH = new ViewHolder(v);
        return VH;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(course.get(position).getcName());
        holder.img.setImageResource(course.get(position).getCfoto());
    }

    @Override
    public int getItemCount() {
        return course.size();
    }

    private void ValidarModulo(final String idmodulo){

        int idalumno = Ope.ValidarUser(context);

        String URL ="http://climper.com.pe/APIv2.0/ValidarModulo.php?idmodulo="+idmodulo+"&iduser="+idalumno;
        Log.d("url ", URL);
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest req1 = new JsonArrayRequest(URL
                ,new Response.Listener<JSONArray>(){

            @Override
            public void onResponse(JSONArray response) {

                try{
                    for (int i=0; i<response.length();i++) {
                        JSONObject JsonValidarModulo = (JSONObject) response.get(i);
                        String status = JsonValidarModulo.getString("status");
                        Log.i("--------- "," ---------");
                        if (status.equals("allow")){
                            IR(idmodulo);
                        }else{
                            IRDetalle(idmodulo);
                        }

                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("bad Diplo_curso_login", error.toString());

                //Toast.makeText(context,"Usted no esta matriculado en este curso",Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(req1);
    }

    private void IR(String idmodulo){
        Toast.makeText(context, " BIENBENIDO ", Toast.LENGTH_SHORT).show();
        parametros.putString("idmodulo", idmodulo);
        Intent i = new Intent(activity, Diplo_Curso_Temas.class);
        i.putExtras(parametros);
        startActivity((Activity) activity, i, Bundle.EMPTY);
    }

    private void IRDetalle(String idmodulo){
        int id= Integer.parseInt(idmodulo);
        if(id == 28 || id == 29 || id == 30 || id == 70 || id == 71){
            parametros.putString("idmodulo", idmodulo);
            Intent i = new Intent(activity, Diplo_Curso_Detalle.class);
            i.putExtras(parametros);
            startActivity((Activity) activity,i, Bundle.EMPTY);
        }else{
            Toast.makeText(context," No esta matriculado en este curso",Toast.LENGTH_SHORT).show();
        }
    }
}
