package com.promofusion.modules.auth.context.models.data

import com.google.gson.annotations.SerializedName

data class Resp(
    @SerializedName("message")
    val message: String,


    @SerializedName("status")
    val status: Int
)
