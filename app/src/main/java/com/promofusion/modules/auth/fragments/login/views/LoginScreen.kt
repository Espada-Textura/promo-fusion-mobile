package com.promofusion.modules.auth.fragments.login.views

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
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.promofusion.modules.auth.fragments.login.viewmodels.LoginViewModel
import com.promofusion.modules.main.navigations.models.MainNavigation

@Composable
fun LoginScreen(navController: NavController? = null) {
    val logoPainter: Painter = painterResource(id = R.drawable.ic_welcome_iamge)
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val viewModel = viewModel<LoginViewModel>()

    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        item {
            HeaderTitle(title = "Login", description = "Welcome Back", action = {})

            Image(
                painter = logoPainter, "logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 34.dp)
            )
        }
        item {
            TextField(
                value = email,
                onValueChange = {
                    email = it },
                label = { Text("Email") },
                placeholder = { Text("Email") },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_qrcode_2_line),
                        contentDescription = "Search Icon"
                    )
                },
                modifier = Modifier
                    .padding(24.dp, 12.dp)
                    .fillMaxWidth()
                    .clip(shape = MaterialTheme.shapes.extraLarge)
                    .border(2.dp, Color.Gray, MaterialTheme.shapes.extraLarge)
            )

            (
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search_line),
                            contentDescription = "Search Icon"
                        )
                    },
                    modifier = Modifier
                        .padding(24.dp, 12.dp)
                        .fillMaxWidth()
                        .clip(shape = MaterialTheme.shapes.extraLarge)
                        .border(2.dp, Color.Gray, MaterialTheme.shapes.extraLarge)
                    )
            )
        }

        item {
            Button(modifier = Modifier
                .padding(24.dp, 12.dp)
                .fillMaxWidth()
                .height(54.dp),
                onClick = {
                    viewModel.handleOnSubmit(email, password)
                    navController?.navigate(MainNavigation.Home.route)
                }
            ) {
                Text(text = "Login")
            }
        }
        item {
            Row(modifier = Modifier.fillMaxWidth()
                .padding(24.dp, 6.dp),
            ) {
                Text(text = "Don’t have an account yet?")
                Text(text = "Sign Up Now",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 4.dp),
                    fontWeight = FontWeight.Bold,
                )
            }
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

