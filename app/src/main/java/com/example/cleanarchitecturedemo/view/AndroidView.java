package com.example.cleanarchitecturedemo.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cleanarchitecturedemo.R;


public class AndroidView extends AppCompatActivity {

    private LowerCaseViewModel lowerCaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add observer to view.
        observeViewModel();

        TextView outputField = findViewById(R.id.textViewScreen);
        outputField.setText(lowerCaseViewModel.getUserInput().getValue());
    }

    // Method thats gonna be called when the print Button is pressed.
    public void printEditText(View view) {
        EditText inputField = findViewById(R.id.editTextViewXml);
        String input = inputField.getText().toString();
        lowerCaseViewModel.setUserInput(input);
    }

    private void observeViewModel(){
        lowerCaseViewModel = new LowerCaseViewModel();
        final Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView outputField = findViewById(R.id.textViewScreen);
                outputField.setText(s);
            }
        };
        lowerCaseViewModel.getUserInput().observe(this,stringObserver);
    }
}