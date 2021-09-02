package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    init {
        Log.d("GameFragment", "GameViewModel created!")
    }

    private var _score = 0
    val score: Int
        get() = _score


    private var _currentWordCount = 0
    val currentWordCount: Int
        get() = _currentWordCount

    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord


}