package com.promofusion.modules.main.fragments.coupons.models.data

import com.google.gson.annotations.SerializedName

data class CouponResponse (

//    @SerializedName("message")
//    var message: String?,

    @SerializedName("data")
    var data: List<Coupon>,
)