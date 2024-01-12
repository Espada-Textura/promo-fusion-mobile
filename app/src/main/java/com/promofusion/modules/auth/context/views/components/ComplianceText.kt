package com.promofusion.modules.auth.context.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ComplianceText(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
) {

    Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        Text(
            text = "By signing in you agree to our.",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 4.dp)
                .padding(24.dp, 2.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Term & Conditions",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(start = 4.dp)
                .padding(24.dp, 2.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )

    }
}