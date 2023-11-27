package Stack.Array;

import ListElems.PostalDelivery;
import MyExceptions.ExceedingListLimitException;
import Stack.StackInterface;

public class Stack implements StackInterface {
    private final static int ARRAY_LENGTH = 100;
    private final PostalDelivery[] array;
    private int head;

    public Stack() {
        array = new PostalDelivery[ARRAY_LENGTH];
        head = 0;
    }
    @Override
    public void push(PostalDelivery x) {
        if (head == 100) throw new ExceedingListLimitException("Stack is full");
        array[head++] = new PostalDelivery(x);
    }

    @Override
    public PostalDelivery pop() {
        if (head == 0) throw new ExceedingListLimitException("Stack is empty");
        return array[head--];
    }

    @Override
    public PostalDelivery top() {
        if (head == 0) throw new ExceedingListLimitException("Stack is empty");
        return new PostalDelivery(array[head]);
    }

    @Override
    public boolean empty() {
        return head == 0;
    }

    @Override
    public boolean full() {
        return head == 100;
    }

    @Override
    public void makeNull() {
        head = 0;
    }

    public String toString() {
        String result = "";
        int i = head - 1;
        while (i != 0) {
            result += array[i--].toString() + '\n';
        }
        return result;
    }
}
