package c.m.popcorn.presentation.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Tv
import androidx.compose.ui.graphics.vector.ImageVector
import c.m.popcorn.R
import c.m.popcorn.common.Constants

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object TvShow: BottomNavigationScreens(Constants.TV_SHOW, R.string.tv_show_title, Icons.Filled.Tv)
    object Movie: BottomNavigationScreens(Constants.MOVIE, R.string.movie_title, Icons.Filled.Movie)
    object Favorite: BottomNavigationScreens(Constants.FAVORITE, R.string.favorite_title, Icons.Filled.Favorite)
}