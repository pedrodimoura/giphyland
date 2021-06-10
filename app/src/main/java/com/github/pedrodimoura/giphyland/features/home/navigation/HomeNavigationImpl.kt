package com.github.pedrodimoura.giphyland.features.home.navigation

import android.content.Context
import android.os.Bundle
import com.github.pedrodimoura.giphyland.features.home.presentation.ui.activity.HomeActivity
import com.github.pedrodimoura.navigation.home.HomeNavigation
import javax.inject.Inject

class HomeNavigationImpl @Inject constructor() : HomeNavigation {
    override fun navigate(context: Context, bundle: Bundle?) {
        context.startActivity(HomeActivity.newIntent(context))
    }
}
