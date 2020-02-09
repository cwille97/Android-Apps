package com.example.temperatureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button celsiusButton = (Button) findViewById(R.id.celsiusButton);
        Button fahrenheitButton = (Button) findViewById(R.id.fahrenheitButton);
        final EditText celsiusText = (EditText) findViewById(R.id.celsiusText);
        final EditText fahrenheitText = (EditText) findViewById(R.id.fahrehneitText);

        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                celsiusToFahrenheit(celsiusText, fahrenheitText);
            }
        });

        fahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                fahrenheitToCelsius(celsiusText, fahrenheitText);
            }
        });
    }

    public static void celsiusToFahrenheit(EditText celsiusText, EditText fahrenheitText) {
        try {
            int celsius = Integer.parseInt(celsiusText.getText().toString());
            double fahrenheit = ((9.0 / 5.0) * celsius) + 32.0;
            fahrenheitText.setText(String.valueOf(Math.round(fahrenheit)));

        }
        catch(Exception ex) {
            System.out.println("Encountered the exception: " + ex);
        }
    }

    public static void fahrenheitToCelsius(EditText celsiusText, EditText fahrenheitText) {
        try {
            int fahrenheit = Integer.parseInt(fahrenheitText.getText().toString());
            double celsius = (5.0 / 9.0) * (fahrenheit - 32.0);
            celsiusText.setText(String.valueOf(Math.round(celsius)));
        }
        catch(Exception ex) {
            System.out.println("Encountered the exception: " + ex);
        }
    }
}
