package com.example.mypc.i_tour.Home;

import com.example.mypc.i_tour.Data.Data_khachsan;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by MyPC on 05/08/2017.
 */

public interface Gitservice_ks {
    @GET("khachsan.php")
    io.reactivex.Observable<List<Data_khachsan>> register();
}
