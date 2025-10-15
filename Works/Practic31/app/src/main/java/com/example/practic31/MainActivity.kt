package com.example.practic31

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practic31.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var site = ""
        binding.search.setOnClickListener{
            site = binding.address.text.toString().substringAfterLast("/")
            webViewSetup("https://"+site)
            binding.text.text = site
        }
    }

    private  fun webViewSetup(urltxt: String){
        binding.webView.webViewClient = WebViewClient()
        binding.webView.apply{
            loadUrl(urltxt)
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }
}