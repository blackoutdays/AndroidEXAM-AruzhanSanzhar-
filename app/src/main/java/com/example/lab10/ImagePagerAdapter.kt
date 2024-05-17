package com.example.lab10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.lab10.R

class ImagePagerAdapter(private val context: Context, private val imageList: List<Int>) :
    PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_image, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(imageList[position])
        container.addView(view)
        return view
    }

    override fun getCount(): Int = imageList.size

    override fun isViewFromObject(view: View, obj: Any): Boolean = view == obj

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }
}
