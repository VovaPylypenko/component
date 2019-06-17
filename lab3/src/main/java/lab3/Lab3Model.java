package lab3;

import lab3.helper.Collection;
import lab3.helper.MyAnnotation;
import lab3.helper.Queue;
import lab3.helper.Stack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Lab3Model {

    private ArrayList<Collection> collections = new ArrayList<Collection>();

    public void generateStructures(ArrayList<Integer> numbers) {
        Collection collection = new Collection(5);
        collection.printArray();

        for (Integer n:numbers) {
            System.out.println(collection.add(n));
        }
        System.out.println();
        collection.printArray();

        Stack stack = new Stack(5);
        for (Integer n:numbers) {
            System.out.println(stack.add(n));
        }
        System.out.println();
        stack.printArray();

        Queue queue = new Queue(5);
        for (Integer n:numbers) {
            System.out.println(queue.add(n));
        }
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

        for (Method method : declaredMethods) {
            try {
                if(method.isAnnotationPresent(MyAnnotation.class)) {
                    System.out.println(method);
                    method.invoke(collection);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        collections.add(collection);
        collections.add(stack);
        collections.add(queue);
    }

    public ArrayList<Collection> getCollections() {
        return collections;
    }

}
