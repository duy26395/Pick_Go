package com.example.mypc.i_tour.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mypc.i_tour.Data.Data_diadiem;
import com.example.mypc.i_tour.R;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiadiemActivity extends AppCompatActivity {
    final String BASE_URL = "http://192.168.181.2/i-Tour/";
    CompositeDisposable mCompositeDisposable;
    Adapter_dd mAdapter;
    RecyclerView recyclerView;
    ArrayList<Data_diadiem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diadiem);
        recyclerView = (RecyclerView) findViewById(R.id.id_listdd);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
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
        arrayList = new ArrayList<Data_diadiem>(androidList);
        mAdapter = new Adapter_dd(this,(ArrayList<Data_diadiem>) androidList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }

}
