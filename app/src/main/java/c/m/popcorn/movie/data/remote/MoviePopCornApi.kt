package c.m.popcorn.movie.data.remote

import c.m.popcorn.common.util.Constants
import c.m.popcorn.movie.data.remote.dto.detail.MovieDetailDTO
import c.m.popcorn.movie.data.remote.dto.discover.MovieDiscoverDTO
import c.m.popcorn.movie.data.remote.dto.search.MovieSearchDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviePopCornApi {
    @GET("/3/discover/movie")
    suspend fun movieDiscover(
        @Header(Constants.AUTHORIZATION) token: String,
        @Query(Constants.PAGE) page: Int
    ): MovieDiscoverDTO

    @GET("/3/search/movie")
    suspend fun searchMovies(
        @Header(Constants.AUTHORIZATION) token: String,
        @Query(Constants.QUERY) querySearch: String,
        @Query(Constants.PAGE) page: Int
    ): MovieSearchDTO

    @GET("/3/movie/{movie_id}")
    suspend fun movieDetail(
        @Header(Constants.AUTHORIZATION) token: String,
        @Path(Constants.MOVIE_ID) movieId: Int
    ): MovieDetailDTO
}