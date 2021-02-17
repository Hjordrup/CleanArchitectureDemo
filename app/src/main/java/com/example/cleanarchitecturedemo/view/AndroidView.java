package com.example.cleanarchitecturedemo.view;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.cleanarchitecturedemo.R;
import com.example.cleanarchitecturedemo.model.Model;




public class AndroidView extends AppCompatActivity {


    private Model logic = new Model();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView outputField = findViewById(R.id.textViewScreen);
        outputField.setText(logic.getData());

        EditText inputField = findViewById(R.id.editTextViewXml);
        inputField.setText(logic.getData());


        // Adding a DataObserver and making it set the outputFiels to what the data.model has.
        logic.addDataObserver(new Model.DataObserver() {
            @Override
            public void update() {
                String data = logic.getData();
                TextView outputField = findViewById(R.id.textViewScreen);
                outputField.setText(data);
            }
        });



    }

    // Method thats gonna be called when the print Button is pressed.
    public void printEditText(View view) {
        EditText inputField = findViewById(R.id.editTextViewXml);
        String input = inputField.getText().toString();
        logic.setData(input);

    }





}