import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class JUnit5ExampleTest {

    @Test
    void collectionTest() {
        Collection collection = new Collection(5);
        collection.add(10);

        assertEquals(collection.get(0), 10);
        assertEquals(collection.get(1), Integer.MAX_VALUE);
        assertNotEquals(collection.get(0), Integer.MAX_VALUE);
    }

    @Test
    void stackTest() {
        Stack stack = new Stack(5);
        stack.add(10);

        assertEquals(stack.get(0), Integer.MAX_VALUE);
        assertEquals(stack.get(1), Integer.MAX_VALUE);
        assertEquals(stack.get(4), 10);
        assertNotEquals(stack.get(1), Integer.MIN_VALUE);
    }

    @Test
    void queueTest() {
        Queue queue = new Queue(5);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);

        assertEquals(queue.get(0), 60);
        assertEquals(queue.get(1), 50);
        assertEquals(queue.get(2), 40);
        assertEquals(queue.get(3), 30);
        assertEquals(queue.get(4), 20);
        assertNotEquals(queue.get(0), Integer.MAX_VALUE);
    }
}