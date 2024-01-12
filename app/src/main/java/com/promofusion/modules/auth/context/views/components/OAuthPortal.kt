package com.promofusion.modules.auth.context.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promofusion.R
import com.promofusion.common.theme.PromoFusionTheme

@Composable
fun OAuthPortal(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(
        24.dp, alignment = Alignment.CenterHorizontally
    ),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
) {

    Row(
        modifier = modifier,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {

        FilledTonalIconButton(onClick = { }, modifier = Modifier.size(52.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google_line),
                contentDescription = "Google Icon",
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }


        FilledTonalIconButton(onClick = { }, modifier = Modifier.size(52.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_facebook_line),
                contentDescription = "Google Icon",
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }


        FilledTonalIconButton(onClick = { }, modifier = Modifier.size(52.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_github_line),
                contentDescription = "Google Icon",
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun OAuthPortalPreview() {
    PromoFusionTheme {
        OAuthPortal()
    }
}