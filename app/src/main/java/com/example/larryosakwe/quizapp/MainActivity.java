package com.example.larryosakwe.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int correctPoints = 0; //number of correct answers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





    /*
    When the submit button is clicked, the user's score is counted and shows up as a Toast message
     */
    public void submitQuiz(View view) {
        Toast toastScore = Toast.makeText(getApplicationContext(), "You scored " + correctPoints + " points!", Toast.LENGTH_SHORT);
        toastScore.show();
    }
}
