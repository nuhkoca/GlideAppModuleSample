package com.example.nuhkoca.appglidemodulesample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.nuhkoca.appglidemodulesample.databinding.ActivitySecondBinding
import com.example.nuhkoca.appglidemodulesample.module.GlideApp

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activitySecondBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        GlideApp.with(this).asBitmap().load(BASE_URL).into(activitySecondBinding.ivImage2)

        activitySecondBinding.ivImage2.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        Toast.makeText(this, "Activity Second is active", Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val BASE_URL =
            "https://upload.wikimedia.org/wikipedia/commons/d/da/Essen_Einkaufsstadt_Hotel_Handelshof_2014.jpg"
    }
}
