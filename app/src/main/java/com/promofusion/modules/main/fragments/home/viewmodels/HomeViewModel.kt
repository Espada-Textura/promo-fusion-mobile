package com.promofusion.modules.main.fragments.home.viewmodels

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.promofusion.common.utils.SessionManager
import com.promofusion.modules.main.fragments.home.models.data.ShopData
import com.promofusion.modules.main.fragments.home.models.repositories.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _featuredShops = MutableStateFlow<List<ShopData>>(emptyList())
    val featuredShops: StateFlow<List<ShopData>> get() = _featuredShops

    // Fetch user data from session manager
    private var _userData = @Composable { SessionManager(LocalContext.current).fetchCurrentUser() }
    fun getUserData(): @Composable () -> SessionManager.UserData? {
        return _userData
    }


    init {
        viewModelScope.launch {
            try {
                val res = homeRepository.getFeaturedShop()
                _featuredShops.value = res.data
                Log.d("SHOP", _featuredShops.value.toString())

            } catch (err: Exception) {
                Log.e("SHOP", err.toString())
            }
        }
    }

}
