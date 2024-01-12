package com.promofusion.modules.main.context.repositories

import com.promofusion.modules.main.context.models.api.ShopService
import com.promofusion.modules.main.context.models.data.ShopListResponse
import javax.inject.Inject

class ShopRepository @Inject constructor(
    private val shopService: ShopService
) {
    suspend fun getFeaturedShop(): ShopListResponse {
        return shopService.getFeaturedShops()
    }
}