package com.github.pedrodimoura.ui.extensions

import android.content.Context
import android.os.Build
import android.widget.ImageView
import coil.ImageLoader
import coil.decode.Decoder
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load

fun ImageView.loadImage(url: String) {
    this.load(url)
}

fun ImageView.loadGif(url: String) {
    this.load(url, getImageLoaderForGif(this.context))
}

internal fun getImageLoaderForGif(context: Context): ImageLoader {
    return ImageLoader.Builder(context).componentRegistry { add(getGifDecoder(context)) }.build()
}

internal fun getGifDecoder(context: Context): Decoder {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
        ImageDecoderDecoder(context)
    else GifDecoder()
}