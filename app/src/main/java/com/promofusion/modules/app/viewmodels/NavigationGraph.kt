package com.promofusion.modules.app.viewmodels

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.promofusion.modules.app.fragments.coupons.views.CouponsScreen
import com.promofusion.modules.app.fragments.home.views.HomeScreen
import com.promofusion.modules.app.fragments.scan.views.ScanScreen
import com.promofusion.modules.app.fragments.settings.views.SettingsScreen
import com.promofusion.modules.app.fragments.subscriptions.views.SubscriptionsScreen
import com.promofusion.modules.app.views.layouts.LayoutWithNavigation


@Composable
fun NavigationGraph() {

    val navHostController = rememberNavController()

    LayoutWithNavigation(navHostController) {
        NavHost(navController = navHostController, startDestination = "home") {

            composable(route = "home") {
                HomeScreen()
            }

            composable(route = "shops") {
                SubscriptionsScreen()
            }

            composable(route = "scan") {
                ScanScreen()
            }

            composable(route = "coupons") {
                CouponsScreen()
            }

            composable(route = "settings") {
                SettingsScreen()
            }

        }
    }
}