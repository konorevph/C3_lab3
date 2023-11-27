package Queue;
import ListElems.PostalDelivery;

public interface QueueInterface {
    public void enqueue(PostalDelivery x);
    public PostalDelivery dequeue();
    public PostalDelivery front();
    public boolean empty();
    public boolean full();
    public void makeNull();
}
