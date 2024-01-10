package com.promofusion.modules.main.fragments.search.views

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import com.promofusion.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    var query by remember {
        mutableStateOf("")
    }

    var isSearchActive by remember {
        mutableStateOf(false)
    }

    SearchBar(query = query,
        onQueryChange = { query = it },
        onSearch = {},
        active = isSearchActive,
        onActiveChange = {
            isSearchActive = it
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search_line),
                contentDescription = "Search Icon",
            )
        },
        placeholder = { Text(text = "Search", color = MaterialTheme.colorScheme.scrim) },
        trailingIcon = {
            if (isSearchActive) Icon(
                painter = painterResource(id = R.drawable.ic_close_line),
                contentDescription = "Clear Icon"
            )
        }) {}
}