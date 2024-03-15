package com.example.myapplication.Instagram

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.mukesh.image_processing.ImageProcessor


class MainActivity : AppCompatActivity() {

    private var bitmap: Bitmap? = null

    private var oneBitMap: Bitmap? = null
    private var twoBitMap: Bitmap? = null
    private var threeBitmap: Bitmap? = null
    private var fourBitMap: Bitmap? = null
    private var fiveBitMap: Bitmap? = null
    private var sixBitMap: Bitmap? = null
    private var sevenBitMap: Bitmap? = null
    private var eightBitMap: Bitmap? = null
    private var nineBitMap: Bitmap? = null
    private var tenBitMap: Bitmap? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // creating a variable for our image processor.
        val processor = ImageProcessor()

        bitmap = BitmapFactory.decodeResource(resources, R.drawable.image)

        oneBitMap = processor.tintImage(bitmap, 90)
        binding.idIVOne.setImageBitmap(oneBitMap)

        twoBitMap = processor.applyGaussianBlur(bitmap)
        binding.idIVTwo.setImageBitmap(twoBitMap)

        threeBitmap = processor.createSepiaToningEffect(bitmap, 1, 2.0, 1.0, 5.0)
        binding.idIVThree.setImageBitmap(threeBitmap)


        fourBitMap = processor.applySaturationFilter(bitmap, 3)
        binding.idIVFour.setImageBitmap(fourBitMap)


        fiveBitMap = processor.applySnowEffect(bitmap)
        binding.idIVFive.setImageBitmap(fiveBitMap)


        sixBitMap = processor.doGreyScale(bitmap)
        binding.idIVSix.setImageBitmap(sixBitMap)


        sevenBitMap = processor.engrave(bitmap)
        binding.idIVSeven.setImageBitmap(sevenBitMap)


        eightBitMap = processor.createContrast(bitmap, 1.5)
        binding.idIVEight.setImageBitmap(eightBitMap)


        nineBitMap = processor.createShadow(bitmap)
        binding.idIVNine.setImageBitmap(nineBitMap)


        tenBitMap = processor.applyFleaEffect(bitmap)
        binding.idIVTen.setImageBitmap(tenBitMap)

        initializeOnCLickListerns()
    }

    private fun initializeOnCLickListerns() {
        binding.idIVOne.setOnClickListener {binding.idIVOriginalImage.setImageBitmap(oneBitMap) }
        binding.idIVTwo.setOnClickListener { binding.idIVOriginalImage.setImageBitmap(twoBitMap) }
        binding.idIVThree.setOnClickListener { binding.idIVOriginalImage.setImageBitmap(threeBitmap) }
        binding.idIVFour.setOnClickListener { binding.idIVOriginalImage.setImageBitmap(fourBitMap) }
        binding.idIVFive.setOnClickListener { binding.idIVOriginalImage.setImageBitmap(fiveBitMap) }
        binding.idIVSix.setOnClickListener { binding.idIVOriginalImage.setImageBitmap(sixBitMap) }
        binding.idIVSeven.setOnClickListener { binding.idIVOriginalImage.setImageBitmap(sevenBitMap) }
        binding.idIVEight.setOnClickListener { binding.idIVOriginalImage.setImageBitmap(eightBitMap) }
        binding.idIVNine.setOnClickListener { binding.idIVOriginalImage.setImageBitmap(nineBitMap) }
        binding.idIVTen.setOnClickListener { binding.idIVOriginalImage.setImageBitmap(tenBitMap) }
    }
}
