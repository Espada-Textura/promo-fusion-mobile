package com.promofusion.modules.app.models

import com.promofusion.R

enum class NavigationType {
    NAVIGATION, ACTION_BUTTON
}

data class NavigationRoute(
    val title: String?,
    val route: String,
    val unselectedIcon: Int,
    val selectedIcon: Int,
    val hasBadge: Boolean,
    val badgeCount: Number,
    val navigationType: NavigationType = NavigationType.NAVIGATION
)

val NavigationRouteItems = listOf(
    NavigationRoute(
        title = "Home",
        route = "home",
        selectedIcon = R.drawable.ic_home_4_fill,
        unselectedIcon = R.drawable.ic_home_4_line,
        badgeCount = 0,
        hasBadge = false,
    ),

    NavigationRoute(
        title = "Shops",
        route = "shops",
        selectedIcon = R.drawable.ic_sale_fill,
        unselectedIcon = R.drawable.ic_sale_line,
        badgeCount = 0,
        hasBadge = false
    ),

    NavigationRoute(
        title = null,
        route = "scan",
        selectedIcon = R.drawable.ic_qrcode_2_fill,
        unselectedIcon = R.drawable.ic_qrcode_2_fill,
        badgeCount = 0,
        hasBadge = false,
        navigationType = NavigationType.ACTION_BUTTON
    ),

    NavigationRoute(
        title = "Coupons",
        route = "coupons",
        selectedIcon = R.drawable.ic_coupon_fill,
        unselectedIcon = R.drawable.ic_coupon_line,
        badgeCount = 0,
        hasBadge = false
    ),

    NavigationRoute(
        title = "Settings",
        route = "settings",
        selectedIcon = R.drawable.ic_settings_3_fill,
        unselectedIcon = R.drawable.ic_settings_3_line,
        badgeCount = 0,
        hasBadge = false
    )
)
