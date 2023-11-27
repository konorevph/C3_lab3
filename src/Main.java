import ListElems.PostalDelivery;
import Map.List.Map;
import Queue.ADTList.Queue;
import Stack.ADTList.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 5; i++) {
            PostalDelivery postalDelivery = new PostalDelivery("name " + i, "address " + i);
            stack.push(postalDelivery);
        }
        System.out.println(stack);

        Queue queue = new Queue();
        for (int i = 0; i < 5; i++) {
            PostalDelivery postalDelivery = new PostalDelivery("name " + i, "address " + i);
            queue.enqueue(postalDelivery);
        }
        System.out.println(queue);
    }
}