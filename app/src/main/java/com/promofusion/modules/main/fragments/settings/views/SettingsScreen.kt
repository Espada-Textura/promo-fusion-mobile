package com.promofusion.modules.main.fragments.settings.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.promofusion.R
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.main.fragments.settings.viewmodels.SettingViewModel

@Composable
fun SettingsScreen(navController: NavController) {
    val settingViewModel = viewModel<SettingViewModel>()
    settingViewModel.setAppContext(LocalContext.current)
    settingViewModel.setNavController(navController)

    Column(modifier = Modifier.fillMaxWidth()) {
        Button(modifier = Modifier
            .padding(24.dp, 12.dp)
            .fillMaxWidth()
            .height(54.dp),
            onClick = {
                settingViewModel.handleOnLogout()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_power_line),
                contentDescription = "Search Icon",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = "Logout" )
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

