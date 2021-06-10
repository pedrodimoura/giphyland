package com.github.pedrodimoura.giphyland.features.home.presentation.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.pedrodimoura.giphyland.databinding.ActivityHomeBinding
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
        homeViewModel.fetchTrendingLiveData.observe(this) {
            if (it.isNotEmpty())
                binding.topOneGif.loadGif(it.first().imageUrl)
        }

        binding.callNetworkButton.setOnClickListener { homeViewModel.fetchTrending() }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}
