package com.promofusion.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.promofusion.R
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ),
    elevation: CardElevation = CardDefaults.cardElevation(
        defaultElevation = 2.dp,
        hoveredElevation = 1.dp,
        pressedElevation = 0.dp,
    ),
    border: BorderStroke? = null,
    icon: @Composable () -> Unit = {
        androidx.compose.material3.Icon(
            painter = painterResource(id = R.drawable.ic_hexagon_line),
            contentDescription = "Category Icon",
            tint = MaterialTheme.colorScheme.primary
        )
    },
    title: String,
    description: String
) {

    Card(
        modifier = modifier
            .defaultMinSize(156.dp)
            .fillMaxSize(),
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
    ) {


        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.ExtraBold,
            maxLines = 2,
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxSize()) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 16.dp)
                    .weight(1f)
            )

            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(12.dp, 0.dp, 12.dp, 0.dp)
                    )
                    .padding(8.dp)
                    .align(Alignment.Bottom),
                contentAlignment = Alignment.Center,
            ) {
                icon()
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun CategoryCardPreview() {
    PromoFusionTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(24.dp)
        ) {
            Box(Modifier.size(256.dp)) {
                CategoryCard(
                    title = "Lorem Ipsum",
                    description = LoremIpsum(5).values.first().toString()
                )
            }
        }
    }
}