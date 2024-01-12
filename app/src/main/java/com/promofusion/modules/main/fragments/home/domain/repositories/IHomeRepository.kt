package com.promofusion.modules.main.fragments.home.domain.repositories

import com.promofusion.modules.main.fragments.home.models.data.ShopListResponse

interface IHomeRepository {
    suspend fun getFeaturedShop(): ShopListResponse
}