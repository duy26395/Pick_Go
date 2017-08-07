package com.example.mypc.i_tour.Weather;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.i_tour.Data.Data_weather;
import com.example.mypc.i_tour.R;

import java.util.List;

import io.reactivex.annotations.Nullable;

/**
 * Created by MyPC on 01/08/2017.
 */

public class Adapter_Weather extends ArrayAdapter<Data_weather> {

    public Adapter_Weather(@NonNull Context context, @LayoutRes int resource, @NonNull List<Data_weather> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Data_weather weather = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_weather, parent, false);
        }

        TextView tvNameCity = (TextView) convertView.findViewById(R.id.tv_namecity);
        TextView tvWeather = (TextView) convertView.findViewById(R.id.tv_weather);
        TextView tvTamperature = (TextView) convertView.findViewById(R.id.tv_temperature);
        ImageView img_icon = (ImageView) convertView.findViewById(R.id.img_icon);

        tvNameCity.setText(weather.getCityName());
        tvWeather.setText(weather.getWeather());
        tvTamperature.setText(weather.getTemperature());

        int imgResource=getContext().getResources().getIdentifier(weather.getIdImage(), "drawable",
                getContext().getPackageName());
        img_icon.setImageResource(imgResource);
        return convertView;
    }
}
