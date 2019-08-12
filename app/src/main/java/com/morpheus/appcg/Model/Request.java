package com.morpheus.appcg.Model;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;
import java.util.Map;

public class Request
{
    public interface OnRequestListener<T>
    {
        void onSuccess(T response);
        void onFailed(String error, int statusCode);
    }

    public interface OnResultElementListener<T>
    {
        void onSuccess(T response);
        void onFailed(String error, int statusCode);
    }

    public interface OnResultListListener<T>
    {
        void onSuccess(List<T> response);
        void onFailed(String error, int statusCode);
    }

    //Clase que contiene las peticiones GET
    public static class GET
    {
        private String url;
        private Context context;

        public GET(Context context, String url)
        {
            this.url = url;
            this.context = context;
        }

        public StringRequest getResponse(final OnRequestListener<String> listener, String tag)
        {
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest request = new StringRequest(com.android.volley.Request.Method.GET, url, new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    listener.onSuccess(response);
                }
            }, new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    listener.onFailed(error.toString(), error.networkResponse != null ? error.networkResponse.statusCode : 0);
                }
            });

            request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            request.setTag(tag);

            queue.add(request);

            return request;
        }
    }

    //Clase que contiene las peticiones POST
    public static class POST
    {
        private Context context;
        private String url;
        private Map<String, String> parametros;

        public POST(Context context, String url, Map<String, String> parametros)
        {
            this.context = context;
            this.url = url;
            this.parametros = parametros;
        }

        public StringRequest getResponse(final OnRequestListener<String> listener, String tag)
        {
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    listener.onSuccess(response);
                }
            }, new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    listener.onFailed(error.toString(), error.networkResponse != null ? error.networkResponse.statusCode : 0);
                }
            })
            {
                @Override
                public String getBodyContentType()
                {
                    return "application/x-www-form-urlencoded; charset=utf-8";
                }

                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {
                    return parametros;
                }
            };

            request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            request.setTag(tag);
            queue.add(request);

            return request;
        }
    }
}
