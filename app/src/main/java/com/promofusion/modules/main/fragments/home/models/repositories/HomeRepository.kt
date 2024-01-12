package com.promofusion.modules.main.fragments.home.models.repositories

import com.promofusion.modules.main.fragments.home.domain.repositories.IHomeRepository
import com.promofusion.modules.main.fragments.home.models.api.HomeApi
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeApi: HomeApi
) : IHomeRepository {
    override suspend fun getFeaturedShop() {
        super.getFeaturedShop()
    }
}