package com.promofusion.modules.auth.fragments.login.views

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.promofusion.R
import com.promofusion.common.components.HeaderTitle
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.auth.context.views.components.ComplianceText
import com.promofusion.modules.auth.context.views.components.OAuthPortal
import com.promofusion.modules.auth.context.views.components.OrSeparator
import com.promofusion.modules.auth.fragments.login.viewmodels.LoginViewModel
import com.promofusion.modules.auth.navigations.models.AuthNavigation

@Composable
fun LoginScreen(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val viewModel = viewModel<LoginViewModel>()
    viewModel.setAppContext(LocalContext.current)
    viewModel.setNavController(navController)

    fun validateInputs(): Boolean {
        val emailPattern = Patterns.EMAIL_ADDRESS

        // Validate email
        if (email.isEmpty() || !emailPattern.matcher(email).matches()) {
            // Handle invalid email
            // You can show an error message or perform any other action
            return false
        }

        // Validate password (you can add more conditions based on your requirements)
        // Handle invalid password
        // You can show an error message or perform any other action
        return !(password.isEmpty() || password.length < 6)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 56.dp)
            .fillMaxSize(),
    ) {

        item {
            HeaderTitle(
                title = "Login",
                description = "Let’s get started to your gateway to a world of exciting promotions.",
                action = {}, modifier = Modifier.padding(24.dp, 12.dp),
                textAlign = TextAlign.Center
            )
        }

        item {
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text("Email") },
                placeholder = { Text("Email") },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = "User Icon"
                    )
                },
                modifier = Modifier
                    .padding(24.dp, 6.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.extraLarge
            )


            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.key_1_line),
                        contentDescription = "Password Icon",

                        )
                }, visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(24.dp, 6.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.extraLarge
            )


            Button(
                modifier = Modifier
                    .padding(24.dp, 12.dp)
                    .fillMaxWidth()
                    .height(54.dp),
                enabled = validateInputs() && !viewModel.pending.value,
                onClick = {
                    viewModel.handleOnSubmit(email, password)
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContainerColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            ) {
                Text(text = if (viewModel.pending.value) "Login ..." else "Login")
            }

        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp, 0.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 4.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don’t have an account yet?",
                    style = MaterialTheme.typography.bodyMedium
                )

                TextButton(onClick = { navController.navigate(AuthNavigation.SignUp.route) }) {
                    Text(
                        text = "Create One",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }


        item {
            OrSeparator(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

        item {
            OAuthPortal(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

        item {
            ComplianceText(modifier = Modifier.padding(top = 56.dp))
        }


    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PromoFusionTheme {
        LoginScreen(navController = NavController(LocalContext.current))
    }
}

