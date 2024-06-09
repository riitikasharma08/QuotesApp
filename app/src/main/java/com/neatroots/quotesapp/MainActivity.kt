package com.neatroots.quotesapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var quoteTextView: TextView
    private lateinit var newQuoteButton: Button
    private lateinit var shareQuoteButton: Button
    private lateinit var favoriteQuoteButton: Button

    private val quotes = listOf(
        "The greatest glory in living lies not in never falling, but in rising every time we fall. - Nelson Mandela",
        "The way to get started is to quit talking and begin doing. - Walt Disney",
        "Your time is limited, so don't waste it living someone else's life. - Steve Jobs",
        "If life were predictable it would cease to be life, and be without flavor. - Eleanor Roosevelt",
        "If you look at what you have in life, you'll always have more. - Oprah Winfrey"
    )

    private var currentQuote: String = quotes[0]
    private val favoriteQuotes = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteTextView = findViewById(R.id.quoteTextView)
        newQuoteButton = findViewById(R.id.newQuoteButton)
        shareQuoteButton = findViewById(R.id.shareQuoteButton)
        favoriteQuoteButton = findViewById(R.id.favoriteQuoteButton)

        newQuoteButton.setOnClickListener {
            showRandomQuote()
        }

        shareQuoteButton.setOnClickListener {
            shareQuote()
        }

        favoriteQuoteButton.setOnClickListener {
            favoriteQuote()
        }
    }

    private fun showRandomQuote() {
        currentQuote = quotes[Random.nextInt(quotes.size)]
        quoteTextView.text = currentQuote
    }

    private fun shareQuote() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, currentQuote)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share quote via"))
    }

    private fun favoriteQuote() {
        if (!favoriteQuotes.contains(currentQuote)) {
            favoriteQuotes.add(currentQuote)
            Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Already in favorites", Toast.LENGTH_SHORT).show()
        }
    }
}



