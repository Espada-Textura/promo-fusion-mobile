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
fun HelpSettingSection(){
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
                    text = "Helps",
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
                    imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_headphone_line),
                    contentDescription = "Customer Services",
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                )
                Text(
                    text = "Customer Services",
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
                    imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_shield_shape_line),
                    contentDescription = "Privacy Policies",
                    modifier = Modifier
                        .padding(16.dp, 0.dp)

                )
                Text(
                    text = "Privacy Policies",
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
                    imageVector = ImageVector.vectorResource(id = com.promofusion.R.drawable.ic_paper_tr),
                    contentDescription = "Terms & Conditions",
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                )
                Text(
                    text = "Terms & Conditions",
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