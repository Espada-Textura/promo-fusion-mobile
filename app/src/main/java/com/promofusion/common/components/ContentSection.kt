package com.promofusion.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun ContentSection(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    title: String,
    link: @Composable () -> Unit? = {},
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
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            link()
        }

        Spacer(modifier = Modifier.height(8.dp))

        content()

    }
}


@Preview(showBackground = true)
@Composable
fun ContentSectionPreview() {
    PromoFusionTheme {
        Surface(
            modifier = Modifier
                .height(IntrinsicSize.Min)
        ) {
            ContentSection(
                title = "Featured Shops",
                link = {
                    TextButton(onClick = { }) {
                        Text(text = "View More", style = MaterialTheme.typography.titleMedium)
                    }
                },
            ) {}
        }
    }
}