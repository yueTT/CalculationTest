package com.example.android.calculationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method for the submit button
    public void submit(View view) {
        question_radio(R.id.radio_group_qs1, "2");
        question2();
        question3();
        question_radio(R.id.radio_group_qs4, "13");
        Toast.makeText(this, "total points :" + points, Toast.LENGTH_SHORT).show();
        points = 0;
    }

    //method for question 1
    private void question_radio(int id, String str) {
        RadioGroup group = (RadioGroup) findViewById(id);
        RadioButton rb_01 = (RadioButton) findViewById(group.getCheckedRadioButtonId());
        String qs1 = rb_01.getText().toString();
        if (qs1.equals(str)) {
            points = points + 1;
        }
    }

    // method for question 2
    private void question2() {
        CheckBox cb03 = (CheckBox) findViewById(R.id.q2_checkbox_03);
        CheckBox cb02 = (CheckBox) findViewById(R.id.q2_checkbox_02);
        CheckBox cb01 = (CheckBox) findViewById(R.id.q2_checkbox_01);
        if (cb03.isChecked()) {
            return;
        } else {
            if (cb01.isChecked() && cb02.isChecked()) {
                points += 1;
            }
        }
    }

    //method of question 3
    private void question3() {
        EditText etx = (EditText) findViewById(R.id.q3_edittext_x);
        EditText ety = (EditText) findViewById(R.id.q3_edittext_y);
        String x = etx.getText().toString();
        String y = ety.getText().toString();
        if (x.equals("2")) {
            if (y.equals("3")) {
                points += 1;
            }
        } else {
            if (x.equals("3")) {
                if (y.equals("2")) {
                    points += 1;
                }
            }
        }
    }

}
