package c.m.popcorn.core.util

sealed class UIEvent {
    data class ShowSnackbar(val message: String) : UIEvent()
}