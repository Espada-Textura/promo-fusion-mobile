package com.promofusion.modules.main.fragments.scan.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun ScanScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderTitle(
            title = "Scan Promotion",
            description = "Scan the QR Code to get a new promotion",
            action = {
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 0.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ScanScreenPreview() {
    PromoFusionTheme {
        ScanScreen()
    }
}

