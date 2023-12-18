package com.promofusion.common.ui.components.navigations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun BottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier,
    containerModifier: Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)?,
    colors: NavigationBarItemColors,
) {
    Row(
        modifier = containerModifier
            .wrapContentSize(align = Alignment.Center),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        NavigationBarItem(
            modifier = modifier,
            selected = selected, onClick = onClick, icon = icon,
            colors = colors,
            alwaysShowLabel = false,
            label = label,
            enabled = enabled,
        )
    }

}