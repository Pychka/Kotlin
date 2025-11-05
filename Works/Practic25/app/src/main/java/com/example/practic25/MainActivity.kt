package com.example.practic25

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
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
    var count=0;
    fun Login(view: View) {
        val username = findViewById<TextView>(R.id.edit_user)
        val password = findViewById<TextView>(R.id.edit_password)
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")
        ) {
            Toast.makeText(applicationContext, "Вход выполнен!", Toast.LENGTH_SHORT).show();
// Выполняем переход на другой экран:
            val intent = Intent(this, Second::class.java);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Неправильные данные! Осталось попыток:"+(3-count).toString(), Toast.LENGTH_SHORT).show();
            count++;
        }
        // Когда выполнено 3 безуспешных попытки залогиниться,
        if(count==3){
            Toast.makeText(getApplicationContext(), "Попытки закончились", Toast.LENGTH_SHORT).show();
            username.isEnabled=false;
            password.isEnabled=false;
        }
    }

}