package com.example.practic211

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practic211.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.tb)
        binding.tb.setOnMenuItemClickListener() {
            when (it.itemId) {
                android.R.id.home -> finish()
                R.id.sync -> {
                    Toast.makeText(this, "Sync", Toast.LENGTH_SHORT).show()
                }

                R.id.save -> {

                    Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                }

                R.id.delete -> {
                    Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        finish()

        return true
    }
}