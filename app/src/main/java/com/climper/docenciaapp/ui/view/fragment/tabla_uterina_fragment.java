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
public class tabla_uterina_fragment extends Fragment {
    private Button btn_calcular;
    private TextInputEditText eg, inmp;
    private GraphView graph;
    private PointsGraphSeries<DataPoint> puntoInsert;

    public tabla_uterina_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tabla_uterina, container, false);
        eg = (TextInputEditText) root.findViewById(R.id.uterina_gesto_value);
        inmp = (TextInputEditText) root.findViewById(R.id.uterina_inmp_value);
        btn_calcular = (Button) root.findViewById(R.id.btn_uterina_calcular);
        graph = (GraphView) root.findViewById(R.id.graph_uterina);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(11, 2.96),
                new DataPoint(12, 2.64),
                new DataPoint(13, 2.39),
                new DataPoint(14, 2.19),
                new DataPoint(15, 2.04),
                new DataPoint(16, 1.91),
                new DataPoint(17, 1.81),
                new DataPoint(18, 1.72),
                new DataPoint(19, 1.64),
                new DataPoint(20, 1.58),
                new DataPoint(21, 1.52),
                new DataPoint(22, 1.47),
                new DataPoint(23, 1.43),
                new DataPoint(24, 1.39),
                new DataPoint(25, 1.35),
                new DataPoint(26, 1.32),
                new DataPoint(27, 1.29),
                new DataPoint(28, 1.27),
                new DataPoint(29, 1.24),
                new DataPoint(30, 1.22),
                new DataPoint(31, 1.20),
                new DataPoint(32, 1.18),
                new DataPoint(33, 1.17),
                new DataPoint(34, 1.15),
                new DataPoint(35, 1.14),
                new DataPoint(36, 1.12),
                new DataPoint(37, 1.11),
                new DataPoint(38, 1.10),
                new DataPoint(39, 1.09),
                new DataPoint(40, 1.08),
                new DataPoint(41, 1.07)
        });
        graph.addSeries(series);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double val[] = {2.96, 2.64, 2.39, 2.19, 2.04, 1.91, 1.81, 1.72, 1.64, 1.58, 1.52, 1.47, 1.43, 1.39, 1.35, 1.32, 1.29, 1.27, 1.24, 1.22, 1.20, 1.18, 1.17, 1.15, 1.14, 1.12, 1.11, 1.10, 1.09, 1.08, 1.07};


                if(eg.getText().toString().equals("") || inmp.getText().toString().equals("")){
                    Toast.makeText(getContext(),"Ingrese los datos correspondientes", Toast.LENGTH_SHORT).show();
                }else{
                    int a= Integer.parseInt(eg.getText().toString());
                    double b = Double.parseDouble(inmp.getText().toString());
                    if(10<a && a<42){
                        if (val[a-11] < b)
                            Toast.makeText(getContext(),"Es un caso patológico", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getContext(),"No un caso patológico", Toast.LENGTH_SHORT).show();
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
