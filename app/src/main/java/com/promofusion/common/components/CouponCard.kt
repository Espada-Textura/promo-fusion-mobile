package com.promofusion.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

import com.promofusion.common.constants.CouponStatus

@Composable
fun CouponElevationCard (
    shopName: String,
    promotion: String,
    expiredAt: String,
    status: String,
    imageUrl: String,
) {
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 16.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
//                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                .align(Alignment.End),
            contentAlignment = Alignment.TopEnd
            ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
//                .offset(x = 0.dp, y = 0.dp)
                    .size(width = 64.dp, height = 24.dp)
                    .background(
                        color = when (status) {
                            "active" -> Color.Green
                            "used" -> Color.Gray
                            "expired" -> Color.Red
                            else -> Color.Magenta
                        },
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 16.dp
                        )
                    ),
            ) {
                Text(
                    text = when (status) {
                        "active" -> "Valid"
                        "Used" -> "Used"
                        "expired" -> "Expired"
                        else -> "Invalid"
                    },
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
            ){
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Shop Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Divider(
                    modifier = Modifier
                        .width(2.dp)
                        .fillMaxHeight(),
                    color = Color(0xFFD4D4D4)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = shopName,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.6.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(),
                    ) {
                        Text(
                            text = "$promotion%",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.6.sp,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            modifier = Modifier
                                .padding(8.dp,0.dp, 0.dp, 4.dp),
                            text = "off",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 0.6.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                    Row {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = expiredAt,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 0.6.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun ReusableCardViewPreview() {
//    CouponElevationCard(
//        1,
//        "STARBUCK",
//        "25",
//        "20-Jan-2024",
//        CouponStatus.Valid,
//        imageUrl,
//    )
//}
