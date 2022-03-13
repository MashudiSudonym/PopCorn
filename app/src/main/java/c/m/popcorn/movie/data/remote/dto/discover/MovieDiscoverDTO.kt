package c.m.popcorn.movie.data.remote.dto.discover

import c.m.popcorn.movie.data.remote.dto.result.MovieResultsDTO
import c.m.popcorn.movie.domain.model.discover.MovieDiscover
import com.google.gson.annotations.SerializedName

data class MovieDiscoverDTO(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<MovieResultsDTO>? = emptyList(),
    @SerializedName("total_results")
    val totalResults: Int? = 0,
    @SerializedName("total_pages")
    val totalPages: Int? = 0
) {
    fun toMovieDiscover(): MovieDiscover {
        return MovieDiscover(
            page = page,
            results = results?.map { it.toMovieResults() },
            totalResult = totalResults,
            totalPages = totalPages
        )
    }
}
