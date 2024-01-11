package com.promofusion.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.common.theme.Stone50
import com.promofusion.common.theme.Stone950

@Composable
fun FeaturedShopCard(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopCenter,
    propagateMinConstraints: Boolean = false,
    promotionType: String,
    shopTitle: String,
    shopDescription: String,
    imageURL: String
) {

    Box(
        modifier = modifier
            .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp))
            .width(256.dp),
        contentAlignment = contentAlignment,
        propagateMinConstraints = propagateMinConstraints,
    ) {

        OutlinedCard(
            modifier = modifier.width(256.dp)
        ) {
            Box(modifier = Modifier, contentAlignment = Alignment.BottomStart) {
                AsyncImage(
                    model = imageURL,
                    contentDescription = "Featured Shop Image",
                    modifier = Modifier
                        .background(
                            color = Color.Unspecified, shape = RoundedCornerShape(16.dp)
                        )
                        .height(196.dp),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Stone950
                                )
                            )
                        )
                        .padding(16.dp)
                        .height(96.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = shopTitle,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        color = Stone50
                    )
                    Spacer(modifier = modifier.height(4.dp))
                    Text(
                        text = shopDescription,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Stone50
                    )
                }
            }
        }

        Box(
            modifier = modifier
                .background(Color.Transparent)
                .fillMaxWidth()
                .width(IntrinsicSize.Min),
            contentAlignment = Alignment.TopEnd,
        ) {
            Text(
                text = promotionType,
                modifier = Modifier
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(64.dp))
                    .padding(16.dp, 8.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FeaturedShopCardPreview() {
    PromoFusionTheme {
        FeaturedShopCard(
            promotionType = "20%",
            shopTitle = "Shop Title",
            shopDescription = LoremIpsum(10).values.first(),
            imageURL = "https://images.unsplash.com/"
        )
    }
}