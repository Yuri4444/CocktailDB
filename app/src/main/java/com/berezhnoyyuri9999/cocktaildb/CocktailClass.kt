package com.berezhnoyyuri9999.cocktaildb

import android.app.Application
import android.content.Context
import com.berezhnoyyuri9999.cocktaildb.data.api.App
import com.berezhnoyyuri9999.cocktaildb.data.api.RetrofitManager
import com.berezhnoyyuri9999.cocktaildb.data.repositories.NetRepositoryImpl
import com.berezhnoyyuri9999.cocktaildb.data.repositories.Repository

class CocktailClass : Application(), App {

    private val net by lazy { NetRepositoryImpl(RetrofitManager(this)) }

    override fun getNetRepository(): Repository.NetRepository = net

    companion object {
        fun getApp(context: Context?): App {
            return context?.applicationContext as App
        }
    }

}