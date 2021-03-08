package com.example.cleanarchitecturedemo.view;

import com.example.cleanarchitecturedemo.model.Model;
import java.util.ArrayList;


public class LowerCasePresenter {

    private String userInput;
    private Model logic = new Model();
    private final ArrayList<LowerCasePresenter.LowerCaseObserver> COLLECTIONOFLOWERCASEOBSERVERS = new ArrayList<>();

    public LowerCasePresenter(){
    observeLogic(logic);
    userInput = getLowerCaseInput(logic.getData());
    }

    private void observeLogic(final Model logic) {
        logic.addDataObserver(new Model.DataObserver() {
            @Override
            public void update() {
                String data = logic.getData();
                userInput = getLowerCaseInput(data);
                notifyObservers();
            }
        });
    }

    private String getLowerCaseInput(String userInput){
        return userInput.toLowerCase();
    }

    public void setUserInput(String userInput){
        logic.setData(userInput);
    }

    public String getUserInput() {
        return userInput;
    }


    public interface LowerCaseObserver {
        void update();
    }

    private void notifyObservers() {
        for (LowerCasePresenter.LowerCaseObserver observer : COLLECTIONOFLOWERCASEOBSERVERS) {
            observer.update();
        }
    }

    public void addLowerCaseObserver(LowerCasePresenter.LowerCaseObserver observer) {
        if (!COLLECTIONOFLOWERCASEOBSERVERS.contains(observer))
            COLLECTIONOFLOWERCASEOBSERVERS.add(observer);
    }


}
