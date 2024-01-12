package com.promofusion.modules.main.fragments.home.models.api

import com.promofusion.common.constants.APIConstants
import com.promofusion.modules.main.fragments.home.models.data.ShopListResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {
    @GET(APIConstants.MERCHANTS_ENDPOINT)
    suspend fun getFeaturedShops(): Response<ShopListResponse>
}