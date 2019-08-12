package com.morpheus.appcg.Model;

import java.util.Locale;

public class Medida
{
    private int id;
    private String fecha;
    private double peso;
    private double gc;

    public Medida(int id, String fecha, double peso, double gc)
    {
        this.id = id;
        this.fecha = fecha;
        this.peso = peso;
        this.gc = gc;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFecha()
    {
        return fecha;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    public double getPeso()
    {
        return peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public double getGc()
    {
        return gc;
    }

    public void setGc(double gc)
    {
        this.gc = gc;
    }

    @Override
    public String toString()
    {
        return String.format(Locale.getDefault(), "ID: %d, Fecha: %s, Peso: %.2f, GC: %.2f", getId(), getFecha(), getPeso(), getGc());
    }
}
