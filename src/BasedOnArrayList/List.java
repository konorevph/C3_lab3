package BasedOnArrayList;

import ListElems.PostalDelivery;
import MyExceptions.ExceedingListLimitException;

public class List {

    //Массив элементов списка
    private PostalDelivery[] array;
    private static final int SIZE = 1000;
    //Первая свободная позиция (после последнего занятого).
    private int end;

    //Конструктор
    public List() {
        /*
        Инициализация массива большим значением
        В position пихаем 0
         */
        array = new PostalDelivery[SIZE];
        end = 0;
    }

    /*
    Задача: Вернуть позицию после последнего элемента списка.
    Параметры: --.
    Результат: Возвращает значение позиции после последнего.
    */
    public Position End(){
        //Выводим сразу нужную позицию, которая храниться в объекте списка
        return new Position(end);
    }

    /*
    Задача: Вставка значения x в позицию p.
    Параметры: p -- позиция элемента, x -- значение.
    Результат: Вставляет в позицию p списка новый элемент.
    */
    public void Insert(Position p, PostalDelivery x){
        /*
        Если индекс не входит в список (меньше 0 или больше первого свободного), то ничего не делаем.
        Если позиция p меньше первой свободной, то сдвигаем члены массива от position до p на 1 вправо
            (используем ShiftBetweenPositions(p, position)).
        Копируем в p значение x
            (копирующий конструктор для класса объекта x)
         */
        if (p.i < 0 || p.i > end) return;
        ShiftForward(p.i);
        array[p.i] = new PostalDelivery(x);
    }

    /*
    Задача: Удалить из позиции p элемент.
    Параметры: p -- позиция удаляемого элемента.
    Результат: Из списка удалена позиция p.
    */
    public void Delete(Position p){
        /*
        Если позиция не входит в список (меньше 0 или >= первому свободному), то игнорируем.
        Если позиция меньше первой свободной - 1, то сдвигаем элементы от p до position на 1 влево
            (используем ShiftBetweenPositions(position, p)).
        Убавляем position на 1
         */
        if (p.i < 0 || p.i >= end) return;
        ShiftBehind(p.i);
    }


    /*
    Задача: Сдвинуть элементы массива с Start до End на 1 в сторону End.
    Параметры: Start -- позиция старта. End -- позиция конца.
    Результат: Значения массива сдвинулись.
    */
    //УБРАТЬ МЕТОД! Либо разделить на 2 (сдвиг вперёд / назад), либо убрать вообще
    private void ShiftBetweenPositions(Position Start, Position End){
        /*
        Если Start == End игнорируем
        Если Start < End
            Обратный цикл (от end до start + 1)
                Переносим адрес объекта из следующего элемента итерации в текущий
        Иначе
            Обратный цикл (от end до start - 1)
                Переносим адрес объекта из следующего элемента итерации в текущий
         */


    }

    private void ShiftForward(int start){
        /*
        С позиции end до start сдвигаем всё вправо
         */

        for (int i = end; i > start; i--){
            array[i] = array[i - 1];
        }

        end += 1;
    }

    private void ShiftBehind(int start){
        /*
        С start + 1 до end сдвигаем всё влево
         */

        for (int i = start; i < end - 1; i++){
            array[i] = array[i + 1];
        }

        end -= 1;
    }


    /*
    Задача: Поиск в списке объекта x
    Параметры: x -- значение объекта
    Результат: Если есть, то позиция искомого объекта, иначе -- End()
    */
    public Position Locate(PostalDelivery x){
        /*
        Цикл по массиву (от 0 до position не включительно)
            Если значение в позиции итерации совпадает с x, то прерываем цикл
            (используем метод сравнения класса объекта)
        Выводим позицию из последней итерации
         */
        int i = 0;
        for (; i < end; i++){
            if (array[i].equals(x)) break;
        }
        return new Position(i);
    }

    public Position Locate(char[] name) {
        int i = 0;
        for (; i < end; i++) {
            int j = 0;
            for (; j < array[i].name.length; j++) {
                if (array[i].name[j] != name[j]) break;
            }
            if (j == array[i].name.length) break;
        }
        return new Position(i);
    }

    /*
    Задача: Вернуть объект в позиции p списка
    Параметры: p -- позиция объекта
    Результат: Возвращает значение объекта, если позиция лежит в списке. Иначе -- исключение
    */
    public PostalDelivery Retrieve(Position p) {
        /*
        Если p < 0 или p >= position выбрасываем исключение
        Иначе выводим значение массива в позиции p
         */

        if (p.i < 0 || p.i >= end)
            throw new ExceedingListLimitException("Retrieve: Позиция отсутствует в списке");
        return array[p.i];
    }

    /*
    Задача: Вернуть первую позицию в списке.
    Параметры: --.
    Результат: Первая позиция списка. Если список пуст, то End().
    */
    public Position First(){
        /*
        Выводим позицию 0
         */
        return new Position(0);
    }

    /*
    Задача: Вернуть следующую за p позицию списка.
    Параметры: p -- позиция.
    Результат: Возвращает позицию следующую за p. Если p == End() или позиции нет в списке, то исключение.
    */
    public Position Next(Position p) {
        /*
        Если p < 0 или p >= position, то исключение
        Иначе выводим p + 1
         */
        if (p.i < 0 || p.i >= end) throw new ExceedingListLimitException("Next: позиция не существует");
        return new Position(p.i + 1);
    }

    /*
    Задача: Вернуть предыдущую перед p позицию списка.
    Параметры: p -- позиция.
    Результат: Возвращает позицию перед p. Если p == 0 или p == End(), то исключение.
    */
    public Position Previous(Position p) {
        /*
        Если p <= 0 или p >= position, то исключение
        Иначе выводим p - 1
         */
        if (p.i <= 0 || p.i >= end) throw new ExceedingListLimitException("Previous: позиция не существует");
        return new Position(p.i - 1);
    }

    /*
    Задача: Обнулить список.
    Параметры: --.
    Результат: Обнуляет список.
    */
    public void MakeNull(){
        /*
        Обнуляем position
         */
        end = 0;
    }

    /*
    Задача: Вывод списка на печать в порядке расположения элементов в списке.
    Параметры: --.
    Результат: Выводит список на печать.
    */
    public void print(){
        /*
        Цикл по массиву (от 0 до position).
            Печатаем значение объекта.
         */
        System.out.println("[");
        for(int i = 0; i < end; i++){
            System.out.println(array[i]);
        }
        System.out.println("]");
    }
}
