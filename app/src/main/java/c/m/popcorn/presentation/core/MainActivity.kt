package c.m.popcorn.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import c.m.popcorn.presentation.core.main.MainScreen
import c.m.popcorn.presentation.core.ui.theme.PopCornTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PopCornTheme {
                MainScreen()
            }
        }
    }
}