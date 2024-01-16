package Map.List;

import Map.MapInterface;

public class Map implements MapInterface{
    private static class Item {
        private char[] name;
        private char[] address;
        private Item next;
        public Item(char[] name, char[] address) {
            this.name = new char[name.length];
            this.address = new char[address.length];
            System.arraycopy(name, 0, this.name, 0, name.length);
            System.arraycopy(address, 0, this.address, 0, name.length);
        }
    }

    private Item head;

    /*
    Не зависимо от существования в отображении d, устанавливаем M(d) = r
     */
    @Override
    public void assign(char[] d, char[] r) {
        // Если список пуст
        if (head == null) {
            head = new Item(d, r);
            return;
        }

        if (arrayEquals(head.name, d)) {
            System.arraycopy(r, 0, head.address, 0, r.length);
            return;
        }

        // Цикл по списку
        Item prev = findPrevious(d);
        if (prev.next != null) {
            System.arraycopy(r, 0, prev.next.address, 0, r.length);
            return;
        }
        // Если d не определено
        prev.next = new Item(d, r);
    }

    /*
    Истина, если M(d) определено. В r записывается значение M(d).
     */
    @Override
    public boolean compute(char[] d, char[] r) {
        if (head == null) return false;
        if (arrayEquals(head.name, d)) {
            System.arraycopy(head.address, 0, r, 0, head.address.length);
            return true;
        }
        // Цикл по списку
        Item prev = findPrevious(d);
        if (prev.next != null) {
            System.arraycopy(prev.next.address, 0, r, 0, prev.next.address.length);
            return true;
        }
        return false;
    }

    /*
    Очищаем отображение.
     */
    @Override
    public void makeNull() {
        head = null;
    }

    public String toString() {
        String result = "";
        Item tmp = head;
        while (tmp != null) {
            result += "Name: ";
            for (char c : tmp.name) {
                result += c;
            }
            result += "; address: ";
            for (char c : tmp.address) {
                result += c;
            }
            result += '\n';
            tmp = tmp.next;
        }
        return result;
    }

    private Item findPrevious(char[] d) {
        Item prev = head, tmp = head.next;
        while (tmp != null){
            if (arrayEquals(d, tmp.name)) break;
            prev = tmp;
            tmp = tmp.next;
        }
        return prev;
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
