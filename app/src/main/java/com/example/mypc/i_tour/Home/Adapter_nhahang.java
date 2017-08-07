package com.example.mypc.i_tour.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.i_tour.Data.Data_nhahang;
import com.example.mypc.i_tour.R;

import java.util.ArrayList;

/**
 * Created by MyPC on 03/08/2017.
 */

public class Adapter_nhahang extends RecyclerView.Adapter<Adapter_nhahang.ViewHolder> {

    private ArrayList<Data_nhahang> mAndroidList;
    private Context context;


    public Adapter_nhahang(Context context,ArrayList<Data_nhahang> mAndroidList) {
        this.mAndroidList = mAndroidList;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dv, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mAndroidList.get(position));
    }

    @Override
    public int getItemCount() {
        return mAndroidList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvName, mTvintro,msdt;
        public ViewHolder(View view) {
            super(view);
            mTvName = (TextView) view.findViewById(R.id.id_tendv);
            mTvintro = (TextView) view.findViewById(R.id.id_dddv);
            msdt = (TextView) view.findViewById(R.id.idsdt);
        }

        public void bindData(Data_nhahang data_tt) {
            mTvName.setText(data_tt.getTenNH());
            mTvintro.setText(data_tt.getDiaChi());
            msdt.setText(data_tt.getSDT());
        }
    }
}
