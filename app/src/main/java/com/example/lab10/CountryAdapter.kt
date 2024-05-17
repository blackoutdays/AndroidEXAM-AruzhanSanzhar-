package com.example.lab10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CountryAdapter(private val context: Context, private val countries: List<Country>) : BaseAdapter() {

    override fun getCount(): Int = countries.size

    override fun getItem(position: Int): Any = countries[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val country = countries[position]
        viewHolder.countryName.text = country.name
        viewHolder.flagImage.setImageResource(country.flagResId)

        return view
    }

    private class ViewHolder(view: View) {
        val flagImage: ImageView = view.findViewById(R.id.flagImage)
        val countryName: TextView = view.findViewById(R.id.countryName)
    }
}