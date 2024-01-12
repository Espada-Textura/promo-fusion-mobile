package com.promofusion.modules.main.fragments.coupons.models.data

import com.google.gson.annotations.SerializedName

data class Coupon (
    @SerializedName("id")
    val id: Int,

    @SerializedName("shopName")
    val shopName: String,

    @SerializedName("promotion")
    val promotion: String,

    @SerializedName("endAt")
    val endAt: String,

    @SerializedName("shopUrl")
    val shopUrl: String,
)