package com.example.playersgetready.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.playersgetready.R

@Composable
fun TopBar(cardNumber: Int, onReloadButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text(
            stringResource(R.string.card_number, cardNumber),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        IconButton(
            onClick = { onReloadButtonClick() },
            modifier = Modifier
                .size(48.dp)
                .shadow(5.dp, shape = CircleShape, clip = false)
                .background(color = MaterialTheme.colorScheme.surface, shape = CircleShape)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_reload),
                contentDescription = stringResource(R.string.reload_button),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}