package c.m.popcorn.common.util

sealed class UIEvent {
    data class ShowSnackbar(val message: String) : UIEvent()
}