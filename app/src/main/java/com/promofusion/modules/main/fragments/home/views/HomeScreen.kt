package com.promofusion.modules.main.fragments.home.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.promofusion.R
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.components.SearchBar
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.main.fragments.home.viewmodels.HomeViewModel
import com.promofusion.modules.search.navigations.models.SearchNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController? = null) {
    val homeViewModel: HomeViewModel = viewModel<HomeViewModel>()


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderTitle(
            title = "Welcome back!", description = "Let's get your promotions", action = {
                IconButton(onClick = { }) {
                    Icon(
                        painter = (painterResource(id = R.drawable.ic_notification_line)),
                        contentDescription = "Notification Bell",
                    )
                }
            }, modifier = Modifier.padding(24.dp)
        )

        SearchBar(enabled = true, modifier = Modifier.padding(24.dp, 0.dp), onActiveChange = {
            if (it) navController?.navigate(SearchNavigation.Default.route)
        }) {}

        Spacer(modifier = Modifier.height(24.dp))

        HomeFeaturedSection()

        Spacer(modifier = Modifier.height(24.dp))

        HomeCategoriesSection(homeViewModel)

        Spacer(modifier = Modifier.height(24.dp))

        HomeExploreSection()

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PromoFusionTheme {
        HomeScreen()
    }
}

