package com.example.loggingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String MyFlag = "CEDRIC";  //this will be our trail of breadcrumbs for logging events.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(MyFlag, ": Activity onCreate State Transition");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MyFlag, ": Activity onPause State Transition");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MyFlag, ": Activity onStop State Transition");
    }

    @Override
    protected void onStart() {
        Log.i(MyFlag, ": Activity onStart State Transition");
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(MyFlag,": Activity onSaveInstanceState State Transition");
        Log.i(MyFlag, "Bundling State of our views before they get destroyed");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(MyFlag, ": Activity onRestoreInstanceState State Transition");
        Log.i(MyFlag, "Retrieving our saved state from before... ");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        Log.i(MyFlag, ": Activity onDestroy State Transition");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        Log.i(MyFlag, ": Activity onResume State Transition");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i(MyFlag, ": Activity onRestart State Transition");
        super.onRestart();
    }

}
