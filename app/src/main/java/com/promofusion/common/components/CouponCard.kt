package com.promofusion.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promofusion.common.constants.CouponStatus
import com.promofusion.common.theme.displayFontFamily

@Composable
fun CouponElevationCard (
    couponId: Int,
    shopName: String,
    promotion: String,
    expiredAt: String,
    status: CouponStatus
) {
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp),
    ) {
        Row(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = com.promofusion.R.drawable.ic_promos_logo_foreground),
                contentDescription = "Shop Logo"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .width(200.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = shopName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.6.sp,
                    textAlign = TextAlign.Center
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = promotion,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.6.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "off",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 0.6.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Text(
                    text = expiredAt,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.6.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.Top)
                    .padding(0.dp)
                    .background(if (status == CouponStatus.Valid) Color.Red else if (status == CouponStatus.Used) Color.Green else Color.Magenta)
                    .fillMaxWidth(),
                
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
    CouponElevationCard(
        1,
        "Starbuck",
        "25%",
        "20 Jan 2024",
        CouponStatus.Valid
    )
}