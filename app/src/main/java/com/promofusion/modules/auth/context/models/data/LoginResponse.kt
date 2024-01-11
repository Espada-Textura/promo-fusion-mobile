package com.promofusion.modules.auth.context.models.data

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("status")
    var status: Int,

    @SerializedName("data")
    var data: Any
)