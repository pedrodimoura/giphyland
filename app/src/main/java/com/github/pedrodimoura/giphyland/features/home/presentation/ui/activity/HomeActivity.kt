package com.github.pedrodimoura.giphyland.features.home.presentation.ui.activity

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.EventListener
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import coil.request.ImageRequest
import coil.request.ImageResult
import com.github.pedrodimoura.giphyland.databinding.ActivityHomeBinding
import com.github.pedrodimoura.giphyland.features.home.presentation.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        homeViewModel.fetchTrendingLiveData.observe(this) {
            if (it.isNotEmpty()) {
                val gif = it.first()

                val imageLoader = ImageLoader.Builder(applicationContext)
                    .componentRegistry {
                        if (Build.VERSION.SDK_INT >= 28) {
                            add(ImageDecoderDecoder(applicationContext))
                        } else {
                            add(GifDecoder())
                        }
                    }
                    .eventListener(object : EventListener {
                        override fun onStart(request: ImageRequest) {
                            super.onStart(request)
                            Log.i("KOIL", "On Start")
                        }
                        override fun onError(request: ImageRequest, throwable: Throwable) {
                            super.onError(request, throwable)
                            Log.i("KOIL", "On Error $throwable")
                        }

                        override fun onSuccess(
                            request: ImageRequest,
                            metadata: ImageResult.Metadata
                        ) {
                            super.onSuccess(request, metadata)
                            Log.i("KOIL", "Success")
                        }
                    })
                    .build()

                binding.topOneGif.load(gif.imageUrl, imageLoader)
            }
        }

        binding.callNetworkButton.setOnClickListener { homeViewModel.fetchTrending() }
    }
}
