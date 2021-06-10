package com.github.pedrodimoura.navigation

import android.content.Context
import android.os.Bundle

interface FeatureNavigation {
    fun navigate(context: Context, bundle: Bundle? = null)
}