package com.promofusion.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.promofusion.R
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun ShopCard(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(
        defaultElevation = 4.dp,
    ),
    border: BorderStroke? = null,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    model: Any?,
    title: String,
    description: String,
    promotion: String,
    duration: String
) {
    Card(
        modifier = modifier, shape = shape, colors = colors, elevation = elevation, border = border
    ) {
        Row(
            horizontalArrangement = horizontalArrangement, verticalAlignment = verticalAlignment,
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.TopStart
            ) {
                AsyncImage(
                    model = model,
                    contentDescription = description,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .fillMaxSize()
                        .background(color = Color.Transparent),
                    contentScale = ContentScale.Crop,
                )

                PromotionRibbon {
                    Text(
                        text = promotion,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 4.dp, alignment = Alignment.Top
                ), modifier = Modifier
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
            ) {

                Text(text = title, style = MaterialTheme.typography.titleMedium)

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.scrim
                )


                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        6.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(0.dp, 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_sandglass_line),
                        contentDescription = "Duration",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.scrim
                    )

                    Text(
                        text = duration,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.scrim,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShopCardPreview() {
    PromoFusionTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(24.dp)
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Min)
        ) {
            ShopCard(
                model = "https://source.unsplash.com/random/500x300/",
                title = "Flower Shop Promotion",
                description = "You can get your free flower extra.",
                promotion = "Buy 1 Get 1",
                duration = "3 days left"
            )
        }
    }
}