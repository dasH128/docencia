package com.climper.docenciaapp.ui.adpater;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.model.Course;
import com.climper.docenciaapp.ui.model.GestoInform;


import java.util.ArrayList;

/**
 * Created by SistemaJ on 01/06/2017.
 */

public class RecyclerView_Gesto extends RecyclerView.Adapter<RecyclerView_Gesto.ViewHolder> {
    private ArrayList<GestoInform> gesto;
    private Context context;

    private Bundle parametros = new Bundle();
    public RecyclerView_Gesto(ArrayList<GestoInform> gesto, Context context) {
        this.gesto = gesto;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView valor, nombre;

        public ViewHolder(View itemView) {
            super(itemView);
            valor  = (TextView) itemView.findViewById(R.id.text_cardview_gestograma_value);
            nombre = (TextView) itemView.findViewById(R.id.text_cardview_gestograma_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_gestograma,parent,false);
        ViewHolder VH = new ViewHolder(v);
        return VH;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.valor.setText(gesto.get(position).getValor());
        holder.nombre.setText(gesto.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return gesto.size();
    }

}
