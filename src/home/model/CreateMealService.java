package home.model;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * Create a background thread that will run a task to add an Recipe / Meal to the meal database
 * using the JavaFX service to manage the thread
 */

public class CreateMealService extends Service<Integer> {

    private Recipe currentRecipe;

    public CreateMealService(Recipe aRecipe){
        currentRecipe = aRecipe;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task() {
            @Override
            protected Integer call() throws Exception {
                //get the singleton
                Datasource anInstance = Datasource.getInstance();
                return anInstance.saveMeal(currentRecipe);
            };
        };
    }
}
