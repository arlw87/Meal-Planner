package home.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

/**
 * Create a background thread that will read and return all Ingredients from the meal database
 * using the JavaFX service to manage the thread
 */

public class LoadIngredientsService extends Service<ObservableList<Ingredient>> {

    @Override
    protected Task<ObservableList<Ingredient>> createTask() {
        return new Task<ObservableList<Ingredient>>() {
            @Override
            protected ObservableList<Ingredient> call() throws Exception {
                //Datasource is a singleton
                List<Ingredient> i = Datasource.getInstance().loadIngredients();
                ObservableList<Ingredient> ingredients = FXCollections.observableList(i);
                return ingredients;
            }
        };
    }
}
