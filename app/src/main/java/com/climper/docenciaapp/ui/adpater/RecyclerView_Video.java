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

import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.model.Course;
import com.climper.docenciaapp.ui.model.ListVideo;
import com.climper.docenciaapp.ui.view.activity.VideoPlayer_Activity;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by SistemaJ on 02/06/2017.
 */

public class RecyclerView_Video extends  RecyclerView.Adapter<RecyclerView_Video.ViewHolder> {
    private ArrayList<ListVideo> listVideos;
    private Context context;
    private Activity activity;

    private Bundle parametros = new Bundle();
    public RecyclerView_Video(ArrayList<ListVideo> listVideos, Context context, Activity activity) {
        this.listVideos = listVideos;
        this.context = context;
        this.activity = activity;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.video_imagen_item);
            name = (TextView) itemView.findViewById(R.id.video_nombre_item);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String codVideo = listVideos.get(getPosition()).getVcod();
            parametros.putString("cod", codVideo+"");

            Intent i = new Intent(activity, VideoPlayer_Activity.class);
            i.putExtras(parametros);
            startActivity((Activity) activity, i, Bundle.EMPTY);

            /*int id = course.get(getPosition()).getIdcurso();
            parametros.putString("id", id+"");
            Intent i = new Intent(context, Diplo_Curso_Temas.class);
            i.putExtras(parametros);
            startActivity((Activity) context, i, Bundle.EMPTY);*/

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_video,parent,false);
        RecyclerView_Video.ViewHolder VH = new RecyclerView_Video.ViewHolder(v);
        return VH;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(listVideos.get(position).getVdescripcion());
        holder.img.setImageResource(listVideos.get(position).getVfoto());
    }

    @Override
    public int getItemCount() {
        return listVideos.size();
    }

}
