package home.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

/**
 * Create a background thread that will read and return all Recipes / Meals from the meal database
 * using the JavaFX service to manage the thread
 */

public class LoadAllRecipesService extends Service<ObservableList<Recipe>> {

    @Override
    protected Task<ObservableList<Recipe>> createTask() {
        return new Task<ObservableList<Recipe>>() {
            @Override
            protected ObservableList<Recipe> call() throws Exception {
                //Datasource is a singleton
                List<Recipe> allRecipes = Datasource.getInstance().loadRecipes();
                return FXCollections.observableArrayList(allRecipes);
            }
        };
    }
}
