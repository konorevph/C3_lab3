package Queue.ADTList;
import BasedOnArrayList.List;
import BasedOnArrayList.Position;
import ListElems.PostalDelivery;
import MyExceptions.ExceedingListLimitException;
import Queue.QueueInterface;

public class Queue implements QueueInterface {
    private final List list;
    public Queue() {
        list = new List();
    }
    @Override
    public void enqueue(PostalDelivery x) {
        list.Insert(list.End(), x);
    }

    @Override
    public PostalDelivery dequeue() {
        if (list.First().equals(list.End())) throw new ExceedingListLimitException("Queue is empty");
        PostalDelivery result = list.Retrieve(list.First());
        list.Delete(list.First());
        return result;
    }

    @Override
    public PostalDelivery front() {
        if (list.First().equals(list.End())) throw new ExceedingListLimitException("Queue is empty");
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
        String result = "";
        for (Position p = list.First(); !p.equals(list.End()); p = list.Next(p)) {
            result += list.Retrieve(p).toString() + '\n';
        }
        return result;
    }
}
