package com.example.emailapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button verify = (Button) findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText emailField = (EditText) findViewById(R.id.emailField);
                TextView label = (TextView) findViewById(R.id.validLabel);
                try {
                    String email = emailField.getText().toString();
                    if (email.contains("@")) {
                        label.setText("VALID");
                        label.setTextColor(0xff0066ff);
                    }
                    else {
                        label.setText("INVALID");
                        label.setTextColor(0xffff0000);
                    }
                }
                catch(Exception e) {
                    System.out.println("Encountered an exception: " + e);
                }
            }
        });
    }
}
