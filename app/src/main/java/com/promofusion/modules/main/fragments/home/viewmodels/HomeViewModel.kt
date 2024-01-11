package com.promofusion.modules.main.fragments.home.viewmodels

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import com.promofusion.R
import com.promofusion.common.theme.Cyan50
import com.promofusion.common.theme.Cyan500
import com.promofusion.common.theme.Green50
import com.promofusion.common.theme.Green500
import com.promofusion.common.theme.Violet50
import com.promofusion.common.theme.Violet500
import com.promofusion.modules.main.fragments.home.models.data.CategoriesData

class HomeViewModel : ViewModel() {
    private val _categories = listOf(
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

    fun getCategories(): List<CategoriesData> {
        return _categories
    }
}