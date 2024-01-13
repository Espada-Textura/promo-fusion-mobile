package com.promofusion.modules.main.navigations.views.layouts

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.promofusion.modules.main.fragments.coupons.viewmodels.CouponViewModel
import com.promofusion.modules.main.fragments.coupons.views.CouponsScreen
import com.promofusion.modules.main.fragments.home.viewmodels.HomeViewModel
import com.promofusion.modules.main.fragments.home.views.HomeScreen
import com.promofusion.modules.main.fragments.scan.views.ScanScreen
import com.promofusion.modules.main.fragments.settings.views.SettingsScreen
import com.promofusion.modules.main.fragments.subscriptions.viewmodels.SubscriptionsViewModel
import com.promofusion.modules.main.fragments.subscriptions.views.SubscriptionsScreen
import com.promofusion.modules.main.navigations.models.MainNavigation


fun NavGraphBuilder.mainNavigationGraph(navController: NavController) {

    navigation(
        route = MainNavigation.Default.route,
        startDestination = MainNavigation.Home.route
    ) {
        composable(route = MainNavigation.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
            val featuredShopsState by homeViewModel.featuredShops.collectAsState()
            HomeScreen(navController = navController, featuredShopsState)
        }

        composable(route = MainNavigation.Shops.route) {
            val subscriptionsViewModel: SubscriptionsViewModel =
                hiltViewModel<SubscriptionsViewModel>()
            val shops by subscriptionsViewModel.featuredShops.collectAsState()
            SubscriptionsScreen(shops)
        }

        composable(route = MainNavigation.Scan.route) {
            ScanScreen()
        }

        composable(route = MainNavigation.Coupons.route) {
            val couponViewModel: CouponViewModel = hiltViewModel<CouponViewModel>()
            val coupons by couponViewModel.data.collectAsState()
            CouponsScreen(coupons)
        }

        composable(route = MainNavigation.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}