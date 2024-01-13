package com.promofusion.modules.main.fragments.home.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.promofusion.common.components.ContentSection
import com.promofusion.common.components.FeaturedShopCard
import com.promofusion.modules.main.context.models.data.ShopData


@Composable
fun HomeFeaturedSection(featuredShops: List<ShopData>) {
    ContentSection(
        title = {
            Text(text = "Featured", style = MaterialTheme.typography.titleMedium)
        },
        modifier = Modifier.padding(24.dp, 0.dp)
    ) {
        LazyRow {
            featuredShops.forEachIndexed { index, shop ->
                item {
                    FeaturedShopCard(
                        promotionType = shop.status ?: "No data",
                        shopTitle = shop.name ?: "Empty Shop Name",
                        shopDescription = shop.description ?: "Empty Description",
                        imageURL = shop.imageUrl ?: "No data"
                    )

                    Spacer(modifier = Modifier.width(24.dp))
                }
            }
        }
    }
}