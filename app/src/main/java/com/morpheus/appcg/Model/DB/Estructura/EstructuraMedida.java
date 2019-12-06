package com.morpheus.appcg.Model.DB.Estructura;

import android.provider.BaseColumns;

public class EstructuraMedida
{
    public static abstract class BaseMedida implements BaseColumns
    {
        public static final String TABLE_NAME = "medida";
        public static final String FECHA = "fecha";
        public static final String PESO = "peso";
        public static final String GC = "gc";
    }
}
