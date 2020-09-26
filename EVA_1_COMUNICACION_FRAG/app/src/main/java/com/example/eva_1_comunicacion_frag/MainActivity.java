package com.example.eva_1_comunicacion_frag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//1. RECUPERAR LOS FRAGMENTOS

    ListFragment lista;
    DataFragment datos;

//2. ACCEDER
// HAY UN METODO QUE SE EJECUTA CUANDO UN FRAGMENTO SE VINCULA

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == ListFragment.class)
            lista = (ListFragment) fragment;
        else if(fragment.getClass()== DataFragment.class)
            datos = (DataFragment)fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
