package com.example.sharedpreferencespractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {

    private TextView label;
    public static final String MyPREFERENCES = "MyPrefs";
    private TextView storedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = findViewById(R.id.textView);
        storedText = findViewById(R.id.textView2);



        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();

        final String storedString = sharedpreferences.getString("stored", null);
        storedText.setText(storedString);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                String labelString = "Stored Value: " + rb.getText().toString();
                label.setText(labelString);
                editor.putString("stored", labelString);
                editor.commit();
            }
        });
    }
}
