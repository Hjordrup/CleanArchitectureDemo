package com.example.cleanarchitecturedemo.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cleanarchitecturedemo.model.Model;

public class LowerCaseViewModel extends ViewModel {

    private final MutableLiveData<String> userInput = new MutableLiveData<>();
    private Model logic = new Model();

    public LowerCaseViewModel(){
    observeLogic(logic);
    userInput.setValue(getLowerCaseInput(logic.getData()));
    }

    private void observeLogic(final Model logic) {
        logic.addDataObserver(new Model.DataObserver() {
            @Override
            public void update() {
                String data = logic.getData();
                userInput.setValue(getLowerCaseInput(data));
            }
        });
    }

    private String getLowerCaseInput(String userInput){
        return userInput.toLowerCase();
    }

    public void setUserInput(String userInput){
        logic.setData(userInput);
    }

    public MutableLiveData<String> getUserInput() {
        return userInput;
    }
}
