package com.promofusion.modules.search.navigations.models

import com.promofusion.modules.navigations.models.INavigationScreen

sealed class SearchNavigation(override val route: String) : INavigationScreen {
    data object Default : SearchNavigation(route = "/search")
    data object Search : SearchNavigation(route = "/search/")
}