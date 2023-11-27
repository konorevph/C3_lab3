package ListElems;


public class PostalDelivery {

    private static final int NAME_LENGTH = 20;
    private static final int ADDRESS_LENGTH = 50;
    public char[] name;
    public char[] address;

    //Конструктор элемента
    public PostalDelivery(String name, String address){
        /*
        Переводим строки name и address в символьные массивы
         */
        this.name = new char[NAME_LENGTH];
        this.address = new char[ADDRESS_LENGTH];

        for (int i = 0; i < NAME_LENGTH && i < name.length(); i++){
            this.name[i] = name.charAt(i);
        }
        for (int i = 0; i < ADDRESS_LENGTH && i < address.length(); i++){
            this.address[i] = address.charAt(i);
        }
    }

    //Копирующий конструктор
    public PostalDelivery(PostalDelivery postalDelivery){
        /*
        Посимвольно копируем значения name и address в новый объект
         */
        name = new char[NAME_LENGTH];
        address = new char[ADDRESS_LENGTH];
        int i = 0;
        for (; i < NAME_LENGTH; i++){
            name[i] = postalDelivery.name[i];
            address[i] = postalDelivery.address[i];
        }
        for(; i < ADDRESS_LENGTH; i++){
            address[i] = postalDelivery.address[i];
        }
    }

    /*
    Задача: сравнить 2 элемента
    Параметры: postalDelivery -- элемент к сравнению
    Вывод: Если объект вызова равен принимаемому параметру, то true. Иначе false
     */
    public boolean equals(PostalDelivery postalDelivery){
        /*
        Если адреса совпадают, то выводим true
        Иначе проверяем совпадение массивов посимвольно
            Если что-то различается, выводим false
        true
         */
        int i = 0;
        for (; i < NAME_LENGTH; i++){
            if(name[i] != postalDelivery.name[i] || address[i] != postalDelivery.address[i]) return false;
        }
        for (; i < ADDRESS_LENGTH; i++){
            if(address[i] != postalDelivery.address[i]) return false;
        }
        return true;
    }


    /*
    Задача: перевести в текстовой формат
    Параметры: --
    Вывод: строка формата "имя" : "адрес"
     */

    //ИСПРАВИТЬ (не создаём объекты)
    public String toString() {
        return String.format("{\n\tName: %s\n\tAddress: %s\n}", new String(name), new String(address));
    }
}
