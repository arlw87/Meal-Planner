package home.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Singleton class to control access to the SQL meals database.
 */

public class Datasource {

    public static final String DATABASE_NAME = "meals.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Andrew\\Programming\\Java\\Programs\\Basic " +
            "Programs\\MealPlanner\\" + DATABASE_NAME;

    //Recipe / Meal table parameters defined.
    public static final String TABLE_RECIPES = "recipes";
    public static final String COLUMN_RECIPES_ID = "_id";
    public static final String COLUMN_RECIPES_MEALNAME = "mealName";
    public static final String COLUMN_RECIPES_METHOD = "method";

    //Ingredients table parameters defined.
    public static final String TABLE_INGREDIENTS = "ingredients";
    public static final String COLUMN_INGRED_ID = "_id";
    public static final String COLUMN_INGRED_INGREDIENT = "ingredientName";
    public static final String COLUMN_INGRED_CALORIES = "calories";
    public static final String COLUMN_INGRED_PROTEIN = "protein";
    public static final String COLUMN_INGRED_CARBS = "carbs";
    public static final String COLUMN_INGRED_SUGAR = "sugar";
    public static final String COLUMN_INGRED_FIBER = "fiber";
    public static final String COLUMN_INGRED_FAT = "fat";
    public static final String COLUMN_INGRED_QUANTITY_NAME = "quantityName";
    public static final String COLUMN_INGRED_SINGLE_QUANTITY_IN_GRAMS = "singleQuantityInGrams";

    //link table links which ingredients are included in which Recipes / Meals and defines how much of that ingredient
    //in grams are in that Recipe / Meal
    public static final String TABLE_LINK = "link";
    public static final String COLUMN_LINK_ID = "_id";
    public static final String COLUMN_LINK_RECIPE_ID = "recipeID";
    public static final String COLUMN_LINK_INGRED_ID = "ingredientsID";
    public static final String COLUMN_LINK_QUANTITY = "ingredeintQuantityInGrams";
    public static final String COLUMN_LINK_QUANTITY_NAME = "QuantityName";

    /*
     * SQL Statements to create tables, add and query data.
     */

    public static final String CREATE_TABLE_RECEIPE = "CREATE TABLE IF NOT EXISTS " + TABLE_RECIPES + " ("
            + COLUMN_RECIPES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RECIPES_MEALNAME + " TEXT, " +
            COLUMN_RECIPES_METHOD + " TEXT)";

    public static final String CREATE_TABLE_INGREDIENTS = "CREATE TABLE IF NOT EXISTS " + TABLE_INGREDIENTS + " ("
            + COLUMN_INGRED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_INGRED_INGREDIENT + " TEXT, " +
            COLUMN_INGRED_CALORIES + " DOUBLE, " + COLUMN_INGRED_PROTEIN + " DOUBLE, " + COLUMN_INGRED_CARBS + " DOUBLE, " +
            COLUMN_INGRED_SUGAR + " DOUBLE, " + COLUMN_INGRED_FIBER + " DOUBLE, " + COLUMN_INGRED_FAT + " DOUBLE, " +
            COLUMN_INGRED_QUANTITY_NAME + " TEXT, " + COLUMN_INGRED_SINGLE_QUANTITY_IN_GRAMS + " DOUBLE)";

    public static final String CREATE_TABLE_LINK = "CREATE TABLE IF NOT EXISTS " + TABLE_LINK + " ("
            + COLUMN_LINK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_LINK_RECIPE_ID + " INT, " +
            COLUMN_LINK_INGRED_ID + " INT, " + COLUMN_LINK_QUANTITY + " DOUBLE)";

    public static final String INSERT_TO_RECIPE_TABLE = "INSERT INTO " + TABLE_RECIPES + "( " + COLUMN_RECIPES_MEALNAME +
    ", " + COLUMN_RECIPES_METHOD + " ) VALUES ( ? , ? )";

