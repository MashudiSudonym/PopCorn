package c.m.popcorn.movie.data.remote.dto.detail

import com.google.gson.annotations.SerializedName

data class MovieSpokenLanguagesDTO(
    @SerializedName("iso_639_1")
    val iso6391: String? = "",
    @SerializedName("name")
    val name: String? = ""
)
