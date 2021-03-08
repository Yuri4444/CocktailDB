package com.berezhnoyyuri9999.cocktaildb.data.api

import com.berezhnoyyuri9999.cocktaildb.data.repositories.Repository

interface App {

    fun getNetRepository(): Repository.NetRepository
}