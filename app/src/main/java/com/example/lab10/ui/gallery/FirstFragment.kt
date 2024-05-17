package com.example.lab10.ui.gallery
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab10.R
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MessageAdapter
    private lateinit var editTextMessage: TextInputEditText

    private val randomResponses = listOf(
        "Sure, I can help with that.",
        "I don't understand. Can you clarify?",
        "That's interesting!",
        "I'll get back to you on that.",
        "Can you provide more details?",
        "Thanks for sharing that.",
        "Let's discuss this further.",
        "I'm here to help.",
        "What do you think about that?",
        "Is there anything else?"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        editTextMessage = view.findViewById(R.id.editTextMessage)

        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.stackFromEnd = true
        recyclerView.layoutManager = layoutManager

        adapter = MessageAdapter()
        recyclerView.adapter = adapter

        // Add the SpaceItemDecoration to the RecyclerView
        val spaceItemDecoration = SpaceItemDecoration(3) // 3dp space
        recyclerView.addItemDecoration(spaceItemDecoration)

        editTextMessage.setOnEditorActionListener { _, _, _ ->
            sendMessage()
            true
        }

        editTextMessage.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (editTextMessage.right - editTextMessage.compoundDrawables[2].bounds.width())) {
                    sendMessage()
                    return@setOnTouchListener true
                }
            }
            false
        }
    }

    private fun sendMessage() {
        val messageText = editTextMessage.text.toString().trim()

        if (messageText.isNotEmpty()) {
            val userMessage = Message(messageText)
            adapter.addMessage(userMessage)
            editTextMessage.text?.clear()

            // Generate a random response after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                val randomResponse = randomResponses[Random.nextInt(randomResponses.size)]
                val botMessage = Message(randomResponse)
                adapter.addMessage(botMessage)
            }, 1000) // 1 second delay before sending a response
        } else {
            editTextMessage.error = "Please enter a message"
        }
    }
}

