package com.promofusion.modules.auth.navigations.views.layouts

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.promofusion.modules.auth.fragments.login.views.LoginScreen
import com.promofusion.modules.auth.fragments.welcnew.views.WelcnewScreen
import com.promofusion.modules.auth.fragments.welcome.views.RegisterScreen
import com.promofusion.modules.auth.fragments.welcome.views.WelcomeScreen
import com.promofusion.modules.auth.navigations.models.AuthNavigation

fun NavGraphBuilder.authNavigationGraph(navController: NavController) {

    navigation(
        route = AuthNavigation.Default.route,
        startDestination = AuthNavigation.Welcome.route
    ) {
        composable(route = AuthNavigation.Welcome.route) {
            WelcomeScreen(navController = navController)
        }

        composable(route = AuthNavigation.SignIn.route) {
            LoginScreen(navController = navController)
        }

        composable(route = AuthNavigation.SignUp.route) {
            RegisterScreen(navController = navController)
        }

        composable(route = AuthNavigation.ForgotPassword.route) {}

        composable(route = AuthNavigation.ResetPassword.route) {}

        composable(route = AuthNavigation.VerifyOtp.route) {}

        composable(route = AuthNavigation.Welcnew.route) {
            WelcnewScreen(navController = navController)
        }
    }

}