package com.example.mypc.i_tour.Home;

import com.example.mypc.i_tour.Data.Data_diadiem;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by MyPC on 02/08/2017.
 */

public interface Gitservice_dd {
    @GET("danhsach.php")
    io.reactivex.Observable<List<Data_diadiem>> register();
}
