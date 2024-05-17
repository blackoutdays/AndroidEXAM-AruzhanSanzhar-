package com.example.lab10.ui.home
import com.example.lab10.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab10.databinding.FragmentHomeBinding
import com.example.lab10.DetailedActivity
import android.widget.ListView


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = view.findViewById<ListView>(R.id.listView)
        val dataList = listOf(
            ListItem(R.drawable.img_1, "Beket Ata mosque", "Mangystau"),
            ListItem(R.drawable.img_5, "Altyn emel", "Almaty"),
            ListItem(R.drawable.img_6, "Katon Karagay", "Semei"),
            ListItem(R.drawable.img_7, "Burabai", "Kokshetau"),
            ListItem(R.drawable.img_8, "Kolsay", "Almaty"),
            ListItem(R.drawable.img_9, "Kozha Ahmet Kesenesi", "Turkestan"),
        )
        val adapter = CustomListAdapter(requireContext(), dataList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataList[position]
            val intent = Intent(requireContext(), DetailedActivity::class.java).apply {
                putExtra("imageResId", selectedItem.imageResId)
                putExtra("name", selectedItem.name)
                putExtra("time", selectedItem.time)
            }
            startActivity(intent)
        }
    }
}
