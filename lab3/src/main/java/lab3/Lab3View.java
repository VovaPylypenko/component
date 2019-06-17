package lab3;

import lab3.helper.Collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab3View implements Lab3ViewInterface {

    private Lab3PresenterInterface presenter = new Lab3Presenter(this);

    public void startProgram() {
        System.out.println("Введіть 6 чисел: ");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++) {
            System.out.println("Число номер " + (i+1));
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            numbers.add(n);
        }
        presenter.generateStructures(numbers);
        presenter.getStructures();
    }

    public void snowStructures(ArrayList<Collection> collections) {
        for (Collection c:collections) {
            c.printArray();
        }
    }

}
