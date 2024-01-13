package com.promofusion.modules.auth.fragments.welcnew.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.promofusion.R
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.theme.PromoFusionTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.promofusion.modules.auth.navigations.models.AuthNavigation




@Composable
fun WelcnewScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        item {
//            Image(
//                painter = logoPainter, "logo",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(12.dp, 56.dp).size(100.dp, 100.dp),
//                tint = MaterialTheme.colorScheme.onSecondary
//            )

            Icon(
                painter = painterResource(id = R.drawable.ic_check_circle_linex),
                contentDescription = "Search Icon",
                tint = Color(0xFF15803c),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, 66.dp).size(100.dp, 100.dp),
            )

            HeaderTitle(title = "Done create account!",
                description = "your account has been created successfully.",
                action = {
                },modifier = Modifier.padding(12.dp, 12.dp),
                textAlign = TextAlign.Center
            )
        }

        item {
            Button(modifier = Modifier
                .padding(24.dp, 12.dp)
                .fillMaxWidth()
                .height(54.dp),
                onClick = {
                    navController.navigate(AuthNavigation.SignIn.route)
                }
            ) {
                Text(text = "Sign into an account" )
            }
        }

        item {

            Text(text = "By signing in you agree to our.",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 4.dp)
                    .padding(24.dp, 2.dp)
                    .fillMaxWidth(),)
            Text(text = "Term & Conditions",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(start = 4.dp)
                    .padding(24.dp, 2.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,

                )

        }

    }
}



@Preview(showBackground = true)
@Composable
fun WelcnewScreenPreview() {
    PromoFusionTheme {
        WelcnewScreen(navController = NavController(LocalContext.current))
    }
}
