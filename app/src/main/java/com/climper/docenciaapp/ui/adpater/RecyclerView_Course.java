package com.climper.docenciaapp.ui.adpater;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.model.Course;
import com.climper.docenciaapp.ui.view.activity.Diplo_Curso_Modulo;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by SistemaJ on 01/06/2017.
 */

public class RecyclerView_Course extends  RecyclerView.Adapter<RecyclerView_Course.ViewHolder> {
    private ArrayList<Course> course;
    private Context context;


    private Bundle parametros = new Bundle();
    public RecyclerView_Course(ArrayList<Course> course, Context context) {
        this.course = course;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.course_imagen_item);
            name = (TextView) itemView.findViewById(R.id.course_nombre_item);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Toast.makeText(context,"No esta matriculado",Toast.LENGTH_SHORT).show();
            int id = course.get(getPosition()).getIdcurso();
            parametros.putString("id", id+"");
            Intent i = new Intent(context, Diplo_Curso_Modulo.class);
            i.putExtras(parametros);
            startActivity((Activity) context, i, Bundle.EMPTY);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_cursos,parent,false);
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
}
