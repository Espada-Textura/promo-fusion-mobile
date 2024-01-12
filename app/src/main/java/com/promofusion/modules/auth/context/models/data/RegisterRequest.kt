package com.promofusion.modules.auth.context.models.data

import com.google.gson.annotations.SerializedName

data class RegisterRequest (
    @SerializedName("email")
    var email: String,

    @SerializedName("password")
    var password: String
)