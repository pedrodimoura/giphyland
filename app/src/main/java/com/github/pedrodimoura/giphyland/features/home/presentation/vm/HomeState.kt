package com.github.pedrodimoura.giphyland.features.home.presentation.vm

import com.github.pedrodimoura.giphyland.common.UIState

data class HomeState(
    val isLoading: Boolean = true
) : UIState {
    fun showLoading() = this.copy(isLoading = true)
    fun hideLoading() = this.copy(isLoading = false)
}
