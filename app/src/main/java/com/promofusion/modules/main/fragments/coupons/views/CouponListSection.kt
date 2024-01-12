package com.promofusion.modules.main.fragments.coupons.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.common.components.CouponElevationCard
import com.promofusion.common.constants.CouponStatus

@Preview
@Composable
fun CouponListSection () {
    LazyColumn (
        modifier = Modifier.padding(24.dp)
    ){
        items(8, itemContent = {
            CouponElevationCard(
                couponId = 1,
                shopName = "STARBUCK",
                promotion = "15",
                expiredAt = "Jan-20-2024",
                status = CouponStatus.Valid
            )

            Spacer(modifier = Modifier.height(16.dp))
        })
    }
}