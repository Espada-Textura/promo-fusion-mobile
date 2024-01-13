package com.promofusion.modules.main.context.di

import com.promofusion.common.constants.APIConstants
import com.promofusion.modules.main.context.models.api.ApiInterceptor
import com.promofusion.modules.main.context.models.api.ShopApi
import com.promofusion.modules.main.context.models.api.ShopService
import com.promofusion.modules.main.context.repositories.ShopRepository
import com.promofusion.modules.main.fragments.coupons.models.api.CouponApi
import com.promofusion.modules.main.fragments.coupons.models.api.CouponService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(ApiInterceptor())
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(APIConstants.BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides // Telling Hilt that this func provides a dependency
    @Singleton // Telling Hilt this dependency has Singleton Scope
    fun provideShopApi(retrofit: Retrofit): ShopApi {
        return retrofit.create(ShopApi::class.java)
    }

    @Provides
    @Singleton
    fun provideShopService(shopApi: ShopApi): ShopService {
        return ShopService(shopApi)
    }

    @Provides
    @Singleton
    fun provideShopRepository(shopService: ShopService): ShopRepository {
        return ShopRepository(shopService)
    }

    @Provides
    @Singleton
    fun provideCouponApi(retrofit: Retrofit): CouponApi {
        return retrofit.create(CouponApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCouponService(couponApi: CouponApi): CouponService {
        return CouponService(couponApi)
    }
}