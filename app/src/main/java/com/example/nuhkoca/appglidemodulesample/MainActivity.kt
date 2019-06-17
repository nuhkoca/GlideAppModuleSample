package com.example.nuhkoca.appglidemodulesample

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.nuhkoca.appglidemodulesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding.btnActivitiy1.setOnClickListener(this)
        activityMainBinding.btnActivitiy2.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val activityIntent: Intent

        val id = v.id

        activityIntent = if (id == R.id.btnActivitiy1) {
            Intent(this@MainActivity, FirstActivity::class.java)
        } else {
            Intent(this@MainActivity, SecondActivity::class.java)
        }

        startActivity(activityIntent)
    }
}
