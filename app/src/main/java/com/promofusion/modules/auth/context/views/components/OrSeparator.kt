package com.promofusion.modules.auth.context.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun OrSeparator(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            space = 16.dp, alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
    ) {

        Spacer(
            modifier = Modifier
                .weight(0.33f)
                .fillMaxWidth()
                .height(0.5.dp)
                .background(
                    color = MaterialTheme.colorScheme.scrim,
                    shape = MaterialTheme.shapes.extraLarge
                )
        )

        Text(text = "Or", style = MaterialTheme.typography.bodyMedium)

        Spacer(
            modifier = Modifier
                .weight(0.33f)
                .fillMaxWidth()
                .height(0.5.dp)
                .background(
                    color = MaterialTheme.colorScheme.scrim,
                    shape = MaterialTheme.shapes.extraLarge
                )
        )

    }


}


@Preview(showBackground = true)
@Composable
fun OrSeparatorPreview() {
    PromoFusionTheme {
        OAuthPortal()
    }
}