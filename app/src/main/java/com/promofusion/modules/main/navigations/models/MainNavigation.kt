package com.promofusion.modules.main.navigations.models

import com.promofusion.R
import com.promofusion.modules.navigations.models.INavigationScreen

enum class NavigationType {
    NAVIGATION, ACTION_BUTTON
}

sealed class MainNavigation(
    val title: String? = null,
    override val route: String,
    val unselectedIcon: Int? = null,
    val selectedIcon: Int? = null,
    val navigationType: NavigationType = NavigationType.NAVIGATION
) : INavigationScreen {

    data object Default : MainNavigation(
        route = "/main"
    )

    data object Home : MainNavigation(
        title = "Home",
        route = "/main/home",
        selectedIcon = R.drawable.ic_home_4_fill,
        unselectedIcon = R.drawable.ic_home_4_line,
    )

    data object Shops : MainNavigation(
        title = "Shops",
        route = "/main/shops",
        selectedIcon = R.drawable.ic_sale_fill,
        unselectedIcon = R.drawable.ic_sale_line,
    )

    data object Scan : MainNavigation(
        title = null,
        route = "/main/scan",
        selectedIcon = R.drawable.ic_qrcode_2_fill,
        unselectedIcon = R.drawable.ic_qrcode_2_line,
        navigationType = NavigationType.ACTION_BUTTON
    )


    data object Coupons : MainNavigation(
        title = "Coupons",
        route = "/main/coupons",
        selectedIcon = R.drawable.ic_coupon_fill,
        unselectedIcon = R.drawable.ic_coupon_line,
    )

    data object Settings : MainNavigation(
        title = "Settings",
        route = "/main/settings",
        selectedIcon = R.drawable.ic_settings_3_fill,
        unselectedIcon = R.drawable.ic_settings_3_line,
    )
}

val NavigationRoutes = listOf(
    MainNavigation.Home,
    MainNavigation.Shops,
    MainNavigation.Scan,
    MainNavigation.Coupons,
    MainNavigation.Settings
)
