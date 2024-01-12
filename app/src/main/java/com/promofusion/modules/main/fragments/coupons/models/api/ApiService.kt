package com.promofusion.modules.main.fragments.coupons.models.api

import com.promofusion.modules.main.fragments.coupons.models.data.Coupon
import com.promofusion.modules.main.fragments.coupons.models.data.CouponResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("ping")
    fun fetchCoupons(@Header("Authorization") token: String): Call<CouponResponse>
}