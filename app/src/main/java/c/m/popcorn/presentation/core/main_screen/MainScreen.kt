package c.m.popcorn.presentation.core.main_screen

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import c.m.popcorn.common.Constants.KEY_ROUTE
import c.m.popcorn.presentation.favorite.FavoriteScreen
import c.m.popcorn.presentation.movie.MovieScreen
import c.m.popcorn.presentation.tv_show.TvShowScreen

@Composable
fun MainScreen() {
    val navHostController: NavHostController = rememberNavController()
    val bottomNavigationItems: List<BottomNavigationScreens> = listOf(
        BottomNavigationScreens.Movie,
        BottomNavigationScreens.TvShow,
        BottomNavigationScreens.Favorite
    )

    Scaffold(
        bottomBar = {
            PopCornAppBottomNavigation(
                navHostController = navHostController,
                items = bottomNavigationItems
            )
        }
    ) {

    }
}

@Composable
private fun MainScreenNavigationConfigurations(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavigationScreens.Movie.route
    ) {
        composable(BottomNavigationScreens.Movie.route) {
            MovieScreen()
        }
        composable(BottomNavigationScreens.TvShow.route) {
            TvShowScreen()
        }
        composable(BottomNavigationScreens.Favorite.route) {
            FavoriteScreen()
        }
    }
}

@Composable
private fun PopCornAppBottomNavigation(
    navHostController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        val currentRoute = currentRoute(navHostController = navHostController)

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
                selected = currentRoute == screen.route,
                alwaysShowLabel = false,
                onClick = {
                    if (currentRoute != screen.route) {
                        navHostController.navigate(screen.route)
                    }
                },
            )
        }
    }
}

@Composable
private fun currentRoute(navHostController: NavHostController): String? {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}