package com.promofusion.modules.main.fragments.settings.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.promofusion.R
import com.promofusion.common.components.ContentSection
import com.promofusion.common.components.ProfileHeader
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.common.utils.SessionManager
import com.promofusion.modules.main.fragments.settings.viewmodels.SettingViewModel

@Composable
fun SettingsScreen(navController: NavController) {
    val settingViewModel = viewModel<SettingViewModel>()
    settingViewModel.setAppContext(LocalContext.current)
    settingViewModel.setNavController(navController)

    val email = SessionManager(LocalContext.current).fetchCurrentUser()?.email ?: "email";
    val name = SessionManager(LocalContext.current).fetchCurrentUser()?.username ?: "Name";

    Column(modifier = Modifier.fillMaxWidth()) {
        ProfileHeader (
            onClick = { /*TODO: Back*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp,)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.verticalScroll(
                rememberScrollState()
            )
        ) {
            ProfileInfoSection(
                Name = email,
                Email = name
            )
            GeneralSettingSection()
            HelpSettingSection()
            ContentSection (
                modifier = Modifier.padding(bottom = 8.dp),
                spacer = 8.dp,
                title = {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .height(32.dp)
                            .background(color = Color(0x12737373))
                    ){
                        Text(
                            text = "Logout",
                            fontWeight = FontWeight.ExtraBold,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.scrim,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp, 0.dp, 0.dp, 0.dp)
                        )
                    }
                },
            ){
                TextButton(
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                        .fillMaxWidth()
                        .height(48.dp),
                    onClick = {
                        settingViewModel.handleOnLogout()
                    }
                ) {
                    Icon(
                        tint = MaterialTheme.colorScheme.primary,
                        imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_exit_line),
                        contentDescription = "Logout",
                        modifier = Modifier
                            .padding(16.dp, 0.dp)
                    )
                    Text(
                        text = "Logout",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 0.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    PromoFusionTheme {
        SettingsScreen(navController = NavController(LocalContext.current))
    }
}

