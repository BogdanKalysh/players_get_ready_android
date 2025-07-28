package com.example.playersgetready.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
fun QuestionCard(
    modifier: Modifier = Modifier,
    question: String,
    onLeftButtonClick: () -> Unit,
    onRightButtonClick: () -> Unit,
    isNextCardAvailable: Boolean,
    isPreviousCardAvailable: Boolean
) {
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
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Text(
            stringResource(R.string.playersgetready_caps),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 32.dp)
        )

        Box(modifier = Modifier
            .height(350.dp)) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1F)
                        .clickable(
                            onClick = onLeftButtonClick
                        )
                        .padding(start = 23.dp)
                ) {
                    if (isPreviousCardAvailable) {
                        Image(
                            painter = painterResource(R.drawable.icn_left_arrow),
                            contentDescription = stringResource(R.string.previous_question_description),
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1F)
                        .clickable(
                            onClick = onRightButtonClick,
                        )
                        .padding(end = 23.dp)
                ) {
                    if (isNextCardAvailable) {
                        Image(
                            painter = painterResource(R.drawable.icn_right_arrow),
                            contentDescription = stringResource(R.string.next_question_description),
                            modifier = Modifier.align(Alignment.CenterEnd)
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Center)
                    .padding(horizontal = 54.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text(question,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(24.dp)
                )
            }
        }

        Text(
            stringResource(R.string.game_for_all_caps),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 32.dp)
        )
    }
}