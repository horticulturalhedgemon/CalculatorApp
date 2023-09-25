package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    TextView textView;
    String num1;
    String num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        textView=(TextView) findViewById(R.id.textView2);
        Intent intent=getIntent();
        String str = intent.getStringExtra("message");
        num1 = intent.getStringExtra("num1");
        num2 = intent.getStringExtra("num2");
        textView.setText(str);
    }
    public void onClick(View view){
        goToActivity();
    }
    public void goToActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("num1",num1);
        intent.putExtra("num2",num2);
        startActivity(intent);
    }

}