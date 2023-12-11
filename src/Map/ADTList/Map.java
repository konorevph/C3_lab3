package Map.ADTList;

import BasedOnArrayList.*;
import ListElems.PostalDelivery;
import Map.MapInterface;

public class Map implements MapInterface{
    private List list = new List();
    @Override
    public void assign(char[] d, char[] r) {
        PostalDelivery postalDelivery = new PostalDelivery(d, r);
        Position position = list.First();

        while (!position.equals(list.End())) {
            if (arrayEquals(list.Retrieve(position).name, d)) {
                list.Insert(position, postalDelivery);
                list.Delete(list.Next(position));
                return;
            }
            position = list.Next(position);
        }

        list.Insert(position, postalDelivery);
    }

    @Override
    public boolean compute(char[] d, char[] r) {
        Position position = list.First();
        while (!position.equals(list.End())) {
            PostalDelivery postalDelivery = list.Retrieve(position);
            if (arrayEquals(postalDelivery.name, d)) {
                System.arraycopy(postalDelivery.address, 0, r, 0, r.length);
                return true;
            }
            position = list.Next(position);
        }
        return false;
    }

    @Override
    public void makeNull() {
        list.MakeNull();
    }

    public String toString() {
        String result = "";
        Position position = list.First();
        while (!position.equals(list.End())) {
            PostalDelivery postalDelivery = list.Retrieve(position);
            result += "Name: ";
            for (char c : postalDelivery.name) {
                result += c;
            }
            result += "; address: ";
            for (char c : postalDelivery.address) {
                result += c;
            }
            result += '\n';
            position = list.Next(position);
        }
        return result;
    }

    private boolean arrayEquals(char[] A, char[] B) {
        if (A.length != B.length) return false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) return false;
        }
        return true;
    }
}
