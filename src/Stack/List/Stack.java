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

    private Item head;

    @Override
    public void push(PostalDelivery x) {
        PostalDelivery copy = new PostalDelivery(x);
        if (head == null) {
            head = new Item(copy);
        } else {
            head = new Item(copy, head);
        }
    }

    @Override
    public PostalDelivery pop() {
        if (head == null) throw new ExceedingListLimitException("Stack is empty");
        PostalDelivery res = head.x;
        head = head.next;
        return res;
    }

    @Override
    public PostalDelivery top() {
        if (head == null) throw new ExceedingListLimitException("Stack is empty");
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
        while (head != null) {
            result += head.toString();
        }
        return result;
    }
}
