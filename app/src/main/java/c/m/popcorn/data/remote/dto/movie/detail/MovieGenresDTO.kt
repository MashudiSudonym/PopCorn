package c.m.popcorn.data.remote.dto.movie.detail

import c.m.popcorn.domain.model.movie.detail.MovieGenres
import com.google.gson.annotations.SerializedName

data class MovieGenresDTO(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
) {
    fun toMovieGenres(): MovieGenres {
        return MovieGenres(
            id = id,
            name = name
        )
    }
}
