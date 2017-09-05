package com.example.mypc.i_tour.FragMent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.i_tour.Data.Data_nhahang;
import com.example.mypc.i_tour.Home.Adapter_nhahang;
import com.example.mypc.i_tour.Home.Gitservice_nh;
import com.example.mypc.i_tour.R;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 03/08/2017.
 */

public class fragment_NH extends Fragment {
    final String BASE_URL = "http://192.168.181.2/i-Tour/";
    CompositeDisposable mCompositeDisposable;
    RecyclerView recyclerView;
    ArrayList arrayList;
    Adapter_nhahang mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_adress, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.id_listdd);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
        return view;

    }
    private void loadJSON() {
        mCompositeDisposable = new CompositeDisposable();

        Gitservice_nh gitservice = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Gitservice_nh.class);


        mCompositeDisposable.add(gitservice.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse));
    }

    private void handleResponse(List<Data_nhahang> androidList) {
        arrayList = new ArrayList<Data_nhahang>(androidList);
        mAdapter = new Adapter_nhahang(getActivity(),(ArrayList<Data_nhahang>) androidList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
