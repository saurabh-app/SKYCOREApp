package com.example.skycoreapp.network;

import com.example.skycoreapp.model.MasterResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({
            "authorization: Bearer XPFgzKwZGK1yqRxHi0d5xsARFOLpXIvccQj5jekqTnysweGyoIfVUHcH2tPfGq5Oc9kwKHPkcOjk2d1Xobn7aTjOFeop8x41IUfVvg2Y27KiINjYPADcE7Qza0RkX3Yx"
    })
    @GET("businesses/search")
     Call<MasterResponseModel> getAlllists(@Query("term")String term, @Query("location")String location, @Query("radius") int radius) ;
}
