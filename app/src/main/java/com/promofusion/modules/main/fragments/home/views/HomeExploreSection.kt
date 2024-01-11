package com.promofusion.modules.main.fragments.home.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.common.components.ContentSection
import com.promofusion.common.components.ShopCard
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun HomeExploreSection() {
    ContentSection(
        title = {
            Text(text = "Explore More", style = MaterialTheme.typography.titleMedium)
        },
        modifier = Modifier.padding(24.dp, 0.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            (1..10).forEachIndexed { index, _ ->
                ShopCard(
                    model = "https://source.unsplash.com/random/150x15$index",
                    title = "Flower Shop Promotion",
                    description = "You can get your free flower extra.",
                    promotion = "Buy 1 Get 1",
                    duration = "1 day ago",
                    modifier = Modifier.height(IntrinsicSize.Min)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeExploreSectionPreview() {
    PromoFusionTheme {
        HomeExploreSection()
    }
}