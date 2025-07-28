package com.example.playersgetready.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.playersgetready.R
import com.example.playersgetready.ui.component.QuestionCard
import com.example.playersgetready.ui.component.StartCard
import com.example.playersgetready.ui.component.TopBar

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val questions = LocalContext.current.resources
        .getStringArray(R.array.questions_array).toList()

    var randomIndexes by remember { mutableStateOf(questions.indices.shuffled()) }
    var cardNumber by remember { mutableIntStateOf(0) }
    var isStarted by remember { mutableStateOf(false) }

    Box(modifier.fillMaxSize()) {
        if (isStarted) {
            TopBar(cardNumber + 1,
                onReloadButtonClick = {
                    randomIndexes = questions.indices.shuffled()
                    cardNumber = 0
                    isStarted = false
                },
                Modifier.align(Alignment.TopCenter))

            QuestionCard(
                modifier.align(Alignment.Center), questions[randomIndexes[cardNumber]],
                onLeftButtonClick = {
                    if (cardNumber > 0) {
                        cardNumber--
                    }
                },
                onRightButtonClick = {
                    if (cardNumber < questions.size - 1) {
                        cardNumber++
                    }
                },
                isNextCardAvailable = cardNumber < questions.size - 1,
                isPreviousCardAvailable = cardNumber > 0,
            )
        } else {
            StartCard(modifier.align(Alignment.Center)) { isStarted = true }
        }
    }
}