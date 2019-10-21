package com.example.muc;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

public class weather extends AppCompatActivity {

    private TextView api = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weather_info();

        Button task = (Button)findViewById(R.id.rating_button);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(weather.this, rating.class);
                finish();
                startActivity(intent);
            }
        });
    }

    public void weather_info() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Atlanta&units=metric&appid=7149b876cbf6006bb8804c98a89b243c";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        setContentView(R.layout.activity_weather);
                        TextView weather_text = (TextView)findViewById(R.id.weather_text);
                        weather_text.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setContentView(R.layout.activity_weather);
                TextView weather_text = (TextView)findViewById(R.id.weather_text);
                weather_text.setText("That didn't work!");            }
        });
        queue.add(stringRequest);
    }
}
