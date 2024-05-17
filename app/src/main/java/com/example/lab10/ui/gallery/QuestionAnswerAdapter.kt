package com.example.lab10.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lab10.R

class QuestionAnswerAdapter(
    private val items: List<QuestionAnswer>
) : RecyclerView.Adapter<QuestionAnswerAdapter.QuestionAnswerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAnswerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question_answer, parent, false)
        return QuestionAnswerViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionAnswerViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class QuestionAnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val questionText: TextView = itemView.findViewById(R.id.questionText)
        private val answerText: TextView = itemView.findViewById(R.id.answerText)

        init {
            itemView.setOnClickListener {
                val item = items[adapterPosition]
                item.isExpanded = !item.isExpanded
                notifyItemChanged(adapterPosition)
            }
        }

        fun bind(item: QuestionAnswer) {
            questionText.text = item.question
            answerText.text = item.answer
            answerText.visibility = if (item.isExpanded) View.VISIBLE else View.GONE
            val arrowDrawable = if (item.isExpanded) {
                ContextCompat.getDrawable(itemView.context, R.drawable.down_arrow)
            } else {
                ContextCompat.getDrawable(itemView.context, R.drawable.right_arrow)
            }
            questionText.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowDrawable, null)
        }
    }
}

