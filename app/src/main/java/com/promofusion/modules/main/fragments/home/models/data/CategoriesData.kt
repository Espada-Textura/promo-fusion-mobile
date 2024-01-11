package com.promofusion.modules.main.fragments.home.models.data

import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable

data class CategoriesData(
    val title: String,
    val description: String,
    val icon: @Composable () -> Unit,
    val cardColors: @Composable () -> CardColors
)