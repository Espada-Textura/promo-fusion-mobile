package com.promofusion.modules.main.fragments.home.models.api

import retrofit2.http.GET

interface HomeApi {
    @GET("/")
    suspend fun getFeaturedShops() {

    }
}