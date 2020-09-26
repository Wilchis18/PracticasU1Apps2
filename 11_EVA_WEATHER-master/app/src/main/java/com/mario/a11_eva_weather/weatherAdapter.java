package com.mario.a11_eva_weather;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class weatherAdapter extends ArrayAdapter <weather> {
   // weather[] objects;
    private List<Weather> objects;
    Context context;
    int resource;
    public weatherAdapter(@NonNull Context context, int resource, @NonNull weather[] objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
        this.resource = resource;

    }
    @NonNull
    @Override
    // este metodo identifica cual view mostrar
    public View getView(int position, @Nullable View convertView, @NonNull List objects
    ) {

        if (convertView == null) {// primera vez, hay que crear el layout
            convertView = ((Activity)context).getLayoutInflater().inflate(resource,parent,false);
        }
        //hay que recupera los componentes
        ImageView imageViewWeather;
        TextView txtCity,txtVtemp,txtDesc;
        imageViewWeather = convertView.findViewById(R.id.imgViewWeather);
        txtCity = convertView.findViewById(R.id.txtviewLocacion);
        txtVtemp = convertView.findViewById(R.id.txtviewGrados);
        txtDesc= convertView.findViewById(R.id.txtview_descrip);
        //CONEXION
        Weather weather = objects.get(position);
        imageViewWeather.setImageResource(objects[position].getImage());
        txtCity.setText(objects[position].getCity());
        txtDesc.setText(objects[position].getDescription());
        txtVtemp.setText(""+ objects[position].getWeather());
        return convertView;


        // este metodo identifica cual view mostrar

    }


}
