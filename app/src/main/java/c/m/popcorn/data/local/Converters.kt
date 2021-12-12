package c.m.popcorn.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import c.m.popcorn.data.util.ListIntegerParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(private val listIntegerParser: ListIntegerParser) {
    // convert genre ids integer to list of integer / list of integer to integer
    @TypeConverter
    fun restoreGenreIds(listOfInt: Int): List<Int> {
        return listIntegerParser.fromListInt<List<Int>>(
            listOfInt, object : TypeToken<List<Int>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun saveGenreIds(listOfInt: List<Int>): Int {
        return listIntegerParser.toListInt(
            listOfInt,
            object : TypeToken<List<Int>>() {}.type
        ) ?: 0
    }
}