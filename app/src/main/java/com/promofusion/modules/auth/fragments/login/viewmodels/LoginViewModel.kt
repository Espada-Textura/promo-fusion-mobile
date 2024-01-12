package com.promofusion.modules.auth.fragments.login.viewmodels

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.promofusion.modules.auth.context.models.api.ApiClient
import com.promofusion.modules.auth.context.models.api.ApiErrorHandler
import com.promofusion.modules.auth.context.models.data.LoginRequest
import com.promofusion.modules.auth.context.models.data.LoginResponse
import com.promofusion.modules.main.navigations.models.MainNavigation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
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


    fun handleOnLoginSuccess() {
        navController?.navigate(MainNavigation.Home.route)
    }

    fun handleOnSubmit( email: String, password: String) {
        pending.value = true
        val error : ApiErrorHandler = ApiErrorHandler()
        apiClient.getApiService().login(request = LoginRequest(email, password)).enqueue(object :
            Callback<LoginResponse> {

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    println(response.body()?.data?.email)
                    handleOnLoginSuccess()
                } else {
                    error.showAlert(context, "Login failed: invalid credentials")
                }

                pending.value = false
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                error.showAlert(context, "Call failed: ${t.message}")
                pending.value = false
            }
        })
    }

}

