package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;
import android.content.Context;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static TextView view;
    Button zeroButton;
    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button clearButton;
    Button equalsButton;
    Button timesButton;
    Button plusButton;
    Button minusButton;
    Button divideButton;
    Button rootButton;
    Button decimalButton;
    static Context context;
    static boolean flag = false; // this flag will be true if the user has just finished a calculation

    public enum Operator {
        PLUS, MINUS, TIMES, DIVIDE,
    }

    static String tempVal;
    static Operator currentOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (TextView) findViewById(R.id.textView);
        zeroButton = (Button) findViewById(R.id.zeroButton);
        oneButton = (Button) findViewById(R.id.oneButton);
        twoButton = (Button) findViewById(R.id.twoButton);
        threeButton = (Button) findViewById(R.id.threeButton);
        fourButton = (Button) findViewById(R.id.fourButton);
        fiveButton = (Button) findViewById(R.id.fiveButton);
        sixButton = (Button) findViewById(R.id.sixButton);
        sevenButton = (Button) findViewById(R.id.sevenButton);
        eightButton = (Button) findViewById(R.id.eightButton);
        nineButton = (Button) findViewById(R.id.nineButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        equalsButton = (Button) findViewById(R.id.equalsButton);
        timesButton = (Button) findViewById(R.id.timesButton);
        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        rootButton = (Button) findViewById(R.id.rootButton);
        decimalButton = (Button) findViewById(R.id.decimalButton);
    }

    public static void clear(View v) {
        view.setText("");
    }

    public static void one(View v) {
        if (flag) {
            flag = false;
            view.setText("");
        }
        String temp = view.getText().toString();
        temp += "1";
        view.setText(temp);
    }

    public static void two(View v) {
        if (flag) {
            flag = false;
            view.setText("");
        }
        String temp = view.getText().toString();
        temp += "2";
        view.setText(temp);
    }

    public static void three(View v) {
        if (flag) {
            flag = false;
            view.setText("");
        }
        String temp = view.getText().toString();
        temp += "3";
        view.setText(temp);
    }

    public static void four(View v) {
        if (flag) {
            flag = false;
            view.setText("");
        }
        String temp = view.getText().toString();
        temp += "4";
        view.setText(temp);
    }

    public static void five(View v) {
        if (flag) {
            flag = false;
            view.setText("");
        }
        String temp = view.getText().toString();
        temp += "5";
        view.setText(temp);
    }

    public static void six(View v) {
        if (flag) {
            flag = false;
            view.setText("");
        }
        String temp = view.getText().toString();
        temp += "6";
        view.setText(temp);
    }

    public static void seven(View v) {if (flag) {
        flag = false;
        view.setText("");
    }

        String temp = view.getText().toString();
        temp += "7";
        view.setText(temp);
    }

    public static void eight(View v) {
        if (flag) {
            flag = false;
            view.setText("");
        }
        String temp = view.getText().toString();
        temp += "8";
        view.setText(temp);
    }

    public static void nine(View v) {
        if (flag) {
            flag = false;
            view.setText("");
        }
        String temp = view.getText().toString();
        temp += "9";
        view.setText(temp);
    }

    public static void zero(View v) {
        if (flag) {
            flag = false;
            view.setText("");
        }
        String temp = view.getText().toString();
        temp += "0";
        view.setText(temp);
    }

    public static void decimal(View v) {
        if (flag) {
            flag = false;
            view.setText("");

        }
        if (!view.getText().toString().contains(".")) {
            String temp = view.getText().toString();
            temp += ".";
            view.setText(temp);
        }
    }

    public static void plus(View v) {
        currentOperator = Operator.PLUS;
        tempVal = view.getText().toString();
        view.setText("");
    }

    public static void minus(View v) {
        currentOperator = Operator.MINUS;
        tempVal = view.getText().toString();
        view.setText("");
    }

    public static void times(View v) {
        currentOperator = Operator.TIMES;
        tempVal = view.getText().toString();
        view.setText("");
    }

    public static void divide(View v) {
        currentOperator = Operator.DIVIDE;
        tempVal = view.getText().toString();
        view.setText("");
    }

    public static void root(View v) {
        tempVal = view.getText().toString();
        Double num = Double.valueOf(tempVal);
        num = Math.sqrt(num);
        view.setText(num.toString());
    }

    public static void equals(View v) {
        try {
            if (view.getText().toString() == "") {
                CharSequence text = "Please enter a valid operation";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else {
                Double val1 = Double.valueOf(tempVal);
                Double val2 = Double.valueOf(view.getText().toString());
                Double total = 0.0;

                switch (currentOperator) {
                    case PLUS:
                        total = val1 + val2;
                        break;

                    case MINUS:
                        total = val1 - val2;
                        break;

                    case TIMES:
                        total = val1 * val2;
                        break;

                    case DIVIDE:
                        total = val1 / val2;
                        break;
                }

                view.setText(total.toString());
            }
            flag = true;
        }
        catch(Exception ex) {
            System.out.println("Encounter the exception: " + ex);
        }
    }




}
