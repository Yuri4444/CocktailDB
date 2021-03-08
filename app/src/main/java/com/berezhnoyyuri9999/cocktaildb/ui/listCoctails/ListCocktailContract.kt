package com.berezhnoyyuri9999.cocktaildb.ui.listCoctails

import com.berezhnoyyuri9999.cocktaildb.data.model.DataCocktails

interface ListCocktailContract {

    interface ListCocktailView {
        fun showList(list : List<DataCocktails>)
    }
    interface ListCocktailPresenter {
        fun fetch()
        fun bindView(view : ListCocktailView)
        fun unBind()

    }
}