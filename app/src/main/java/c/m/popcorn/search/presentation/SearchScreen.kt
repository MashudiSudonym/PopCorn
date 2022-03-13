package c.m.popcorn.presentation.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import c.m.popcorn.R
import c.m.popcorn.core.presentation.custom.DefaultAppBar

@Composable
fun SearchScreen(title: String?, icon: ImageVector) {
    Scaffold(topBar = {
        DefaultAppBar(
            title = title ?: stringResource(id = R.string.app_name),
            icon = icon
        )
    }) {

    }
}