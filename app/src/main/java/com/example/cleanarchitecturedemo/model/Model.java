package com.example.cleanarchitecturedemo.model;
import java.util.ArrayList;


public class Model {


    private String data = "Hello";
    private final ArrayList<DataObserver> COLLECTIONOFDATAOBSERVERS = new ArrayList<>();

    public void setData(String data ){
        this.data = data;
        notifyObservers();
    }

    public String getData(){
        return this.data;
    }



    private void notifyObservers() {
        for (DataObserver observer : COLLECTIONOFDATAOBSERVERS) {
            observer.update();
        }
    }

    public void addDataObserver(DataObserver observer) {
        if (!COLLECTIONOFDATAOBSERVERS.contains(observer))
            COLLECTIONOFDATAOBSERVERS.add(observer);
    }

    public interface DataObserver {
        void update();
    }



}
