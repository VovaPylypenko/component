import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Collection collection = new Collection(5);
        collection.printArray();

        System.out.println(collection.add(100));
        System.out.println(collection.add(1));
        System.out.println(collection.add(150));
        System.out.println(collection.add(170));
        System.out.println(collection.add(180));
        System.out.println(collection.add(190));
        System.out.println();
        collection.printArray();

        Stack stack = new Stack(5);
        System.out.println(stack.add(100));
        System.out.println(stack.add(1));
        System.out.println(stack.add(110));
        System.out.println(stack.add(120));
        System.out.println(stack.add(180));
        System.out.println(stack.add(190));
        System.out.println();
        stack.printArray();

        Queue queue = new Queue(5);
        System.out.println(queue.add(100));
        System.out.println(queue.add(10));
        System.out.println(queue.add(110));
        System.out.println(queue.add(120));
        System.out.println(queue.add(200));
        System.out.println(queue.add(201));
        System.out.println();
        queue.printArray();

        Class<Collection> collectionClass = Collection.class;
        System.out.println(collectionClass.getSuperclass().getName()); //superclass name
        Method[] declaredMethods = collectionClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method); //all method info
        }
        System.out.println();

        Class<Stack> stackClass = Stack.class;
        System.out.println(stackClass.getSuperclass().getName());
        Method[] declaredMethods2 = stackClass.getDeclaredMethods();
        for (Method method : declaredMethods2) {
            System.out.println(method);
        }
        System.out.println();

        Class<Queue> queueClass = Queue.class;
        System.out.println(queueClass.getSuperclass().getName());
        Method[] declaredMethods3 = queueClass.getDeclaredMethods();
        for (Method method : declaredMethods3) {
            System.out.println(method);
        }
        System.out.println();

        try {
            Task3 task3 = new Task3("Collection");
            task3.run();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}