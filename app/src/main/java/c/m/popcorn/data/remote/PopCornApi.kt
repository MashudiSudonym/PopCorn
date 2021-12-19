package c.m.popcorn.data.remote

import c.m.popcorn.common.Constants
import c.m.popcorn.data.remote.dto.movie.detail.MovieDetailDTO
import c.m.popcorn.data.remote.dto.movie.discover.MovieDiscoverDTO
import c.m.popcorn.data.remote.dto.movie.search.MovieSearchDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PopCornApi {
    @GET("/3/discover/movie")
    fun movieDiscover(
        @Header(Constants.AUTHORIZATION) token: String,
        @Query(Constants.PAGE) page: Int
    ): MovieDiscoverDTO

    @GET("/3/search/movie")
    fun searchMovies(
        @Header(Constants.AUTHORIZATION) token: String,
        @Query(Constants.QUERY) querySearch: String,
        @Query(Constants.PAGE) page: Int
    ): MovieSearchDTO

    @GET("/3/movie/{movie_id}")
    fun movieDetail(
        @Header(Constants.AUTHORIZATION) token: String,
        @Path(Constants.MOVIE_ID) movieId: Int
    ): MovieDetailDTO
}