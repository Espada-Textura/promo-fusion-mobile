package com.promofusion.modules.main.fragments.home.di

import com.promofusion.common.constants.APIConstants
import com.promofusion.modules.main.fragments.home.domain.repositories.IHomeRepository
import com.promofusion.modules.main.fragments.home.models.api.HomeApi
import com.promofusion.modules.main.fragments.home.models.repositories.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides // Telling Hilt that this func provides a dependency
    @Singleton // Telling Hilt this dependency has Singleton Scope
    fun provideHomeApiInstance(): HomeApi {
        return Retrofit.Builder().baseUrl(APIConstants.BASE_URL).build().create(HomeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(homeApi: HomeApi): IHomeRepository {
        return HomeRepository(homeApi = homeApi)
    }
}

