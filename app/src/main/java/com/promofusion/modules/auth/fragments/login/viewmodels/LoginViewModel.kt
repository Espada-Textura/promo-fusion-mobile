package com.promofusion.modules.auth.fragments.login.viewmodels

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


    fun handleOnLoginSuccess(response: LoginResponse) {
        SessionManager(context!!).saveAuthToken(response.data.accessToken)
        SessionManager(context!!).saveCurrentUser(
            SessionManager.UserData(response.data.id, response.data.email, response.data.email)
        )
        navController?.navigate(MainNavigation.Home.route)
    }

    fun handleOnSubmit(email: String, password: String) {
        pending.value = true
        val error: ApiErrorHandler = ApiErrorHandler()
        apiClient.getApiService().login(request = LoginRequest(email, password)).enqueue(object :
            Callback<LoginResponse> {

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    handleOnLoginSuccess(response.body()!!)
//                    println(SessionManager(context!!).fetchAuthToken())
//                    println(SessionManager(context!!).fetchCurrentUser())
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

    fun handleOnRegister() {
        pending.value = true
        val error: ApiErrorHandler = ApiErrorHandler()

        apiClient.getApiService().getUsers("Bearer ${SessionManager(context!!).fetchAuthToken()}")
            .enqueue(object :
                Callback<UsersResponse> {

                override fun onResponse(
                    call: Call<UsersResponse>,
                    response: Response<UsersResponse>
                ) {
                    if (response.isSuccessful) {
                        println(response.body()!!.data[0].email)
                        error.showAlert(
                            context,
                            "Call failed: ${response.body()!!.data}"
                        )
                        pending.value = false
                    } else {
//                    error.showAlert(context, "Call failed: ${t.message}")
                        pending.value = false
                    }
                }

                override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                    error.showAlert(context, "Call failed: ${t.message}")
                    pending.value = false
                }
            })
    }

}

