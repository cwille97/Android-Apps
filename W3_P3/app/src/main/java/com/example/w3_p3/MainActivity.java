package com.example.w3_p3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.usernameEdit);
        password = findViewById(R.id.passwordEdit);

    }

    public void verifyCredentials(View v) {
        final String enteredUsername = username.getText().toString();
        final String enteredPassword = password.getText().toString();
        if (enteredUsername.equals("james") && enteredPassword.equals("123")) {
            // load next activity
            try {
                Intent intent = new Intent(this, QuizActivity.class );
                intent.putExtra("username", enteredUsername);
                startActivity(intent);
            }
            catch(Exception ex) {
                Log.i("Error", String.valueOf(ex));
            }
        }
        else {
            // display incorrect toast
            CharSequence text = "Incorrect Username or Password";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
        }
    }
}
