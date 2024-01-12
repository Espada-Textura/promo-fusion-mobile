package com.promofusion.modules.auth.fragments.welcnew.viewmodels

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.promofusion.modules.auth.context.models.api.ApiClient

class WelcnewViewModel : ViewModel() {
    @SuppressLint("StaticFieldLeak")
    private var context: android.content.Context? = null
    private var navController: NavController? = null
    private var _isPending = mutableStateOf(false)
    val pending: MutableState<Boolean> = _isPending
    private var apiClient: ApiClient = ApiClient()

    fun setAppContext(con: android.content.Context) {
        context = con
    }

    fun setNavController(nav: NavController) {
        navController = nav
    }

}

