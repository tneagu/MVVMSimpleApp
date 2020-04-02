package com.tneagu.mvvmsimpleapp.main.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit

/**
 * Created by TNE17909 on 3/31/2020.
 * Copyright © 2019 OpenGroupe. All rights reserved.
 */
class SharedPreferencesHelper {

    companion object{
        private const val PREF_TIME = "Pref time"
        private var prefs: SharedPreferences? = null

        @Volatile private var instance: SharedPreferencesHelper? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): SharedPreferencesHelper = instance ?: synchronized(LOCK){
            instance ?: buildHelper(context).also{
                instance = it
            }
        }

        private fun buildHelper(context: Context): SharedPreferencesHelper{
            prefs = PreferenceManager.getDefaultSharedPreferences(context)
            return SharedPreferencesHelper()
        }
    }

    fun saveUpdateTime(time: Long){
        prefs?.edit(commit = true){
            putLong(PREF_TIME, time)
        }
    }

    fun getUpdateTime() = prefs?.getLong(PREF_TIME, 0)

}