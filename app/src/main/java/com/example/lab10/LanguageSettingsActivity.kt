package com.example.lab10

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class LanguageSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_settings)

        val gridView: GridView = findViewById(R.id.gridView)
        val countries = listOf(
            Country("USA", R.drawable.flag_usa),
            Country("Canada", R.drawable.flag_canada),
            Country("UK", R.drawable.flag_uk),
            Country("Germany", R.drawable.flag_germany),
            Country("France", R.drawable.flag_france),
            Country("Spain", R.drawable.flag_spain),
            Country("Italy", R.drawable.flag_italy),
            Country("Japan", R.drawable.flag_russia),
            Country("China", R.drawable.flag_china),
            Country("Kazakhstan", R.drawable.flag_kazakhstan)
        )

        val adapter = CountryAdapter(this, countries)
        gridView.adapter = adapter
    }
}