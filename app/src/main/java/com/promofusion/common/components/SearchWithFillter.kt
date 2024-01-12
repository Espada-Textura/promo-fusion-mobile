package com.promofusion.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.promofusion.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchWithFilter(
    modifier: Modifier = Modifier,
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    onSearch: (String) -> Unit = {},
    active: Boolean = false,
    onActiveChange: (Boolean) -> Unit = {},
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = {
        Text(
            text = "Search", color = MaterialTheme.colorScheme.scrim
        )
    },
    leadingIcon: @Composable (() -> Unit)? = {
        Icon(
            painter = painterResource(id = R.drawable.ic_search_line),
            contentDescription = "Search Icon"
        )
    },
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = SearchBarDefaults.inputFieldShape,
    colors: SearchBarColors = SearchBarDefaults.colors(),
    tonalElevation: Dp = SearchBarDefaults.Elevation,
    windowInsets: WindowInsets = SearchBarDefaults.windowInsets,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    buttonOnClick: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier,
    ) {
        SearchBar(
            modifier = Modifier
                .weight(1F)
                .padding(0.dp, 0.dp, 16.dp, 0.dp),
            query = query,
            onQueryChange = onQueryChange,
            onSearch = onSearch,
            active = active,
            onActiveChange = onActiveChange,
            enabled = enabled,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            shape = shape,
            colors = colors,
            tonalElevation = tonalElevation,
            windowInsets = windowInsets,
            interactionSource = interactionSource
        ) {
            content()
        }

        FilledIconButton(
            onClick = buttonOnClick, // Set the button size,
            modifier = Modifier
                .background(color = Color.Transparent)
                .padding(8.dp)
                .size(52.dp)
        ) {
            Icon(
                tint = Color.White,
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
                contentDescription = "Search Filter Icon",
                modifier = Modifier.defaultMinSize(24.dp) // Set the icon size
            )
        }
    }

}