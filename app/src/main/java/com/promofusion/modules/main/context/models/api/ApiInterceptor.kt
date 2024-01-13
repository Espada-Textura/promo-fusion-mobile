package com.promofusion.modules.main.context.models.api

import com.promofusion.common.utils.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = SessionManager.USER_TOKEN
        val request =
            chain.request().newBuilder().addHeader("Authorization", "Bearer $token").build()

        return chain.proceed(request)
    }
}