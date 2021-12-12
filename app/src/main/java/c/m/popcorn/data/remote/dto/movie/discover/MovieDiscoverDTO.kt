package c.m.popcorn.data.remote.dto.movie.discover

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
)
