package com.semenchuk.state

sealed class LoadState {
    object Loading : LoadState()
    object Success : LoadState()
    object Await : LoadState()
    data class Error(val message: String) : LoadState()
}