package c.m.popcorn.dummy

import c.m.popcorn.data.local.movie.entity.MovieDetailEntity
import c.m.popcorn.data.remote.dto.movie.detail.MovieDetailDTO

class FakeDummyMovieData {
    fun fakeMovieDetail(): MovieDetailEntity {
        val fakeMovieDetailDTO = MovieDetailDTO()

        fakeMovieDetailDTO.apply {
            MovieDetailDTO(
                adult = false,
                backdropPath = "link",
                belongsToCollection = null,
                budget = 0,
                genres = emptyList(),
                homepage = "homepage",
                id = 0,
                imdbId = "imdbId",
                originalTitle = "original title",
                originalLanguage = "original language",
                overview = "overview",
                popularity = 0,
                posterPath = "poster path",
                productionCompanies = emptyList(),
                productionCountries = emptyList(),
                releaseDate = "release date",
                revenue = 0,
                runtime = 0,
                spokenLanguages = emptyList(),
                status = "status",
                tagline = "tagline",
                title = "title",
                video = false,
                voteAverage = 0.0,
                voteCount = 0
            )
        }

        return fakeMovieDetailDTO.toMovieDetailEntity()
    }
}