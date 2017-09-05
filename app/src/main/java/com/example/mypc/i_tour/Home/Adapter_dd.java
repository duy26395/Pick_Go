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
import com.example.mypc.i_tour.Data.Data_diadiem;
import com.example.mypc.i_tour.R;

import java.util.ArrayList;

/**
 * Created by MyPC on 02/08/2017.
 */

public class Adapter_dd extends RecyclerView.Adapter<Adapter_dd.ViewHolder> {

    private ArrayList<Data_diadiem> mAndroidList;
    private Context context;

    public Adapter_dd(Context context, ArrayList<Data_diadiem> mAndroidList) {
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
        final  String id = mAndroidList.get(position).getIDDd();
        final  String  name = mAndroidList.get(position).getTendd();
        final  String  gt = mAndroidList.get(position).getMota();
        final String hinh = mAndroidList.get(position).getHinhAnh();
        holder.setonclick((v, post) -> opendetail(id,name,hinh,gt));


    }
    private void opendetail(String id,String name, String hinh, String gt) {
        Intent intent =new Intent(context,DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ID_KEY",id);
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


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTvName, mTvintro;
        private ImageView imageView;
        private Onitemclick onitemclick;

        ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.idimg);
            mTvName = (TextView)view.findViewById(R.id.idtieude);
            mTvintro = (TextView)view.findViewById(R.id.idmota);

        }

        void bindData(Data_diadiem data_tt) {
            mTvName.setText(data_tt.getTendd());
            mTvintro.setText(data_tt.getMota());
            Glide.with(itemView.getContext())
                    .load(data_tt.getHinhAnh())
                    .into(imageView);
            itemView.setOnClickListener(this);
        }
        void setonclick(Onitemclick onitemclick)
        {
            this.onitemclick = onitemclick;
        }

        @Override
        public void onClick(View view) {
            onitemclick.onItem(view,getAdapterPosition());
        }

    }
}
