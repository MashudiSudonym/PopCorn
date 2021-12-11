package c.m.popcorn.data.remote.dto.movie.detail

import com.google.gson.annotations.SerializedName

data class MovieProductionCountriesDTO(
    @SerializedName("iso_3166_1")
    val iso31661: String? = "",
    @SerializedName("name")
    val name: String? = ""
)
