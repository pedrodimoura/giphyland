package com.github.pedrodimoura.giphyland.features.home.presentation.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.pedrodimoura.giphyland.common.onAction
import com.github.pedrodimoura.giphyland.common.onStateChange
import com.github.pedrodimoura.giphyland.databinding.ActivityHomeBinding
import com.github.pedrodimoura.giphyland.features.home.presentation.vm.HomeAction
import com.github.pedrodimoura.giphyland.features.home.presentation.vm.HomeViewModel
import com.github.pedrodimoura.ui.extensions.loadGif
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

        onStateChange(homeViewModel) {
            Log.i("STATE_ACTION", "Tela carregando: ${it.isLoading}")
        }

        onAction(homeViewModel) {
            when (it) {
                is HomeAction.ShowGifOnUI -> showGifOnImageView(it.url)
                is HomeAction.ShowErrorOnUI -> Log.e("STATE_ACTION", "Error: ${it.message}")
            }
        }

        binding.callNetworkButton.setOnClickListener { homeViewModel.fetchTrending() }
    }

    private fun showGifOnImageView(gifUrl: String) = binding.topOneGif.loadGif(gifUrl)

    companion object {
        fun newIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}
