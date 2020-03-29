package com.tneagu.mvvmsimpleapp.main.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by TNE17909 on 3/29/2020.
 * Copyright © 2019 OpenGroupe. All rights reserved.
 */
@Database(entities = arrayOf(DogBreed::class), version = 1)
abstract class DogDatabase: RoomDatabase() {
    abstract fun dogDao(): DogDao

    companion object{
        @Volatile private var instance: DogDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DogDatabase::class.java,
            "dogdatabase"
        ).build()
    }
}