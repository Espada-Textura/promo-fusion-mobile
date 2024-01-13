package com.promofusion.modules.main.fragments.coupons.models.api

import com.promofusion.common.constants.APIConstants
import com.promofusion.modules.main.fragments.coupons.models.data.CouponResponse
import retrofit2.Response
import retrofit2.http.GET

interface CouponApi {
    @GET(APIConstants.COUPONS_ENDPOINT)
    suspend fun getCoupons(): Response<CouponResponse>
}