package com.promofusion.modules.auth.fragments.welcome.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.promofusion.R
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.auth.context.views.components.ComplianceText
import com.promofusion.modules.auth.navigations.models.AuthNavigation

@Composable
fun WelcomeScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 56.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.ic_welcome_iamge),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 24.dp)
            )

            HeaderTitle(
                title = "Welcome back!",
                description = "Let’s get started to your gateway to a world of exciting promotions.",
                action = {},
                modifier = Modifier.padding(24.dp, 12.dp),
                textAlign = TextAlign.Center
            )
        }

        item {
            Button(modifier = Modifier
                .padding(24.dp, 6.dp)
                .fillMaxWidth()
                .height(54.dp),
                onClick = {
                    navController.navigate(AuthNavigation.SignUp.route)
                }) {
                Text(
                    text = "Register an account",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            OutlinedButton(
                modifier = Modifier
                    .padding(24.dp, 6.dp)
                    .fillMaxWidth()
                    .height(54.dp), onClick = {
                    navController.navigate(AuthNavigation.SignIn.route)
                }, border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Sign into an account",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        item {
            ComplianceText()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    PromoFusionTheme {
        WelcomeScreen(navController = NavController(LocalContext.current))
    }
}

