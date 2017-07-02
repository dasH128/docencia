package com.climper.docenciaapp.ui.view.fragment;

import android.content.Context;
import android.net.Uri;
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
public class tabla_umbilical_fragment extends Fragment {
    private Button btn_calcular;
    private TextInputEditText eg, inmp;
    private GraphView graph;
    private PointsGraphSeries<DataPoint> puntoInsert;

    public tabla_umbilical_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tabla_umbilical, container, false);
        eg = (TextInputEditText) root.findViewById(R.id.umbilical_gesto_value);
        inmp = (TextInputEditText) root.findViewById(R.id.umbilical_inmp_value);
        btn_calcular = (Button) root.findViewById(R.id.btn_umbilical_calcular);
        graph = (GraphView) root.findViewById(R.id.graph_umbilical);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {

                new DataPoint(14, 2.35),
                new DataPoint(15, 2.18),
                new DataPoint(16, 2.04),
                new DataPoint(17, 1.93),
                new DataPoint(18, 1.83),
                new DataPoint(19, 1.75),
                new DataPoint(20, 1.68),
                new DataPoint(21, 1.62),
                new DataPoint(22, 1.56),
                new DataPoint(23, 1.51),
                new DataPoint(24, 1.47),
                new DataPoint(25, 1.43),
                new DataPoint(26, 1.40),
                new DataPoint(27, 1.37),
                new DataPoint(28, 1.34),
                new DataPoint(29, 1.31),
                new DataPoint(30, 1.29),
                new DataPoint(31, 1.27),
                new DataPoint(32, 1.25),
                new DataPoint(33, 1.23),
                new DataPoint(34, 1.21),
                new DataPoint(35, 1.20),
                new DataPoint(36, 1.18),
                new DataPoint(37, 1.17),
                new DataPoint(38, 1.15),
                new DataPoint(39, 1.14),
                new DataPoint(40, 1.13)
        });
        graph.addSeries(series);


        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double val[] = {2.35, 2.18, 2.04, 1.93, 1.83, 1.75, 1.68, 1.62, 1.56, 1.51, 1.47, 1.43, 1.40, 1.37, 1.34, 1.31, 1.29, 1.27, 1.25, 1.23, 1.21, 1.20, 1.18, 1.17, 1.15, 1.14, 1.13};

                if(eg.getText().toString().equals("") || inmp.getText().toString().equals("")){
                    Toast.makeText(getContext(),"Ingrese los datos correspondientes", Toast.LENGTH_SHORT).show();
                }else{
                    int a= Integer.parseInt(eg.getText().toString());
                    double b = Double.parseDouble(inmp.getText().toString());
                    if (13<a && a<41){
                        if (val[a-14] < b)
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
