package com.example.w3_p3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private Button newGameButton;
    private Button submitButton;
    private EditText answerField;
    private TextView questionView;
    private int roundCounter = 1; // keeps track of the number of rounds played
    private int score = 0;
    private boolean inGame = false;
    private int globalAnswer = 0;
    private String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        newGameButton = findViewById(R.id.newGameButton);
        submitButton = findViewById(R.id.submitButton);

        answerField = findViewById(R.id.answerField);
        questionView = findViewById(R.id.questionView);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                username = null;
            } else {
                username = extras.getString("username");
            }
        } else {
            username = (String) savedInstanceState.getSerializable("username");
        }

        CharSequence text = "Welcome, " + username;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCounter", roundCounter);
        outState.putInt("score", score);
        outState.putBoolean("inGame", inGame);
        outState.putInt("globalAnswer", globalAnswer);
        outState.putString("currentQuestion", questionView.getText().toString());
        outState.putString("currentInput", answerField.getText().toString());
        outState.putString("username", username);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
            roundCounter = savedInstanceState.getInt("roundCounter");
            score = savedInstanceState.getInt("score");
            inGame = savedInstanceState.getBoolean("inGame");
            globalAnswer = savedInstanceState.getInt("globalAnswer");
            String currentQuestion = savedInstanceState.getString("currentQuestion");
            String currentInput = savedInstanceState.getString("currentInput");
            username = savedInstanceState.getString("username");

            questionView.setText(currentQuestion);
            answerField.setText(currentInput);
    }

    public void startGame(View v) {
        roundCounter = 1;
        score = 0;
        globalAnswer = 0;
        inGame = true;
        generateQuestion();
        newGameButton.setVisibility(View.GONE);
    }



    public void submitAnswer(View v) {
        if (inGame) {
            String answerString =  answerField.getText().toString();
            if (!answerString.equals("")) {
                if (Integer.parseInt(answerString) == globalAnswer) {
                    score++;
                }
            }
            answerField.setText("");

            if (roundCounter < 10) {
                generateQuestion();
            }
            else {
                // game has ended, toast score
                newGameButton.setVisibility(View.VISIBLE);
                inGame = false;
                CharSequence text = "Game over, your score is " + score + " out of 10.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();

            }
        }
        else {
            // toast saying to start a new game
            CharSequence text = "You are not currently playing the game. Start a new game via the button at the top.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
        }
    }

    public void generateQuestion() {
        // generate new question
        Random rand = new Random();
        int firstVal = rand.nextInt(100);
        int secondVal = rand.nextInt(100 + 1);
        while (firstVal % secondVal != 0) { // keep generating new values until you get two that are divisible without a remainder
            firstVal = rand.nextInt(100);
            secondVal = rand.nextInt(100) + 1;
        }
        globalAnswer = firstVal / secondVal;
        String prompt = firstVal + " / " + secondVal;
        questionView.setText(prompt);
        roundCounter++;
    }
}
