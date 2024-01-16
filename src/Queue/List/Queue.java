package Queue.List;
import ListElems.PostalDelivery;
import MyExceptions.ExceedingListLimitException;
import Queue.QueueInterface;

import javax.imageio.event.IIOReadProgressListener;

public class Queue implements QueueInterface {
    private class Item {
        private PostalDelivery x;
        private Item next;

        private Item(PostalDelivery x) {
            this.x = new PostalDelivery(x);
        }

        private Item(PostalDelivery x, Item next) {
            this.x = new PostalDelivery(x);
            this.next = next;
        }
    }

    private Item tail;

    // Сохраняет копию
    @Override
    public void enqueue(PostalDelivery x) {
        PostalDelivery copy = new PostalDelivery(x);
        if (tail == null) {
            tail = new Item(copy);
            tail.next = tail;
        } else {
            tail.next = new Item(copy, tail.next);
            tail = tail.next;
        }
    }

    // Возвращает оригинал
    @Override
    public PostalDelivery dequeue() {
        PostalDelivery result = tail.next.x;
        if (tail == tail.next) {
            tail = null;
        } else  {
            tail.next = tail.next.next;
        }
        return result;
    }

    // Возвращает копию
    @Override
    public PostalDelivery front() {
        return new PostalDelivery(tail.next.x);
    }

    @Override
    public boolean empty() {
        return tail == null;
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void makeNull() {
        tail = null;
    }

    public String toString() {
        if (tail == null) return "";
        Item tmp = tail.next;

        String result = "";
        while (tmp != tail) {
            result += tmp.x.toString()+ '\n';
            tmp = tmp.next;
        }
        return result;
    }
}
