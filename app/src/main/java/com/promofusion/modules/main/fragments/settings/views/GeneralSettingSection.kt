package com.promofusion.modules.main.fragments.settings.views

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.R
import com.promofusion.common.components.ContentSection

@Preview(showBackground = true)
@Composable
fun GeneralSettingSection(){
    ContentSection (
        spacer = 8.dp,
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(32.dp)
                    .background(color = Color(0x12737373))
            ){
                Text(
                    text = "General",
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
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ){
                Icon(
                    tint = MaterialTheme.colorScheme.scrim,
                    imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_user_24),
                    contentDescription = "Account Setting",
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                )
                Text(
                    text = "Account Setting",
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ){
                Icon(
                    tint = MaterialTheme.colorScheme.scrim,
                    imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_notification_line),
                    contentDescription = "Notification",
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                )
                Text(
                    text = "Notification",
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ){
                Icon(
                    tint = MaterialTheme.colorScheme.scrim,
                    imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_safe_lock_line),
                    contentDescription = "Privacy & Securities",
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                )
                Text(
                    text = "Privacy & Securities",
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ){
                Icon(
                    tint = MaterialTheme.colorScheme.scrim,
                    imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_translate_line),
                    contentDescription = "Languages",
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                )
                Text(
                    text = "Languages",
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ){
                Icon(
                    tint = MaterialTheme.colorScheme.scrim,
                    imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_settings_3_line),
                    contentDescription = "Settings",
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                )
                Text(
                    text = "Setting",
                    fontWeight = FontWeight.Medium,
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