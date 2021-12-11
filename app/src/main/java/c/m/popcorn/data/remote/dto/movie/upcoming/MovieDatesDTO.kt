package c.m.popcorn.data.remote.dto.movie.upcoming

import com.google.gson.annotations.SerializedName

data class MovieDatesDTO(
    @SerializedName("maximum")
    val maximum: String? = "",
    @SerializedName("minimum")
    val minimum: String? = ""
)
