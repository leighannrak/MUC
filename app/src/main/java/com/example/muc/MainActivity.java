package com.example.muc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View v) {
        toWeatherScreen();
    }

    public void toWeatherScreen() {
        Intent intent = new Intent(MainActivity.this, weather.class);
        finish();
        startActivity(intent);
    }
}