    public static final String INSERT_INTO_INGRED_TABLE = "INSERT INTO " + TABLE_INGREDIENTS + "( " + COLUMN_INGRED_INGREDIENT +
            ", " + COLUMN_INGRED_CALORIES + ", " + COLUMN_INGRED_PROTEIN + ", " + COLUMN_INGRED_CARBS +
            ", " + COLUMN_INGRED_SUGAR + ", " + COLUMN_INGRED_FIBER + ", " + COLUMN_INGRED_FAT + ", " +
            COLUMN_INGRED_QUANTITY_NAME + ", " + COLUMN_INGRED_SINGLE_QUANTITY_IN_GRAMS +
            ") VALUES ( ? , ? , ? , ? , ? , ? , ?, ?, ?)";

    public static final String LOAD_INGREDIENTS = "SELECT " + COLUMN_INGRED_ID + ", " + COLUMN_INGRED_INGREDIENT + ", " +
            COLUMN_INGRED_CALORIES + ", " + COLUMN_INGRED_PROTEIN + ", " + COLUMN_INGRED_CARBS + ", " +
            COLUMN_INGRED_SUGAR + ", " + COLUMN_INGRED_FIBER + ", " + COLUMN_INGRED_FAT + ", " +
            COLUMN_INGRED_QUANTITY_NAME + ", " + COLUMN_INGRED_SINGLE_QUANTITY_IN_GRAMS + " FROM " + TABLE_INGREDIENTS;

    public static final String INSERT_INTO_LINK_TABLE = "INSERT INTO " + TABLE_LINK + " (" + COLUMN_LINK_RECIPE_ID +
            ", " + COLUMN_LINK_INGRED_ID + "," + COLUMN_LINK_QUANTITY + " ) VALUES ( ? , ? , ?)";

    public static final String SELECT_ALL_RECIPES = "SELECT " + COLUMN_RECIPES_ID + ", " + COLUMN_RECIPES_MEALNAME +
        ", " + COLUMN_RECIPES_METHOD + " FROM " + TABLE_RECIPES;

    //query the ingredient's IDs for a specified meal
    public static final String SELECT_LINK_WITH_RECIPE_ID = "SELECT " + COLUMN_LINK_INGRED_ID + ", " +
            COLUMN_LINK_QUANTITY + " FROM " + TABLE_LINK +
            " WHERE " + COLUMN_LINK_RECIPE_ID + " = ?";

    public static final String SELECT_SPECIFIC_INGREDRIENTS = "SELECT " + COLUMN_INGRED_INGREDIENT + ", " +
            COLUMN_INGRED_CALORIES + ", " + COLUMN_INGRED_PROTEIN + ", " + COLUMN_INGRED_CARBS + ", " +
            COLUMN_INGRED_SUGAR + ", " + COLUMN_INGRED_FIBER + ", " + COLUMN_INGRED_FAT + ", " +
            COLUMN_INGRED_QUANTITY_NAME + ", " + COLUMN_INGRED_SINGLE_QUANTITY_IN_GRAMS + " FROM " +
            TABLE_INGREDIENTS + " WHERE " + COLUMN_INGRED_ID + " = ?";

    public static final String UPDATE_SPECIFIC_INGREDIENT = "UPDATE " + TABLE_INGREDIENTS + " SET "
            + COLUMN_INGRED_CALORIES + " = ?, " + COLUMN_INGRED_PROTEIN + " = ?, " + COLUMN_INGRED_CARBS +
            " = ?, " + COLUMN_INGRED_SUGAR + " = ?, " + COLUMN_INGRED_FIBER + " = ?, " + COLUMN_INGRED_FAT  +
            " = ?, " + COLUMN_INGRED_QUANTITY_NAME + " = ?, " + COLUMN_INGRED_SINGLE_QUANTITY_IN_GRAMS + " = ? WHERE "
         + COLUMN_INGRED_ID + " = ?";

    private Connection conn;

    //Declare Prepared Statements
    private PreparedStatement create_table_recipes;
    private PreparedStatement create_table_ingrendients;
    private PreparedStatement create_table_link;
    private PreparedStatement insert_recipe_data;
    private PreparedStatement insert_ingred_data;
    private PreparedStatement load_all_ingredients;
    private PreparedStatement insert_link_data;
    private PreparedStatement select_recipes;
    private PreparedStatement select_ingred_id_with_recipe_id;
    private PreparedStatement select_ingredients;
    private PreparedStatement update_ingredient;


