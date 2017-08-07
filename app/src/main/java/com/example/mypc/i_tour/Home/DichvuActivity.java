package com.example.mypc.i_tour.Home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mypc.i_tour.FragMent.Adapter_DV;
import com.example.mypc.i_tour.R;

public class DichvuActivity extends AppCompatActivity {

    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dichvu);

        View viewPage = (ViewPager)findViewById(R.id.view_pager);
        tabLayout = (TabLayout)findViewById(R.id.idtab);
        tabLayout.setupWithViewPager((ViewPager) viewPage);
        ((ViewPager) viewPage).setAdapter(new Adapter_DV(getSupportFragmentManager(),this));
    }
}
