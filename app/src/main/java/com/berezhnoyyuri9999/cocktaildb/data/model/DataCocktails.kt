package com.berezhnoyyuri9999.cocktaildb.data.model

import com.google.gson.annotations.SerializedName

data class DataCocktails(

    @SerializedName("strCategory")
    val group: String?,

    @SerializedName("strDrinkThumb")
    val image: String?,

    @SerializedName("strDrink")
    val title: String?
)