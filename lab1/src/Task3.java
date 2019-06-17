import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task3 {

    private Class aClass;

    public Task3(String className) throws ClassNotFoundException {
        aClass = Class.forName(className);
    }

    public Task3(Class aClass) {
        this.aClass = aClass;
    }

    public void run() {
        System.out.println("Class name :");
        System.out.println(aClass.getName());
        System.out.println("Methods :");
        Method[] declaredMethods = aClass.getMethods();
        for(Method method : declaredMethods)
            System.out.println(method);
        System.out.println("Super class :");
        System.out.println(aClass.getSuperclass());
        Collection collection = new Collection(5);

        System.out.println("Annotation!");

        for (Method method : declaredMethods) {
            try {
                if(method.isAnnotationPresent(MyAnnotation.class)) {
                    System.out.println("method: " + method.getName());
                    method.invoke(collection);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}