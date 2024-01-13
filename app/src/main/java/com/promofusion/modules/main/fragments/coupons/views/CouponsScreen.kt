package com.promofusion.modules.main.fragments.coupons.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.promofusion.R
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.components.SearchWithFilter
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.main.fragments.coupons.models.data.Coupon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CouponsScreen(coupons: List<Coupon> = emptyList()) {

    Column(
        modifier = Modifier
//            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        HeaderTitle(modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 0.dp
        ),
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

        SearchWithFilter(
            modifier = Modifier.padding(16.dp)
        ) {}

        CouponListSection(coupons)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CouponsScreenPreview() {
//    PromoFusionTheme {
//        CouponsScreen()
//    }
//}

