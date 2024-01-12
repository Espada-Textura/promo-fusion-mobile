package com.promofusion.common.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.promofusion.R

/**
 * Session manager to save and fetch data from SharedPreferences
 */
class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_DATA = "user_data"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    data class UserData(
        val id: String?,
        val username: String?,
        val email: String?
    )

    /**
     * Function to save current user information as a model
     */
    fun saveCurrentUser(userData: UserData) {
        val editor = prefs.edit()
        val userDataJson = Gson().toJson(userData)
        editor.putString(USER_DATA, userDataJson)
        editor.apply()
    }

    /**
     * Function to fetch current user information as a model
     */
    fun fetchCurrentUser(): UserData? {
        val userDataJson = prefs.getString(USER_DATA, null)
        return Gson().fromJson(userDataJson, UserData::class.java)
    }

    /**
     * Function to logout user
     */
    fun logout() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}