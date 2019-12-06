package com.morpheus.appcg.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessMedida
{
    private static ProcessMedida processMedida;

    private ProcessMedida()
    {

    }

    public static ProcessMedida getInstance()
    {
        if(processMedida == null)
            processMedida = new ProcessMedida();

        return processMedida;
    }

    //Cambia la fecha de String a Date
    public Date getDate(String fecha) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        Date date = format.parse(fecha);

        return date;
    }

    //Obtiene la fecha de hoy en String
    public String getTodayDateString()
    {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yy-MM-dd");

        return format.format(date);
    }

    //Obtiene los años que han pasado entre dos fechas
    public long getYears(Date fechaInicial, Date fechaFinal)
    {
        long dif = fechaFinal.getTime() - fechaInicial.getTime();
        return dif / 1000 / 60 / 60 / 24 / 365;
    }

    //Realiza el calculo de grasa corporal
    public double calculoGC(double peso, double estatura, int edad, boolean isHombre)
    {
        double imc = peso / (estatura * estatura);
        double value = isHombre ? 1 : 0;

        return (1.2 * imc) + (0.23 * edad) - (10.8 * value) - 5.4;
    }
}
