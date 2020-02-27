package com.tneagu.mvvmsimpleapp.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tneagu.mvvmsimpleapp.main.model.DogBreed

/**
 * Created by tne17909 on 2/27/2020.
 * Copyright © 2019 Belersoft. All rights reserved.
 */
class DetailViewModel: ViewModel() {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(){
        val dog = DogBreed("2", "Labrador", "12 years", "breedGroup", "bredFor", "temperament", "")
        this.dogLiveData.value = dog
    }
}