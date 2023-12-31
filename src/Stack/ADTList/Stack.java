package Stack.ADTList;

import BasedOnArrayList.*;
import ListElems.PostalDelivery;
import MyExceptions.ExceedingListLimitException;
import Stack.StackInterface;

public class Stack implements StackInterface {
    List list;

    public Stack(){
        list = new List();
    }
    @Override
    public void push(PostalDelivery x) {
        list.Insert(list.First(), x);
    }

    @Override
    public PostalDelivery pop() {
        if (empty()) throw new ExceedingListLimitException("Stack is empty");
        PostalDelivery result = list.Retrieve(list.First());
        list.Delete(list.First());
        return result;
    }

    @Override
    public PostalDelivery top() {
        if (empty()) throw new ExceedingListLimitException("Stack is empty");
        return list.Retrieve(list.First());
    }

    @Override
    public boolean empty() {
        return list.First().equals(list.End());
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void makeNull() {
        list.MakeNull();
    }

    public String toString() {
        Position position = list.First();
        String result = "";
        while (!position.equals(list.End())) {
            result += list.Retrieve(position) + "\n";
            position = list.Next(position);
        }
        return result;
    }
}
