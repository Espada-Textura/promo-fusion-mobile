package com.promofusion.modules.main.fragments.coupons.models.api

import com.promofusion.modules.main.fragments.coupons.models.data.CouponResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CouponService @Inject constructor(private val couponApi: CouponApi){
    suspend fun getCoupons(): CouponResponse {
        return withContext(Dispatchers.IO) {
            val couponResponse = couponApi.getCoupons()
            (couponResponse.body() as CouponResponse)
        }
    }
}
