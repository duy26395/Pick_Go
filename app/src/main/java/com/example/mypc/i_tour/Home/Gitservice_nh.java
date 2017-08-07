package com.example.mypc.i_tour.Home;

import com.example.mypc.i_tour.Data.Data_nhahang;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by MyPC on 04/08/2017.
 */

public interface Gitservice_nh{
        @GET("nhahang.php")
        io.reactivex.Observable<List<Data_nhahang>> register();
}
