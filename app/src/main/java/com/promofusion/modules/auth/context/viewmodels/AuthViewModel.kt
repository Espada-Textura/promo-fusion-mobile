package com.promofusion.modules.auth.context.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.math.log

class AuthViewModel : ViewModel() {
    // Your data variables go here
    // Example:
    private var email: String = "Login"
    private var password: String = ""

    private val _loginStatus = mutableStateOf("Not logged in")
    val loginStatus: MutableState<String> = _loginStatus

    fun getTitle(): String {
        return this.email
    }

    fun login(email: String, password: String){
        // Your login logic goes here
        // Example:
        if (email == "admin" && password == "admin") {
            _loginStatus.value = "Login success"
        } else {
            // Login failed
        }


    }

}