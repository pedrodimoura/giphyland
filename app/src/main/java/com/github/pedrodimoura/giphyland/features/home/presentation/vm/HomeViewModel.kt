package com.github.pedrodimoura.giphyland.features.home.presentation.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.pedrodimoura.giphyland.features.gif.domain.model.Gif
import com.github.pedrodimoura.giphyland.features.gif.domain.uc.FetchTrending
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchTrendingUseCase: FetchTrending
) : ViewModel() {

    private val _fetchTrendingLiveData = MutableLiveData<List<Gif>>()
    val fetchTrendingLiveData: LiveData<List<Gif>> = _fetchTrendingLiveData

    fun fetchTrending() {
        viewModelScope.launch {
            kotlin.runCatching {
                fetchTrendingUseCase()
            }.onSuccess {
                _fetchTrendingLiveData.value = it
            }.onFailure {
                Log.e("HILT_TEST", it.stackTraceToString())
            }
        }
    }

}
