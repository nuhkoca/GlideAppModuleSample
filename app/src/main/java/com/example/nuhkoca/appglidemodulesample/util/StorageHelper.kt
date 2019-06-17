package com.example.nuhkoca.appglidemodulesample.util

import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.UUID

class StorageHelper {
    fun saveImageToExternalStorage(bitmap: Bitmap?): Uri {
        // Get the external storage directory path
        val path = Environment.getExternalStorageDirectory().toString()

        // Create a file to save the image
        val file = File(path, "${UUID.randomUUID()}.jpg")

        try {
            // Get the file output stream
            val stream: OutputStream = FileOutputStream(file)

            // Compress the bitmap
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, stream)

            // Flush the output stream
            stream.flush()

            // Close the output stream
            stream.close()
            Log.d(TAG, "Image saved successful.")
        } catch (e: IOException) { // Catch the exception
            e.printStackTrace()
            Log.d(TAG, "Error to save image.")
        }

        // Return the saved image path to uri
        return Uri.parse(file.absolutePath)
    }

    companion object {
        private const val TAG = "StorageHelper"
    }
}
