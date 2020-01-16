package designpattern.observer;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addListener(new Observer() {
            @Override
            public void update(String value) {
                System.out.println("value on Listener 1: " + value);
            }
        });

        subject.addListener(new Observer() {
            @Override
            public void update(String value) {
                System.out.println("value on Listener 2: " + value);
            }
        });

        subject.setValue("the first value");
        subject.setValue("the second value");


    }
}
