package com.climper.docenciaapp.ui.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.climper.docenciaapp.R;

public class Diplo_Curso_Detalle extends AppCompatActivity {
    private ImageView img;
    private TextView txt_nombre, txt_detalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplo_curso_detalle);

        img = (ImageView) findViewById(R.id.course_detalle_imagen_item);
        txt_nombre = (TextView) findViewById(R.id.course_detalle_nombre_item);
        txt_detalle = (TextView) findViewById(R.id.course_detalle_detalle_item);

        String st = getIntent().getExtras().getString("idmodulo");
        int id = Integer.parseInt(st);
        Log.i("T->",id+"");
        switch (id){
            case 28: img.setImageResource(R.drawable.modulo_5_10); txt_nombre.setText("CURSOS ECOGRAFÍA MORFOLÓGICA");
                txt_detalle.setText("El presente curso nos permitirá realizar una exploración precisa y detallada del feto entre las 20 y las 24 semanas de edad gestacional, conoceremos la técnica adecuada de la medición del pliegue nucas, medición del hueso nasal, así como hacer un estudio detallado del sistema nervioso central y del corazón fetal principalmente."); break;
            case 29: img.setImageResource(R.drawable.modulo_5_11); txt_nombre.setText("CURSO ECOGRAFÍA DOPPLER");
                txt_detalle.setText("Este curso nos permitirá dominar la técnica ecográfica doppler, la cual servirá de herramienta valiosa para detectar posibles retardos del crecimiento intrauterino entre otras patologías; dominaremos la técnica adecuada de la toma del doppler umbilical, cerebral media y uterinas. ");break;
            case 30: img.setImageResource(R.drawable.modulo_5_12); txt_nombre.setText("CURSO DE ECOGRAFÍA 3D 4D");
                txt_detalle.setText("El presente curso nos permitirá dominar la técnica adecuada de la toma del 3D y 4D así como hacer los cortes adecuados para evaluar la cara fetal y conocer algunos secretos ultrasonográfico para hacer un ecografía 3d y 4 d eficiente .");break;
            case 70: img.setImageResource(R.drawable.id_img_diplomado); txt_nombre.setText("CURSO ECOGRAFIA GENETICA");
                txt_detalle.setText("El presente curso tiene por objetivo hacer un estudio por menorizado del feto entre las 11 y 13 semanas y 6 días, conociendo detalladamente su morfología, dominar la técnica adecuada de la medición de la translucencia nucal, evaluar el hueso nasas y dominar la técnica correcta de la isonación del ductus venoso; esto nos permitirá tener una certeza de más del 90% de que el feto se encuentra en buenas condiciones.");break;
            case 71: img.setImageResource(R.drawable.id_img_diplomado); txt_nombre.setText("CURSO DE TÉCNICA ECOGRÁFICA OBSTÉTRICA");
                txt_detalle.setText("El presente curso nos permite dominar la técnica correcta de hacer una exploración biométrica fetal, medir en forma adecuada el diámetro biparietal, el perímetro cefálico, la circunferencia abdominal y el fémur de tal manera que podemos precisar con mayor certeza su edad gestacional y su peso.");break;
        }

    }
}
