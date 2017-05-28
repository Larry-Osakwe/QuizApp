package com.example.larryosakwe.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int correctPoints = 0; //number of correct answers
    private int question1 = 0;
    private int question2 = 0;
    private int question3 = 0;
    private int question4 = 0;
    private int question5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    *When the submit button is clicked, the user's score is counted and shows up as a Toast message
    */
    public void submitQuiz(View view) {

        if(parentKiller()) {
            question1 = 1;
        } else{
            question1 = 0;
        }

        if(jokerKills()) {
            question2 = 1;
        } else {
            question2 = 0;
        }

        if (batCity()) {
            question3 = 1;
        } else {
            question3 = 0;
        }

        if (checkboxQuestion()) {
            question4 = 1;
        } else {
            question4 = 0;
        }

        if (nameEntry()) {
            question5 = 1;
        } else {
            question5 = 0;
        }

        correctPoints = question1 + question2 + question3 + question4 + question5;

        Toast toastScore = Toast.makeText(getApplicationContext(), "You scored " + correctPoints + " points!", Toast.LENGTH_SHORT);
        toastScore.show();
    }

    /*
    * Question 1
    * Checks to see if the user knows who killed Batman's parents
    */
    private boolean parentKiller() {
        RadioGroup radioGroupCity = (RadioGroup) findViewById(R.id.parent_killer);
        RadioButton parentCheckRadioButton = (RadioButton) radioGroupCity.findViewById(radioGroupCity.getCheckedRadioButtonId());
        boolean checked = (parentCheckRadioButton.isChecked());

        switch (parentCheckRadioButton.getId()) {
            case R.id.marconi_button:
                if (checked) {
                    return false;
                }
            case R.id.falcone_button:
                if (checked) {
                    return false;
                }
            case R.id.chill_button:
                if (checked) {
                    return true;
                }
            case R.id.zucco_button:
                if (checked) {
                    return false;
                }
        }
        return false;
    }

    /*
    * Question 2
    * Checks to see if the user knows which robin the joker kills
    */
    private boolean jokerKills() {
        RadioGroup radioGroupCity = (RadioGroup) findViewById(R.id.joker_kills_group);
        RadioButton killsCheckRadioButton = (RadioButton) radioGroupCity.findViewById(radioGroupCity.getCheckedRadioButtonId());
        boolean checked = (killsCheckRadioButton.isChecked());

        switch (killsCheckRadioButton.getId()) {
            case R.id.grayson_button:
                if (checked) {
                    return false;
                }
            case R.id.todd_button:
                if (checked) {
                    return true;
                }
            case R.id.drake_button:
                if (checked) {
                    return false;
                }
            case R.id.wayne_button:
                if (checked) {
                    return false;
                }
        }
        return false;
    }

    /*
    * Question 3
    * Checks to see if the user knows where Batman lives
    */
    private boolean batCity() {
        RadioGroup radioGroupCity = (RadioGroup) findViewById(R.id.batman_city_group);
        RadioButton trueCheckRadioButton = (RadioButton) radioGroupCity.findViewById(radioGroupCity.getCheckedRadioButtonId());
        boolean checked = (trueCheckRadioButton.isChecked());

        switch (trueCheckRadioButton.getId()) {
            case R.id.city_true:
                if (checked) {
                    return false;

                }
            case R.id.city_false:
                if (checked) {
                    return true;
                }
        }

        return false;
    }

    /*
    * Question 4
    * Two checkboxes need to be correct for this to return a true value
    */
    private boolean checkboxQuestion() {
        CheckBox detectiveCheck = (CheckBox) findViewById(R.id.greatest_detective);
        CheckBox greatestCheck = (CheckBox) findViewById(R.id.dark_knight);
        CheckBox boyWonderCheck = (CheckBox) findViewById(R.id.boy_wonder);
        CheckBox manOfSteelCheck = (CheckBox) findViewById(R.id.man_of_steel);

        boolean detectiveCheckChecked = detectiveCheck.isChecked();
        boolean greatestCheckChecked = greatestCheck.isChecked();
        boolean boyWonderCheckChecked = boyWonderCheck.isChecked();
        boolean manOfSteelCheckChecked = manOfSteelCheck.isChecked();

        return detectiveCheckChecked && greatestCheckChecked && !boyWonderCheckChecked && !manOfSteelCheckChecked;

    }

    /*
    * Question 5
    * Checks to see if the user knows Batman's true identity
    */
    private boolean nameEntry() {
        EditText nameField = (EditText) findViewById(R.id.batman_identity);
        String batmanIdentity = nameField.getText().toString();

        if (batmanIdentity.equalsIgnoreCase("bruce wayne")) {
            return true;
        }

        return false;

    }


}
