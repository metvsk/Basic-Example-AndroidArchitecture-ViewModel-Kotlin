package com.chillandcode.basic_example_androidarchitecture_viewmodel_kotlin.ui.timer

import androidx.lifecycle.ViewModel

class ScoresViewModel : ViewModel() {
    private var _score = 0// variable with all controls only to the view model class
    val score: Int get() = _score // accessible property to other classes which is read only and gives access to the value of _score

    fun increaseScore() {
        _score++
    }

    fun reduceScore() {
        _score--
    }
}