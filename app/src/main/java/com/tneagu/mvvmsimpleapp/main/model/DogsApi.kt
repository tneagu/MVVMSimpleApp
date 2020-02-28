package com.tneagu.mvvmsimpleapp.main.model

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by tne17909 on 2/28/2020.
 * Copyright © 2019 Belersoft. All rights reserved.
 */
interface DogsApi {

    @GET("DevTides/DogsApi/master/dogs.json")
    fun getDogs(): Single<List<DogBreed>>
}