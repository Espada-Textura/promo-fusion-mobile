package com.promofusion.modules.auth.fragments.login.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.promofusion.modules.auth.context.models.api.ApiClient
import com.promofusion.modules.auth.context.models.data.LoginRequest
import com.promofusion.modules.auth.context.models.data.LoginResponse
import com.promofusion.modules.auth.context.models.data.Resp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    private var _loginStatus = mutableStateOf("Not --- logged in")
    val loginStatus: MutableState<String> = _loginStatus
    private var apiClient: ApiClient = ApiClient()


    fun handleOnSubmit( email: String, password: String) {
//        apiClient.getApiService().login(request = LoginRequest(email, password))
        apiClient.getApiService().ping().enqueue(object :
            Callback<Resp> {

            override fun onResponse(call: Call<Resp>, response: Response<Resp>) {
                println("in s")
                if (response.isSuccessful) {
                    _loginStatus.value = "Login success"
                } else {
                    // Login failed
                }
            }

            override fun onFailure(call: Call<Resp>, t: Throwable) {

                println("in failure")
                println("Call failed: ${t.message}")
                // You can also print the stack trace if needed
                t.printStackTrace()
            }
        })


//        _loginStatus.value = "Logged in"
    }

}

