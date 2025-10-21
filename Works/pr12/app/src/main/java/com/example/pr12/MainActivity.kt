package com.example.pr12

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun isFieldEmpty(): Boolean{

        var edA = findViewById<TextView>(R.id.edA)
        var edB = findViewById<TextView> (R.id.edB)
        if (edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
        if (edB.text.isNullOrEmpty()) edB.error = "Поле должно быть заполнено"
        return  edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
    }
    private fun getResult(): String{
        val a: Double
        val b: Double
        var edA:TextView
        var edB:TextView
        edA = findViewById (R.id.edA)
        edB = findViewById(R.id.edB)
        a = edA.text.toString().toDouble()
        b = edB.text.toString().toDouble()

        return kotlin.math.sqrt((a*a) + (b*b)).toString()
    }
    fun onClickResult(view: View){
        val  tvResult :TextView
        tvResult= findViewById(R.id.tvResult)
        if(!isFieldEmpty()){
            val result = getString(R.string.result_info) + getResult()
            tvResult.text = result
        }
    }

}