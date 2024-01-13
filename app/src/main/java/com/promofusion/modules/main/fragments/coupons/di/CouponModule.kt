package com.promofusion.modules.main.fragments.coupons.di

import com.promofusion.modules.main.fragments.coupons.models.api.CouponService
import com.promofusion.modules.main.fragments.coupons.models.repositories.CouponRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object CouponModule{

    @Provides
    fun provideCouponRepository(couponService: CouponService): CouponRepository {
        return CouponRepository(couponService)
    }
}
