package com.promofusion.modules.auth.fragments.login.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private var _loginStatus = mutableStateOf("Not --- logged in")
    val loginStatus: MutableState<String> = _loginStatus

    fun handleOnSubmit( email: String, password: String) {


        _loginStatus.value = "Logged in"
    }

}

