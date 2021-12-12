package c.m.popcorn.data.remote.dto.movie.search

import com.google.gson.annotations.SerializedName

data class MovieSearchDTO(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<MovieSearchResultsDTO>? = emptyList(),
    @SerializedName("total_results")
    val totalResults: Int? = 0,
    @SerializedName("total_pages")
    val totalPages: Int? = 0
)
