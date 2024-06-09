package com.example.quotesapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.neatroots.quotesapp.R

class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val favoritesTextView: TextView = findViewById(R.id.favoritesListTextView)
        val favoriteQuotes = intent.getStringArrayListExtra("FAVORITE_QUOTES")

        favoritesTextView.text = favoriteQuotes?.joinToString(separator = "\n\n") ?: "No favorite quotes"
    }
}

