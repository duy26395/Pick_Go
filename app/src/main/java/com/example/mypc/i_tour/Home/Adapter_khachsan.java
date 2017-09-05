package com.example.mypc.i_tour.Home;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.i_tour.Data.Data_khachsan;
import com.example.mypc.i_tour.R;

import java.util.ArrayList;

/**
 * Created by MyPC on 05/08/2017.
 */

public class Adapter_khachsan extends RecyclerView.Adapter<Adapter_khachsan.ViewHolder> {

    private ArrayList<Data_khachsan> mAndroidList;
    private Context context;


    public Adapter_khachsan(Context context,ArrayList<Data_khachsan> mAndroidList) {
        this.mAndroidList = mAndroidList;
        this.context = context;
    }



    @Override
    public Adapter_khachsan.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dv, parent, false);
        return new Adapter_khachsan.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Adapter_khachsan.ViewHolder holder, int position) {
        holder.bindData(mAndroidList.get(position));
        holder.setonclick(new Onitemclick() {
            @Override
            public void onItem(View v, int post) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                String c =  holder.mTvName.getText().toString();
                String d = holder.mTvintro.getText().toString();
//                String e = holder.msdt.getText().toString();
                builder.setTitle(c);
                builder.setMessage(d);
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAndroidList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Onitemclick onitemclick;
        private TextView mTvName, mTvintro,msdt;
        public ViewHolder(View view) {
            super(view);
            mTvName = (TextView) view.findViewById(R.id.id_tendv);
            mTvintro = (TextView) view.findViewById(R.id.id_dddv);
            msdt = (TextView) view.findViewById(R.id.idsdt);
        }

        public void bindData(Data_khachsan data_tt) {
            mTvName.setText(data_tt.getTenKS());
            mTvintro.setText(data_tt.getDiaChi());
            msdt.setText(data_tt.getSDT());
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
