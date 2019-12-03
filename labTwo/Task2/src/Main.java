
public class Main {
    public static void main(String[] args) {
        Queue queueOne = new Queue();
        Queue queueTwo = new Queue(4);

        queueOne.push(8);
        queueOne.push(6);
        queueOne.push(4);
        queueOne.push(2);
        queueOne.push(0);
        queueOne.push(-2);

        int number = queueOne.pop();

        System.out.println("Popped number: " + number);
        System.out.println(queueOne.isEmpty());
        System.out.println(queueOne.isFull());

        System.out.println();

        queueTwo.push(5);
        queueTwo.push(10);
        queueTwo.push(16);
        queueTwo.push(-7);
        queueTwo.push(1);

        number = queueTwo.pop();
        System.out.println("Popped number: " + number);

        System.out.println(queueTwo.isEmpty());
        System.out.println(queueTwo.isFull());
    }
}
