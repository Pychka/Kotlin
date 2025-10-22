package com.example.practic31

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)

        webView.loadUrl("https://vk.com/theenddrive")

        webView.settings.javaScriptEnabled = true

        webView.settings.setSupportZoom(true)
    }



}
