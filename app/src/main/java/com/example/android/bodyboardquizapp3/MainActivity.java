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

    String q5 = "Hawaii";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This app is a quiz about Bodyboard sport.
     */
    /**
     * Initial point score
     **/

    int points = 0;

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
     * This method is called for question 1.
     */
    private void quizOne() {
        RadioButton Question1 = (RadioButton) findViewById(R.id.drop_knee_rb);
        boolean right1 = Question1.isChecked();
        if (right1) {
            points = points + 1;
        }
    }

    /**
     * This method is called for question 2.
     */
    private void quizTwo() {
        RadioButton Question2 = (RadioButton) findViewById(R.id.date2_rb);
        boolean right2 = Question2.isChecked();
        if (right2) {
            points = points + 1;
        }
    }

    /**
     * This method is called for question 3.
     */
    private void quizThree() {
        CheckBox box1 = (CheckBox) findViewById(R.id.option_a_cb);
        CheckBox box2 = (CheckBox) findViewById(R.id.option_b_cb);
        CheckBox box3 = (CheckBox) findViewById(R.id.option_c_cb);
        CheckBox box4 = (CheckBox) findViewById(R.id.option_d_cb);

        boolean check1 = box1.isChecked() & box3.isChecked();
        if (check1) {
            points = points + 1;
        }
    }

    /**
     * This method is called for question 4.
     */
    private void quizFour() {
        RadioButton Question4 = (RadioButton) findViewById(R.id.quiz4_d_rb);
        boolean right4 = Question4.isChecked();
        if (right4) {
            points = points + 1;
        }
    }

    /**
     * This method is called for question 5.
     */
    private void quizFive() {
        EditText Question5 = (EditText) findViewById(R.id.answerText5_et);
        String userEntry = Question5.getText().toString();
        if (userEntry.equals(q5)) {
            points = points + 1;
        }
    }

    /**
     * This method is called for question 6.
     */
    private void quizSix() {
        RadioButton Question6 = (RadioButton) findViewById(R.id.quiz6_a_rb);
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
        EditText nameField = (EditText) findViewById(R.id.enterName_et);
        String enterName = nameField.getText().toString();
        String text;
        text = enterName + getString(R.string.scoreIs) + points + getString(R.string.exclamation);
        if (points <= 1) {
            text += getString(R.string.wipeout);
        } else if (points <= 3) {
            text += getString(R.string.doItBetter);
        } else if (points <= 5) {
            text += getString(R.string.Excellent);
        } else if (points <= 6) {
            text += getString(R.string.authentic);
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
        ((RadioGroup) findViewById(R.id.quiz1_rg)).clearCheck();
        ((RadioGroup) findViewById(R.id.quiz2_rg)).clearCheck();
        ((CheckBox) findViewById(R.id.option_a_cb)).setChecked(false);
        ((CheckBox) findViewById(R.id.option_b_cb)).setChecked(false);
        ((CheckBox) findViewById(R.id.option_c_cb)).setChecked(false);
        ((CheckBox) findViewById(R.id.option_d_cb)).setChecked(false);
        ((RadioGroup) findViewById(R.id.quiz4_rg)).clearCheck();
        ((EditText) findViewById(R.id.answerText5_et)).getText().clear();
        ((RadioGroup) findViewById(R.id.quiz6_rg)).clearCheck();
    }
}