package com.promofusion.modules.main.fragments.home.models.repositories

import com.promofusion.modules.main.fragments.home.domain.repositories.IHomeRepository
import com.promofusion.modules.main.fragments.home.models.api.HomeService
import com.promofusion.modules.main.fragments.home.models.data.ShopListResponse
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeService: HomeService
) : IHomeRepository {
    override suspend fun getFeaturedShop(): ShopListResponse {
        return homeService.getFeaturedShops()
    }
}