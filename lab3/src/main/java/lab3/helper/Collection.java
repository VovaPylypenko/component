package lab3.helper;

import java.util.Arrays;

public class Collection {

    int size;
    int[] array;

    Collection() {
        size = 10;
        initArray();
    }

    public Collection(int newSize) {
        size = newSize;
        initArray();
    }

    private void initArray() {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.MAX_VALUE;
        }
    }

    @MyAnnotation
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
    }

    public int get(int index) {
        if(index >= 0 && index < size) {
            return array[index];
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public boolean add(int item) {
        boolean isAdd = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == Integer.MAX_VALUE) {
                array[i] = item;
                isAdd = true;
                break;
            }
        }
        return isAdd;
    }


    @MyAnnotation
    @Override
    public String toString() {
        return "lab3.helper.Collection{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
