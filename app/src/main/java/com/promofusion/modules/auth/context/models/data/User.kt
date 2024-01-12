package com.promofusion.modules.auth.context.models.data

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    var id: String,

    @SerializedName("username")
    var username: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("accessToken")
    var accessToken: String,

    @SerializedName("refreshToken")
    var refreshToken: String,

    @SerializedName("type")
    var type: String
)