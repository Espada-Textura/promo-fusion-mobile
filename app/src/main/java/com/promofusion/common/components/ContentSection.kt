package com.promofusion.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.promofusion.R
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun ContentSection(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    title: @Composable () -> Unit? = {},
    link: @Composable () -> Unit? = {},
    spacer: Dp = 16.dp,
    content: @Composable () -> Unit,
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                title()
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_line),
                    contentDescription = "Right Icon",
                    modifier = Modifier.size(20.dp)
                )
            }
            link()
        }

        Spacer(modifier = Modifier.height(spacer))

        content()

    }
}


@Preview(showBackground = true)
@Composable
fun ContentSectionPreview() {
    PromoFusionTheme {
        Surface(
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            ContentSection(
                title = {
                    Text(
                        text = "Featured Shop", style = MaterialTheme.typography.titleMedium
                    )
                },
            ) {}
        }
    }
}