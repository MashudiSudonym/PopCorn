package c.m.popcorn.data.remote.dto.movie.upcoming

import c.m.popcorn.data.remote.dto.movie.discover.MovieResultsDTO
import com.google.gson.annotations.SerializedName

data class MovieUpcomingDTO(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<MovieUpcomingResultsDTO>? = emptyList(),
    @SerializedName("dates")
    val dates: MovieDatesDTO = MovieDatesDTO(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)
