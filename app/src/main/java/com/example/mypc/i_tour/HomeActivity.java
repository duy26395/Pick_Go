package com.example.mypc.i_tour;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.mypc.i_tour.Data.Data_favorite;
import com.example.mypc.i_tour.FragMent.Adapter_user;
import com.example.mypc.i_tour.FragMent.FragHome;
import com.example.mypc.i_tour.FragMent.FragUser;
import com.example.mypc.i_tour.FragMent.FragWeather;
import com.example.mypc.i_tour.FragMent.Fragment_About;
import com.example.mypc.i_tour.FragMent.Map;
import com.example.mypc.i_tour.SQL.DBHelper;


public class HomeActivity extends AppCompatActivity {
    DBHelper dbHelper;
    Adapter_user mAdapter;
    Data_favorite data_favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,new Map()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_map :
                    MapsActivity();
                    return true;
                case R.id.navigation_home:
                    Frag_homebtn();
                    return true;
                case R.id.navigation_dashboard:
                    Frag_User();
                    return  true;
                case R.id.navigation_notifications:
                    Frag_weather();
                    return  true;
                case R.id.navigation_about:
                    Fragment_About();
                    return true;
            }
            return false;
        }
        private void MapsActivity(){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content,new Map()).commit();
        }

        private void Frag_weather() {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content,new FragWeather()).commit();

        }

        private void Frag_User() {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content,new FragUser()).commit();
        }
        private void Fragment_About(){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content,new Fragment_About()).commit();
        }

        private void Frag_homebtn() {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content,new FragHome()).commit();
        }
    };
}
