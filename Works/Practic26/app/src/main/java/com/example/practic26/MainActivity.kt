package com.example.practic26

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var user_field: EditText
    private lateinit var main_btn: Button
    private lateinit var result_info: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user_field = findViewById(R.id.city)
        main_btn = findViewById(R.id.main_btn)
        result_info = findViewById(R.id.result)
        main_btn.setOnClickListener {
            thread {
                Thread.sleep(1000)
                println("test")
            }
            if(user_field.text?.toString()?.trim()?.equals("")!!)
                Toast.makeText(this, "введите город", Toast.LENGTH_LONG).show()
            else
            {
                val city: String = user_field?.text.toString()
                val key: String = "325428857943bd7d71c3a9e40e2ae79a"
                val url: String = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$key&units=metric&lang=ru"
                thread {
                    val apiResponse = try {
                        URL(url).readText()
                    } catch (ex: Exception) {
                        return@thread
                    }
                    runOnUiThread {
                        val weather = JSONObject(apiResponse).getJSONArray("weather")
                        val desc = weather.getJSONObject(0).getString("description")
                        val main = JSONObject(apiResponse).getJSONObject("main")
                        val temp = main.getString("temp")
                        result_info.text = "Температура: $temp\n$desc"
                    }
                }
            }
        }

    }
}