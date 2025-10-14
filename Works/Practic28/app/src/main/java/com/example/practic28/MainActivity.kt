package com.example.practic28

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practic28.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var counter = 0
    var test = ""
    var pref : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        counter = pref?.getInt("counter",0)!!
        test = "Value: ${pref?.getInt("test", 0)!!}"
        binding.tvResult.text = counter.toString()
        binding.cashTV.text = test
    }

    fun onClickAdd(view: View) {
        counter++
        binding.tvResult.text = counter.toString()
        saveData(counter)
    }

    private fun saveData(res: Int, key: String = "counter")
    {
        val editor = pref?.edit()
        editor?.putInt(key, res)
        editor?.apply()
    }

    private fun deleteAll() {
        val editor = pref?.edit()
        editor?.clear()
        editor?.apply()
    }

    private fun deleteIem(deletItem: String)
    {
        val editor = pref?.edit()
        editor?.remove(deletItem)
        editor?.apply()
    }

    fun onClickClear(view: View)
    {
        deleteAll()
    }

    fun onClickDeleteItem(view: View)
    {
        deleteIem("test")
        test = "Value: null"
        binding.cashTV.text = test
    }

    fun onClickAddRandomValue(view: View) {
        val testValue = Random.nextInt(20000)
        test = "Value: ${testValue}"
        saveData(testValue, "test")
        binding.cashTV.text = test

    }

}