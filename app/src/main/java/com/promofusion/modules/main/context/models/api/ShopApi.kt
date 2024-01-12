package com.promofusion.modules.main.context.models.api

import com.promofusion.common.constants.APIConstants
import com.promofusion.modules.main.context.models.data.ShopListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ShopApi {
    @GET(APIConstants.MERCHANTS_ENDPOINT)
    suspend fun getFeaturedShops(): Response<ShopListResponse>
}