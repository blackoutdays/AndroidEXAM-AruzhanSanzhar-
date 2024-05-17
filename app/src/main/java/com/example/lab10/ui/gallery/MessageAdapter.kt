package com.example.lab10.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab10.R
import com.example.lab10.R.layout.item_message

class MessageAdapter : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    private val messages: MutableList<Message> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount(): Int = messages.size

    fun addMessage(message: Message) {
        messages.add(message)
        notifyItemInserted(messages.size - 1)
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textMessage: TextView = itemView.findViewById(R.id.textMessage)

        fun bind(message: Message) {
            textMessage.text = message.text
        }
    }
}
