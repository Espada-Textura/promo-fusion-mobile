package com.promofusion.modules.main.fragments.home.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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

        LazyVerticalGrid(
            columns = GridCells.Adaptive(128.dp),
            verticalArrangement = Arrangement.spacedBy(space = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(space = 24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            homeViewModel.getCategories().forEach { category ->
                item {
                    CategoryCard(
                        title = category.title,
                        description = category.description,
                        colors = category.cardColors(),
                        icon = category.icon
                    )

                    Spacer(modifier = Modifier.size(8.dp))
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