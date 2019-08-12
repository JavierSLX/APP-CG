package com.morpheus.appcg.Controller;

import android.content.Context;

import com.android.volley.toolbox.StringRequest;
import com.morpheus.appcg.Model.Medida;
import com.morpheus.appcg.Model.Request;
import com.morpheus.appcg.Resources.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedidaDAO
{
    public static MedidaDAO dao;

    private MedidaDAO()
    {
    }

    public static MedidaDAO getInstance()
    {
        if(dao == null)
            dao = new MedidaDAO();

        return dao;
    }

    //Permite obtener los datos que tiene medida
    public StringRequest getData(Context context, final Request.OnResultListListener<Medida> listener)
    {
        String url = Constants.HOST + "data";

        Request.GET get = new Request.GET(context, url);
        return get.getResponse(new Request.OnRequestListener<String>()
        {
            @Override
            public void onSuccess(String response)
            {
                try
                {
                    JSONArray array = new JSONArray(response);
                    List<Medida> lista = new ArrayList<>();
                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject object = array.getJSONObject(i);
                        Medida medida = new Medida(object.getInt("id"), object.getString("fecha"),
                                object.getDouble("peso"), object.getDouble("gc"));

                        lista.add(medida);
                    }

                    listener.onSuccess(lista);
                }catch (JSONException e)
                {
                    listener.onSuccess(null);
                }
            }

            @Override
            public void onFailed(String error, int statusCode)
            {
                listener.onFailed(error, statusCode);
            }
        }, "data");
    }

    //Permite agregar un nuevo valor
    public StringRequest setValue(Context context, double value, final Request.OnResultElementListener<String> listener)
    {
        String url = Constants.HOST + "setData";
        Map<String, String> params = new HashMap<>();

        params.put("peso", String.valueOf(value));

        Request.POST post = new Request.POST(context, url, params);
        return post.getResponse(new Request.OnRequestListener<String>()
        {
            @Override
            public void onSuccess(String response)
            {
                listener.onSuccess(response);
            }

            @Override
            public void onFailed(String error, int statusCode)
            {
                listener.onFailed(error, statusCode);
            }
        }, "setValue");
    }
}
