package c.m.popcorn.presentation.core.main_screen

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Tv
import androidx.compose.ui.graphics.vector.ImageVector
import c.m.popcorn.R

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object TvShow: BottomNavigationScreens("TV Show", R.string.tv_show_title, Icons.Filled.Tv)
    object Movie: BottomNavigationScreens("Movie", R.string.movie_title, Icons.Filled.Movie)
    object Favorite: BottomNavigationScreens("Favorite", R.string.favorite_title, Icons.Filled.Favorite)
}
