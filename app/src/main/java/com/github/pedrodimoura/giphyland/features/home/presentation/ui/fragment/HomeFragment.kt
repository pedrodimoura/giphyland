package com.github.pedrodimoura.giphyland.features.home.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.pedrodimoura.giphyland.common.onAction
import com.github.pedrodimoura.giphyland.common.onStateChange
import com.github.pedrodimoura.giphyland.databinding.FragmentHomeBinding
import com.github.pedrodimoura.giphyland.features.home.presentation.vm.HomeAction
import com.github.pedrodimoura.giphyland.features.home.presentation.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    private fun showGifOnImageView(gifUrl: String) {
        binding.topOneGif.gifUrl = gifUrl
    }

}