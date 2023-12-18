package com.promofusion.common.ui.components.navigations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.common.ui.theme.PromoFusionTheme


@Composable
fun BottomNavigationBar(

) {

    var bottomNavState by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            NavigationRouteItems.forEachIndexed { index, item ->

                if (item.route === "scan") {

                    BottomNavigationItem(
                        selected = bottomNavState == index,
                        onClick = {
                            bottomNavState = index
                        },
                        icon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(
                                    item.unselectedIcon
                                ), contentDescription = item.title
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        containerModifier = Modifier
                            .size(64.dp)
                            .background(
                                MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(64.dp)
                            ),
                        label = { },
                        colors = NavigationBarItemDefaults.colors(
                            unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            indicatorColor = MaterialTheme.colorScheme.primary
                        )
                    )

                } else {

                    BottomNavigationItem(
                        selected = bottomNavState == index,
                        onClick = {
                            bottomNavState = index
                        },
                        icon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(
                                    if (bottomNavState == index) item.selectedIcon
                                    else item.unselectedIcon
                                ), contentDescription = item.title
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        containerModifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        label = {
                            item.title?.let { Text(text = it) }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            unselectedIconColor = MaterialTheme.colorScheme.scrim,
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.background
                        ),
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    PromoFusionTheme {
        BottomNavigationBar()
    }
}