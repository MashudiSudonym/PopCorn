package c.m.popcorn.presentation.movie

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import c.m.popcorn.R
import c.m.popcorn.common.Constants
import c.m.popcorn.presentation.core.custom.MainAppBar
import c.m.popcorn.presentation.core.ui.theme.PopCornTheme

@Composable
fun MovieScreen(title: String?) {
    Scaffold(topBar = { MainAppBar(title = title ?: stringResource(id = R.string.app_name)) }) {

    }
}

@Composable
@Preview(name = "Movie Screen")
fun MovieScreenPreview() {
    PopCornTheme() {
        MovieScreen(title = Constants.MOVIE)
    }
}