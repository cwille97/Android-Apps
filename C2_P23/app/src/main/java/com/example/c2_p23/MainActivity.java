package com.example.c2_p23;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static View trafficLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trafficLight = (View) findViewById(R.id.trafficLight);
        trafficLight.setBackgroundColor(0xAA009900);

    }

    public static void changeColor(View v) {
        ColorDrawable labelColor = (ColorDrawable) trafficLight.getBackground();
        int colorId = labelColor.getColor();

        if (colorId == 0xAA009900) {
            // if the current color is green, make it yellow
            trafficLight.setBackgroundColor(0xAAffcc00);
        }

        if (colorId == 0xAAffcc00) {
            // if the current color is yellow, make it red
            trafficLight.setBackgroundColor(0xAAff0000);
        }

        if (colorId == 0xAAff0000) {
            // if the current color is red, make it green
            trafficLight.setBackgroundColor(0xAA009900);
        }
    }
}
