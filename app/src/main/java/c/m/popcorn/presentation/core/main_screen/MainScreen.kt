package c.m.popcorn.presentation.core.main_screen

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
        MainScreenNavigationConfigurations(navHostController = navHostController)
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
                selectedContentColor = MaterialTheme.colors.primary,
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