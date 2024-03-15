package com.example.myapplication.Native_Ads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Ads.loadSmallMediumSizeNativeAds
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityNativeAdsBinding

class NativeAdsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNativeAdsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNativeAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadSmallMediumSizeNativeAds(this, R.string.native_ads1, binding.templateView)
    }
}