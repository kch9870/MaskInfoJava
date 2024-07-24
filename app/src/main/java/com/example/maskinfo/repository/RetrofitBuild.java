package com.example.maskinfo.repository;

import com.example.maskinfo.model.StoreInfo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitBuild {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(MaskService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    MaskService service = retrofit.create(MaskService.class);
}
