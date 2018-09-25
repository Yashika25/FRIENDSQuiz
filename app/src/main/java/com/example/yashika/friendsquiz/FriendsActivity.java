package com.example.yashika.friendsquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class FriendsActivity extends AppCompatActivity {

    int totalScore = 0;
    Toast checkToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
    }

    /**
     * This function checks if the correct radio button is selected by the user for question 1.
     */
    public void checkQues1() {
        RadioButton r = (RadioButton)findViewById(R.id.question1c);
        if(r.isChecked())
            totalScore++;
    }

    /**
     * This function checks if the correct radio button is selected by the user for question 2.
     */
    public void checkQues2() {
        RadioButton r = (RadioButton)findViewById(R.id.question2b);
        if(r.isChecked())
            totalScore++;
    }

    /**
     * This function checks if the correct radio button is selected by the user for question 3.
     */
    public void checkQues3() {
        RadioButton r = (RadioButton)findViewById(R.id.question3a);
        if(r.isChecked())
            totalScore++;
    }

    /**
     * This function checks if the correct radio button is selected by the user for question 4.
     */
    public void checkQues4() {
        RadioButton r = (RadioButton)findViewById(R.id.question4a);
        if(r.isChecked())
            totalScore++;
    }

    /**
     * This function checks if the correct answer has been filled by the user for question 5.
     */
    private void checkQues5() {
        EditText text = (EditText) findViewById(R.id.question5);
        String value = text.getText().toString();
        if (value.equals("And I just want a million dollars!"))
            totalScore++;
    }

    /**
     * This function checks if the correct radio button is selected by the user for question 6.
     */
    public void checkQues6() {
        RadioButton r = (RadioButton)findViewById(R.id.question6a);
        if(r.isChecked())
            totalScore++;
    }

    /**
     * This function checks if all the correct answers are checked by the user for question 7.
     */
    public void checkQues7() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.question7a);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.question7b);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.question7c);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.question7d);
        if (checkBox1.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked())
            totalScore++;
    }

    /**
     * This function checks if the correct radio button is selected by the user for question 8.
     */
    public void checkQues8() {
        RadioButton r = (RadioButton)findViewById(R.id.question8b);
        if(r.isChecked())
            totalScore++;
    }

    /**
     * This function checks all correct radiobuttons, checkboxes and edit the edit text view with the correct answer and notifies the user using Toast message.
     * @param view (check answers button view)
     */
    public void finalAnswers(View view) {
        RadioButton radio1 = (RadioButton) findViewById(R.id.question1c);
        radio1.setChecked(true);
        RadioButton radio2 = (RadioButton) findViewById(R.id.question2b);
        radio2.setChecked(true);
        RadioButton radio3 = (RadioButton) findViewById(R.id.question3a);
        radio3.setChecked(true);
        RadioButton radio4 = (RadioButton) findViewById(R.id.question4a);
        radio4.setChecked(true);
        EditText text5 = (EditText) findViewById(R.id.question5);
        text5.setText("And I just want a million dollars!", TextView.BufferType.EDITABLE);
        RadioButton radio6 = (RadioButton) findViewById(R.id.question6a);
        radio6.setChecked(true);
        CheckBox check1 = (CheckBox) findViewById(R.id.question7a);
        CheckBox check2 = (CheckBox) findViewById(R.id.question7b);
        CheckBox check3 = (CheckBox) findViewById(R.id.question7c);
        CheckBox check4 = (CheckBox) findViewById(R.id.question7d);
        check1.setChecked(true);
        check2.setChecked(false);
        check3.setChecked(true);
        check4.setChecked(true);
        RadioButton radio8 = (RadioButton) findViewById(R.id.question8b);
        radio8.setChecked(true);
        if(checkToast!=null)
            checkToast.cancel();
        checkToast = Toast.makeText(FriendsActivity.this, "Correct answers have been marked. Please check your answers above.", Toast.LENGTH_LONG);
        checkToast.show();
    }

    /**
     * This function calls function for each question to check if user has selected correct answer and calculates score.
     * On the basis of score Toast message is displayed telling the user if he has cleared the test or not.
     * @param view (submit button view)
     */
    public void submitScore(View view) {
        checkQues1();
        checkQues2();
        checkQues3();
        checkQues4();
        checkQues5();
        checkQues6();
        checkQues7();
        checkQues8();
        if(checkToast!=null) {
            checkToast.cancel();
        }
        if(totalScore > 4) {
            checkToast = Toast.makeText(FriendsActivity.this, "Congo! You passed the quiz. Your score is  " + totalScore + " points.", Toast.LENGTH_LONG);
            checkToast.show();
        }
        else {
            checkToast = Toast.makeText(FriendsActivity.this, "Nice try! Better luck next time.\nYour score is " + totalScore + " points.", Toast.LENGTH_LONG);
            checkToast.show();
        }
        totalScore = 0;
    }
}
