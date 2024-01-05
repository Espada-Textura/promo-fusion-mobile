package com.promofusion.modules.main.fragments.subscriptions.views

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
fun SubscriptionsScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderTitle(title = "Subscription", description = "Explore more shops", action = {
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
fun SubscriptionsScreenPreview() {
    PromoFusionTheme {
        SubscriptionsScreen()
    }
}

