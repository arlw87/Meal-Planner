package home.model;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * Create a background thread that will run a task to add an ingredient to the meal database
 * using the JavaFX service to manage the thread
 */

public class CreateIngredientService extends Service<Integer> {

    private Ingredient ingredient;

    public CreateIngredientService(Ingredient anIngredient){
        ingredient = anIngredient;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                //get singleton of datasource
                Datasource instance = Datasource.getInstance();
                int recordCreatedID = instance.insertIngredientData(ingredient);
                return recordCreatedID;
            }
        };
    }
}
