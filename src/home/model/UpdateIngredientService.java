package home.model;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * Create a background thread that will update an ingredients in the meal database
 * using the JavaFX service to manage the thread
 */

public class UpdateIngredientService extends Service {

    private Ingredient updatedIngredient;

    public UpdateIngredientService(Ingredient anIngredient) {
        updatedIngredient = anIngredient;
    }

    @Override
    protected Task createTask() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                //Datasource is a singleton
                Datasource instance = Datasource.getInstance();
                instance.updateIngredient(updatedIngredient);
                return null;
            }
        };
    }
}
