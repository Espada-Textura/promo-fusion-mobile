package com.promofusion.modules.main.fragments.coupons.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.R
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.components.SearchWithFilter
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun CouponsScreen() {
    Column(
        modifier = Modifier
//            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        HeaderTitle(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 24.dp),
            title = "Promotions",
            description = "Let's see what you've got",
            action = {
            IconButton(onClick = { }) {
                Icon(
                    painter = (painterResource(id = R.drawable.ic_notification_line)),
                    contentDescription = "Notification Bell",
                )
            }
        })
        SearchWithFilter (
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 0.dp, bottom = 0.dp),
            width = 50.dp,
            height = 50.dp,
            onClick = { }
        )
        CouponListSection()
    }
}

@Preview(showBackground = true)
@Composable
fun CouponsScreenPreview() {
    PromoFusionTheme {
        CouponsScreen()
    }
}

