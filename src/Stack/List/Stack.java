package Stack.List;

import ListElems.PostalDelivery;
import MyExceptions.ExceedingListLimitException;
import Stack.StackInterface;
public class Stack implements StackInterface {
    private static class Item {
        private PostalDelivery x;
        private Item next;

        private Item(PostalDelivery x) {
            this.x = x;
        }

        private Item(PostalDelivery x, Item next) {
            this.x = x;
            this.next = next;
        }
    }

    private Item head = null;

    // Пушит копию
    @Override
    public void push(PostalDelivery x) {
        PostalDelivery copy = new PostalDelivery(x);
        head = new Item(copy, head);
    }

    // Возвращает оригинал
    @Override
    public PostalDelivery pop() {
        PostalDelivery res = head.x;
        head = head.next;
        return res;
    }

    // Возвращает копию
    @Override
    public PostalDelivery top() {
        return new PostalDelivery(head.x);
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void makeNull() {
        head = null;
    }

    public String toString() {
        String result = "";
        Item tmp = head;
        while (tmp != null) {
            result += tmp.x.toString() + '\n';
            tmp = tmp.next;
        }
        return result;
    }
}
