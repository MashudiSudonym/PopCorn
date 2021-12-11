package c.m.popcorn.data.remote.dto.movie.detail

import com.google.gson.annotations.SerializedName

data class MovieBelongsToCollectionDTO(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("backdrop_path")
    val backdropPath: String? = ""
)