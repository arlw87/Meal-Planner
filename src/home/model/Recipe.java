package home.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A Recipe / Meal. Recipe includes the name and method of the meal along with a list of ingredients that are included
 * in the meal. Recipe implements serializable and so the object can be saved to a file.
 * */

public class Recipe implements Serializable {

    private int id;
    private String name;
    private String method;
    private ArrayList<Ingredient> ingredients;

    //unique ID for the serialization of the object
    private static final long serialVersionUID = 1259685982677694690L;

    public Recipe(int id, String name, String method, List<Ingredient> sourceIngredients) {
        this.id = id;
        this.name = name;
        this.method = method;
        copyList(sourceIngredients);
    }

    public Recipe(int id, String name, String method){
        this.id = id;
        this.name = name;
        this.method = method;
    }

    /**
     * Copies passed list of ingredients to the Recipe list of ingredients
     * @param scr - source ingredients
     */
    private void copyList(List<Ingredient> scr){
        ingredients = new ArrayList<>(scr);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ArrayList<Ingredient> getIngredients(){
        return this.ingredients;
    }

    /**
     * Calculates the total calories of the Recipe / Meal
     * @return The calories of the Recipe / Meal
     */
    public double getTotalCalories(){
        double totalcalories = 0;
        if (ingredients.size() == 0){
            System.out.println("No Ingredients in the meal");
        } else {
            for (Ingredient i: ingredients){
                totalcalories = totalcalories + (i.getCalorie() * (i.getQuantityInGrams()/100));
            }
        }
        return totalcalories;
    }

    /**
     * Calculates the total sugar of the Recipe / Meal
     * @return The amount of sugar in the Recipe / Meal
     */
    public double getTotalSugar(){
        double totalSugar = 0;
        if (ingredients.size() == 0){
            System.out.println("No Ingredients in the meal");
        } else {
            for (Ingredient i: ingredients){
                totalSugar = totalSugar + (i.getSugar() * (i.getQuantityInGrams()/100));
            }
        }
        return totalSugar;
    }

    /**
     * Calculates the total protien in the Recipe / Meal
     * @return The amount of protein in the Recipe / Meal
     */
    public double getTotalProtein(){
        double totalProtein = 0;
        if (ingredients.size() == 0){
            System.out.println("No Ingredients in the meal");
        } else {
            for (Ingredient i: ingredients){
                totalProtein = totalProtein + (i.getProtein() * (i.getQuantityInGrams()/100));
            }
        }
        return totalProtein;
    }

    /**
     * Calculates the total fibre in the Recipe / Meal
     * @return The amount of fibre in the Recipe / Meal
     */
    public double getTotalFibre(){
        double totalFibre = 0;
        if (ingredients.size() == 0){
            System.out.println("No Ingredients in the meal");
        } else {
            for (Ingredient i: ingredients){
                totalFibre = totalFibre + (i.getFiber() * (i.getQuantityInGrams()/100));
            }
        }
        return totalFibre;
    }

    /**
     * Calculates the total carbohydrates in a Recipe / Meal
     * @return The total amount Carbohydrates in the Recipe / Meal
     */
    public double getTotalCarbs(){
        double totalCarbs = 0;
        if (ingredients.size() == 0){
            System.out.println("No Ingredients in the meal");
        } else {
            for (Ingredient i: ingredients){
                totalCarbs = totalCarbs + (i.getCarbs() * (i.getQuantityInGrams()/100));
            }
        }
        return totalCarbs;
    }

    /**
     * Calculates the total fat in a Recipe / Meal
     * @return The total amount of fat in the Recipe / Meal
     */
    public double getTotalFat(){
        double totalFat = 0;
        if (ingredients.size() == 0){
            System.out.println("No Ingredients in the meal");
        } else {
            for (Ingredient i: ingredients){
                totalFat = totalFat + (i.getFat() * (i.getQuantityInGrams()/100));
            }
        }
        return totalFat;
    }

}
