package com.promofusion.modules.search.navigations.views.layouts

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.promofusion.modules.search.navigations.models.SearchNavigation

fun NavGraphBuilder.searchNavigationGraph(navController: NavController) {
    navigation(
        route = SearchNavigation.Default.route,
        startDestination = SearchNavigation.Search.route
    ) {
        composable(route = SearchNavigation.Search.route) {

        }
    }
}