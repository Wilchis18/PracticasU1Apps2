package com.example.rep_1_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtxVwDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtxVwDatos = findViewById(R.id.txtxVwDatos);
        MiClaseAsincrona mcaPrueba = new MiClaseAsincrona();//objeto de clase asincrona
        mcaPrueba.execute(1,10, 1000); //Se corre con metodo execute



    }
                                        //INPUT, COMUNICACION, OUTPUT
     class MiClaseAsincrona extends AsyncTask<Integer, String, Double>{

      @Override
        protected void onPreExecute() {
        super.onPreExecute();
        txtxVwDatos.append("INICIO DEL HILO");
      }
      @Override // trabajo en segundo plano
        protected Double doInBackground(Integer... integers) {
          int i= integers[0]; //inicio
          while (i <= integers[1]) { //final
              try{
              Thread.sleep(integers[2]);
              publishProgress("Hola mundo!!\n");
          } catch (InterruptedException e){
                  e.printStackTrace();
              }
              i++;
          }
        return null;
      }

      @Override
      protected void onProgressUpdate(String... values) {
         super.onProgressUpdate(values[0]);
          }

                                            @Override
        protected void onPostExecute(Double aDouble) {
        super.onPostExecute(aDouble);
        txtxVwDatos.append("Final del hilo");
       }
      }
}
