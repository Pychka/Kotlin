package com.example.practic13

import MyAdapter
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practic13.Data.Discipline
import com.example.practic13.Data.Group
import com.example.practic13.Data.Student

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
        val studentListView = findViewById<ListView>(R.id.studentListView)
        val students = listOf(
            Student(
                "Шадиев Ильяс Азаматович",
                Group("ИСп-1-23", "Русанов Валерий Сергеевич"),
                Discipline("Разработка мобильных приложений","Косыгина Татьяна Николаевна")
            ),
            Student(
                "Абдувохидов Амир Абдукодирович",
                Group("ИСп-1-23", "Русанов Валерий Сергеевич"),
                Discipline("Разработка мобильных приложений","Косыгина Татьяна Николаевна")
            ),
        )

        val adapter =MyAdapter(this, this,students)
        studentListView.adapter = adapter
    }
}