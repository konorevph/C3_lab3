import ListElems.PostalDelivery;
import Map.List.Map;
import Queue.ADTList.Queue;
import Stack.List.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 5; i++) {
            PostalDelivery postalDelivery = new PostalDelivery("name " + i, "address " + i);
            stack.push(postalDelivery);
        }
        System.out.println("Stack:\n" + stack);

        Queue queue = new Queue();
        for (int i = 0; i < 5; i++) {
            PostalDelivery postalDelivery = new PostalDelivery("name " + i, "address " + i);
            queue.enqueue(postalDelivery);
        }
        queue.dequeue();
        System.out.println("Queue:\n" + queue);


        System.out.println("Map");
        Map map = new Map();

        PostalDelivery mapItem = new PostalDelivery("name1", "address1");
        map.assign(mapItem.name, mapItem.address);
        mapItem = new PostalDelivery("name1", "address1");
        map.assign(mapItem.name, mapItem.address);
        mapItem = new PostalDelivery("name2", "address2");
        map.assign(mapItem.name, mapItem.address);
        mapItem = new PostalDelivery("name1", "address3");
        map.assign(mapItem.name, mapItem.address);

        char[] address = new char[50];
        map.compute(mapItem.name, address);

        for (char c : address) {
            System.out.print(c);
        }
        System.out.println();
        System.out.println(map);
    }
}