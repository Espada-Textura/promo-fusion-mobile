package com.promofusion.modules.auth.fragments.register.viewmodels

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.promofusion.modules.auth.context.models.api.ApiClient
import com.promofusion.modules.auth.context.models.api.ApiErrorHandler
import com.promofusion.modules.auth.context.models.data.RegisterRequest
import com.promofusion.modules.auth.context.models.data.RegisterResponse
import com.promofusion.modules.auth.navigations.models.AuthNavigation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {
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

    fun handleOnRegisterSuccess(response: RegisterResponse?) {
        navController?.navigate(AuthNavigation.Welcnew.route)
    }

    fun handleOnSubmit(email: String, password: String) {
        pending.value = true
        val error: ApiErrorHandler = ApiErrorHandler()
        apiClient.getApiService().register(request = RegisterRequest(email, password))
            .enqueue(object :
                Callback<RegisterResponse> {

                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        handleOnRegisterSuccess(response.body())
                    } else {
                        error.showAlert(
                            context,
                            "Register failed: invalid email or email has been used"
                        )
                    }

                    pending.value = false
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    error.showAlert(context, "Register failed: invalid credentials")
                    pending.value = false
                }
            })
    }

}

