package com.example.practic32

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practic32.databinding.ActivityMainBinding
import com.yandex.mobile.ads.banner.BannerAdSize
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.MobileAds

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initYandexAd()
    }
    private fun initYandexAd() {
        MobileAds.initialize(this) {

        }
        binding.adView.setAdUnitId("demo-banner-yandex")
        val adRequest = AdRequest.Builder().build()
        binding.adView.setAdSize(BannerAdSize.stickySize(this, 350))
        binding.adView.loadAd(adRequest)
    }
}
