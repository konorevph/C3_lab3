package Queue.Array;
import ListElems.PostalDelivery;
import MyExceptions.ExceedingListLimitException;
import Queue.QueueInterface;

public class Queue implements QueueInterface {
    private final static int ARRAY_LENGTH = 100;
    private final PostalDelivery[] array;
    private int head, tail;

    public Queue() {
        array = new PostalDelivery[ARRAY_LENGTH];
        head = 0;
        tail = 0;
    }
    @Override
    public void enqueue(PostalDelivery x) {
        if (full()) throw new ExceedingListLimitException("Queue is full");
        array[tail] = new PostalDelivery(x);
        tail = next(tail);
    }

    @Override
    public PostalDelivery dequeue() {
        if (empty()) throw new ExceedingListLimitException("Queue is empty");
        PostalDelivery res = array[head];
        head = next(head);
        return res;
    }

    @Override
    public PostalDelivery front() {
        if (empty()) throw new ExceedingListLimitException("Queue is empty");
        return new PostalDelivery(array[head]);
    }

    @Override
    public boolean empty() {
        return tail == head;
    }

    @Override
    public boolean full() {
        return next(tail) == head;
    }

    @Override
    public void makeNull() {
        tail = head;
    }

    private int next(int i) {
        return (i + 1) % ARRAY_LENGTH;
    }

    private int prev(int i) {
        if (i == 0) return ARRAY_LENGTH - 1;
        return i - 1;
    }

    public String toString() {
        String result = "";
        for (int i = head; i != tail; i = next(i)) {
            result += array[i].toString() + '\n';
        }
        return result;
    }
}

