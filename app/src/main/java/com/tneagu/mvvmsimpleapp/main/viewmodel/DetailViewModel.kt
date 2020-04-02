package com.tneagu.mvvmsimpleapp.main.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tneagu.mvvmsimpleapp.main.model.DogBreed
import com.tneagu.mvvmsimpleapp.main.model.DogDatabase
import kotlinx.coroutines.launch
import java.util.*

/**
 * Created by tne17909 on 2/27/2020.
 * Copyright © 2019 Belersoft. All rights reserved.
 */
class DetailViewModel(application: Application): BaseViewModel(application) {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(uuid: Int){
        launch {
            val dog = DogDatabase(getApplication()).dogDao().getDog(uuid)
            dogLiveData.value = dog
        }
    }
}