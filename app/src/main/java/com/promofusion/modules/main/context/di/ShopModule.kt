package com.promofusion.modules.main.context.di

import com.promofusion.common.constants.APIConstants
import com.promofusion.modules.main.context.models.api.ShopApi
import com.promofusion.modules.main.context.models.api.ShopService
import com.promofusion.modules.main.context.repositories.ShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides // Telling Hilt that this func provides a dependency
    @Singleton // Telling Hilt this dependency has Singleton Scope
    fun provideShopApiInstance(): ShopApi {
        return Retrofit.Builder().baseUrl(APIConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ShopApi::class.java)
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
}

