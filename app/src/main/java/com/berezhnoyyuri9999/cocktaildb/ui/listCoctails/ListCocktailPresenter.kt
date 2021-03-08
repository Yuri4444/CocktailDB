package com.berezhnoyyuri9999.cocktaildb.ui.listCoctails

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.cocktaildb.data.api.App
import com.berezhnoyyuri9999.cocktaildb.domain.services.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListCocktailPresenter(app: App) : ListCocktailContract.ListCocktailPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view : ListCocktailContract.ListCocktailView? = null

    @SuppressLint("CheckResult")
    override fun fetch() {
        interactor.getList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showList(it)
                Log.e("R", it.toString())
            }, {
                it.message?.let { it1 -> Log.e("R", it1) }
            })
    }

    override fun bindView(view: ListCocktailContract.ListCocktailView) {
        this.view = view
    }

    override fun unBind() {
        this.view = null
    }
}