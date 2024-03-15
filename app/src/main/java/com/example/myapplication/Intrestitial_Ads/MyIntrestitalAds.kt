package com.example.myapplication.Intrestitial_Ads

import android.app.Activity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError

import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class MyIntrestitalAds(private val activity: Activity) {

    private var interstitialAd :InterstitialAd?=null

    fun loadInterstitialAd(adUnitId: Int)
    {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            activity,
            activity.getString(adUnitId),
            adRequest,
            object : InterstitialAdLoadCallback(){
                override fun onAdLoaded(minterstitialAd: InterstitialAd) {
                    interstitialAd= minterstitialAd
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    interstitialAd=null
                }
            }
        )
    }

    fun showInterstitialAd(afterSomeCode: () -> Unit){
        if(interstitialAd!=null)
        {
            interstitialAd!!.fullScreenContentCallback=
                object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {

                        interstitialAd=null
                        afterSomeCode()
                    }
                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {

                        interstitialAd=null
                        afterSomeCode()
                    }
                }

            interstitialAd!!.show(activity)
        }
        else
        {
            afterSomeCode()
        }
    }
}