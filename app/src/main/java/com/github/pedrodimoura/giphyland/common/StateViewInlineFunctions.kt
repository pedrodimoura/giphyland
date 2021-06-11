package com.github.pedrodimoura.giphyland.common

import androidx.appcompat.app.AppCompatActivity

inline fun <reified State : UIState, reified Action : UIAction> AppCompatActivity.onStateChange(
    viewModel: StateViewModel<State, Action>,
    crossinline state: (State) -> Unit
) {
    viewModel.state.observe(this) { state(it as State) }
}

inline fun <reified State : UIState, reified Action : UIAction> AppCompatActivity.onAction(
    viewModel: StateViewModel<State, Action>,
    crossinline action: (Action) -> Unit
) {
    viewModel.action.observe(this) { action(it as Action) }
}