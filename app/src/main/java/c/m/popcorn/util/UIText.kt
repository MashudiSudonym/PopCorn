package c.m.popcorn.util

import androidx.annotation.StringRes
import c.m.popcorn.R

sealed class UIText {
    data class DynamicString(val value: String) : UIText()
    data class StringResource(@StringRes val id: Int): UIText()

    companion object {
        fun unknownError(): UIText {
            return StringResource(R.string.error_unknown)
        }
    }
}