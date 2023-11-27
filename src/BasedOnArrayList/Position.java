package BasedOnArrayList;

public class Position {

    //В массиве позиция = целочисленное значение
    public int i;

    //Конструктор
    public Position(int i){
        this.i = i;
    }

    public boolean equals(Position position) {
        return i == position.i;
    }
}
