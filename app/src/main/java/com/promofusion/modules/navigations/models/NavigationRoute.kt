package com.promofusion.modules.navigations.models

import com.promofusion.R

enum class NavigationType {
    NAVIGATION, ACTION_BUTTON
}

sealed class NavigationScreen(
    val title: String?,
    val route: String,
    val unselectedIcon: Int? = null,
    val selectedIcon: Int? = null,
    val navigationType: NavigationType = NavigationType.NAVIGATION
) {
    data object Home : NavigationScreen(
        title = "Home",
        route = "home",
        selectedIcon = R.drawable.ic_home_4_fill,
        unselectedIcon = R.drawable.ic_home_4_line,
    )

    data object Shops : NavigationScreen(
        title = "Shops",
        route = "shops",
        selectedIcon = R.drawable.ic_sale_fill,
        unselectedIcon = R.drawable.ic_sale_line,
    )

    data object Scan : NavigationScreen(
        title = null,
        route = "scan",
        selectedIcon = R.drawable.ic_qrcode_2_fill,
        unselectedIcon = R.drawable.ic_qrcode_2_line,
        navigationType = NavigationType.ACTION_BUTTON
    )


    data object Coupons : NavigationScreen(
        title = "Coupons",
        route = "coupons",
        selectedIcon = R.drawable.ic_coupon_fill,
        unselectedIcon = R.drawable.ic_coupon_line,
    )

    data object Settings : NavigationScreen(
        title = "Settings",
        route = "settings",
        selectedIcon = R.drawable.ic_settings_3_fill,
        unselectedIcon = R.drawable.ic_settings_3_line,
    )

    data object Search : NavigationScreen(
        title = null,
        route = "Search"
    )
}

val NavigationRouteItems = listOf(
    NavigationScreen.Home,
    NavigationScreen.Shops,
    NavigationScreen.Scan,
    NavigationScreen.Coupons,
    NavigationScreen.Settings
)
