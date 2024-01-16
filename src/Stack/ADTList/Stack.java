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

    // Копия создаётся в Insert
    @Override
    public void push(PostalDelivery x) {
        list.Insert(list.First(), x);
    }

    // Возвращает оригинал
    @Override
    public PostalDelivery pop() {
        PostalDelivery result = list.Retrieve(list.First());
        list.Delete(list.First());
        return result;
    }

    // Возвращает копию
    @Override
    public PostalDelivery top() {
        return new PostalDelivery(list.Retrieve(list.First()));
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
