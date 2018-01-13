package com.example.nuhkoca.appglidemodulesample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nuhkoca.appglidemodulesample.databinding.ActivitySecondBinding;
import com.example.nuhkoca.appglidemodulesample.module.GlideApp;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    ActivitySecondBinding activitySecondBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        final String url = "https://upload.wikimedia.org/wikipedia/commons/d/da/Essen_Einkaufsstadt_Hotel_Handelshof_2014.jpg";

        GlideApp.with(this)
                .asBitmap()
                .load(url)
                .into(activitySecondBinding.ivImage2);

        activitySecondBinding.ivImage2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Activity Second is active", Toast.LENGTH_LONG).show();
    }
}
