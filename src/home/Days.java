package home;

import home.model.Recipe;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

/**
 * Represent the meals set for a single day, breakfast, lunch and dinner. Meals are defined as Recipe objects.
 * Implements serializable to allow saving to an external file.
 */

public class Days implements Serializable {

    private String day;
    private Recipe lunch = null;
    private Recipe dinner = null;
    private Recipe breakfast = null;

    private static final long serialVersionUID = 652296825982674690L;

    /**
     * Constructor only requires the days name.
     * @param aDay Name of the DayMeal
     */
    public Days(String aDay) {
        this.day = aDay;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Recipe getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Recipe breakfast) {
        this.breakfast = breakfast;
    }

    public Recipe getLunch() {
        return lunch;
    }

    public void setLunch(Recipe lunch) {
        this.lunch = lunch;
    }

    public Recipe getDinner() {
        return dinner;
    }

    public void setDinner(Recipe dinner) {
        this.dinner = dinner;
    }

    /**
     * Returns if the DayMeal has a Breakfast Set
     * @return true if DaysMeals has breakfast set, false if not
     */
    public boolean isBreakfastSet(){
        if (breakfast == null){
            return false;
        }
        return true;
    }

    /**
     * Returns if the DayMeal has a lunch set
     * @return true if DaysMeals has lunch set, false if not
     */
    public boolean isLunchSet(){
        if (lunch == null){
            return false;
        }
        return true;
    }

    /**
     * Returns if the DayMeal has a Dinner set
     * @return true if DaysMeals has Dinner set, false if not
     */
    public boolean isDinnerSet(){
        if (dinner == null){
            return false;
        }
        return true;
    }

    /**
     * Determines if any meals have been set for this day
     * @return Returns true if breakfast, lunch and dinner are not set. False if one or more are.
     */
    public boolean noMealsSet(){
        if (!this.isDinnerSet() && !this.isLunchSet() && !this.isBreakfastSet()){
            return true;
        }
        return false;
    }

}
