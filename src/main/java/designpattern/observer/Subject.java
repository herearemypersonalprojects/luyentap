package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observerList = new ArrayList<>();

    private String value;

    public Subject() {
        value = "init";
    }

    public void addListener(Observer observer) {
        observerList.add(observer);
    }

    public void setValue(String value) {
        this.value = value;
        notify2Observers(value);
    }

    private void notify2Observers(String value) {
        for (Observer observer : observerList) {
            observer.update(value);
        }
    }

}
