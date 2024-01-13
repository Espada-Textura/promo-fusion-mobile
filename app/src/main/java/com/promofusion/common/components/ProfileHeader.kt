package com.promofusion.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import com.promofusion.R

@Composable
fun ProfileHeader (
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    onClick: () -> Unit //Click Handler
) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ){
        IconButton (
            onClick = onClick
        ) {
            Icon (
                tint = MaterialTheme.colorScheme.onSurface,
                painter = (painterResource(id = R.drawable.ic_back_line)),
                contentDescription = "Back Icon"
            )
        }
        Text(
            text = "Profile",
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.titleLarge,
            textAlign = textAlign,
        )

        IconButton(onClick = { /*TODO*/ }) {
            Icon (
                tint = MaterialTheme.colorScheme.onSurface,
                painter = (painterResource(id = R.drawable.ic_search_line)),
                contentDescription = "Back Icon"
            )
        }
    }
}