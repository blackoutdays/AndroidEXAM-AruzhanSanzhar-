package com.example.lab10.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab10.R

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        // Create and set the layout manager
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        // Create and set the adapter for the RecyclerView
        val questionsAndAnswers = listOf(
            QuestionAnswer("How you can buy a tour?", "You enter to tour which you and then enter and press buy."),
            QuestionAnswer("When we were created?", "We were created in 2005."),
            QuestionAnswer("How we can find a tour guide?", "Tour guide will meet you at airport.")
        ) // Replace these with your actual data
        val adapter = QuestionAnswerAdapter(questionsAndAnswers)
        recyclerView.adapter = adapter
    }
}

