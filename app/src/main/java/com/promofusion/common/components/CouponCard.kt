package com.promofusion.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.common.constants.CouponStatus

@Composable
fun CouponCardView(
    couponId: Int,
    shopName: String,
    promotion: String,
    expiredAt: String,
    status: CouponStatus
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .padding(0.dp)
            .shadow(8.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
    ) {
        Row(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = com.promofusion.R.drawable.ic_coupon_fill),
                contentDescription = "Shop Logo"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = shopName)
                Text(text = promotion + " off")
                Text(text = expiredAt)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .background(if (status == CouponStatus.Valid) Color.Red else if (status == CouponStatus.Used) Color.Green else Color.Magenta)
                    .fillMaxWidth()

            ) {
                Text(
                    text = if (status == CouponStatus.Valid) "Valid" else if (status == CouponStatus.Used) "Used" else if (status == CouponStatus.Expired) "Expired" else "Invalid",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ReusableCardViewPreview() {
    CouponCardView(
        1,
        "Starbuck",
        "25%",
        "20 Jan 2024",
        CouponStatus.Valid
    )
}