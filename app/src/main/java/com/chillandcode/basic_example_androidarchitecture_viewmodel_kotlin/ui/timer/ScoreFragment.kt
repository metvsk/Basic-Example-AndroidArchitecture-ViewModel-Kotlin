package com.chillandcode.basic_example_androidarchitecture_viewmodel_kotlin.ui.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chillandcode.basic_example_androidarchitecture_viewmodel_kotlin.R

class Timer : Fragment() {

    // Create a ViewModel the first time the fragment is created.
    // If the fragment is re-created, it receives the same GameViewModel instance created by the first fragment.
    private val scoresViewModel: ScoresViewModel by viewModels()//from delegate property library
    /*     viewModels () comes from this library
    implementation 'androidx.fragment:fragment-ktx:1.3.6'*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scores, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        updateScoreUi()//if the scores have been changed and device configuration changes then restores the score value to the UI

        view.findViewById<Button>(R.id.buttonIncrease)
            .setOnClickListener {
                scoresViewModel.increaseScore()
                updateScoreUi()
            }
        view.findViewById<Button>(R.id.buttonDecrease)
            .setOnClickListener {
                scoresViewModel.reduceScore()
                updateScoreUi()
            }
    }

    private fun updateScoreUi() {
        requireView().findViewById<TextView>(R.id.textView).text = scoresViewModel.score.toString()
    }
}