package com.promofusion.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun HeaderTitle(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    textAlign: TextAlign = TextAlign.Start,
    title: String, description: String, action: (@Composable () -> Unit)?,
    showAction: Boolean? = true,
) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .weight(0.5f)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = textAlign,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = description,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.scrim,
                textAlign = textAlign,
                modifier = Modifier.fillMaxWidth()
            )
        }

        if (showAction == true) {
            action.let {
                it?.invoke()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HeaderTitlePreview() {
    PromoFusionTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            HeaderTitle(
                title = "Lorem Ipsum", description = "Description Placeholder", action = null
            )
        }
    }
}