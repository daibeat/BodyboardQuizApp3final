package com.example.android.bodyboardquizapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    /**
     * This app is a quiz about Bodyboard sport.
     */
    /**
     * Initial point score
     **/

    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method calculates the score
     */
    private void calculateScore() {
        points = 0;
        quizOne();
        quizTwo();
        quizThree();
        quizFour();
        quizFive();
        quizSix();

    }

    /**
     * This method is called when the question 1.
     */
    private void quizOne() {
        RadioButton Question1 = (RadioButton) findViewById(R.id.drop_knee);
        boolean right1 = Question1.isChecked();
        if (right1) {
            points = points + 1;
        }
    }

    /**
     * This method is called when the question 2.
     */
    private void quizTwo() {
        RadioButton Question2 = (RadioButton) findViewById(R.id.date2);
        boolean right2 = Question2.isChecked();
        if (right2) {
            points = points + 1;
        }
    }

    /**
     * This method is called when the question 3.
     */
    private void quizThree() {
        CheckBox box1 = (CheckBox) findViewById(R.id.option_a);
        boolean check1 = box1.isChecked();
        if (check1) {
            points = points + 1;

        }

        CheckBox box2 = (CheckBox) findViewById(R.id.option_c);
        boolean check2 = box2.isChecked();
        if (check2)
            points = points + 1;


    }

    /**
     * This method is called when the question 4.
     */
    private void quizFour() {
        RadioButton Question4 = (RadioButton) findViewById(R.id.quiz4_d);
        boolean right4 = Question4.isChecked();
        if (right4) {
            points = points + 1;
        }
    }

    /**
     * This method is called when the question 5.
     */
    private void quizFive() {
        RadioButton Question5 = (RadioButton) findViewById(R.id.quiz5_c);
        boolean right5 = Question5.isChecked();
        if (right5) {
            points = points + 1;
        }
    }

    /**
     * This method is called when the question 6.
     */
    private void quizSix() {
        RadioButton Question6 = (RadioButton) findViewById(R.id.quiz6_a);
        boolean right6 = Question6.isChecked();
        if (right6) {
            points = points + 1;
        }
    }


    /**
     * This method is called when submit button is clicked.
     */
    public void submit(View view) {
        calculateScore();
        EditText nameField = (EditText) findViewById(R.id.enterName);
        String enterName = nameField.getText().toString();
        String text = enterName + ", your score is " + points;
        if (points <= 1) {
            text += "\nThat is a real wipeout";
        } else if (points <= 3) {
            text += "\nWell, I am sure you can do it better!";
        } else if (points <= 5) {
            text += "\nExcellent rider!";
        } else if (points <= 6) {
            text += "\nYou are an authentic bodyboarder!";
        } else if (points <= 7) {
            text += "\nAwesome, You are a pro bodyboarder!";
        }

        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();

    }

    /**
     * This method is called when the reset button is clicked.
     * Clear all the scores and clicked options
     */

    public void reset(View view) {
        ((RadioGroup) findViewById(R.id.quiz1)).clearCheck();
        ((RadioGroup) findViewById(R.id.quiz2)).clearCheck();
        ((CheckBox) findViewById(R.id.option_a)).setChecked(false);
        ((CheckBox) findViewById(R.id.option_b)).setChecked(false);
        ((CheckBox) findViewById(R.id.option_c)).setChecked(false);
        ((CheckBox) findViewById(R.id.option_d)).setChecked(false);
        ((RadioGroup) findViewById(R.id.quiz4)).clearCheck();
        ((RadioGroup) findViewById(R.id.quiz5)).clearCheck();
        ((RadioGroup) findViewById(R.id.quiz6)).clearCheck();


    }
}