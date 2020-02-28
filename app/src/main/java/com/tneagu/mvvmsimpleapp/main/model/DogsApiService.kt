package com.tneagu.mvvmsimpleapp.main.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by tne17909 on 2/28/2020.
 * Copyright © 2019 Belersoft. All rights reserved.
 */
class DogsApiService {

    private val BASE_URL = "https://raw.githubusercontent.com"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(DogsApi::class.java)

    
    fun getDogs(): Single<List<DogBreed>>{
        return api.getDogs();
    }
}