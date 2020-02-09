package com.example.c2_p29;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private EditText cheeseBurgerEditText;
    private EditText friesEditText;
    private EditText sodaEditText;
    private TextView total;
    private static int totalCalories = 0;
    private static int totalCheeseBurgerCalories = 0;
    private static int totalFriesCalories = 0;
    private static int totalSodaCalories = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cheeseBurgerEditText = findViewById(R.id.cheeseBurgerText);
        friesEditText = findViewById(R.id.friesText);
        sodaEditText = findViewById(R.id.sodaText);
        total = findViewById(R.id.totalView);

        cheeseBurgerEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                try {
                    int num = 0;
                    String burgerText = cheeseBurgerEditText.getText().toString();
                    if (burgerText != null && burgerText != "") {
                        num = Integer.parseInt(burgerText);
                    }
                    totalCheeseBurgerCalories = num * 350;
                    totalCalories = totalCheeseBurgerCalories + totalFriesCalories + totalSodaCalories;
                    total.setText("Total calories in your meal: " + String.valueOf(totalCalories));
                    if (totalCalories > 1000) {
                        total.setTextColor(0xAAff0000);
                    }
                    else {
                        total.setTextColor(0xAA000000);
                    }
                }
                catch(Exception ex) {
                    System.out.println("Encountered Exception: " + ex);
                }


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String burgerText = cheeseBurgerEditText.getText().toString();
                if (burgerText != null && burgerText != "") {
                    totalCalories = 0 + totalFriesCalories + totalSodaCalories;
                    total.setText("Total calories in your meal: " + String.valueOf(totalCalories));

                }
                if (totalCalories > 1000) {
                    total.setTextColor(0xAAff0000);
                }
                else {
                    total.setTextColor(0xAA000000);
                }
            }
        });

        friesEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                try {
                    int num = 0;
                    String friesText = friesEditText.getText().toString();
                    if (friesText != null && friesText != "") {
                        num = Integer.parseInt(friesText);
                    }
                    totalFriesCalories = num * 400;
                    totalCalories = totalCheeseBurgerCalories + totalFriesCalories + totalSodaCalories;
                    total.setText("Total calories in your meal: " + String.valueOf(totalCalories));
                    if (totalCalories > 1000) {
                        total.setTextColor(0xAAff0000);
                    }
                    else {
                        total.setTextColor(0xAA000000);
                    }
                }
                catch(Exception ex) {
                    System.out.println("Encountered Exception: " + ex);
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String friesText = friesEditText.getText().toString();
                if (friesText != null && friesText != "") {
                    totalCalories = totalCheeseBurgerCalories + 0 + totalSodaCalories;
                    total.setText("Total calories in your meal: " + String.valueOf(totalCalories));
                    if (totalCalories > 1000) {
                        total.setTextColor(0xAAff0000);
                    }
                    else {
                        total.setTextColor(0xAA000000);
                    }
                }
            }
        });

        sodaEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                try {
                    int num = 0;
                    String sodaText = sodaEditText.getText().toString();
                    if (sodaText != null && sodaText != "") {
                        num = Integer.parseInt(sodaText);
                    }
                    totalSodaCalories = num * 200;
                    totalCalories = totalCheeseBurgerCalories + totalFriesCalories + totalSodaCalories;
                    total.setText("Total calories in your meal: " + String.valueOf(totalCalories));
                    if (totalCalories > 1000) {
                        total.setTextColor(0xAAff0000);
                    }
                    else {
                        total.setTextColor(0xAA000000);
                    }
                }
                catch(Exception ex) {
                    System.out.println("Encountered Exception: " + ex);

                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String sodaText = sodaEditText.getText().toString();
                if (sodaText != null && sodaText != "") {
                    totalCalories = totalCheeseBurgerCalories + totalFriesCalories + 0;
                    total.setText("Total calories in your meal: " + String.valueOf(totalCalories));
                }
                if (totalCalories > 1000) {
                    total.setTextColor(0xAAff0000);
                }
                else {
                    total.setTextColor(0xAA000000);
                }
            }
        });

    }
}
