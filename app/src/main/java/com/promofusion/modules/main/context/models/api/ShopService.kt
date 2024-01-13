package com.promofusion.modules.main.context.models.api

import com.promofusion.modules.main.context.models.data.ShopsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ShopService @Inject constructor(private val shopApi: ShopApi) {

    suspend fun getFeaturedShops(): ShopsResponse {

        return withContext(Dispatchers.IO) {
            val shopListResponse = shopApi.getFeaturedShops()
            (shopListResponse.body() as ShopsResponse)
        }
    }
}