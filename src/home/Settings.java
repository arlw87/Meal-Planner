package home;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * Stores the settings of the program to be saved in a file to keep the user experience consist between program
 * usages. When ever a setting is updated, the settings will be automatically saved to a file. The constructor
 * of this class will load in the settings from the settings file when the object is initialised.
 *
 * The settings that are saved in this settings object are:
 * - excludeCupboard, saves the state of the exclude cupboard ingredients checkbox in the meal planner pane
 * - generaedShoppingListDate, stores the date and time when the shopping list was last generated
 * - shoppingListOutOfSync, states when the shopping list ingredients are not the same as all the ingredients in the
 *   mealPlanners meals. This is done to help the user notice if the mealPlanner has been updated but a new shopping List
 *   has not been created.
 * - settingFilePath, location of the file that contains the saved settings
 *
 * Note:
 * The shoppingListOutOfSync state is not perfect as there are some situation when this could be set to true
 * when in fact the shopping list includes all the ingredients that the meal in the mealplanner contains.
 * Although these situation are rare, it should be treated as a guide for the user to re-generate the shopping list
 * if they are not sure that mealPlanner and the shoppingList match.
 * Currently the shoppingListOutofSync will be set to true, if a meal is update or deleted in the planner, is the
 * mealPlanner or the shoppingList are cleared. It is therefor possible to clear a meal and then add it again or
 * to update a meal with the same meal and the shoppingList to reflect the mealPlanner but the shoppingListOutOfSync to
 * be set to true.
 * It should also be noted that is the exclude cupboard ingredients checkbox is ticked or unticked this doesnt affect
 * the shoppingListOutOfSync variable.
 *
 */

public class Settings implements Serializable {

    private boolean excludeCupboard;
    private LocalDateTime generatedShoppingListDate;
    private boolean shoppingListOutOfSync;
    private String settingFilePath;

    private static final long serialVersionUID = 6529685982677694690L;

    /**
     * Constructor takes the filePath of the saved settings. If the file exists the settings are loaded  from the
     * file and used to set the current settings object. If it doesnt defaults are loaded.
     * @param filePath
     */
    public Settings(String filePath){
        settingFilePath = filePath;
        try{
            Settings loadedSettings = loadSettingsFromFile();
            excludeCupboard = loadedSettings.isExcludeCupboard();
            generatedShoppingListDate = loadedSettings.getGeneratedShoppingListDate();
            shoppingListOutOfSync = loadedSettings.isShoppingListOutOfSync();
        } catch (Exception e){
            System.out.println("No settings loaded, using defaults");
            e.printStackTrace();
            excludeCupboard = false;
            generatedShoppingListDate = null;
            shoppingListOutOfSync = false;
        }
    }

    public boolean isExcludeCupboard() {
        return excludeCupboard;
    }

    public void setExcludeCupboard(boolean excludeCupboard) {
        this.excludeCupboard = excludeCupboard;
        saveSettingsToFile();
    }

    public LocalDateTime getGeneratedShoppingListDate() {
        return generatedShoppingListDate;
    }

    public void setGeneratedShoppingList(LocalDateTime generatedShoppingList) {
        this.generatedShoppingListDate = generatedShoppingList;
        saveSettingsToFile();
    }

    /**
     * Returns a text verison of the date the shopping list was generated.
     * @return String of the date and time the shopping list was generated
     */
    public String getGeneratedShoppingListDateAsString(){
        if (generatedShoppingListDate != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd MMM HH:mm");
            String dateTime = generatedShoppingListDate.format(formatter);
            return dateTime;
        }
        return "";
    }

    public boolean isShoppingListOutOfSync() {
        return shoppingListOutOfSync;
    }

    public void setShoppingListOutOfSync(boolean shoppingListOutOfSync) {
        this.shoppingListOutOfSync = shoppingListOutOfSync;
        saveSettingsToFile();
    }

    /**
     * Saves the settings object to the filePath specificed in settingFilePath.
     */
    private void saveSettingsToFile(){
        Data.saveObject(this, settingFilePath);
    }

    /**
     * Loads the settings from the file
     * @return A Settings object
     * @throws Exception - If the settings couldnt be loaded from the file
     */
    private Settings loadSettingsFromFile() throws Exception {
        return Data.<Settings>loadObject(settingFilePath);
    }
}
