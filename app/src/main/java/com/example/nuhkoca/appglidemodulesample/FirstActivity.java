package com.example.nuhkoca.appglidemodulesample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nuhkoca.appglidemodulesample.databinding.ActivityFirstBinding;
import com.example.nuhkoca.appglidemodulesample.module.GlideApp;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityFirstBinding activityFirstBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFirstBinding = DataBindingUtil.setContentView(this, R.layout.activity_first);

        final String url = "https://upload.wikimedia.org/wikipedia/commons/d/da/Essen_Einkaufsstadt_Hotel_Handelshof_2014.jpg";

        GlideApp.with(this)
                .asBitmap()
                .load(url)
                .into(activityFirstBinding.ivImage1);

        activityFirstBinding.ivImage1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Activity First is active", Toast.LENGTH_LONG).show();
    }
}
