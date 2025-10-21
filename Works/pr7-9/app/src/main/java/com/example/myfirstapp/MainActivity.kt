package com.example.myfirstapp

import android.content.Intent
import android.view.View
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    fun countMe(view: View){
        val countString = textView.text.toString()
        var count:Int = Integer.parseInt(countString)
        count++
        textView.text = count.toString()
    }
    fun toastMe(view: View){
        val myToast = Toast.makeText(this,"Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }
    fun randomMe(view: View){
        val randomIntent = Intent(this, SecondActivity::class.java)
        val count = textView.text.toString().toInt()
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
        startActivity(randomIntent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textView = findViewById(R.id.textView)
    }
}