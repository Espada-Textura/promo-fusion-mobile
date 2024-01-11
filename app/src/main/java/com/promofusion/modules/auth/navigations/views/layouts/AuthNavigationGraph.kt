package com.promofusion.modules.auth.navigations.views.layouts

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.promofusion.modules.auth.fragments.login.views.LoginScreen
import com.promofusion.modules.auth.navigations.models.AuthNavigation

fun NavGraphBuilder.authNavigationGraph(navController: NavController) {

    navigation(
        route = AuthNavigation.Default.route,
        startDestination = AuthNavigation.SignIn.route
    ) {
        composable(route = AuthNavigation.SignIn.route) {
            LoginScreen(navController = navController)
        }

        composable(route = AuthNavigation.SignUp.route) {}

        composable(route = AuthNavigation.ForgotPassword.route) {}

        composable(route = AuthNavigation.ResetPassword.route) {}

        composable(route = AuthNavigation.VerifyOtp.route) {}
    }

}