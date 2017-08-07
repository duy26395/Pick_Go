package com.example.mypc.i_tour.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypc.i_tour.Data.Data_amthuc;
import com.example.mypc.i_tour.R;

import java.util.ArrayList;

/**
 * Created by MyPC on 02/08/2017.
 */

public class Adapter_at extends RecyclerView.Adapter<Adapter_at.ViewHolder> {

    private ArrayList<Data_amthuc> mAndroidList;
    private Context context;


    public Adapter_at(Context context,ArrayList<Data_amthuc> mAndroidList) {
        this.mAndroidList = mAndroidList;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diadiem, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mAndroidList.get(position));
        final  String  name = mAndroidList.get(position).getTenAmthuc();
        final  String  gt = mAndroidList.get(position).getMoTa();
        final String hinh = mAndroidList.get(position).getHinhAnh();
        holder.setonclick(new Onitemclick() {
            @Override
            public void onItem(View v, int post) {

                opendetail(name,hinh,gt);
            }
        });


    }
    private void opendetail(String name, String hinh, String gt) {
        Intent intent =new Intent(context,DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("NAME_KEY",name);
        bundle.putString("IMAGE_KEY",hinh);
        bundle.putString("INTRO_KEY",gt);
        intent.putExtra("DATA",bundle);
        context.startActivity(intent);

    }
    @Override
    public int getItemCount() {
        return mAndroidList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTvName, mTvintro;
        private ImageView imageView;
        private Onitemclick onitemclick;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.idimg);
            mTvName = (TextView) view.findViewById(R.id.idtieude);
            mTvintro = (TextView) view.findViewById(R.id.idmota);

        }

        public void bindData(Data_amthuc data_tt) {
            mTvName.setText(data_tt.getTenAmthuc());
            mTvintro.setText(data_tt.getMoTa());
            Glide.with(itemView.getContext())
                    .load(data_tt.getHinhAnh())
                    .into(imageView);
            itemView.setOnClickListener(this);
        }
        public void setonclick(Onitemclick onitemclick)
        {
            this.onitemclick = onitemclick;
        }

        @Override
        public void onClick(View view) {
            onitemclick.onItem(view,getAdapterPosition());
        }

    }
}

