package com.promofusion.modules.main.fragments.scan.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun ScanScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {}
}


@Preview(showBackground = true)
@Composable
fun ScanScreenPreview() {
    PromoFusionTheme {
        ScanScreen()
    }
}

