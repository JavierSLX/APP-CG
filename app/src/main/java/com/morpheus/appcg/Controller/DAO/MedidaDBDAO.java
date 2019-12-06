package com.morpheus.appcg.Controller.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.morpheus.appcg.Model.DB.BaseDatos;
import com.morpheus.appcg.Model.DB.Estructura.EstructuraMedida;
import com.morpheus.appcg.Model.Medida;

import java.util.ArrayList;
import java.util.List;

public class MedidaDBDAO implements CRUD<Medida>
{
    private static MedidaDBDAO dao;
    private BaseDatos baseDatos;
    private SQLiteDatabase db;

    private MedidaDBDAO()
    {

    }

    public static MedidaDBDAO getInstance()
    {
        if(dao == null)
            dao = new MedidaDBDAO();

        return dao;
    }

    @Override
    public List<Medida> listar(Context context)
    {
        baseDatos = new BaseDatos(context);
        db = baseDatos.getReadableDatabase();

        List<Medida> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT m.* FROM (SELECT * FROM medida ORDER BY " + EstructuraMedida.BaseMedida._ID + " DESC LIMIT 15) m ORDER BY m._id ASC", null);

        if(cursor.moveToFirst())
        {
            do
            {
                lista.add(new Medida(cursor.getInt(cursor.getColumnIndex(EstructuraMedida.BaseMedida._ID)),
                        cursor.getString(cursor.getColumnIndex(EstructuraMedida.BaseMedida.FECHA)),
                        cursor.getDouble(cursor.getColumnIndex(EstructuraMedida.BaseMedida.PESO)),
                        cursor.getDouble(cursor.getColumnIndex(EstructuraMedida.BaseMedida.GC))));
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return lista;
    }

    @Override
    public void insertar(Context context, Medida medida)
    {
        baseDatos = new BaseDatos(context);
        db = baseDatos.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EstructuraMedida.BaseMedida.FECHA, medida.getFecha());
        values.put(EstructuraMedida.BaseMedida.PESO, medida.getPeso());
        values.put(EstructuraMedida.BaseMedida.GC, medida.getGc());

        db.insert(EstructuraMedida.BaseMedida.TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public Medida buscar(Context context, int id)
    {
        return null;
    }

    @Override
    public void eliminar(Context context, int id)
    {

    }

    @Override
    public void actualizar(Context context, int id, Medida medida)
    {

    }
}
