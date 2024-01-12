package com.promofusion.modules.main.fragments.settings.viewmodels

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.promofusion.common.utils.SessionManager
import com.promofusion.modules.auth.context.models.api.ApiClient
import com.promofusion.modules.auth.context.models.api.ApiErrorHandler
import com.promofusion.modules.auth.context.models.data.LoginRequest
import com.promofusion.modules.auth.context.models.data.LoginResponse
import com.promofusion.modules.auth.context.models.data.UsersResponse
import com.promofusion.modules.auth.navigations.models.AuthNavigation
import com.promofusion.modules.main.navigations.models.MainNavigation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingViewModel : ViewModel() {
    @SuppressLint("StaticFieldLeak")
    private var context: android.content.Context? = null
    private var navController: NavController? = null

    fun setAppContext(con: android.content.Context) {
        context = con
    }

    fun setNavController(nav: NavController) {
        navController = nav
    }

    fun handleOnLogout() {
        SessionManager(context!!).logout()
        navController?.navigate(AuthNavigation.Default.route)
    }

}

