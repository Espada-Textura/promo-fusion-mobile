package com.promofusion.modules.auth.fragments.login.views

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.painter.Painter
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.promofusion.modules.auth.fragments.login.viewmodels.LoginViewModel
import com.promofusion.modules.main.navigations.models.MainNavigation
import kotlin.math.log

@Composable
fun LoginScreen(navController: NavController? = null) {
    val logoPainter: Painter = painterResource(id = R.drawable.ic_promos_logo_foreground)
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val loginStatus = viewModel<LoginViewModel>().loginStatus.value
    val viewModel = viewModel<LoginViewModel>()

    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        item {
            HeaderTitle(title = loginStatus, description = "Wellcome Back", action = {})

            Image(
                painter = logoPainter, "logo",
                modifier = Modifier.fillMaxWidth()
                    .padding(0.dp, 34.dp)
                    .size(164.dp)
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
                modifier = Modifier
                    .padding(24.dp, 12.dp)
                    .fillMaxWidth()

            )

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                modifier = Modifier
                    .padding(24.dp, 12.dp)
                    .fillMaxWidth(),
            )
        }



        item {
            Button(modifier = Modifier
                .padding(24.dp, 12.dp)
                .fillMaxWidth()
                .height(54.dp),
                onClick = {
                    viewModel.hit()
//                    navController?.navigate(MainNavigation.Home.route)
//                    onLoginClick(email, password)
                }
            ) {
                Text(text = "Login")
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

