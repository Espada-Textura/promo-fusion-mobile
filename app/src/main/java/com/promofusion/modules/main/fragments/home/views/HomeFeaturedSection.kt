package com.promofusion.modules.main.fragments.home.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.promofusion.common.components.ContentSection
import com.promofusion.common.components.FeaturedShopCard

@Composable
fun HomeFeaturedSection() {
    ContentSection(
        title = {
            Text(text = "Featured", style = MaterialTheme.typography.titleMedium)
        },
        modifier = Modifier.padding(24.dp, 0.dp)
    ) {
        LazyRow {
            items(10, itemContent = { key ->
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