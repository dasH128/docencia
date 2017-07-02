package com.climper.docenciaapp.ui.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.climper.docenciaapp.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

/**
 * A simple {@link Fragment} subclass.
 */
public class tabla_acm_fragment extends Fragment {
    private Button btn_calcular;
    private TextInputEditText eg, inmp;
    private GraphView graph;
    private PointsGraphSeries<DataPoint> puntoInsert;

    public tabla_acm_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tabla_acm, container, false);
        eg = (TextInputEditText) root.findViewById(R.id.acm_gesto_value);
        inmp = (TextInputEditText) root.findViewById(R.id.acm_inmp_value);
        btn_calcular = (Button) root.findViewById(R.id.btn_acm_calcular);

        graph = (GraphView) root.findViewById(R.id.graph_acm);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {

                new DataPoint(15, 1.02),
                new DataPoint(16, 1.04),
                new DataPoint(17, 1.06),
                new DataPoint(18, 1.07),
                new DataPoint(19, 1.09),
                new DataPoint(20, 1.10),
                new DataPoint(21, 1.11),
                new DataPoint(22, 1.12),
                new DataPoint(23, 1.13),
                new DataPoint(24, 1.13),
                new DataPoint(25, 1.14),
                new DataPoint(26, 1.14),
                new DataPoint(27, 1.14),
                new DataPoint(28, 1.14),
                new DataPoint(29, 1.13),
                new DataPoint(30, 1.13),
                new DataPoint(31, 1.12),
                new DataPoint(32, 1.11),
                new DataPoint(33, 1.10),
                new DataPoint(34, 1.08),
                new DataPoint(35, 1.07),
                new DataPoint(36, 1.05),
                new DataPoint(37, 1.03),
                new DataPoint(38, 1.01),
                new DataPoint(39, 0.99),
                new DataPoint(40, 0.97),
                new DataPoint(41, 0.74)
        });
        graph.addSeries(series);


        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double val[] = { 1.02, 1.04, 1.06, 1.07, 1.09, 1.10, 1.11, 1.12, 1.13, 1.13, 1.14, 1.14, 1.14, 1.14, 1.13, 1.13, 1.12, 1.11, 1.10, 1.08, 1.07, 1.05, 1.03, 1.01, 0.99, 0.97, 0.74};

                if(eg.getText().toString().equals("") || inmp.getText().toString().equals("")){
                    Toast.makeText(getContext(),"Ingrese los datos correspondientes", Toast.LENGTH_SHORT).show();
                }else{
                    int a= Integer.parseInt(eg.getText().toString());
                    double b = Double.parseDouble(inmp.getText().toString());
                    if(14<a && a<42){
                        if (val[a-15] < b)
                            Toast.makeText(getContext(),"No un caso patológico", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getContext(),"Si un caso patológico", Toast.LENGTH_SHORT).show();
                        ShowPunto(a,b);
                    }else{
                        Toast.makeText(getContext(),"No hay registro para determinada edad gestacional", Toast.LENGTH_SHORT).show();
                    }
                }




            }
        });
        return root;
    }
    void ShowPunto(int a, double b){
        graph.removeSeries(puntoInsert);
        puntoInsert = new PointsGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(a,b)
        });
        graph.addSeries(puntoInsert);
    }

}
