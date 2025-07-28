package com.example.playersgetready

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.playersgetready.ui.screen.MainScreen
import com.example.playersgetready.ui.theme.PlayersGetReadyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlayersGetReadyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(innerPadding)
                    )
                }
            }
        }
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = true
    }
}

@Preview (showSystemUi = true)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    MainScreen(modifier = modifier.padding(vertical = 28.dp))
}

