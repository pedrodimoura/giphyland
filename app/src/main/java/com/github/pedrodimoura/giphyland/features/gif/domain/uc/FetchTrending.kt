package com.github.pedrodimoura.giphyland.features.gif.domain.uc

import com.github.pedrodimoura.giphyland.features.gif.domain.model.Gif
import com.github.pedrodimoura.giphyland.features.gif.domain.repository.GifRepository
import javax.inject.Inject

class FetchTrending @Inject constructor(private val gifRepository: GifRepository) {

    suspend operator fun invoke(): List<Gif> = gifRepository.fetchTrending()

}
