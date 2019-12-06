package com.morpheus.appcg.Model.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.morpheus.appcg.Model.DB.Estructura.EstructuraMedida;

public class BaseDatos extends SQLiteOpenHelper
{
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS ";
    private static final int VERSION = 1;
    public static final String DATABASE_NAME = "controlgc.sqlite";

    //Borra la tabla
    private static final String SQL_DELETE_MEDIDA = DROP_TABLE + EstructuraMedida.BaseMedida.TABLE_NAME;

    //Tabla DB
    private static final String TABLE_MEDIDA = "CREATE TABLE " + EstructuraMedida.BaseMedida.TABLE_NAME + "(" +
            EstructuraMedida.BaseMedida._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            EstructuraMedida.BaseMedida.FECHA + " TEXT NOT NULL, " +
            EstructuraMedida.BaseMedida.PESO + " REAL NOT NULL, " +
            EstructuraMedida.BaseMedida.GC + " REAL NOT NULL)";

    public BaseDatos(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_MEDIDA);

        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-07", 88.8, 24.54});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-08", 88.4, 24.4});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-09", 88.6, 24.47});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-10", 88.3, 24.35});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-11", 88.4, 24.4});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-12", 87.8, 24.17});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-13", 87.6, 24.10});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-14", 87.7, 24.14});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-15", 87.2, 23.95});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-16", 87.4, 24.03});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-17", 87.3, 23.99});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-18", 86.8, 23.80});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-19", 86.7, 23.76});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-20", 86.5, 23.69});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-21", 86.2, 23.57});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-22", 86.0, 23.50});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-23", 86.1, 23.53});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-24", 86.0, 23.50});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-25", 85.8, 23.42});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-26", 85.5, 23.31});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-27", 85.7, 23.38});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-28", 85.5, 23.31});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-29", 85.3, 23.23});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-30", 85.0, 23.12});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-08-31", 84.8, 23.04});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-01", 84.6, 22.97});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-02", 84.8, 23.04});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-03", 84.4, 22.89});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-04", 84.2, 22.81});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-05", 84.0, 22.74});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-06", 83.7, 22.63});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-10", 83.6, 22.59});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-11", 83.5, 22.55});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-12", 83.5, 22.55});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-13", 83.3, 22.47});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-14", 82.8, 22.28});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-15", 82.6, 22.21});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-16", 82.5, 22.17});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-17", 82.4, 22.13});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-18", 82.0, 21.98});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-19", 82.0, 21.98});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-20", 81.8, 21.91});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-21", 81.5, 21.79});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-23", 81.9, 21.94});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-24", 81.8, 21.91});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-25", 81.6, 21.83});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-26", 81.7, 21.87});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-27", 81.3, 21.72});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-28", 80.9, 21.57});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-29", 80.7, 21.49});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-09-30", 80.9, 21.57});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-01", 80.6, 21.45});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-02", 80.7, 21.49});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-03", 80.4, 21.38});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-04", 80.2, 21.30});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-05", 80.1, 21.26});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-06", 79.7, 21.11});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-07", 79.5, 21.03});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-08", 79.4, 21.00});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-09", 79.4, 21.00});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-10", 79.5, 21.03});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-11", 79.4, 21.00});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-12", 79.2, 20.92});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-13", 79.0, 20.85});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-14", 78.9, 20.81});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-15", 79.2, 20.92});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-16", 79.2, 20.92});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-17", 78.7, 20.73});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-18", 78.4, 20.62});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-19", 78.6, 20.69});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-20", 78.2, 20.54});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-21", 77.8, 20.39});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-22", 78.2, 20.54});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-23", 78.0, 20.47});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-24", 77.7, 20.58});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-25", 78.2, 20.77});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-26", 78.2, 20.77});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-27", 78.0, 20.70});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-28", 77.8, 20.62});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-29", 77.8, 20.62});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-30", 77.6, 20.55});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-10-31", 77.6, 20.55});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-01", 77.4, 20.47});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-02", 77.2, 20.39});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-03", 77.0, 20.32});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-04", 76.8, 20.24});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-05", 76.8, 20.24});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-06", 77.3, 20.43});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-07", 77.1, 20.36});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-08", 77.0, 20.32});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-09", 76.8, 20.24});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-11", 76.5, 20.13});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-12", 76.6, 20.17});
        db.execSQL("INSERT INTO " + EstructuraMedida.BaseMedida.TABLE_NAME + "(fecha, peso, gc) VALUES (?, ?, ?);", new Object[]{"2019-11-14", 76.5, 20.13});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL(SQL_DELETE_MEDIDA);

        onCreate(db);
    }
}
