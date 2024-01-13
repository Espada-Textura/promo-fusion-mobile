package com.promofusion.modules.main.fragments.coupons.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.promofusion.common.components.CouponElevationCard
import com.promofusion.common.constants.CouponStatus
import com.promofusion.common.utils.DateTime
import com.promofusion.modules.main.fragments.coupons.models.data.Coupon
import com.promofusion.modules.main.fragments.coupons.viewmodels.CouponViewModel

//@Composable
//fun CouponListSection (viewModel: CouponViewModel = viewModel()) {
//
//    // Observe StateFlow as State
//    val coupons = viewModel.data.collectAsState().value
//
////    coupons = when (status) {
////        CouponStatus.Valid -> Color.Green
////        CouponStatus.Used -> Color.Gray
////        CouponStatus.Expired -> Color.Red
////        else -> Color.Magenta
////    },
//
//    LazyColumn (
//        modifier = Modifier.padding(24.dp, 0.dp)
//    ){
//        items(coupons.size) { coupon ->
//            CouponElevationCard(
//                couponId = coupon.id,
//                shopName = coupon.name,
//                promotion = coupon.promotion,
//                expiredAt = coupon.endDate,
//                status = coupon.status,
//                imageUrl = coupon.imageUrl,
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//    }
//}

@Composable
fun CouponListSection (coupons: List<Coupon> = emptyList()) {

    // Observe StateFlow as State
//    val coupons = viewModel.data.collectAsState().value

//    coupons = when (status) {
//        CouponStatus.Valid -> Color.Green
//        CouponStatus.Used -> Color.Gray
//        CouponStatus.Expired -> Color.Red
//        else -> Color.Magenta
//    },

    Column (
        modifier = Modifier.padding(24.dp, 0.dp)
    ){
        coupons.forEachIndexed { index, coupon ->
            CouponElevationCard(
                shopName = coupon.name ?: "No Data",
                promotion = coupon.promotionTitle ?: "No Data",
                expiredAt = coupon.endDate?.let { (DateTime.getFormattedDate(it)) }
                    ?: "No data",
                status = coupon.status ?: "No Data",
                imageUrl = coupon.imageUrl ?: "No Data",
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}