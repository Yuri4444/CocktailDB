package com.berezhnoyyuri9999.cocktaildb.domain.services

import com.berezhnoyyuri9999.cocktaildb.data.api.App
import io.reactivex.schedulers.Schedulers

class Interactor(private val app: App) {

    private val net by lazy { app.getNetRepository() }

    fun getList() = net.getListCocktails()
        .subscribeOn(Schedulers.io())
}