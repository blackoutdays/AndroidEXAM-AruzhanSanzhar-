package com.example.lab10.ui.home
import com.example.lab10.R

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.lab10.databinding.ListItemBinding
import android.content.Intent
import com.example.lab10.DetailedActivity

// CustomListAdapter.kt
class CustomListAdapter(context: Context, private val dataSource: List<ListItem>) :
    ArrayAdapter<ListItem>(context, 0, dataSource) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListItemBinding
        val rowView: View

        if (convertView == null) {
            binding = ListItemBinding.inflate(inflater, parent, false)
            rowView = binding.root
            rowView.tag = binding
        } else {
            binding = convertView.tag as ListItemBinding
            rowView = convertView
        }

        val listItem = getItem(position)

        listItem?.let {
            binding.listImage.setImageResource(it.imageResId)
            binding.listName.text = it.name
            binding.listTime.text = it.time


            binding.cardImage.setOnClickListener {
                val intent = Intent(context, DetailedActivity::class.java)
                // Pass any necessary data to DetailedActivity using extras
                context.startActivity(intent)

            }
        }

        return rowView
    }
}

