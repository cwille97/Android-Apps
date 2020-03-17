package com.example.celsiustofahrenheit;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button convert;
    EditText celsius;
    TextView fahrenheit;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert = findViewById(R.id.convertButton);
        celsius = findViewById(R.id.celsiusEdit);
        fahrenheit = findViewById(R.id.fahrenheitLabel);

        context = getApplicationContext();
    }

    public void convert(View view) {
        try {
            double celsiusVal = Double.valueOf(celsius.getText().toString());

            double fahrenheitVal = (celsiusVal * (9.0 / 5.0)) + 32.0;
            String temp = "";
            temp += String.valueOf(fahrenheitVal);
            temp += " degrees F";
            fahrenheit.setText(temp);
        }
        catch(Exception ex) {
            System.out.println("Exception: " + ex);

            CharSequence text = "Invalid Input";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
    }
}


