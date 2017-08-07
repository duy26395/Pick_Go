package com.example.mypc.i_tour.FragMent;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mypc.i_tour.Data.Data_weather;
import com.example.mypc.i_tour.R;
import com.example.mypc.i_tour.Weather.Adapter_Weather;
import com.example.mypc.i_tour.Weather.DownloadJsonAsyncTask;
import com.example.mypc.i_tour.Weather.DownloadJsonAsyncTaskListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.mypc.i_tour.R.layout.activity_list_weather;

/**
 * Created by MyPC on 01/08/2017.
 */

public class FragWeather extends Fragment implements DownloadJsonAsyncTaskListener {
    private ListView myListView;
    private Adapter_Weather myAdapter;
    private ArrayList<Data_weather> weatherDataSource;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(activity_list_weather, container, false);


        myListView = (ListView)view.findViewById(R.id.mylistview);
        //step 2: data source
        weatherDataSource = new ArrayList<>();

        DownloadJsonAsyncTask downloadJsonAsyncTask = new DownloadJsonAsyncTask();
        downloadJsonAsyncTask.SetLister(this);
        downloadJsonAsyncTask.execute("https://api.myjson.com/bins/4z4r4");
        //step 3: create adapter
        myAdapter = new Adapter_Weather(getActivity(), R.layout.item_weather, weatherDataSource);
        //step 4:
        myListView.setAdapter(myAdapter);
        return view;
    }
    @Override
    public void OnFinisheDownload(String result) {
        ParseJson(result);
    }
    public void ParseJson(String jsonString) {
        try{
            JSONObject jsonRootObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonRootObject.optJSONArray("Weather");
            for (int i=0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String cityName = jsonObject.optString("cityName");
                String weather = jsonObject.optString("weather");
                String temperature = jsonObject.optString("temperature");
                String icon = jsonObject.optString("icon");
                weatherDataSource.add(new Data_weather(cityName, weather, temperature, icon));
            }
            myAdapter.notifyDataSetChanged();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
