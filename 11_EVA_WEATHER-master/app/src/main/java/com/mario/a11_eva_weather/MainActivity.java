package com.mario.a11_eva_weather;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;







public static void nuke() {
        try {
        TrustManager[] trustAllCerts = new TrustManager[] {
        new X509TrustManager() {
public X509Certificate[] getAcceptedIssuers() {
        X509Certificate[] myTrustedAnchors = new X509Certificate[0];
        return myTrustedAnchors;
        }

@Override
public void checkClientTrusted(X509Certificate[] certs, String authType) {}

@Override
public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
@Override
public boolean verify(String arg0, SSLSession arg1) {
        return true;
        }
        });
        } catch (Exception e) {
        }
        }
        }











public class MainActivity extends AppCompatActivity{
//implements ListView.OnItemClickListener{
ListView listview1Clima;
List<weather> lstCiudades = new ArrayList();
    private Object AdapterView;
/*weather[] cities = {
        new weather("chihuahua",20,"tornado", R.drawable.tornado),
        new weather("delicias",-5,"despejado", R.drawable.sunny),
        new weather("camargo",20,"nublado", R.drawable.snow),
        new weather("parral",4,"nublado", R.drawable.rainy),
        new weather("cuauhtemoc",8,"nublado", R.drawable.thunderstorm),
        new weather("creel",10,"nublado", R.drawable.atmospher),
        new weather("juarez",3,"nublado", R.drawable.light_rain),
        new weather("satevo",6,"nublado", R.drawable.thunderstorm),
        new weather("delicias",30,"nublado", R.drawable.sunny),
        new weather("chihuahua",14,"nublado", R.drawable.rainy)

};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview1Clima = findViewById(R.id.listview1);
      //  imageViewnclima = findViewById(R.id.imgViewWeather);
       // listview1Clima.setAdapter(new weatherAdapter(this,R.layout.mi_layout,cities));

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=439d4b804bc8187953eb36d2a8c26a02",
                null,
               new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){

                try {
                    JSONArray jsonArray = response.getJSONArray("list");
                    for(int i=0; i< jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        weather wCiudad = new weather();
                        wCiudad.setCity(jsonObject.getString("name"));
                        JSONObject jsMain = jsonObject.getJSONObject("main");
                        wCiudad.setWeather((int)jsMain.getDouble("temp"));


                        JSONArray jaClima = jsonObject.getJSONArray("weather");
                        JSONObject joClimaCiudad =  jaClima.getJSONObject(0);
                        wCiudad.setDescription(joClimaCiudad.getString(description));
                        int iId = joClimaCiudad.getInt("id");

                        if(iId < 300){
                            wCiudad.setImage(R.drawable.thunderstorm);
                        }else if(iId < 400){
                            wCiudad.setImage(R.drawable.light_rain);
                        }else if()iId < 600){
                            wCiudad.setImage(R.drawable.rainy);

                        }else if(iId < 700){
                        wCiudad.setImage(R.drawable.snow);
                    }
                         else if(iId < 801){
                    wCiudad.setImage(R.drawable.thunderstorm);
                }else if(iId < 900){
                    wCiudad.setImage(R.drawable.cloudy);
                }
                         lstCiudades.add(wCiudad);
                }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Aqui se conecta el adaptador a nuestros datos
                lstVwClima.setAdapter(new weatherAdapter(MainActivity.this,
                        R.layout.mi_layout, lstCiudades));



            }
        },
            new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
    }
        );
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }
}
