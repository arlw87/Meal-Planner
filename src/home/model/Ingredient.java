package home.model;
import java.io.Serializable;

/**
 * Ingredient that are used in Recipes / Meals.
 * The ingredient object includes the name and nutritional information of the ingredient.
 * The ingredient object provides standard getters and setters but can also provide a method to deep copy itself.
 * Ingredient implements serializable and so the object can be saved to a file.
 *
 * A further explanation of some of ingredients fields.
 * <b>id</b> - is the id of the ingredient as stored in the database
 * <b>quantityInGrams</b> - is the quantity of the ingredient in grams. As ingredient objects are deep copied there can
 * be multiple ingredients with the same id and name but a different quantity
 * <b>quantityName</b> - The name of the standard quantity for the ingredient for example Egg, Tin, Slice for (Eggs,
 * chickpeas and bread)
 * <b>singleQuantityInGrams</b> - The amount in grams that quantity name represents in grams. For example a slice of
 * bread is 36 grams.
 */

public class Ingredient implements Serializable {

    private int id;
    private String name;
    private double calorie;
    private double protein;
    private double carbs;
    private double sugar;
    private double fiber;
    private double fat;
    private double quantityInGrams;
    private String quantityName;
    private double singleQuantityInGrams;

    //unique ID for the serialization of the object
    private static final long serialVersionUID = 6529937982677432690L;

    public Ingredient(String name, int calorie) {
        this.name = name;
        this.calorie = calorie;
    }

    public Ingredient(int id, String name, int calorie) {
        this.name = name;
        this.calorie = calorie;
        this.id = id;
        this.quantityName = "";
    }

    public Ingredient(String name, double calorie,
                      double protein, double carbs, double sugar,
                      double fiber, double fat) {
        this.name = name;
        this.calorie = calorie;
        this.protein = protein;
        this.carbs = carbs;
        this.sugar = sugar;
        this.fiber = fiber;
        this.fat = fat;
        this.quantityName = "";
    }

    public Ingredient(int _id, String name, double calorie,
                      double protein, double carbs, double sugar,
                      double fiber, double fat) {
        this.id = _id;
        this.name = name;
        this.calorie = calorie;
        this.protein = protein;
        this.carbs = carbs;
        this.sugar = sugar;
        this.fiber = fiber;
        this.fat = fat;
        this.quantityName = "";
    }

    //Constructor that creates a deep copy
    public Ingredient(Ingredient that){
        this(that.getId(), that.getName(), that.getCalorie(), that.getProtein(), that.getCarbs(), that.getSugar(), that.getFiber(),
                that.getFat());
        setQuantityInGrams(that.getQuantityInGrams());
        setQuantityName(that.getQuantityName());
        setSingleQuantityInGrams(that.getSingleQuantityInGrams());
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public double getQuantityInGrams() {
        return quantityInGrams;
    }

    public void setQuantityInGrams(double quantityInGrams) {
        this.quantityInGrams = quantityInGrams;
    }

    public String getQuantityName() {
        return quantityName;
    }

    public void setQuantityName(String quantityName) {
        this.quantityName = quantityName;
    }

    public double getSingleQuantityInGrams() {
        return singleQuantityInGrams;
    }

    public void setSingleQuantityInGrams(double singleQuantityInGrams) {
        this.singleQuantityInGrams = singleQuantityInGrams;
    }

}
