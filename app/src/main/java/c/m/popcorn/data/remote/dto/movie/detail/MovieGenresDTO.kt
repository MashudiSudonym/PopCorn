package c.m.popcorn.data.remote.dto.movie.detail

import com.google.gson.annotations.SerializedName

data class MovieGenresDTO(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
)
