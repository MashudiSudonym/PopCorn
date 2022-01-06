package c.m.popcorn.presentation.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import c.m.popcorn.R
import c.m.popcorn.common.Constants
import c.m.popcorn.presentation.core.custom.MainAppBar
import c.m.popcorn.presentation.core.ui.theme.PopCornTheme

@Composable
fun SearchScreen(title: String?) {
    Scaffold(topBar = { MainAppBar(title = title ?: stringResource(id = R.string.app_name)) }) {

    }
}

@Composable
@Preview(name = "Search Screen")
fun SearchScreenPreview() {
    PopCornTheme() {
        SearchScreen(title = Constants.SEARCH)
    }
}