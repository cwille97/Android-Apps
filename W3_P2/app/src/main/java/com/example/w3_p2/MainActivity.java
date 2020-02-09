package com.example.w3_p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SeekBar celsiusSeek;
    SeekBar fahrenheitSeek;
    TextView celsiusValue;
    TextView fahrenheitValue;
    TextView interestingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsiusSeek = findViewById(R.id.celsiusSeekBar);
        fahrenheitSeek = findViewById(R.id.fahrenheitSeekBar);
        celsiusValue = findViewById(R.id.celsiusValue);
        fahrenheitValue = findViewById(R.id.fahrenheitValue);
        interestingMessage = findViewById(R.id.interestingMessage);

        fahrenheitSeek.setMax(180);


        // perform seek bar change listener event used for getting the progress value
        celsiusSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                celsiusValue.setText(String.valueOf(progressChangedValue));
                if (Integer.parseInt(celsiusValue.getText().toString()) < 12) {
                    interestingMessage.setText(R.string.cold);
                }
                else
                {
                    interestingMessage.setText(R.string.notCold);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                celsiusValue.setText(String.valueOf(progressChangedValue));
                int fahrenheitEquivalent = celsiusToFahrenheit(progressChangedValue);
                fahrenheitValue.setText(String.valueOf(fahrenheitEquivalent));
                fahrenheitSeek.setProgress(fahrenheitEquivalent-32);
            }
        });

        fahrenheitSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                fahrenheitValue.setText(String.valueOf(progressChangedValue));
                if (Integer.parseInt(celsiusValue.getText().toString()) < 12) {
                    interestingMessage.setText(R.string.cold);
                }
                else
                {
                    interestingMessage.setText(R.string.notCold);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                fahrenheitValue.setText(String.valueOf(progressChangedValue));
                int celsiusEquivalent = fahrenheitToCelsius(progressChangedValue);
                celsiusValue.setText(String.valueOf(celsiusEquivalent));
                celsiusSeek.setProgress(celsiusEquivalent);
            }
        });
    }

    private static int celsiusToFahrenheit(int celsius) {
        double fahrenheit = (9.0/5.0) * celsius + 32.0;
        return (int) Math.round(fahrenheit);
    }

    private static int fahrenheitToCelsius(int fahrenheit) {
        double celsius = (fahrenheit-32.0)*5.0/9.0;
        return (int) Math.round(celsius);
    }
}
