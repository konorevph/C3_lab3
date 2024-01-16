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

    // Пушит копию
    @Override
    public void push(PostalDelivery x) {
        array[head++] = new PostalDelivery(x);
    }

    //Возвращает оригинал
    @Override
    public PostalDelivery pop() {
        return array[head--];
    }

    // Возвращает копию
    @Override
    public PostalDelivery top() {
        return new PostalDelivery(array[head]);
    }

    @Override
    public boolean empty() {
        return head == -1;
    }

    @Override
    public boolean full() {
        return head == ARRAY_LENGTH - 1;
    }

    @Override
    public void makeNull() {
        head = 0;
    }

    public String toString() {
        String result = "";
        int i = head - 1;
        while (i != -1) {
            result += array[i--].toString() + '\n';
        }
        return result;
    }
}
