package com.promofusion.modules.main.fragments.home.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.promofusion.R
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderTitle(title = "Welcome back!", description = "Let's get your promotions", action = {
            IconButton(onClick = { }) {
                Icon(
                    painter = (painterResource(id = R.drawable.ic_notification_line)),
                    contentDescription = "Notification Bell",
                )
            }
        })
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PromoFusionTheme {
        HomeScreen()
    }
}

