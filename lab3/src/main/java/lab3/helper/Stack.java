package lab3.helper;

import java.util.Arrays;

/**
 * Лабораторна робота №1
 * Мамута Максим, ІП-63, варіант 18
 */

public class Stack extends Collection {

    Stack() {
        super();
    }

    public Stack(int newSize) {
        super(newSize);
    }

    @Override
    public boolean add(int item) {
        boolean isAdd = false;
        for (int i = size-1; i >= 0; i--) {
            if (array[i] == Integer.MAX_VALUE) {
                array[i] = item;
                isAdd = true;
                break;
            }
        }
        return isAdd;
    }

    @Override
    public String toString() {
        return "lab3.helper.Stack{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
