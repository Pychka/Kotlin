package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab2.databinding.ActivitySignInBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SignInActivity : AppCompatActivity() {
    lateinit var binding : ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun signing(view: View) {
        if(binding.email.text.isNotEmpty() && binding.password.text.isNotEmpty()){
            val intent = Intent(this@SignInActivity, MenuActivity::class.java)
            startActivity(intent)
        }
        else
        {
            MaterialAlertDialogBuilder(this)
                .setTitle("Заголовок")
                .setMessage("Текст сообщения")
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }
    }
}