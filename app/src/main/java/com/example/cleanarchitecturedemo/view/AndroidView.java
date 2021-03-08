package com.example.cleanarchitecturedemo.view;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.cleanarchitecturedemo.R;


public class AndroidView extends AppCompatActivity {

    private LowerCasePresenter lowerCaseViewModel = new LowerCasePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add observer to view.
        observeViewModel();

        TextView outputField = findViewById(R.id.textViewScreen);
        outputField.setText(lowerCaseViewModel.getUserInput());
    }



    // Method thats gonna be called when the print Button is pressed.
    public void printEditText(View view) {
        EditText inputField = findViewById(R.id.editTextViewXml);
        String input = inputField.getText().toString();
        lowerCaseViewModel.setUserInput(input);
    }

    private void observeViewModel() {
        lowerCaseViewModel.addLowerCaseObserver(new LowerCasePresenter.LowerCaseObserver() {
            @Override
            public void update() {
                String data = lowerCaseViewModel.getUserInput();
                TextView outputView = (TextView) findViewById(R.id.textViewScreen);
                outputView.setText(data);
            }
        });

    }
}