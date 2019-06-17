package lab3;

import java.util.ArrayList;

public class Lab3Presenter implements Lab3PresenterInterface {

    private Lab3Model model = new Lab3Model();
    private Lab3ViewInterface view;

    public Lab3Presenter(Lab3ViewInterface view) {
        this.view = view;
    }

    public void generateStructures(ArrayList<Integer> numbers) {
        model.generateStructures(numbers);
    }

    public void getStructures() {
        view.snowStructures(model.getCollections());
    }

}
