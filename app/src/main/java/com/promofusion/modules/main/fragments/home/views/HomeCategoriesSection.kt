package com.promofusion.modules.main.fragments.home.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.promofusion.common.components.CategoryCard
import com.promofusion.common.components.ContentSection
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.main.fragments.home.viewmodels.HomeViewModel

@Composable
fun HomeCategoriesSection(homeViewModel: HomeViewModel) {
    ContentSection(
        title = { Text(text = "Categories", style = MaterialTheme.typography.titleMedium) },
        modifier = Modifier.padding(24.dp, 0.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(space = 24.dp),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
        ) {
            homeViewModel.getCategories().forEachIndexed { index, categoriesData ->
                if (index % 2 == 0) Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    CategoryCard(
                        title = categoriesData.title,
                        description = categoriesData.description,
                        colors = categoriesData.cardColors(),
                        icon = categoriesData.icon,
                        modifier = Modifier
                            .weight(1f)
                            .width(IntrinsicSize.Min)
                            .fillMaxHeight()
                    )

                    CategoryCard(
                        title = homeViewModel.getCategories()[index + 1].title,
                        description = homeViewModel.getCategories()[index + 1].description,
                        colors = homeViewModel.getCategories()[index + 1].cardColors(),
                        icon = homeViewModel.getCategories()[index + 1].icon,
                        modifier = Modifier
                            .weight(1f)
                            .width(IntrinsicSize.Min)
                            .fillMaxHeight()

                    )
                }
            }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeCategoriesSectionPreview() {
    PromoFusionTheme {
        HomeCategoriesSection(homeViewModel = viewModel<HomeViewModel>())
    }
}