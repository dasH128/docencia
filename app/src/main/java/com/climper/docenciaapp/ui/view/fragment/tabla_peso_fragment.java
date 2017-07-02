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
public class tabla_peso_fragment extends Fragment {
    private Button btn_calcular;
    private TextInputEditText eg, inmp;
    private GraphView graph;
    private PointsGraphSeries<DataPoint> puntoInsert;

    public tabla_peso_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tabla_peso, container, false);
        eg = (TextInputEditText) root.findViewById(R.id.peso_gesto_value);
        inmp = (TextInputEditText) root.findViewById(R.id.peso_inmp_value);
        btn_calcular = (Button) root.findViewById(R.id.btn_peso_calcular);
        graph = (GraphView) root.findViewById(R.id.graph_peso);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {

                new DataPoint(24, 690),
                new DataPoint(25, 690),
                new DataPoint(26, 710),
                new DataPoint(27, 770),
                new DataPoint(28, 860),
                new DataPoint(29, 980),
                new DataPoint(30, 1125),
                new DataPoint(31, 1295),
                new DataPoint(32, 1475),
                new DataPoint(33, 1665),
                new DataPoint(34, 1860),
                new DataPoint(35, 2060),
                new DataPoint(36, 2250),
                new DataPoint(37, 2435),
                new DataPoint(38, 2600),
                new DataPoint(39, 2750),
                new DataPoint(40, 2875)
        });
        graph.addSeries(series);


        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double val[] = {690, 690, 710, 770, 860, 980, 1125, 1295, 1475, 1665, 1860, 2060, 2250, 2435, 2600, 2750, 2875};


                if(eg.getText().toString().equals("") || inmp.getText().toString().equals("")){
                    Toast.makeText(getContext(),"Ingrese los datos correspondientes", Toast.LENGTH_SHORT).show();
                }else{
                    int a= Integer.parseInt(eg.getText().toString());
                    double b = Double.parseDouble(inmp.getText().toString());
                    if (23<a && a<41){
                        if (val[a-24] < b)
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
