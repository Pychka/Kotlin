package com.example.myfirstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class SecondActivity : AppCompatActivity() {
    companion object {
        const val TOTAL_COUNT = "total_count"
    }
    fun showRandomNumber() {
        // Get the count from the intent extras
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        // Generate the random number
        val random = Random()
        var randomInt = 0
        // Add one because the bound is exclusive
        if (count > 0) {
            // Add one because the bound is exclusive
            randomInt = random.nextInt(count + 1)
        }
        // Display the random number.
        val textview_random=findViewById<TextView>(R.id. textView_random)
        val  textview_label = findViewById<TextView>(R.id.textView_label)

        textview_random.text = randomInt.toString()
        textview_label.text = getString(R.string.random_heading, count)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showRandomNumber()
    }
}