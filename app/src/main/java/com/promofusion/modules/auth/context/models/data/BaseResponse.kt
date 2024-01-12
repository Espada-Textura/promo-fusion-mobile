package com.promofusion.modules.auth.context.models.data

import com.google.gson.annotations.SerializedName

data class BaseResponse(

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: User,

    @SerializedName("status")
    val status: Int
)
