package com.example.practic32

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practic32.databinding.ActivityMainBinding
import com.yandex.mobile.ads.banner.BannerAdSize
import com.yandex.mobile.ads.common.AdError
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestConfiguration
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.common.MobileAds
import com.yandex.mobile.ads.interstitial.InterstitialAd
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener
import com.yandex.mobile.ads.interstitial.InterstitialAdLoadListener
import com.yandex.mobile.ads.interstitial.InterstitialAdLoader

class MainActivity : AppCompatActivity() {
    private var interstitialAd: InterstitialAd? = null
    private var interstitialAdLoader: InterstitialAdLoader? = null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initYandexAd()
        interstitialAdLoader = InterstitialAdLoader(this).apply {
            setAdLoadListener(object : InterstitialAdLoadListener {
                override fun onAdFailedToLoad(error: AdRequestError) {
                }

                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                }
            })
        }
        loadInterstitialAd()
        binding.showAdButton.setOnClickListener {
            showAd()
        }
    }

    private fun initYandexAd() {
        MobileAds.initialize(this) {

        }
        binding.adView.setAdUnitId("demo-banner-yandex")
        val adRequest = AdRequest.Builder().build()
        binding.adView.setAdSize(BannerAdSize.stickySize(this, 350))
        binding.adView.loadAd(adRequest)
    }

    private fun loadInterstitialAd() {
        val adRequestConfiguration = AdRequestConfiguration.Builder("demo-interstitial-yandex").build()
        interstitialAdLoader?.loadAd(adRequestConfiguration)
    }

    fun showAd() {
        interstitialAd?.apply {
            setAdEventListener(object : InterstitialAdEventListener {
                override fun onAdShown() {
                    // Called when ad is shown.
                }
                override fun onAdFailedToShow(adError: AdError) {
                    destroyInterstitialAd()

                    loadInterstitialAd()
                }
                override fun onAdDismissed() {
                    startActivity(Intent(this@MainActivity, SecondActivity::class.java))

                    destroyInterstitialAd()

                    loadInterstitialAd()
                }
                override fun onAdClicked() {
                }
                override fun onAdImpression(impressionData: ImpressionData?) {
                }
            })
            show(this@MainActivity)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        interstitialAdLoader?.setAdLoadListener(null)
        interstitialAdLoader = null
        destroyInterstitialAd()
    }

    private fun destroyInterstitialAd() {
        interstitialAd?.setAdEventListener(null)
        interstitialAd = null
    }
}
