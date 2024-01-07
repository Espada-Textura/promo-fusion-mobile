package com.promofusion.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.promofusion.common.theme.PromoFusionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {

    var queryState by remember {
        mutableStateOf("")
    }
    var activeState by remember {
        mutableStateOf(false)
    }

}


@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    PromoFusionTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

        }
    }
}