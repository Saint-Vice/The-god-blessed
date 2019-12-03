
import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> values = new ArrayList<>();
     int max = 0;

    public Queue(){}

    public Queue(int maxSize){
        this.max = maxSize;
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }

    void push(int value) {
        if (max == 0 || values.size() < max) {
            values.add(0, value);
            System.out.println("Inserted " + value);
            System.out.println(values);
        } else
            System.out.println("Queue is overloaded");
    }

    int pop() {
        int number = values.get(values.size() - 1);
        values.remove(values.size() - 1);
        System.out.println(values);
        return number;
    }

    public boolean isEmpty() {
        return values.size() == 0;
    }

    public boolean isFull() {
        if (max == 0) {
            System.out.println("Queue cannot be full");
            return false;
        } else {
            return values.size() >= max;
        }
    }
}
