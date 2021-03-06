package c.m.popcorn.movie.data.remote.dto.detail

import com.google.gson.annotations.SerializedName

data class MovieProductionCompaniesDTO(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("logo_path")
    val logoPath: String? = "",
    @SerializedName("origin_country")
    val originCountry: String? = ""
)
