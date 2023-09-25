package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            String num1Text = intent.getExtras().getString("num1");
            String num2Text = intent.getExtras().getString("num2");
            TextView num1TextView=(TextView) findViewById(R.id.editTextText);
            TextView num2TextView=(TextView) findViewById(R.id.editTextText);
            num1TextView.setText(num1Text);
            num2TextView.setText(num2Text);
        }
    }
    private boolean checkValid(String i, String j) {
        if (Integer.parseInt(j) == 0) {
            return false;
        }
        return true;
    }
    public void clickAdd(View view){
        EditText num1 = (EditText) findViewById(R.id.editTextText);
        EditText num2 = (EditText) findViewById(R.id.editTextText2);
        //check if int
        //check if div by 0
        goToActivity(Integer.toString(Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString())));
    }
    public void clickSub(View view){
        EditText num1 = (EditText) findViewById(R.id.editTextText);
        EditText num2 = (EditText) findViewById(R.id.editTextText2);
        //check if int
        goToActivity(Integer.toString(Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString())));
    }
    public void clickMult(View view){
        EditText num1 = (EditText) findViewById(R.id.editTextText);
        EditText num2 = (EditText) findViewById(R.id.editTextText2);
        //check if int
        goToActivity(Integer.toString(Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString())));
    }
    public void clickDiv(View view){

        EditText num1 = (EditText) findViewById(R.id.editTextText);
        EditText num2 = (EditText) findViewById(R.id.editTextText2);
        if (!checkValid(num1.getText().toString(),num2.getText().toString())) {
            goToActivity("Error: Divide by zero");
        }
        //check if int
        //check if div by 0
        String doubleAnswer = Double.toString((double)Integer.parseInt(num1.getText().toString()) / (double)Integer.parseInt(num2.getText().toString()));
        String intAnswer = Integer.toString(Integer.parseInt(num1.getText().toString()) / Integer.parseInt(num2.getText().toString()));
        if (doubleAnswer.length() > 3 + intAnswer.length()) {
            goToActivity(doubleAnswer.substring(0,3 + intAnswer.length()));
        }
        else {
            goToActivity(doubleAnswer.substring(0,doubleAnswer.length()-2));
        }

    }
    public void goToActivity(String s){
        Intent intent = new Intent(this,Results.class);
        EditText num1E = (EditText) findViewById(R.id.editTextText);
        EditText num2E = (EditText) findViewById(R.id.editTextText2);
        String num1 = num1E.getText().toString();
        String num2 = num2E.getText().toString();
        intent.putExtra("message",s);
        intent.putExtra("num1",num1);
        intent.putExtra("num2",num2);
        startActivity(intent);
    }
}