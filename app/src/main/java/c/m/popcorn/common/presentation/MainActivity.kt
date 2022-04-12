package c.m.popcorn.common.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import c.m.popcorn.common.presentation.main.MainScreen
import c.m.popcorn.common.presentation.ui.theme.PopCornTheme
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