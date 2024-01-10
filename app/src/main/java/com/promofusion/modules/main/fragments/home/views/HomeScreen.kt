package com.promofusion.modules.main.fragments.home.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.promofusion.R
import com.promofusion.common.components.ContentSection
import com.promofusion.common.components.FeaturedShopCard
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.components.SearchBar
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.search.navigations.models.SearchNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController? = null) {

    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderTitle(title = "Welcome back!", description = "Let's get your promotions", action = {
            IconButton(onClick = { }) {
                Icon(
                    painter = (painterResource(id = R.drawable.ic_notification_line)),
                    contentDescription = "Notification Bell",
                )
            }
        })


        SearchBar(
            enabled = false,
            modifier = Modifier
                .padding(24.dp, 0.dp)
                .clickable { navController?.navigate(SearchNavigation.Default.route) },
        ) {}


        ContentSection(
            title = "Featured Shops",
            link = {
                TextButton(onClick = { }) {
                    Text(text = "View More", style = MaterialTheme.typography.labelLarge)
                }
            },
            modifier = Modifier.padding(24.dp)
        ) {
            LazyRow {
                items(10, itemContent = {key ->
                    FeaturedShopCard(
                        promotionType = "20%",
                        shopTitle = LoremIpsum(4).values.first(),
                        shopDescription = LoremIpsum(10).values.first(),
                        imageURL = "https://source.unsplash.com/random/500x30$key"
                    )

                    Spacer(modifier = Modifier.width(24.dp))
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PromoFusionTheme {
        HomeScreen()
    }
}

