package com.promofusion.modules.main.fragments.home.viewmodels

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.promofusion.common.utils.SessionManager
import com.promofusion.modules.main.fragments.home.models.repositories.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    // Fetch user data from session manager
    private val _userData = @Composable { SessionManager(LocalContext.current).fetchCurrentUser() }

    fun getUserData(): @Composable () -> SessionManager.UserData? {
        return _userData
    }
}