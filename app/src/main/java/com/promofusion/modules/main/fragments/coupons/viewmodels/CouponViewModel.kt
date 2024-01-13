package com.promofusion.modules.main.fragments.coupons.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.promofusion.modules.main.fragments.coupons.models.data.Coupon
import com.promofusion.modules.main.fragments.coupons.models.repositories.CouponRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CouponViewModel @Inject constructor(private val repository: CouponRepository): ViewModel() {

//    private val _data = MutableStateFlow<CouponResponse?>(null)
//    val data: StateFlow<CouponResponse?> = _data

    private val _data = MutableStateFlow<List<Coupon>>(emptyList())
    val data: StateFlow<List<Coupon>> get() = _data

    init {
        viewModelScope.launch {
            try {
                val result = repository.getCoupon()
                _data.value = result.data
                Log.d("Coupon", "Fetched coupons: $result")
            } catch (e: Exception) {
                Log.e("Coupon", "Error fetching coupons", e)
            }
        }
    }
}
