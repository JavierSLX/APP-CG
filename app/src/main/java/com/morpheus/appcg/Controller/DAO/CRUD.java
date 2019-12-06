package com.morpheus.appcg.Controller.DAO;

import android.content.Context;

import java.util.List;

public interface CRUD<T>
{
    List<T> listar(Context context);
    void insertar(Context context, T t);
    T buscar(Context context, int id);
    void eliminar(Context context, int id);
    void actualizar(Context context, int id, T t);
}
