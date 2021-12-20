package c.m.popcorn.dummy

import c.m.popcorn.data.local.movie.entity.MovieDetailEntity
import c.m.popcorn.domain.model.movie.detail.MovieDetail

class FakeDummyMovieData {
    private val fakeLastSeenMoviesData: ArrayList<MovieDetail> = arrayListOf()
    private val fakeMovieDetailData = MovieDetailEntity(
        backdropPath = "link",
        genres = emptyList(),
        homepage = "homepage",
        movieId = 0,
        imbdId = "imdb id",
        originalTitle = "original title",
        originalLanguage = "original language",
        overview = "overview",
        popularity = 0,
        posterPath = "poster path",
        status = "status",
        tagline = "tagline",
        voteAverage = 0.0,
        voteCount = 0
    )

    fun fakeLastSeenMovies(): List<MovieDetail> {
        fakeLastSeenMoviesData.apply {
            add(
                MovieDetail(
                    backdropPath = "link",
                    genres = emptyList(),
                    homepage = "homepage",
                    originalTitle = "original title",
                    originalLanguage = "original language",
                    overview = "overview",
                    popularity = 0,
                    posterPath = "poster path",
                    status = "status",
                    tagline = "tagline",
                    voteAverage = 0.0,
                    voteCount = 0
                )
            )
        }

        return fakeLastSeenMoviesData
    }

    fun fakeMovieDetail(): MovieDetailEntity = fakeMovieDetailData
}