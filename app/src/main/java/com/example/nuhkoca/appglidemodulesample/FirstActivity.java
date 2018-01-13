package com.example.nuhkoca.appglidemodulesample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nuhkoca.appglidemodulesample.databinding.ActivityFirstBinding;
import com.example.nuhkoca.appglidemodulesample.module.GlideApp;

public class FirstActivity extends AppCompatActivity {

    ActivityFirstBinding activityFirstBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFirstBinding = DataBindingUtil.setContentView(this, R.layout.activity_first);

        final String url = "https://media.essen.de/media/emg_1/essen_tourismus/bilder_16/header_bilder/headerauswahl_2015/veranstaltungen_5/2013_Essen_Original_Panorama_EMG_1200_1zu2.jpg";

        GlideApp.with(this)
                .load(url)
                .into(activityFirstBinding.ivImage1);
    }
}
