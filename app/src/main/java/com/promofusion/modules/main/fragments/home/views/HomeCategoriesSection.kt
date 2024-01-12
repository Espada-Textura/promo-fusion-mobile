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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.R
import com.promofusion.common.components.CategoryCard
import com.promofusion.common.components.ContentSection
import com.promofusion.common.theme.Cyan50
import com.promofusion.common.theme.Cyan500
import com.promofusion.common.theme.Green50
import com.promofusion.common.theme.Green500
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.common.theme.Violet50
import com.promofusion.common.theme.Violet500
import com.promofusion.modules.main.fragments.home.models.data.CategoriesData

@Composable
fun HomeCategoriesSection() {

    val categories = listOf(
        CategoriesData(title = "Percentage",
            description = "Percentage Value Discount",
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_currency_dollar_2_fill),
                    contentDescription = "Percentage Icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            cardColors = {
                (CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ))
            }),

        CategoriesData(title = "Extra Addons", description = "Extra Addon Products", icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_package_2_fill),
                contentDescription = "Percentage Icon",
                tint = Violet500,
            )
        }, cardColors = {
            (CardDefaults.cardColors(
                containerColor = Violet500,
                contentColor = Violet50,
            ))
        }),


        CategoriesData(
            title = "New Customer",
            description = "Special Offers & Membership",
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_gift_fill),
                    contentDescription = "Percentage Icon",
                    tint = Green500
                )
            },
            cardColors = {
                (CardDefaults.cardColors(
                    containerColor = Green500,
                    contentColor = Green50,
                ))
            }),


        CategoriesData(title = "Time Limited",
            description = "Time Limited Offers",
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_sandglass_fill),
                    contentDescription = "Percentage Icon",
                    tint = Cyan500
                )
            },
            cardColors = {
                (CardDefaults.cardColors(
                    containerColor = Cyan500,
                    contentColor = Cyan50,
                ))
            })
    )


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
            categories.forEachIndexed { index, categoriesData ->
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
                        title = categories[index + 1].title,
                        description = categories[index + 1].description,
                        colors = categories[index + 1].cardColors(),
                        icon = categories[index + 1].icon,
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
        HomeCategoriesSection()
    }
}