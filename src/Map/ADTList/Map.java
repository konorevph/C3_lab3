package Map.ADTList;

import BasedOnArrayList.*;
import ListElems.PostalDelivery;
import Map.MapInterface;

public class Map implements MapInterface{
    private List list = new List();

    /*
    Не зависимо от существования в отображении d, устанавливаем M(d) = r
     */
    @Override
    public void assign(char[] d, char[] r) {
        // Создаём объект для вставки в список. Берём позицию начала списка.
        PostalDelivery postalDelivery = new PostalDelivery(d, r);

        // Если список пуст
        if (list.First().equals(list.End())) {
            list.Insert(list.First(), postalDelivery);
            return;
        }

        // Поиск позиции в списке
        Position position = list.Locate(d);
        if (position != null) {
            list.Insert(position, postalDelivery);
            list.Delete(list.Next(position));
            return;
        }

        // Если d не определено в отображении, то создаём новый
        list.Insert(list.End(), postalDelivery);
    }

    /*
    Истина, если M(d) определено. В r записывается значение M(d).
     */
    @Override
    public boolean compute(char[] d, char[] r) {
        Position position = list.Locate(d);

        if (position == null)
            return false;

        PostalDelivery postalDelivery = list.Retrieve(position);
        System.arraycopy(postalDelivery.address, 0, r, 0, r.length);
        return true;
    }

    private Position FindPositionByKey(char[] key) {
        Position position = list.First();
        while (!position.equals(list.End())) {
            if (arrayEquals(list.Retrieve(position).name, key)) {
                return position;
            }
            position = list.Next(position);
        }
        return null;
    }

    /*
    Очищаем отображение.
     */
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

    /*
    Проверка эквивалентности значений массивов
     */
    private boolean arrayEquals(char[] A, char[] B) {
        if (A.length != B.length) return false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) return false;
        }
        return true;
    }
}
