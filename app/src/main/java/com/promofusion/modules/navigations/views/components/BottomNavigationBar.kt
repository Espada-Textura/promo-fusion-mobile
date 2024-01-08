package com.promofusion.modules.navigations.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.navigations.models.NavigationRouteItems
import com.promofusion.modules.navigations.models.NavigationType


@Composable
fun BottomNavigationBar(
    navHostController: NavHostController
) {

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            NavigationRouteItems.forEachIndexed { _, item ->

                if (item.navigationType === NavigationType.ACTION_BUTTON) {

                    BottomNavigationItemContainer(
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(64.dp)
                            ),
                    ) {
                        NavigationBarItem(selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                            onClick = {
                                navHostController.navigate(item.route)
                            },
                            icon = {
                                item.unselectedIcon?.let {
                                    ImageVector.vectorResource(
                                        it
                                    )
                                }?.let {
                                    Icon(
                                        imageVector = it,
                                        contentDescription = item.title,
                                        modifier = Modifier.padding(0.dp, 16.dp)
                                    )
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .align(Alignment.CenterVertically),
                            colors = NavigationBarItemDefaults.colors(
                                unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                                selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                                selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                                indicatorColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }

                } else {

                    BottomNavigationItemContainer(
                        modifier = Modifier.weight(1f)
                    ) {
                        NavigationBarItem(selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                            onClick = {
                                navHostController.navigate(item.route)
                            },
                            icon = {
                                (if (currentDestination?.hierarchy?.any { it.route == item.route } == true) item.selectedIcon
                                else item.unselectedIcon)?.let { ImageVector.vectorResource(it) }
                                    ?.let {
                                        Icon(
                                            imageVector = it,
                                            contentDescription = item.title
                                        )
                                    }
                            },
                            modifier = Modifier
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
                            alwaysShowLabel = false
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    PromoFusionTheme {
        BottomNavigationBar(navHostController = rememberNavController())
    }
}