package com.berezhnoyyuri9999.cocktaildb.data.repositories

import com.berezhnoyyuri9999.cocktaildb.data.api.RetrofitManager
import com.berezhnoyyuri9999.cocktaildb.data.model.DataCocktails
import io.reactivex.Observable

class NetRepositoryImpl(private val netManager: RetrofitManager) :
    Repository.NetRepository {

    private val api by lazy { netManager.getApi() }

    override fun getListCocktails(): Observable<List<DataCocktails>> {
        return api.getListCocktails()
    }
}