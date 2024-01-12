package com.promofusion.modules.main.fragments.home.models.api

import com.promofusion.modules.main.fragments.home.models.data.ShopListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeService @Inject constructor(private val homeApi: HomeApi) {

    suspend fun getFeaturedShops(): ShopListResponse {

        return withContext(Dispatchers.IO) {
            val shopListResponse = homeApi.getFeaturedShops()
            (shopListResponse.body() as ShopListResponse)
        }
    }
}