package c.m.popcorn.movie.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import c.m.popcorn.core.data.util.JsonParser
import c.m.popcorn.movie.domain.model.detail.MovieGenres
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class MovieGenresConverters(private val jsonParser: JsonParser) {
    @TypeConverter
    fun fromJson(json: String): List<MovieGenres> {
        return jsonParser.fromJson(json, object : TypeToken<List<MovieGenres>>() {}.type)
            ?: emptyList()
    }

    @TypeConverter
    fun toJson(genres: List<MovieGenres>): String {
        return jsonParser.toJson(genres, object : TypeToken<List<MovieGenres>>() {}.type) ?: "[]"
    }
}