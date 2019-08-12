package com.morpheus.appcg.Model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.morpheus.appcg.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LinesChart
{
    private Context context;
    private List<String> fechaList;
    private List<Double> pesoList;

    public LinesChart(List<Double> pesoList, List<String> fechaList, Context context)
    {
        this.context = context;
        this.pesoList = pesoList;
        this.fechaList = fechaList;
    }

    public void drawChart(LineChart chart)
    {
        chart.setDrawGridBackground(false);
        chart.setDescription(null);
        chart.setNoDataText("No hay elementos suficientes a graficar");
        chart.setTouchEnabled(true);

        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);
        chart.setPinchZoom(true);

        LimitLine llAxis = new LimitLine(10f, "Index 10");
        llAxis.setLineWidth(4f);
        llAxis.enableDashedLine(10f, 10f, 0f);
        llAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        llAxis.setTextSize(10f);

        XAxis xAxis = chart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setValueFormatter(new LabelFormatter(fechaList));

        LimitLine ll1 = new LimitLine(100f, "Maximo hacia arriba");
        ll1.setLineWidth(4f);
        ll1.enableDashedLine(10f, 10f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        ll1.setTextSize(10f);

        LimitLine ll2 = new LimitLine(0f, "Minimo hacia abajo");
        ll2.setLineWidth(4f);
        ll2.enableDashedLine(10f, 10f, 0f);
        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        ll2.setTextSize(10f);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(ll2);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLimitLinesBehindData(true);
        leftAxis.setValueFormatter(new NumberFormatter());

        //Saca el valor máximo mas 20%
        leftAxis.setAxisMaximum(valueMax(pesoList) + 1);
        leftAxis.setAxisMinimum(valueMin(pesoList) - 1);

        chart.getAxisRight().setEnabled(false);

        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setEnabled(false);

        //Pasa los datos
        List<Entry> entries = new ArrayList<>();
        for(int i = 0; i < pesoList.size(); i++)
            entries.add(new Entry(i, ((Number) pesoList.get(i)).floatValue()));

        LineDataSet dataSet;

        //Define detalles finales
        dataSet = new LineDataSet(entries, "Datos");
        dataSet.enableDashedLine(10f, 5f, 0f);
        dataSet.getColor(Color.BLACK);
        dataSet.setCircleColor(Color.BLACK);
        dataSet.setCircleRadius(3f);
        dataSet.setLineWidth(1f);
        dataSet.setDrawCircleHole(false);
        dataSet.setValueTextSize(9f);
        dataSet.setDrawFilled(true);

        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.fade_red);
        dataSet.setFillDrawable(drawable);

        List<ILineDataSet> lineDataSet = new ArrayList<>();
        lineDataSet.add(dataSet);

        LineData data = new LineData(lineDataSet);
        chart.setData(data);

        chart.animateX(pesoList.size() * 83);
        chart.invalidate();
    }

    //Saca el valor maximo de una lista
    private static float valueMax(List<Double> lista)
    {
        if(lista.size() == 0)
            return 0;

        double valor = lista.get(0);
        for(int i = 0; i < lista.size(); i++)
            if(valor < lista.get(i))
                valor = lista.get(i);

        return (float)valor;
    }

    //Saca el valor minimo de una lista
    private static float valueMin(List<Double> lista)
    {
        if(lista.size() == 0)
            return 0;

        double valor = lista.get(0);
        for(int i = 0; i < lista.size(); i++)
            if(valor > lista.get(i))
                valor = lista.get(i);

        return (float)valor;
    }

    //Clase que le da formato a las etiquetas
    private static class LabelFormatter implements IAxisValueFormatter
    {
        private List<String> etiquetas;

        public LabelFormatter(List<String> etiquetas)
        {
            this.etiquetas = etiquetas;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis)
        {
            return etiquetas.get((int)value);
        }
    }

    //Clase que le da formato a las cantidades numericas
    private static class NumberFormatter implements IAxisValueFormatter
    {
        private DecimalFormat decimalFormat;

        public NumberFormatter()
        {
            decimalFormat = new DecimalFormat("###,###");
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis)
        {
            return decimalFormat.format(value);
        }
    }
}
