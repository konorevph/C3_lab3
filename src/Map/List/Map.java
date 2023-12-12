package Map.List;

import Map.MapInterface;

public class Map implements MapInterface{
    private static class Item {
        private char[] name;
        private char[] address;
        private Item next;
        public Item(char[] name, char[] address) {
            this.name = name;
            this.address = address;
        }
        public Item(char[] name, char[] address, Item next) {
            this.name = name;
            this.address = address;
            this.next = next;
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

        // Цикл по списку
        Item tmp = head, prev = null;
        while (tmp != null) {
            // Если d определено, то заменяем для него значение
            if (arrayEquals(tmp.name, d)) {
                tmp.address = r;
                return;
            }
            prev = tmp;
            tmp = tmp.next;
        }

        // Если d не определено
        prev.next = new Item(d, r);
    }

    /*
    Истина, если M(d) определено. В r записывается значение M(d).
     */
    @Override
    public boolean compute(char[] d, char[] r) {
        // Цикл по списку
        Item tmp = head;
        while (tmp != null) {
            //Если d определено, вставляем в r его значение и выводим true
            if (arrayEquals(tmp.name, d)) {
                System.arraycopy(tmp.address, 0, r, 0, tmp.address.length);
                return true;
            }
            tmp = tmp.next;
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
