package com.promofusion.modules.main.fragments.coupons.models.repositories

import com.promofusion.modules.main.fragments.coupons.models.api.CouponService
import com.promofusion.modules.main.fragments.coupons.models.data.CouponResponse
import javax.inject.Inject

class CouponRepository @Inject constructor(private val couponService: CouponService){
    suspend fun getCoupon(): CouponResponse {
        return couponService.getCoupons()
    }
}