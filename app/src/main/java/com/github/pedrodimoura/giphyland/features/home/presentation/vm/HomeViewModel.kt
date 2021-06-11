package com.github.pedrodimoura.giphyland.features.home.presentation.vm

import androidx.lifecycle.viewModelScope
import com.github.pedrodimoura.giphyland.common.StateViewModel
import com.github.pedrodimoura.giphyland.features.gif.domain.uc.FetchTrending
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchTrendingUseCase: FetchTrending
) : StateViewModel<HomeState, HomeAction>(HomeState()) {

    fun fetchTrending() {
        viewModelScope.launch {
            setState { currentState -> currentState.showLoading() }
            kotlin.runCatching {
                fetchTrendingUseCase()
            }.onSuccess { gifs ->
                if (gifs.isNotEmpty())
                    sendAction { HomeAction.ShowGifOnUI(gifs.first().imageUrl) }
                else sendAction { HomeAction.ShowErrorOnUI("Lista Vazia") }
            }.onFailure {
                sendAction { HomeAction.ShowErrorOnUI(it.message.orEmpty()) }
            }
            setState { currentState -> currentState.hideLoading() }
        }
    }

}
