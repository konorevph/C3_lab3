package Map.List;

import ListElems.PostalDelivery;
import Map.MapInterface;

public class Map implements MapInterface{
    private static class Item {
        private PostalDelivery x;
        private Item next;
        public Item(PostalDelivery x) {
            this.x = x;
        }
        public Item(PostalDelivery x, Item next) {
            this.x = x;
            this.next = next;
        }
    }

    private Item head;

    @Override
    public void assign(String d, String r) {
        PostalDelivery postalDelivery = new PostalDelivery(d, r);

        if (head == null) {
            head = new Item(postalDelivery);
            return;
        }

        Item tmp = head, prev = null;
        while (tmp != null) {
            if (arrayEquals(tmp.x.name, postalDelivery.name)) {
                tmp.x.address = postalDelivery.address;
                return;
            }
            prev = tmp;
            tmp = tmp.next;
        }

        prev.next = new Item(postalDelivery);
    }

    @Override
    public boolean compute(String d, String r) {
        PostalDelivery postalDelivery = new PostalDelivery(d, r);

        Item tmp = head;
        while (tmp != null) {
            if (arrayEquals(tmp.x.name, postalDelivery.name)) {
                tmp.x.address = postalDelivery.address;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public void makeNull() {
        head = null;
    }

//    public String toString() {
//        String result = "";
//        Item tmp = head;
//        while (tmp != null) {
//            result += "Name: " + tmp.name.toString() + "; address: " + tmp.address.toString() + '\n';
//            tmp = tmp.next;
//        }
//        return result;
//    }

    // Если используем PostalDelivery
    private boolean arrayEquals(char[] A, char[] B) {
        if (A.length != B.length) return false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) return false;
        }
        return true;
    }
}
