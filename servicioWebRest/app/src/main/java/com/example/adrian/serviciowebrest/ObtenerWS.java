package com.example.adrian.serviciowebrest;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by Adrian on 30/09/2016.
 */

public class ObtenerWS extends AsyncTask<String,String,Boolean> {
    String respStr;

    @Override
    protected Boolean doInBackground(String... params) {


        Boolean resul  =true;

        HttpClient httpClient = new DefaultHttpClient();

        HttpGet url = new HttpGet ("http://indicadoresdeldia.cl/webservice/indicadores.json");

        url.setHeader ("content-type","application/json");

        try{
            HttpResponse respuesta = httpClient.execute(url);
            respStr = EntityUtils.toString(respuesta.getEntity());
            JSONObject respJSON = new JSONObject(respStr);


        }catch(Exception ex){
            Log.e("ServicioRest","Error!", ex);
            resul = false;
        }

        return resul;
    }

    protected void onPostExecute(Boolean result) {

        if (result)
        {

        }
    }
}
