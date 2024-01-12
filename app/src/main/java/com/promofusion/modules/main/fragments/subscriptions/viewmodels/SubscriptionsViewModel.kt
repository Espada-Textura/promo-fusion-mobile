package com.promofusion.modules.main.fragments.subscriptions.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.promofusion.modules.main.context.models.data.ShopData
import com.promofusion.modules.main.context.repositories.ShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubscriptionsViewModel @Inject constructor(
    private val shopRepository: ShopRepository
) : ViewModel() {

    private val _featuredShops = MutableStateFlow<List<ShopData>>(emptyList())
    val featuredShops: StateFlow<List<ShopData>> get() = _featuredShops


    init {
        viewModelScope.launch {
            try {
                val res = shopRepository.getFeaturedShop()
                _featuredShops.value = res.data
                Log.d("SHOP", _featuredShops.value.toString())

            } catch (err: Exception) {
                Log.e("SHOP", err.toString())
            }
        }
    }
}