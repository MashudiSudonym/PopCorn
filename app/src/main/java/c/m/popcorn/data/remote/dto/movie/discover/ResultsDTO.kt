package c.m.popcorn.data.remote.dto.movie.discover

import com.google.gson.annotations.SerializedName

data class ResultsDTO(
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("overview")
    val overview: String? = "",
    @SerializedName("release_date")
    val releaseDate: String? = "",
    // TODO : Write next data from https://developers.themoviedb.org/3/discover/movie-discover
)
