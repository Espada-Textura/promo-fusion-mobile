package com.promofusion.modules.auth.fragments.auth.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.promofusion.R
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.theme.PromoFusionTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun LoginScreen() {
    var text by rememberSaveable { mutableStateOf("") }
    val logoPainter: Painter = painterResource(id = R.drawable.ic_promos_logo_foreground)

    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderTitle(title = "Login", description = "Wellcome Back", action = {})

        Image(
            painter = logoPainter, "logo",
            modifier = Modifier.fillMaxWidth()
                .padding(0.dp, 34.dp)
                .size(184.dp)
        )

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Username") },
            singleLine = true,
            modifier = Modifier
                .padding(24.dp, 12.dp)
                .fillMaxWidth()
        )

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Password") },
            singleLine = true,
            modifier = Modifier
                .padding(24.dp, 12.dp)
                .fillMaxWidth(),
        )


        Button(onClick = { /*TODO*/ },modifier = Modifier
            .padding(24.dp, 12.dp)
            .fillMaxWidth()
            .height(54.dp) ) {
            Text(text = "Login")

        }

    }
}



@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PromoFusionTheme {
        LoginScreen()
    }
}

