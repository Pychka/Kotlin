package com.example.practic28_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.DBHelper
import com.example.practic28_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addName.setOnClickListener{

            val db = DBHelper(this, null)

            val name = binding.enterName.text.toString()
            val age = binding.enterAge.text.toString()

            db.addName(name, age)

            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

            binding.enterName.text.clear()
            binding.enterAge.text.clear()
        }

        binding.printName.setOnClickListener{

            val db = DBHelper(this, null)

            val cursor = db.getName()
            binding.Name.text = ""
            binding.Age.text = ""
            cursor!!.moveToFirst()
            binding.Name.append(cursor.getString(kotlin.math.max(cursor.getColumnIndex(DBHelper.NAME_COl), 0)) + "\n")
            binding.Age.append(cursor.getString(kotlin.math.max(cursor.getColumnIndex(DBHelper.AGE_COL), 0)) + "\n")

            while(cursor.moveToNext()){
                binding.Name.append(cursor.getString(kotlin.math.max(cursor.getColumnIndex(DBHelper.NAME_COl), 0)) + "\n")
                binding.Age.append(cursor.getString(kotlin.math.max(cursor.getColumnIndex(DBHelper.AGE_COL), 0)) + "\n")
            }

            cursor.close()
        }
    }
}
