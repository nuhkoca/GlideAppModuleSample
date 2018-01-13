package com.example.nuhkoca.appglidemodulesample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nuhkoca.appglidemodulesample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.btnActivitiy1.setOnClickListener(this);
        activityMainBinding.btnActivitiy2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent activityIntent;

        int id = v.getId();

        if (id == R.id.btnActivitiy1) {
            activityIntent = new Intent(MainActivity.this, FirstActivity.class);
        } else {
            activityIntent = new Intent(MainActivity.this, SecondActivity.class);
        }

        startActivity(activityIntent);
    }
}
