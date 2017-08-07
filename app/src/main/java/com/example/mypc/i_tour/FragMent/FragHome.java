package com.example.mypc.i_tour.FragMent;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mypc.i_tour.Home.AmThuc_Activity;
import com.example.mypc.i_tour.Home.DiadiemActivity;
import com.example.mypc.i_tour.Home.DichvuActivity;
import com.example.mypc.i_tour.R;

/**
 * Created by MyPC on 01/08/2017.
 */

public class FragHome extends Fragment {
    Button btn1,btn2,btn3;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_adress,container,false);
        btn1= (Button)view.findViewById(R.id.iddd);
        btn2= (Button)view.findViewById(R.id.idat);
        btn3= (Button)view.findViewById(R.id.iddv);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DiadiemActivity.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AmThuc_Activity.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DichvuActivity.class));
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}
