package com.example.additionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import java.util.Random;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addition = (Button) findViewById((R.id.addition_button));
        Button generate = (Button) findViewById((R.id.button_generate));

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addition(v);
            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate(v);
            }
        });

        Random rand = new Random();
        TextView label1 = (TextView) findViewById(R.id.label1);
        TextView label2 = (TextView) findViewById(R.id.label2);
        TextView label_sum = (TextView) findViewById(R.id.label_sum);

        int first_value = rand.nextInt(10)+1; // 10 + 1 to ensure it's between 1 and 10
        int second_value = rand.nextInt(10)+1;

        label1.setText(String.valueOf(first_value));
        label2.setText(String.valueOf(second_value));

    }

    public void generate(View v) {
        Random rand = new Random();
        TextView label1 = (TextView) findViewById(R.id.label1);
        TextView label2 = (TextView) findViewById(R.id.label2);
        TextView label_sum = (TextView) findViewById(R.id.label_sum);

        int first_value = rand.nextInt(10)+1; // 10 + 1 to ensure it's between 1 and 10
        int second_value = rand.nextInt(10)+1;

        label1.setText(String.valueOf(first_value));
        label2.setText(String.valueOf(second_value));
    }

    public void addition(View v) {
        TextView label1 = (TextView) findViewById(R.id.label1);
        TextView label2 = (TextView) findViewById(R.id.label2);
        TextView label_sum = (TextView) findViewById(R.id.label_sum);
        try {
            int first_value = Integer.parseInt(label1.getText().toString());
            int second_value = Integer.parseInt(label2.getText().toString());
            int sum = first_value + second_value;
            label_sum.setText(String.valueOf(sum));
        }
        catch(NumberFormatException nfe) {
            // add alert here
            Context context = getApplicationContext();
            CharSequence text = "Number formatting error!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }
}
