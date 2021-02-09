package com.example.cleanarchitecturedemo;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    public void printEditText(View view) {
        TextView t1 = findViewById(R.id.textViewScreen);
        EditText e1 = findViewById(R.id.editTextViewXml);
        String newText = String.valueOf(e1.getText());
        t1.setText(newText);
    }
}