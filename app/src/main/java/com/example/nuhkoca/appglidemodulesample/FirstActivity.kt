package com.example.nuhkoca.appglidemodulesample

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.M
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.nuhkoca.appglidemodulesample.databinding.ActivityFirstBinding
import com.example.nuhkoca.appglidemodulesample.module.GlideApp
import com.example.nuhkoca.appglidemodulesample.util.StorageHelper

class FirstActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityFirstBinding: ActivityFirstBinding
    private val storageHelper = StorageHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityFirstBinding = DataBindingUtil.setContentView(this, R.layout.activity_first)

        GlideApp.with(this)
            .asBitmap()
            .load(BASE_URL)
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    if (isStoragePermissionGranted()) {
                        storageHelper.saveImageToExternalStorage(resource)
                    }
                    return false
                }
            })
            .into(activityFirstBinding.ivImage1)

        activityFirstBinding.ivImage1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        Toast.makeText(this, "Activity First is active", Toast.LENGTH_LONG).show()
    }

    fun isStoragePermissionGranted(): Boolean {
        return if (SDK_INT >= M) {
            if (checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PERMISSION_GRANTED) {
                true
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(WRITE_EXTERNAL_STORAGE), REQ_CODE_EXTERNAL_STORAGE)
                false
            }
        } else {
            true
        }
    }

    companion object {
        private const val REQ_CODE_EXTERNAL_STORAGE = 100
        private const val BASE_URL =
            "https://upload.wikimedia.org/wikipedia/commons/d/da/Essen_Einkaufsstadt_Hotel_Handelshof_2014.jpg"
    }
}
