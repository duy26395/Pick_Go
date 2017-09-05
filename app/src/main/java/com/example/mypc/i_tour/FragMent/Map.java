package com.example.mypc.i_tour.FragMent;

import android.Manifest;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.i_tour.Data.Data_diadiem;
import com.example.mypc.i_tour.Home.Gitservice_dd;
import com.example.mypc.i_tour.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 08/15/2017.
 */

public class Map extends Fragment implements OnMapReadyCallback {
    final String BASE_URL = "http://192.168.181.2/i-Tour/";
    CompositeDisposable mCompositeDisposable;
    ArrayList<Data_diadiem> arrayList;
    GoogleMap mgoogleMap;
    MapView mapView;
    private Location mLocation;
    private GPSTracker gpsTracker;
    double latitude, longitude;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.mapView);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (mLocation != null) {
            latitude = mLocation.getLatitude();
            longitude = mLocation.getLongitude();
        }
        LatLng loco = new LatLng(latitude, longitude);
        MapsInitializer.initialize(getActivity());
        mgoogleMap = googleMap;
        loadJSON();
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mgoogleMap.setMyLocationEnabled(true);

//        mgoogleMap.moveCamera(CameraUpdateFactory.newLatLng(loco));
    }

    private Marker options(String latitude, String longitude, String a, String pic) {
        return mgoogleMap.addMarker(new MarkerOptions()
                .position(new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude))).title(a));
    }

    private void loadJSON() {
        mCompositeDisposable = new CompositeDisposable();

        Gitservice_dd gitservice = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Gitservice_dd.class);


        mCompositeDisposable.add(gitservice.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse));
    }

    private void handleResponse(List<Data_diadiem> androidList) {
        arrayList = new ArrayList<>(androidList);
        Log.e("áddddddddđ", String.valueOf(androidList));
        for(int i = 0 ; i < arrayList.size() ; i++ ) {

            options(arrayList.get(i).getLatitude(), arrayList.get(i).getLongitude(), arrayList.get(i).getTendd(),arrayList.get(i).getHinhAnh());
        }
    }

}
