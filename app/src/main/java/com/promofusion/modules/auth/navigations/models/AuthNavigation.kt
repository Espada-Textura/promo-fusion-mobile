package com.promofusion.modules.auth.navigations.models

import com.promofusion.modules.navigations.models.INavigationScreen

sealed class AuthNavigation(
    override val route: String
) : INavigationScreen {
    data object Default : AuthNavigation(route = "/auth")
    data object Welcome : AuthNavigation(route = "/auth/welcome")
    data object SignIn : AuthNavigation(route = "/auth/sign-in")
    data object SignUp : AuthNavigation(route = "/auth/sign-up")
    data object ForgotPassword : AuthNavigation(route = "/auth/forgot-password")
    data object ResetPassword : AuthNavigation(route = "/auth/reset-password")
    data object VerifyOtp : AuthNavigation(route = "/auth/verify-otp")
    data object Welcnew : AuthNavigation(route = "/auth/welcnew")
}