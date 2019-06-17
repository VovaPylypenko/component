import java.util.Arrays;

public class Stack extends Collection {

    Stack() {
        super();
    }

    Stack(int newSize) {
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
        return "Stack{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
