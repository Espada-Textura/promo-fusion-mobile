package com.promofusion.modules.main.fragments.coupons.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.promofusion.common.components.CouponElevationCard
import com.promofusion.common.utils.getFormattedDate
import com.promofusion.modules.main.fragments.coupons.models.data.Coupon

@Composable
fun CouponListSection (coupons: List<Coupon> = emptyList()) {

//    coupons = when (status) {
//        CouponStatus.Valid -> Color.Green
//        CouponStatus.Used -> Color.Gray
//        CouponStatus.Expired -> Color.Red
//        else -> Color.Magenta
//    },

    Column (
        verticalArrangement = Arrangement.spacedBy(0.dp),
        modifier = Modifier
            .padding(24.dp, 0.dp)
            .verticalScroll(rememberScrollState()),
    ){
        coupons.forEachIndexed { index, coupon ->
            CouponElevationCard(
                shopName = coupon.name ?: "No Data",
                promotion = coupon.promotionTitle ?: "No Data",
                expiredAt = coupon.endDate?.let { getFormattedDate(it) }
                    ?: "No data",
                status = coupon.status ?: "No Data",
                imageUrl = coupon.imageUrl ?: "No Data",
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}