package com.example.mypc.i_tour.FragMent;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.i_tour.Data.Data_favorite;
import com.example.mypc.i_tour.R;
import com.example.mypc.i_tour.SQL.DBHelper;

import java.util.List;

/**
 * Created by MyPC on 01/08/2017.
 */

public class FragUser extends Fragment {
    DBHelper dbHelper;
    RecyclerView recyclerView;
    Adapter_user mAdapter;
    List<Data_favorite> data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_adress, container, false);
        dbHelper = new DBHelper(this.getActivity());

        recyclerView = (RecyclerView) view.findViewById(R.id.id_listdd);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new Adapter_user(dbHelper.getallteam(),getActivity());
        recyclerView.setAdapter(mAdapter);
        Log.e("dnsklgnlksg", String.valueOf(data));
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
