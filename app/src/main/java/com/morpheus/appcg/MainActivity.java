package com.morpheus.appcg;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.morpheus.appcg.Controller.MedidaDAO;
import com.morpheus.appcg.Model.LinesChart;
import com.morpheus.appcg.Model.Medida;
import com.morpheus.appcg.Model.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener
{
    private TextView txtGC;
    private EditText edtPeso;
    private LineChart chartPeso;
    private ProgressDialog progressDialog;
    private List<Medida> medidas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chartPeso = (LineChart) findViewById(R.id.chartPeso);
        txtGC = (TextView)findViewById(R.id.txtGC);
        edtPeso = (EditText)findViewById(R.id.edtPeso);
        Button btAgregar = (Button)findViewById(R.id.btAgregar);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        getData();

        //Eventos
        btAgregar.setOnClickListener(eventAgregar);
        chartPeso.setOnChartValueSelectedListener(this);
    }

    private View.OnClickListener eventAgregar = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            progressDialog.show();
            String cadena = edtPeso.getText().toString();
            if(cadena.length() == 0)
            {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Coloque el valor a registrar", Toast.LENGTH_SHORT).show();
            }
            else
            {
                MedidaDAO.getInstance().setValue(MainActivity.this, Double.valueOf(cadena), new Request.OnResultElementListener<String>()
                {
                    @Override
                    public void onSuccess(String response)
                    {
                        progressDialog.dismiss();
                        getData();
                    }

                    @Override
                    public void onFailed(String error, int statusCode)
                    {
                        Toast.makeText(MainActivity.this, error + " " + statusCode, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    };

    private void getData()
    {
        progressDialog.show();

        MedidaDAO.getInstance().getData(this, new Request.OnResultListListener<Medida>()
        {
            @Override
            public void onSuccess(List<Medida> response)
            {
                progressDialog.dismiss();
                medidas = response;
                doChart(response);

                //Asigna el ultimo valor GC al TextView
                asignarGC(response.get(response.size() - 1).getGc());
            }

            @Override
            public void onFailed(String error, int statusCode)
            {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, error + " " + statusCode, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void doChart(List<Medida> lista)
    {
        List<Double> pesos = new ArrayList<>();
        List<String> fechas = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++)
        {
            pesos.add(lista.get(i).getPeso());

            String[] cadena = lista.get(i).getFecha().split("/");
            fechas.add(cadena[0] + "/" + cadena[1]);
        }

        LinesChart linesChart = new LinesChart(pesos, fechas, this);
        linesChart.drawChart(chartPeso);
    }

    //Asigna el valor de GC
    private void asignarGC(double value)
    {
        if(value > 25)
            txtGC.setTextColor(getResources().getColor(android.R.color.holo_red_light));
        else if(value > 20 && value <= 25)
            txtGC.setTextColor(getResources().getColor(android.R.color.holo_orange_light));
        else
            txtGC.setTextColor(getResources().getColor(android.R.color.holo_green_light));

        txtGC.setText(String.format(Locale.getDefault(),"%.2f", value));
    }

    @Override
    public void onValueSelected(Entry e, Highlight h)
    {
        Medida medida = medidas.get((int)e.getX());
        String cadena = "Fecha: " + medida.getFecha() + ", Peso: " + medida.getPeso() + ", GC: " +
                String.format(Locale.getDefault(), "%.2f", medida.getGc());

        Toast.makeText(this, cadena, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected()
    {

    }
}
