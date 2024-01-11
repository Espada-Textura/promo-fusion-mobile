package com.promofusion.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchWithFilter(
    modifier: Modifier = Modifier,
    width: Dp = 50.dp, // Default width
    height: Dp = 50.dp, // Default height
    iconSize: Dp = 24.dp, // Default icon size
    onClick: () -> Unit // Click handler
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier,
    ){
        SearchBar (
            modifier = Modifier
                .weight(1F)
                .padding(0.dp, 0.dp, 16.dp, 0.dp)
        ){}
        Button(
            onClick = onClick,
            modifier = Modifier.size(width, height) // Set the button size
        ) {
            Icon(
                tint = Color.White,
                imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_filter),
                contentDescription = "Search Filter Icon",
                modifier = Modifier.size(iconSize) // Set the icon size
            )
        }
    }

}