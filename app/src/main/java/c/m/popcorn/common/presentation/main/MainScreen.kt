package c.m.popcorn.common.presentation.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import c.m.popcorn.common.util.Constants
import c.m.popcorn.common.presentation.navigation.BottomNavigationScreens
import c.m.popcorn.common.presentation.ui.theme.Red500
import c.m.popcorn.presentation.favorite.FavoriteScreen
import c.m.popcorn.movie.presentation.MovieScreen
import c.m.popcorn.presentation.search.SearchScreen
import c.m.popcorn.tv_show.presentation.TvShowScreen
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun MainScreen() {
    val navHostController: NavHostController = rememberNavController()
    val bottomNavigationItems: List<BottomNavigationScreens> = listOf(
        BottomNavigationScreens.Movie,
        BottomNavigationScreens.TvShow,
        BottomNavigationScreens.Favorite,
        BottomNavigationScreens.Search,
    )

    Scaffold(
        bottomBar = {
            PopCornAppBottomNavigation(
                navHostController = navHostController,
                items = bottomNavigationItems
            )
        }
    ) {
        ProvideWindowInsets {
            MainScreenNavigationConfigurations(navHostController = navHostController)
        }
    }
}

@Composable
private fun MainScreenNavigationConfigurations(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavigationScreens.Movie.route
    ) {
        composable(BottomNavigationScreens.Movie.route) {
            MovieScreen(Constants.MOVIE, BottomNavigationScreens.Movie.icon)
        }
        composable(BottomNavigationScreens.TvShow.route) {
            TvShowScreen(Constants.TV_SHOW, BottomNavigationScreens.TvShow.icon)
        }
        composable(BottomNavigationScreens.Favorite.route) {
            FavoriteScreen(Constants.FAVORITE, BottomNavigationScreens.Favorite.icon)
        }
        composable(BottomNavigationScreens.Search.route) {
            SearchScreen(Constants.SEARCH, BottomNavigationScreens.Search.icon)
        }
    }
}

@Composable
private fun PopCornAppBottomNavigation(
    navHostController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation(backgroundColor = Red500) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = screen.resourceId))
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                onClick = {
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}