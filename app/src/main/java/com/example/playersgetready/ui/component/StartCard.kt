package com.example.playersgetready.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.playersgetready.R

@Composable
fun StartCard(modifier: Modifier = Modifier, onStartCardClicked: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(24.dp),
                clip = false
            )
            .clip(RoundedCornerShape(24.dp))
            .background(color = MaterialTheme.colorScheme.primary)
            .clickable { onStartCardClicked() }
    ) {
        Text(
            stringResource(R.string.playersgetready_caps),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier.padding(vertical = 32.dp)
        )

        Box(
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Image(painterResource(R.drawable.ic_smile), contentDescription = null)
                Text(
                    stringResource(R.string.start_caps),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.surface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
            }
        }

        Text(
            stringResource(R.string.game_for_all_caps),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier.padding(vertical = 32.dp)
        )
    }
}