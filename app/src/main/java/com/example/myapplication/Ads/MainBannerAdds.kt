package com.example.myapplication.Ads

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Intrestitial_Ads.AfterInterstitailAdsFinishedActivity
import com.example.myapplication.Intrestitial_Ads.MyIntrestitalAds
import com.example.myapplication.Native_Ads.NativeAdsActivity
import com.example.myapplication.R
import com.example.myapplication.Reward_Ads.MyRewardedAds
import com.example.myapplication.Reward_Ads.SharedPreferenceManger
import com.example.myapplication.databinding.ActivityMainBannerAddsBinding
import com.google.android.gms.ads.AdSize

class MainBannerAdds : AppCompatActivity() {

    private lateinit var binding: ActivityMainBannerAddsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBannerAddsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //loadBannerAds(this, binding.adsFrameLayout, AdSize.BANNER, R.string.banner_ads1)
        loadBannerAds(this, binding.adsFrameLayout, AdSize.LARGE_BANNER, R.string.banner_ads1)
        //loadBannerAds(this, binding.adsFrameLayout, AdSize.FULL_BANNER, R.string.banner_ads1)

        val myIntrestitalAds= MyIntrestitalAds(this)
        myIntrestitalAds.loadInterstitialAd(R.string.interstitial_ads1)

        binding.showinterstitialadsBtn.setOnClickListener {
            myIntrestitalAds.showInterstitialAd {
                // here interstitial ads finish or dismiss or not load after execute
                startActivity(Intent(this,AfterInterstitailAdsFinishedActivity::class.java))
            }
        }

        binding.showNativeAdsBtn.setOnClickListener {
            startActivity(Intent(this,NativeAdsActivity::class.java))
        }


        val sharedPreferenceManger = SharedPreferenceManger(this)
        getRewardedCoin(sharedPreferenceManger.totalRewardedAmount)

        val rewardedAdsBtn = findViewById<Button>(R.id.rewardedAdsBtn)
        val myRewardedAds = MyRewardedAds(this)
        myRewardedAds.loadRewardedAds(R.string.rewarded_ads1)

        rewardedAdsBtn.setOnClickListener {
            myRewardedAds.showRewardedAds(R.string.rewarded_ads1){
                val rewardedCoin = it.amount
                sharedPreferenceManger.totalRewardedAmount += rewardedCoin
                getRewardedCoin(sharedPreferenceManger.totalRewardedAmount)
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private fun getRewardedCoin(totalRewardedAmount: Int){
        val totalRATxt = findViewById<TextView>(R.id.totalRATxt)
        totalRATxt.text = "Total Rewarded Coins: $totalRewardedAmount Coins"
    }
}
