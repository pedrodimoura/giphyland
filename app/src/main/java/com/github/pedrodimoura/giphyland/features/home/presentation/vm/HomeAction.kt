package com.github.pedrodimoura.giphyland.features.home.presentation.vm

import com.github.pedrodimoura.giphyland.common.UIAction

sealed class HomeAction : UIAction {
    data class ShowGifOnUI(val url: String) : HomeAction()
    data class ShowErrorOnUI(val message: String) : HomeAction()
}
