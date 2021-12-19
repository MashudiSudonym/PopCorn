package c.m.popcorn.data.remote.dto.movie.search

import c.m.popcorn.data.remote.dto.movie.result.MovieResultsDTO
import c.m.popcorn.domain.model.movie.search.MovieSearch
import com.google.gson.annotations.SerializedName

data class MovieSearchDTO(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<MovieResultsDTO>? = emptyList(),
    @SerializedName("total_results")
    val totalResults: Int? = 0,
    @SerializedName("total_pages")
    val totalPages: Int? = 0
) {
    fun toMovieSearch(): MovieSearch {
        return MovieSearch(
            page = page,
            results = results?.map { it.toMovieResults() },
            totalResult = totalResults,
            totalPages = totalPages
        )
    }
}
