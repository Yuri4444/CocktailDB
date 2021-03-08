package com.berezhnoyyuri9999.cocktaildb.data.repositories

import com.berezhnoyyuri9999.cocktaildb.data.model.DataCocktails
import io.reactivex.Observable

interface Repository {

    interface NetRepository {
        fun getListCocktails() : Observable<List<DataCocktails>>
    }

}