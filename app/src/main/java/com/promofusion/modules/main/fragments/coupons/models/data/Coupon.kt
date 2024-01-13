package com.promofusion.modules.main.fragments.coupons.models.data

import com.google.gson.annotations.SerializedName

data class Coupon (

    @SerializedName("name")
    val name: String?,

    //Later Convert To "promotionValue"
    @SerializedName("promotionTitle")
    val promotionTitle: String?,

    @SerializedName("endDate")
    val endDate: String?,

    @SerializedName("imageUrl")
    val imageUrl: String?,

    @SerializedName("status")
    val status: String?,
)