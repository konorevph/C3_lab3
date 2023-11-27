package Stack;

import ListElems.PostalDelivery;

public abstract interface StackInterface {
    public void push(PostalDelivery x);
    public PostalDelivery pop();
    public PostalDelivery top();
    public boolean empty();
    public boolean full();
    public void makeNull();
}
