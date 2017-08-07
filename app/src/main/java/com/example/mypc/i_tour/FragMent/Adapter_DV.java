package com.example.mypc.i_tour.FragMent;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by MyPC on 03/08/2017.
 */

public class Adapter_DV extends FragmentPagerAdapter {
    Context context;

    public Adapter_DV(FragmentManager fm, Context context) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment_KS tb1 = new Fragment_KS();
                return tb1;
            case 1:
                fragment_NH tb2 = new fragment_NH();
                return tb2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Khách Sạn";
            case 1:
                return "Nhà Hàng";
        }
        return null;
    }
}
