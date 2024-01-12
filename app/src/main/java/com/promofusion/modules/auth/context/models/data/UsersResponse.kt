package com.promofusion.modules.auth.context.models.data

import com.google.gson.annotations.SerializedName

data class UsersResponse (
    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: List<User>,

    @SerializedName("status")
    val status: Int
)