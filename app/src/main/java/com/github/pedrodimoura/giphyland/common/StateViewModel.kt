package com.github.pedrodimoura.giphyland.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class StateViewModel<State : UIState, Action : UIAction>(
    initialState: State
) : ViewModel() {

    private val _states = MutableLiveData<State>()
    private val _actions = MutableLiveData<Action>()

    init {
        _states.value = initialState
    }

    val state: LiveData<State> = _states
    val action: LiveData<Action> = _actions

    fun setState(state: (State) -> State) {
        _states.value = state(_states.value!!)
    }

    fun sendAction(action: () -> Action) {
        _actions.value = action()
    }

}