package c.m.popcorn.core.presentation.custom

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingIndicator() {
    Box {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}