package com.promofusion.modules.navigations.views.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.promofusion.common.utils.SessionManager
import com.promofusion.modules.auth.navigations.models.AuthNavigation
import com.promofusion.modules.auth.navigations.views.layouts.authNavigationGraph
import com.promofusion.modules.main.navigations.models.MainNavigation
import com.promofusion.modules.main.navigations.views.components.BottomNavigationBar
import com.promofusion.modules.main.navigations.views.layouts.mainNavigationGraph
import com.promofusion.modules.search.navigations.views.layouts.searchNavigationGraph


@Composable
fun NavigationGraph() {

    val navController = rememberNavController()

    // Fetch user data from session manager
    val userData = SessionManager(LocalContext.current).fetchCurrentUser()

    // If user is logged in, set default screen to MainNavigation.Default.route
    val defaultScreen: String =
        userData?.let { MainNavigation.Default.route } ?: AuthNavigation.Default.route

    Scaffold(bottomBar = {
        BottomNavigationBar(navHostController = navController)
    }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = defaultScreen,
            modifier = Modifier.padding(paddingValues),
        ) {
            mainNavigationGraph(navController)
            authNavigationGraph(navController)
            searchNavigationGraph(navController)
        }
    }
}
