package com.example.mypc.i_tour.FragMent;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mypc.i_tour.Data.Data_favorite;
import com.example.mypc.i_tour.Home.Onitemclick;
import com.example.mypc.i_tour.R;
import com.example.mypc.i_tour.SQL.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 08/08/2017.
 */

public class Adapter_user extends RecyclerView.Adapter<Adapter_user.ViewHolder> {

    public List<Data_favorite> mAndroidList;
    public Context context;
    DBHelper dbHelper;

    public Adapter_user(List<Data_favorite> mAndroidList, Context context) {
        if (mAndroidList == null) {
            this.mAndroidList = new ArrayList<>();
        }
        this.mAndroidList = mAndroidList;
        this.context = context;
        dbHelper = new DBHelper(context.getApplicationContext());
    }

    @Override
    public Adapter_user.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);
        return new Adapter_user.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Adapter_user.ViewHolder holder, int position) {
        holder.bindData(mAndroidList.get(position));
        Log.e("DBHELP", String.valueOf(dbHelper));
        holder.btXoa.setOnClickListener(view -> {

            dbHelper.delete(mAndroidList.get(position).getId());
            mAndroidList.remove(position);
            notifyDataSetChanged();

            Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show();
            Log.e("ahiiiiiiiiiiiiii", String.valueOf(dbHelper));
        });
        holder.setonclick((v, post) -> {
            Log.e("ahihihi","ạdhakfhkjdlf");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            String c =  holder.mTvName.getText().toString();
            String d = holder.mIntro.getText().toString();
            builder.setTitle(c);
            builder.setMessage(d);
            builder.show();
        });

    }


    @Override
    public int getItemCount() {
        return mAndroidList == null ? 0 : mAndroidList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTvName,mIntro;
        private Button btXoa;
        ImageView mImage;
        private Onitemclick onitemclick;

        ViewHolder(View view) {
            super(view);
            mTvName = (TextView) view.findViewById(R.id.user_ten);
            mIntro = (TextView)view.findViewById(R.id.user_mota);
            mImage = (ImageView) view.findViewById(R.id.user_img);
            btXoa = (Button) view.findViewById(R.id.btn_xoa);

        }
        void bindData(Data_favorite data_tt) {
            mTvName.setText(data_tt.getName());
            mIntro.setText(data_tt.getIntro());
            Glide.with(itemView.getContext())
                    .load(data_tt.getImage())
                    .into(mImage);
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