package com.promofusion.modules.main.fragments.search.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.promofusion.R
import com.promofusion.common.theme.PromoFusionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController? = null) {

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {

        SearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            placeholder = { Text(text = "Search", color = MaterialTheme.colorScheme.onSurface) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RectangleShape),
            leadingIcon = {
                IconButton(onClick = {
                    navController?.previousBackStackEntry?.destination?.route?.let {
                        navController.navigate(
                            it
                        )
                    }
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_left_line),
                        contentDescription = "Back Icon"
                    )
                }
            },
        ) {

        }

        Spacer(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onSurface)
                .fillMaxWidth()
                .height(0.5.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    PromoFusionTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            SearchScreen()
        }
    }
}