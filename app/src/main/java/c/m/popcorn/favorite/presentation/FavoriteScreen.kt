package c.m.popcorn.presentation.favorite

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import c.m.popcorn.R
import c.m.popcorn.common.presentation.custom.DefaultAppBar

@Composable
fun FavoriteScreen(title: String?, icon: ImageVector) {
    Scaffold(topBar = {
        DefaultAppBar(
            title = title ?: stringResource(id = R.string.app_name),
            icon = icon
        )
    }) {

    }
}