package com.promofusion.common.ui.components.navigations

import com.promofusion.R

data class NavigationRoute(
    val title: String?,
    val route: String,
    val unselectedIcon: Int,
    val selectedIcon: Int,
    val hasBadge: Boolean,
    val badgeCount: Number
)

val NavigationRouteItems = listOf(
    NavigationRoute(
        title = "Home",
        route = "home",
        selectedIcon = R.drawable.ic_hero_home_filled,
        unselectedIcon = R.drawable.ic_hero_home,
        badgeCount = 0,
        hasBadge = false
    ),

    NavigationRoute(
        title = "Shops",
        route = "shops",
        selectedIcon = R.drawable.ic_hero_shopping_cart_filled,
        unselectedIcon = R.drawable.ic_hero_shopping_cart,
        badgeCount = 0,
        hasBadge = false
    ),

    NavigationRoute(
        title = null,
        route = "scan",
        selectedIcon = R.drawable.ic_hero_qrcode,
        unselectedIcon = R.drawable.ic_hero_qrcode,
        badgeCount = 0,
        hasBadge = false
    ),

    NavigationRoute(
        title = "Coupons",
        route = "coupons",
        selectedIcon = R.drawable.ic_hero_ticket_filled,
        unselectedIcon = R.drawable.ic_hero_ticket,
        badgeCount = 0,
        hasBadge = false
    ),

    NavigationRoute(
        title = "Settings",
        route = "setting",
        selectedIcon = R.drawable.ic_hero_cog_filled,
        unselectedIcon = R.drawable.ic_hero_cog,
        badgeCount = 0,
        hasBadge = false
    )
)
