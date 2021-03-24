package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chy
 * @Date: 2021/1/21 13:03
 * @Description:
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer task1 = new Task1();
        Observer task2 = new Task2();
        subject.addObserver(task1);
        subject.addObserver(task2);
        subject.notifyObserver("1111");
    }
}

class Subject {
    private List<Observer> container = new ArrayList<>();

    public void addObserver(Observer observer) {
        container.add(observer);
    }
    public void removeObserver(Observer observer) {
        container.remove(observer);
    }
    public void notifyObserver(Object object) {
        for (Observer observer: container) {
            observer.update(object);
        }
    }
}

interface Observer {
    void update(Object object);
}


class Task1 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println(" Task1 received: " + object);
    }
}

class Task2 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println(" Task2 received: " + object);
    }
}