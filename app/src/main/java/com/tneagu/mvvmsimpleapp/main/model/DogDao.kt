package com.tneagu.mvvmsimpleapp.main.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by TNE17909 on 3/29/2020.
 * Copyright © 2019 OpenGroupe. All rights reserved.
 */

@Dao
interface DogDao {
    @Insert
    suspend fun insertAll(vararg dogs : DogBreed): List<Long>

    @Query("SELECT * FROM dogbreed")
    suspend fun getAllDogs(): List<DogBreed>

    @Query("SELECT * FROM dogbreed WHERE uuid = :dogId")
    suspend fun getDog(dogId: Int) : DogBreed

    @Query("DELETE FROM dogbreed")
    suspend fun deleteAllDogs()
}