    //List of prepared statements for ease of closing
    List<PreparedStatement> preparedStatements = new ArrayList<>();

    // Make this class a singleton
    private static Datasource instance = new Datasource();
    private Datasource(){}
    public static Datasource getInstance(){
        return instance;
    }

    /**
     * Open or create the database
     * Initialised Prepared Statements go here. This improves the performance of the database.
     * @return True if the database opens successfully. False if it does not.
     */

    public boolean open(){
        try{
            System.out.println(CONNECTION_STRING);

            //create the connection to the database
            conn = DriverManager.getConnection(CONNECTION_STRING);

            //Initial Prepared Statements when the database opens
            //Improves dB performance. Code Reusability and security.
            create_table_recipes = conn.prepareStatement(CREATE_TABLE_RECEIPE);
            create_table_ingrendients = conn.prepareStatement(CREATE_TABLE_INGREDIENTS);
            create_table_link = conn.prepareStatement(CREATE_TABLE_LINK);
            insert_recipe_data = conn.prepareStatement(INSERT_TO_RECIPE_TABLE, Statement.RETURN_GENERATED_KEYS);
            insert_ingred_data = conn.prepareStatement(INSERT_INTO_INGRED_TABLE, Statement.RETURN_GENERATED_KEYS);
            load_all_ingredients = conn.prepareStatement(LOAD_INGREDIENTS);
            insert_link_data = conn.prepareStatement(INSERT_INTO_LINK_TABLE);
            select_recipes = conn.prepareStatement(SELECT_ALL_RECIPES);
            select_ingred_id_with_recipe_id = conn.prepareStatement(SELECT_LINK_WITH_RECIPE_ID);
            select_ingredients = conn.prepareStatement(SELECT_SPECIFIC_INGREDRIENTS);
            update_ingredient = conn.prepareStatement(UPDATE_SPECIFIC_INGREDIENT);

            //add all prepared statements to the preparedStatement list for ease of closing
            preparedStatements.add(create_table_ingrendients);
            preparedStatements.add(create_table_link);
            preparedStatements.add(create_table_recipes);
            preparedStatements.add(insert_recipe_data);
            preparedStatements.add(insert_ingred_data);
            preparedStatements.add(load_all_ingredients);
            preparedStatements.add(select_recipes);
            preparedStatements.add(select_ingred_id_with_recipe_id);
            preparedStatements.add(select_ingredients);
            preparedStatements.add(update_ingredient);

            //database has opened correctly return true
            return true;
        } catch (SQLException e){
            System.out.println("Cant connect to the database: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Closes the database.
     * All objects needs to be closed in reverse order to what they were opened with.
     */
    public void close(){
        try{
            //loop through all prepared statements and close them if needed.
            for (PreparedStatement p: preparedStatements){
                if (p != null){
                    p.close();
                }
            }

            //close the connection to the database
            if (conn != null){
                conn.close();
            }

        } catch (SQLException e){
            System.out.println("Unable to close the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Create the three database tables if they do not exist already
     */
    public void createTables(){
        System.out.println(CREATE_TABLE_RECEIPE);
        System.out.println(CREATE_TABLE_INGREDIENTS);
        System.out.println(CREATE_TABLE_LINK);

        try{
            create_table_ingrendients.execute();
            create_table_recipes.execute();
            create_table_link.execute();
        } catch (SQLException e){
            System.out.println("Issue when creating tables: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Save a new Recipe / Meal to the database
     * @param newRecipe Recipe / Meal object passed to this method to be saved to the database
     * @return The id of the newly saved meal in the database
     */

    public Integer saveMeal(Recipe newRecipe){
        int index;
        try{
            //insert Recipe / Meal into Recipe / Meal table and get new id
            insert_recipe_data.setString(1, newRecipe.getName());
            insert_recipe_data.setString(2, newRecipe.getMethod());
            int affectcedRows = insert_recipe_data.executeUpdate();
            System.out.println("saveMeal Number of Recipe Records inserted: " + affectcedRows);
            if (affectcedRows != 1){
                throw new SQLException("Couldnt insert new recipe into the database");
            }
            ResultSet generatedKeys = insert_recipe_data.getGeneratedKeys();
            if (generatedKeys.next()){
                index = generatedKeys.getInt(1);
            } else {
                index = 0;
                new SQLException("No index value for recipe insert returned");
            }
            System.out.println("saveMeal id of the Recipe returned: " + index);

            //now add the recipe id and the corresponding ingredients to the link table
            for (Ingredient i: newRecipe.getIngredients()){
                insert_link_data.setInt(1, index);
                insert_link_data.setInt(2, i.getId());
                insert_link_data.setDouble(3, i.getQuantityInGrams());
                insert_link_data.execute();
            }

            //return the recipe id
            return index;

        } catch (SQLException e){
            System.out.println("There was a problem inserting data into the receiple table: " + e.getMessage());
            e.printStackTrace();
            return -1;
        } catch (Exception e){
            System.out.println("There has been a problem with saving a new recipe");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Insert a new ingredient into the ingredient table of the database
     * @param ingred Ingredient to insert into the database
     * @return The id of the row of the newly inserted database
     */

    public int insertIngredientData(Ingredient ingred){
        System.out.println(INSERT_INTO_INGRED_TABLE);
        int index;
        try{
            insert_ingred_data.setString(1, ingred.getName());
            insert_ingred_data.setDouble(2, ingred.getCalorie());
            insert_ingred_data.setDouble(3, ingred.getProtein());
            insert_ingred_data.setDouble(4, ingred.getCarbs());
            insert_ingred_data.setDouble(5, ingred.getSugar());
            insert_ingred_data.setDouble(6, ingred.getFiber());
            insert_ingred_data.setDouble(7, ingred.getFat());
            insert_ingred_data.setString(8, ingred.getQuantityName());
            insert_ingred_data.setDouble(9, ingred.getSingleQuantityInGrams());
            int affectcedRows = insert_ingred_data.executeUpdate();

            System.out.println("Ingredient Number of Recipe Records inserted: " + affectcedRows);
            if (affectcedRows != 1){
                throw new SQLException("Couldnt insert new ingredient into the database");
            }

            ResultSet generatedKeys = insert_ingred_data.getGeneratedKeys();
            if (generatedKeys.next()){
                index = generatedKeys.getInt(1);
            } else {
                index = 0;
                new SQLException("No index value for recipe insert retuned");
            }

            return index;

        } catch (SQLException e){
            System.out.println("There was a problem inserting data into the ingredients table " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Query and return all the ingredients in the ingredients table from the database
     * @return A list of all the ingredients from the ingredients database
     */

    public List<Ingredient> loadIngredients(){
        System.out.println(LOAD_INGREDIENTS);
        List<Ingredient> ingredients = new ArrayList<>();

        try{
            ResultSet results = load_all_ingredients.executeQuery();

            while (results.next()){
                int id = results.getInt(1);
                String name = results.getString(2);
                double calories = results.getDouble(3);
                double protein = results.getDouble(4);
                double carbs = results.getDouble(5);
                double sugar = results.getDouble(6);
                double fiber = results.getDouble(7);
                double fat = results.getDouble(8);
                String quantityName = results.getString(9);
                double singleQuantityInGrams = results.getDouble(10);

                Ingredient newIngredient = new Ingredient(id, name, calories, protein, carbs, sugar, fiber, fat);
                newIngredient.setQuantityName(quantityName);
                newIngredient.setSingleQuantityInGrams(singleQuantityInGrams);

                ingredients.add(newIngredient);
            }

            return ingredients;

        } catch (SQLException e){
            System.out.println("Could not load ingredients: " + e.getMessage());
            return null;
        }
    }

    /**
     * Query and return a list of all the Recipes / Meals in the Recipe table of the database
     * @return list of all the recipes
     */

    public List<Recipe> loadRecipes(){
        List<Recipe> allRecipes = new ArrayList<>();
        System.out.println(SELECT_ALL_RECIPES);
        try{
            ResultSet results = select_recipes.executeQuery();
            while (results.next()){
                int id = results.getInt(1);
                String name = results.getString(2);
                String method = results.getString(3);
                List<Ingredient> ingredients = getIngredientsForRecipe(id);
                Recipe loadedRecipe = new Recipe(id, name, method, ingredients);
                allRecipes.add(loadedRecipe);
            }
            return allRecipes;
        } catch (SQLException e){
            System.out.println("Problems When loading Recipe: " + e.getMessage());
            return null;
        }
    }

    /**
     * Query and return a list of ingredients for a recipe using the recipe id. The Recipe id is used to get the
     * ingredients IDs from the link table and the ingredient ID are then used to get the ingredients details from
     * the Ingredients table.
     * @param recipe_id
     * @return A list of Ingredients for the Recipe / Meal
     */

    public List<Ingredient> getIngredientsForRecipe(int recipe_id) {

        List<Ingredient> ingredients = new ArrayList<>();
        System.out.println();

        try {
            //get ids for ingredients from link table
            select_ingred_id_with_recipe_id.setInt(1, recipe_id);
            ResultSet results = select_ingred_id_with_recipe_id.executeQuery();
            while (results.next()) {
                //cycle through ingredient id, query ingredient table to get ingredient details
                int ingredient_id = results.getInt(1);
                double ingredient_quantity = results.getDouble(2);
                try {
                    select_ingredients.setInt(1, ingredient_id);
                    ResultSet results2 = select_ingredients.executeQuery();
                    while (results2.next()) {
                        String ingredientName = results2.getString(1);
                        Double ingredientCalorie = results2.getDouble(2);
                        Double ingredientProtein = results2.getDouble(3);
                        Double ingredientCarbs = results2.getDouble(4);
                        Double ingredientSugar = results2.getDouble(5);
                        Double ingredientFiber = results2.getDouble(6);
                        Double ingredientFat = results2.getDouble(7);
                        String ingredientQuantityName = results2.getString(8);
                        Double ingredientSingleQuantityAmount = results2.getDouble(9);
                        //create Ingredient object and add it to the list
                        Ingredient i = new Ingredient(ingredient_id, ingredientName, ingredientCalorie, ingredientProtein,
                                ingredientCarbs, ingredientSugar, ingredientFiber, ingredientFat);
                        i.setQuantityInGrams(ingredient_quantity);
                        i.setQuantityName(ingredientQuantityName);
                        i.setSingleQuantityInGrams(ingredientSingleQuantityAmount);
                        ingredients.add(i);
                    }
                } catch (SQLException es) {
                    System.out.println("Cant get ingredients from ingredient id: " + es.getMessage());
                    System.out.println("cause: " + es.getCause());
                    return null;
                }
            }
            return ingredients;
        } catch (SQLException e) {
            System.out.println("Something went wrong getting the ingredients for a specific recipe: " + e.getMessage());
            e.printStackTrace();
            e.getCause();
            return null;
        }
    }

    /**
     * Update the ingredient in the Ingredient table of the database.
     * @param updatedIngredient - Ingredient to update in database
     */

    public void updateIngredient(Ingredient updatedIngredient) {
        System.out.println(UPDATE_SPECIFIC_INGREDIENT);
        System.out.println("Update Ingredient ID: " + updatedIngredient.getId());
        try{
            update_ingredient.setDouble(1, updatedIngredient.getCalorie());
            update_ingredient.setDouble(2, updatedIngredient.getProtein());
            update_ingredient.setDouble(3, updatedIngredient.getCarbs());
            update_ingredient.setDouble(4, updatedIngredient.getSugar());
            update_ingredient.setDouble(5, updatedIngredient.getFiber());
            update_ingredient.setDouble(6, updatedIngredient.getFat());
            update_ingredient.setString(7, updatedIngredient.getQuantityName());
            update_ingredient.setDouble(8, updatedIngredient.getSingleQuantityInGrams());
            update_ingredient.setInt(9, updatedIngredient.getId());
            update_ingredient.execute();


        } catch (SQLException e){
            System.out.println("There was a problem updating data into the ingredients table " + e.getMessage());
            e.printStackTrace();
        }
    }

}


