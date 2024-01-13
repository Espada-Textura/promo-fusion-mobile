package com.promofusion.modules.main.fragments.subscriptions.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.R
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.components.SearchWithFilter
import com.promofusion.common.components.ShopCard
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.main.context.models.data.ShopData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionsScreen(shops: List<ShopData> = emptyList()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        HeaderTitle(title = "Subscription", description = "Explore more shops", action = {
            IconButton(onClick = { }) {
                Icon(
                    painter = (painterResource(id = R.drawable.ic_notification_line)),
                    contentDescription = "Notification Bell",
                )
            }
        }, modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 0.dp))

        SearchWithFilter(modifier = Modifier.padding(24.dp, 0.dp)) {}

        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, top = 0.dp, end = 24.dp, bottom = 24.dp)
        ) {
            shops.forEachIndexed { index, shop ->
                ShopCard(
                    model = "https://source.unsplash.com/random/150x15$index",
                    title = shop.name ?: "No data",
                    description = shop.description ?: "No data",
                    promotion = shop.status ?: "No data",
                    modifier = Modifier.height(IntrinsicSize.Min)
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun SubscriptionsScreenPreview() {
    PromoFusionTheme {
        SubscriptionsScreen()
    }
}

