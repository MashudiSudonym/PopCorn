package c.m.popcorn.common.util

import c.m.popcorn.BuildConfig

object Constants {
    const val POPCORN_DB = "popcorn_db"
    const val STARTING_PAGE_INDEX = 1
    const val AUTHORIZATION = "Authorization"
    const val PAGE = "page"
    const val QUERY = "query"
    const val MOVIE_ID = "movie_id"
    const val BASE_URL_API = BuildConfig.BASE_URL_API
    const val BASE_URL_IMAGE = BuildConfig.BASE_URL_IMAGE
    const val TOKEN = BuildConfig.API_KEY
    const val UNEXPECTED_ERROR = "An unexpected error occurred"
    const val IS_BLANK = ""
    const val MOVIE = "Movie"
    const val MOVIE_DETAIL = "Movie Detail"
    const val TV_SHOW = "Tv Show"
    const val TV_SHOW_DETAIL = "Tv Show Detail"
    const val FAVORITE = "Favorite"
    const val SEARCH = "Search"
}