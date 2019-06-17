import java.util.Arrays;

public class Queue extends Stack {

    Queue() {
        super();
    }

    Queue(int newSize) {
        super(newSize);
    }

    @Override
    public boolean add(int item) {
        boolean isAdd = super.add(item);
        if(!isAdd) {
            for (int i = size-1; i > 0; i--) {
                array[i] = array[i-1];
            }
            array[0] = item;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
