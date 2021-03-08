package com.berezhnoyyuri9999.cocktaildb.data.api

import com.berezhnoyyuri9999.cocktaildb.data.model.DataCocktails
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import java.util.*

interface API {

    @GET("v3/76649b86-9b6e-4f9d-b945-5101ea0d4053")

    fun getListCocktails(): Observable<List<DataCocktails>>

    companion object {
        const val BASE_URL = "https://run.mocky.io/"

    }
}