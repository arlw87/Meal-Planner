package home;

import home.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Controller {

    //************** UI Components ***************************//

    //Main Menu

    //Main Menu Pane
    @FXML
    Pane MenuPane;
    //Main Menu Buttons
    @FXML
    Button plannerBtn;
    @FXML
    Button mealsBtn;
    @FXML
    Button ingredBtn;

    //SubMenus

    //Meal Sub Menu
    //Meal Sub Menu Pane
    @FXML
    Pane MealSubMenuPane;

    //Ingredient Sub Menu
    //Ingredient Sub Menu Pane
    @FXML
    Pane IngredientsSubMenu;

    //Planner Sub Menu
    //Planner Sub Menu Pane
    @FXML
    Pane PlannerSubMenuPane;

    //Program Panes
    //Ingredients Browse Pane
    @FXML
    Pane IngredientsBrowsePane;
    //TextFields, Labels, ComboBoxs, Listviews, TextAreas and Buttons
    @FXML
    ComboBox<Ingredient> ingredientsBrowseCombo;
    @FXML
    TextField ingredCalorieInputBrowse;
    @FXML
    TextField ingredFatInputBrowse;
    @FXML
    TextField ingredProteinInputBrowse;
    @FXML
    TextField ingredFiberInputBrowse;
    @FXML
    TextField ingredSugarInputBrowse;
    @FXML
    TextField ingredCarbsInputBrowse;
    @FXML
    TextField ingredQuantityNameInputBrowse;
    @FXML
    TextField ingredQuantityAmountInputBrowse;
    @FXML
    ToggleButton ingredBrowseEditToggle;
    @FXML
    Button updateIngredsBtn;
    @FXML
    Pane IngredientsBrowseSubPane;
    @FXML
    Button btnExitProgramIngredBrowse;
    @FXML
    Button btnMinimiseProgramIngredBrowse;

    //Ingredients Add Pane
    @FXML
    Pane IngredientsAddPane;
    @FXML
    Pane IngredientsAddSubPane;
    //TextFields, Labels, ComboBoxs, Listviews, TextAreas and Buttons
    @FXML
    TextField ingredNameInput;
    @FXML
    TextField ingredCalorieInput;
    @FXML
    TextField ingredFatInput;
    @FXML
    TextField ingredProteinInput;
    @FXML
    TextField ingredFiberInput;
    @FXML
    TextField ingredSugarInput;
    @FXML
    TextField ingredCarbsInput;
    @FXML
    TextField ingredQuantityNameInput;
    @FXML
    TextField ingredQuantityAmountInput;
    @FXML
    Button btnSaveIngredients;
    @FXML
    Button btnExitProgramIngredAdd;
    @FXML
    Button btnMinimiseProgramIngredAdd;

    //Meals Browse Pane
    @FXML
    Pane MealsBrowsePane;
    //TextFields, Labels, ComboBoxs, Listviews, TextAreas and Buttons
    @FXML
    ComboBox<Recipe> comboMealSelection;
    @FXML
    ListView<Ingredient> mealIngred;
    @FXML
    TextArea mealMethod;
    @FXML
    Label browseMealNutritionOne;
    @FXML
    Label browseMealNutritionTwo;
    @FXML
    Button btnExitProgramMealsBrowsePane;
    @FXML
    Button btnMinimiseProgramMealsBrowsePane;
    @FXML
    Pane mealBrowseSubPane;

    //Meals Add Pane
    @FXML
    Pane MealsAddPane;
    @FXML
    Pane mealAddSubPane;
    //TextFields, Labels, ComboBoxs, Listviews, TextAreas and Buttons
    @FXML
    TextArea methodField;
    @FXML
    TextField mealNameField;
    @FXML
    TextField mealsInputQuantityNumber;
    @FXML
    TextField searchIngredient;
    @FXML
    TextField ingredientQuantityInput;
    @FXML
    ListView<Ingredient> ingredientsForMeal;
    @FXML
    ListView<Ingredient> ingredientsList;
    @FXML
    Button btnAddIngredToMeal;
    @FXML
    Button btnRemoveIngredFromMeal;
    @FXML
    Button btnSaveMeal;
    @FXML
    Label quantityNameLabel;
    @FXML
    Button btnExitProgramMealsAddPane;
    @FXML
    Button btnMinimiseProgramMealsAddPane;
    @FXML
    Label labelMealIngredients;
    @FXML
    Label labelQuantityTitle;
    @FXML
    Label labelInGrams;
    @FXML
    Label labelSetAmount;
    @FXML
    Label labelQuantityNumber;

    //Week Planner Pane
    @FXML
    Pane PlannerPlanPane;
    //TextFields, Labels, ComboBoxs, Listviews, TextAreas and Buttons
    @FXML
    ListView<Days> weekList;
    @FXML
    Text textBreakfastTitle;
    @FXML
    Text textLunchTitle;
    @FXML
    Text textDinnerTitle;
    @FXML
    Text textTotalNutrition;
    @FXML
    Line lineBreakfast;
    @FXML
    Line lineLunch;
    @FXML
    Line lineDinner;
    @FXML
    Line lineTotal;
    @FXML
    ComboBox<Recipe> breakfastCombo;
    @FXML
    ComboBox<Recipe> lunchCombo;
    @FXML
    ComboBox<Recipe> dinnerCombo;
    @FXML
    Text textDay;
    @FXML
    Button btnPlanSaveBreakfast;
    @FXML
    Button btnPlanSaveLunch;
    @FXML
    Button btnPlanSaveDinner;
    @FXML
    Button btnGenerateShoppingList;
    @FXML
    Label breakfastNutritionOne;
    @FXML
    Label breakfastNutritionTwo;
    @FXML
    Label lunchNutritionOne;
    @FXML
    Label lunchNutritionTwo;
    @FXML
    Label dinnerNutritionOne;
    @FXML
    Label dinnerNutritionTwo;
    @FXML
    Label totalNutritionOne;
    @FXML
    Label totalNutritionTwo;
    @FXML
    CheckBox cupboardCheckBox;
    @FXML
    Button btnExitProgramPlannerPlanPane;
    @FXML
    Button btnMinimiseProgramPlannerPlanPlane;
    @FXML
    Button btnClearPlanner;


    //Shopping List Pane
    @FXML
    Pane PlannerShoppingListPane;
    //TextFields, Labels, ComboBoxs, Listviews, TextAreas and Buttons
    @FXML
    Label labelShoppingList;
    @FXML
    ListView<Ingredient> shoppingList;
    @FXML
    Button btnClearShoppingList;
    @FXML
    Button btnExportShopping;
    @FXML
    Button btnExitProgramPlannerShoppingListPane;
    @FXML
    Button btnMinimiseProgramPlannerShoppingListPane;
    @FXML
    Label labelWarningShoppingList;
    @FXML
    Label labelGeneratedDateTime;

    //Planner Cupboard Pane
    @FXML
    Pane PlannerCupboardPane;
    @FXML
    Pane plannerCupboardSubPane;
    @FXML
    ListView<Ingredient> allIngredientsCupboardPane;
    @FXML
    ListView<Ingredient> IngredientsInCupboard;
    @FXML
    TextField searchIngredientCupboard;
    @FXML
    TextField ingredientQuantityInputCupboard;
    @FXML
    TextField cupboardQuantityNumber;
    @FXML
    Label quantityNameLabelCupboard;
    @FXML
    Button btnMinimiseProgramPlannerCupboardPane;
    @FXML
    Button btnExitProgramPlannerCupboardPane;
    @FXML
    Button btnRemoveIngredFromCupboard;
    @FXML
    Button btnAddIngredToCupboard;
    @FXML
    Button btnClearCupboard;
    @FXML
    Label labelNumberPlanner;
    @FXML
    Label labelCupboardStores;

    //List View Lists
    ObservableList<Ingredient> newIngredients = FXCollections.observableArrayList();
    ObservableList<Ingredient> ingredientsFromDatabase = FXCollections.observableArrayList();
    ObservableList<Ingredient> filterObservableList = FXCollections.observableArrayList();
    ObservableList<Recipe> recipesFromDatabase = FXCollections.observableArrayList();
    ObservableList<Ingredient> cupboardIngredients = FXCollections.observableArrayList();
    ObservableList<Ingredient> shoppingListIngredients = FXCollections.observableArrayList();
    ObservableList<Days> ObservableWeekList = FXCollections.observableArrayList();

    //define colors
    private static final String ingredientColor = "40a0f0";
    private static final String mealColor = "fa745a";
    private static final String plannerColor = "64b6ac";
    private static final String defaultColor = "948c8c";
    //private static final String defaultColor = "C8C8C8";
    private static final String darkenSubMenuButtonColor = "B9B9B9";
    private static final String standardSubMenuButtonColor = "C2C2C2";
    private static final String mealColorDark = "dd5a43";
    private static final String plannerColorDark = "529a90";
    private static final String ingredientColorDark = "1765a4";
    public static final String defaultTextColor = "8d8585";
    public static final String weekCellFontColor = "313335";

    //planner breakfast lunch and dinner colours
    private static final String breakfastColor = "DE541E";
    private static final String lunchColor = "96C5F7";
    private static final String dinnerColor = "B481D4";
    private static final String breakfastColorLight = "F7D9CD";
    private static final String lunchColorLight = "D0E5FB";
    private static final String dinnerColorLight = "E6D5F0";
    public static final String warningColor = "#ff0000";

    //external files paths
    public static final String shoppingListFile = "shoppingList.dat";
    public static final String mealPlannerFile = "weekPlanner.dat";
    public static final String settingsFile = "settings.dat";
    public static final String cupboardFile = "cupboard.dat";

    //Save the previously selected day in meal planner for a good user experience
    private Days previouslySelected;

    //global settings
    Settings settings;

    //Warning or Confirmation DialogeBoxs
    InformationBox plannerBox;
    InformationBox mealBox;
    InformationBox ingredientBox;


    /**
     * Initialise the Java FX Thread
     */
    public void initialize(){

        //load Settings
        settings = new Settings(settingsFile);
        if (settings.isExcludeCupboard()){
            cupboardCheckBox.setSelected(true);
        }

        //The first pane to see when the program starts is the meals Browse pane
        mealsBtnClicked();

        //set up focus and out of focus styling for all the Panes
        styleIngredientBrowsePane();
        styleIngredientAddPane();
        styleMealAddPane();
        styleMealBrowsePane();
        stylePlanShoppingListPane();
        stylePlanWeeklyPlanner();
        stylePlanCupboard();

        //setup the Ingredients Browse Pane
        setupBrowseIngredientsPane();

        //setup up the main menu hoover button effects
        setupHoverMainMenuButtons();

        //setup the meal Add Pane
        MealAddPaneSetUp();

        //setup the meal Browse Pane
        mealBrowsePaneSetup();

        //setup up the meal planner weekly pane
        weeklyPlannerSetup();

        //setup the planner shopping list pane
        plannerShoppingListSetup();

        //setup the planner cupboard pane
        plannerCupboardSetup();

        //Load the meals from the database
        loadMeals();

        //set up the focus styling for the minimise and exit buttons
        setupWindowButtons();

        //when the program loads, load the shopping list and meal planner from previous usage
        loadShoppingList();
        loadMealPlanner();

        //Set up the information boxes instance for ingredient pane, meal pane and planner pane
        plannerBox = new InformationBox(PlannerPlanPane, plannerColor, plannerColorDark,
                "images/icons8_planner_96px_Black.png");
        mealBox = new InformationBox(MealsBrowsePane, mealColor, mealColorDark,
                "images/icons8_cutlery_96px_Black.png");
        ingredientBox = new InformationBox(IngredientsBrowsePane, ingredientColor, ingredientColorDark,
                "images/icons8_apple_96px_Black.png");

    }


    /**
     * Setup and configure the Meal Planner shopping list pane.
     */

    public void plannerShoppingListSetup(){
        //Set the items of the shopping list.
        shoppingList.setItems(shoppingListIngredients);
        //Format the cells of the shopping List ListView
        Callback<ListView<Ingredient>, ListCell<Ingredient>> ingredientsMealFormat =
                new Callback<ListView<Ingredient>, ListCell<Ingredient>>() {
            @Override
            public ListCell<Ingredient> call(ListView<Ingredient> ingredientListView) {
                ListCell<Ingredient> cell = new ListCell<>(){
                    @Override
                    protected void updateItem(Ingredient ingredient, boolean empty) {
                        super.updateItem(ingredient, empty);
                        if (empty){
                            setText(null);
                        } else {
                            String quantityName = ingredient.getQuantityName();
                            double quantityInGrams = ingredient.getQuantityInGrams();
                            double quantityRatio = (quantityInGrams / ingredient.getSingleQuantityInGrams());

                            DecimalFormat df = new DecimalFormat("#.#");
                            DecimalFormat df2 = new DecimalFormat("#");

                            if (quantityRatio > 1){
                                quantityName = quantityName + "s";
                            }

                            setText( ingredient.getName() + " ( " + df2.format(quantityInGrams) + " grams / "  +
                                    df.format(quantityRatio) + " " + quantityName + ")");
                        }
                        setFont(InterfaceStyling.textFieldFont);
                    }
                };
                return cell;
            }
        };
        shoppingList.setCellFactory(ingredientsMealFormat);
        Label emptyLabel = new Label("Empty Shopping List");
        emptyLabel.setFont(InterfaceStyling.textFieldFont);
        //Set the label placeholder for an empty listview.
        shoppingList.setPlaceholder(emptyLabel);
    }

    /**
     * Setup the weekly planner pane (Calendar).
     */
    private void weeklyPlannerSetup() {
        //Setup the 7 Days of the planner
        Days monday = new Days("Monday");
        Days tuesday = new Days("Tuesday");
        Days wednesday = new Days("Wednesday");
        Days thursday = new Days("Thursday");
        Days friday = new Days("Friday");
        Days saturday = new Days("Saturday");
        Days sunday = new Days("Sunday");

        //Add days to list and set them to listView
        ObservableWeekList.addAll(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
        weekList.setItems(ObservableWeekList);

        //get listViews Height
        double listViewHeight = weekList.getPrefHeight();
        double cellHeight = Math.round(listViewHeight / 7);
        double cellWidth = weekList.getPrefWidth();

        //set planners cell format
        weekList.setCellFactory(new Callback<ListView<Days>, ListCell<Days>>() {
            @Override
            public ListCell<Days> call(ListView<Days> daysListView) {
                return new WeekCell(breakfastColor, lunchColor, dinnerColor, breakfastColorLight,
                        lunchColorLight, dinnerColorLight, weekCellFontColor, cellHeight, cellWidth);
            }
        });

        //Setup a weekList View Change Listener, that will set the comboBoxs selected Recipes / Meals to match
        //the Recipes / Meals of the selected day and will then display the appropriate nutritional information
        weekList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Days>() {
            @Override
            public void changed(ObservableValue<? extends Days> observableValue, Days days, Days t1) {
                previouslySelected = t1;
                if (t1 != null) {
                    if (t1.isBreakfastSet()){
                        //get the breakfast recipe id. Then use it to find the recipe in the breakfastCombo
                        //this is done as when the program is loaded weekplanner.dat is loaded and the
                        //recipes in here will be loaded to a new memory location to find via an object search
                        Recipe breakfast = findRecipeFromID(t1.getBreakfast().getId(), breakfastCombo);
                        breakfastCombo.getSelectionModel().select(breakfast);
                        //set breakfast nutrition information
                        displayBreakfastNutrition(t1.getBreakfast());

                    } else {
                        breakfastCombo.getSelectionModel().clearSelection();
                        breakfastCombo.setValue(null);
                        //clear the nutritional labels if there is no meal
                        clearBreakfastNutrition();
                    }

                    if(t1.isLunchSet()){
                        Recipe lunch = findRecipeFromID(t1.getLunch().getId(), lunchCombo);
                        lunchCombo.getSelectionModel().select(lunch);
                        displayLunchNutrition(t1.getLunch());
                    } else {
                        lunchCombo.getSelectionModel().clearSelection();
                        clearLunchNutrition();
                        lunchCombo.setValue(null);
                    }

                    if(t1.isDinnerSet()){
                        Recipe dinner = findRecipeFromID(t1.getDinner().getId(), dinnerCombo);
                        dinnerCombo.getSelectionModel().select(dinner);
                        displayDinnerNutrition(t1.getDinner());
                    } else {
                        dinnerCombo.getSelectionModel().clearSelection();
                        dinnerCombo.setValue(null);
                        clearDinnerNutrition();
                    }

                    textDay.setText(t1.getDay());
                }
            }
        });

        //select the first day in the weekList
        weekList.getSelectionModel().selectFirst();

        setupPlannerMealComboboxs(breakfastCombo);
        setupPlannerMealComboboxs(lunchCombo);
        setupPlannerMealComboboxs(dinnerCombo);

        clearBreakfastNutrition();
        clearDinnerNutrition();
        clearLunchNutrition();
        clearTotalNutrition();
    }

    /**
     * Set up and configure the Planner Cupboard Pane.
     */

    private void plannerCupboardSetup(){
        //Set up quantity label to change on different ingredient selection
        dynamicQuantityLabelSetUp(allIngredientsCupboardPane, quantityNameLabelCupboard);
        //Format All Ingredients Cupboard Pane ListView Cells to display ingredient name
        styleIngredientListCell(allIngredientsCupboardPane);
        //Format Ingredients In Cupboard ListView Cells to display ingredient name and quantity
        styleIngredientAddedListCell(IngredientsInCupboard);
        quantityNameLabelCupboard.setWrapText(true);
        IngredientsInCupboard.setItems(cupboardIngredients);
        //load cupboard Ingredients from external file
        try{
            List<Ingredient> returnedList = Data.<Ingredient>loadList(cupboardFile);
            if (returnedList != null){
                cupboardIngredients = FXCollections.observableList(returnedList);
                IngredientsInCupboard.setItems(cupboardIngredients);
            } else {
                System.out.println("No cupboard list to load");
            }
        } catch (Exception e){
            System.out.println("Could not load the cupboard Ingredients");
        }

        quantityNameLabelCupboard.setText("");

    }

    /**
     * Setup the styling for the weekly planner / Calendar in the planner section
     */

    public void stylePlanWeeklyPlanner(){
        //title setup
        textBreakfastTitle.setFill(Color.valueOf(breakfastColor));
        textLunchTitle.setFill(Color.valueOf(lunchColor));
        textDinnerTitle.setFill(Color.valueOf(dinnerColor));
        textTotalNutrition.setFill(Color.valueOf(plannerColor));
        textBreakfastTitle.setFont(InterfaceStyling.titleFont);
        textLunchTitle.setFont(InterfaceStyling.titleFont);
        textDinnerTitle.setFont(InterfaceStyling.titleFont);
        textTotalNutrition.setFont(InterfaceStyling.titleFont);
        cupboardCheckBox.setFont(InterfaceStyling.systemFont);

        //style day title
        textDay.setFont(InterfaceStyling.titleFont);

        //color dividing lines
        lineBreakfast.setStroke(Color.valueOf(breakfastColor));
        lineLunch.setStroke(Color.valueOf(lunchColor));
        lineDinner.setStroke(Color.valueOf(dinnerColor));
        lineTotal.setStroke(Color.valueOf(plannerColor));

        //style the combo boxs
        InterfaceStyling.setHighlightStyling(breakfastCombo, breakfastColor, defaultColor);
        InterfaceStyling.setHighlightStyling(lunchCombo, lunchColor, defaultColor);
        InterfaceStyling.setHighlightStyling(dinnerCombo, dinnerColor, defaultColor);

        //style buttons
        InterfaceStyling.buttonStyle(btnPlanSaveBreakfast, breakfastColor, breakfastColorLight);
        InterfaceStyling.buttonStyle(btnPlanSaveLunch, lunchColor, lunchColorLight);
        InterfaceStyling.buttonStyle(btnPlanSaveDinner, dinnerColor, dinnerColorLight);
        InterfaceStyling.buttonStyle(btnGenerateShoppingList, plannerColor, plannerColorDark);
        InterfaceStyling.buttonStyle(btnClearPlanner, plannerColor, plannerColorDark);

        //style the list
        InterfaceStyling.setHighlightStyling(weekList, plannerColor, defaultColor);
    }

    /**
     * Style the planner cupboard pane in the planner section
     */

    public void stylePlanCupboard(){

        //style the buttons
        InterfaceStyling.buttonStyle(btnAddIngredToCupboard, plannerColor, plannerColorDark);
        InterfaceStyling.buttonStyle(btnRemoveIngredFromCupboard, plannerColor, plannerColorDark);
        InterfaceStyling.buttonStyle(btnClearCupboard, plannerColor,plannerColorDark );

        //style the various nodes in the pane
        InterfaceStyling.setHighlightStyling(allIngredientsCupboardPane, plannerColor, defaultColor);
        InterfaceStyling.setHighlightStyling(IngredientsInCupboard, plannerColor, defaultColor);
        InterfaceStyling.setHighlightStyling(searchIngredientCupboard, plannerColor, defaultColor);
        InterfaceStyling.setHighlightStyling(ingredientQuantityInputCupboard, plannerColor, defaultColor);
        InterfaceStyling.setHighlightStyling(cupboardQuantityNumber, plannerColor, defaultColor);

        //Style the labels and the text in this pane
        for (Node n : plannerCupboardSubPane.getChildren()) {
            if (n.getClass().isInstance(new Label())) {
                ((Label) n).setFont(InterfaceStyling.titleFontNonBold);
                ((Label) n).setTextFill(Paint.valueOf(defaultTextColor));
            }
        }

        labelNumberPlanner.setFont(InterfaceStyling.systemFont);
        labelNumberPlanner.setTextFill(Paint.valueOf(defaultColor));

        labelCupboardStores.setFont(InterfaceStyling.titleFont);
        labelCupboardStores.setTextFill(Paint.valueOf(defaultColor));
    }

    /**
     * Style the shopping list pane in the planner section
     */

    public void stylePlanShoppingListPane(){
        InterfaceStyling.setHighlightStyling(shoppingList, plannerColor, defaultColor);
        labelShoppingList.setFont(InterfaceStyling.titleFont);
        InterfaceStyling.buttonStyle(btnClearShoppingList, plannerColor, plannerColorDark);
        InterfaceStyling.buttonStyle(btnExportShopping, plannerColor, plannerColorDark);

        labelWarningShoppingList.setFont(InterfaceStyling.textFieldFont);
        labelWarningShoppingList.setTextFill(Color.valueOf(warningColor));
        labelWarningShoppingList.setWrapText(true);
        labelGeneratedDateTime.setFont(InterfaceStyling.titleFontNonBold);
    }

    /**
     * Setup and configure the Ingredients Browser Pane.
     */
    private void setupBrowseIngredientsPane(){
        //Set the browse ingredients fields as read only initially
        setEditOnIngredientsBrowseFields(false);

        //set up the toggle button. If the toggle is selected then you can edit the record. If it isnt, then you can not.
        ingredBrowseEditToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean notSelected, Boolean selected) {
                //Means the toggle has been selected
                if (selected){
                    setEditOnIngredientsBrowseFields(true);
                    ingredBrowseEditToggle.setText("Read Only");
                } else {
                    setEditOnIngredientsBrowseFields(false);
                    ingredBrowseEditToggle.setText("Edit");
                }
            }
        });

        //Callback function to format the ingredients Browse comboBox to display ingredients name in drop down list
        Callback<ListView<Ingredient>, ListCell<Ingredient>> listSetUp =
                new Callback<ListView<Ingredient>, ListCell<Ingredient>>() {
            @Override
            public ListCell<Ingredient> call(ListView<Ingredient> ingredientListView) {
                ListCell<Ingredient> cell = new ListCell<>(){
                    @Override
                    protected void updateItem(Ingredient ingredient, boolean empty) {
                        super.updateItem(ingredient, empty);
                        if (empty){
                            setText(null);
                        } else {
                            setText(ingredient.getName());
                        }
                        setFont(InterfaceStyling.textFieldFont);
                    }
                };
                return cell;
            }
        };

        ingredientsBrowseCombo.setCellFactory(listSetUp);

        //Set up the display of Ingredients Browser Combo to some ingredients name in the button cell
        ingredientsBrowseCombo.setButtonCell(new ListCell<Ingredient>(){
            @Override
            protected void updateItem(Ingredient ingredient, boolean empty) {
                super.updateItem(ingredient, empty);
                if (empty){
                    setText(null);
                } else {
                    setText(ingredient.getName());
                }
                setFont(InterfaceStyling.textFieldFont);
            }
        });

    }

    /***
     * Setups the styling of the Ingredients Browse Pane Fields.
     */
    private void styleIngredientBrowsePane(){
        //Ingredients Browser / Edit
        InterfaceStyling.setHighlightStyling(ingredCalorieInputBrowse, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredSugarInputBrowse, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredProteinInputBrowse, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredFiberInputBrowse, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredCarbsInputBrowse, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredFatInputBrowse, ingredientColor , defaultColor);
        InterfaceStyling.buttonStyle(updateIngredsBtn, ingredientColor, ingredientColorDark);
        InterfaceStyling.toggleButtonStyle(ingredBrowseEditToggle, ingredientColor);
        InterfaceStyling.setHighlightStyling(ingredQuantityNameInputBrowse, ingredientColor, defaultColor);
        InterfaceStyling.setHighlightStyling(ingredQuantityAmountInputBrowse, ingredientColor, defaultColor);

        //Style all the labels in the Pane
        for (Node n: IngredientsBrowseSubPane.getChildren()){
            if (n.getClass().isInstance(new Label())){
                ((Label) n).setFont(InterfaceStyling.titleFontNonBold);
                ((Label) n).setTextFill((Paint.valueOf(defaultTextColor)));
            }
        }
    }

    /***
     * Setups the styling of the Ingredients Add Pane Fields.
     */
    private void styleIngredientAddPane(){
        InterfaceStyling.setHighlightStyling(ingredNameInput, ingredientColor, defaultColor);
        InterfaceStyling.setHighlightStyling(ingredCalorieInput, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredSugarInput, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredProteinInput, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredFiberInput, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredCarbsInput, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredFatInput, ingredientColor , defaultColor);
        InterfaceStyling.setHighlightStyling(ingredQuantityAmountInput, ingredientColor, defaultColor);
        InterfaceStyling.setHighlightStyling(ingredQuantityNameInput, ingredientColor, defaultColor);
        InterfaceStyling.setHighlightStyling(ingredientsBrowseCombo, ingredientColor, defaultColor);
        InterfaceStyling.buttonStyle(btnSaveIngredients, ingredientColor, ingredientColorDark);

        //Style all the text in the Pane
        for (Node n: IngredientsAddSubPane.getChildren()){
            if (n.getClass().isInstance(new Text())){
                ((Text) n).setFont(InterfaceStyling.titleFontNonBold);
                ((Text) n).setFill(Paint.valueOf(defaultTextColor));

            }
        }
    }

    /**
     * Set up the Meal Add Pane
     */
    private void MealAddPaneSetUp(){
        //When a ingredient in the ingredient list is selected (Meals Add Pane) Retrieve the standard quantity name
        //and amount for that ingredient. e.g if bread is selected display slice in the quantity label
        dynamicQuantityLabelSetUp(ingredientsList, quantityNameLabel );
        //bind the listView with a list of ingredients
        ingredientsForMeal.setItems(newIngredients);
        //setup the cell format for the two ListViews in this pane
        //ListView displays Ingredients name and quantity
        styleIngredientAddedListCell(ingredientsForMeal);
        //listview displays ingredient name
        styleIngredientListCell(ingredientsList);
    }

    /**
     * Setup the meal Browse Pane
     */
    private void mealBrowsePaneSetup(){
        //format the listCell to display the name and quantity of the ingredient
        styleIngredientAddedListCell(mealIngred);
        //format the comboBox to display the name of the Recipe
        setupMealSelectionCombobox(comboMealSelection);
    }

    /**
     * Setup the styling for the Meals Browse Pane.
     */
    public void styleMealBrowsePane() {
        //style the various nodes in the pane
        InterfaceStyling.setHighlightStyling(mealMethod, mealColor, defaultColor);
        InterfaceStyling.setHighlightStyling(mealIngred, mealColor, defaultColor);
        InterfaceStyling.setHighlightStyling(comboMealSelection, mealColor, defaultColor);
        mealMethod.setFont(InterfaceStyling.textFieldFont);

        //look through all the labels and style them
        for (Node n : mealBrowseSubPane.getChildren()) {
            if (n.getClass().isInstance(new Label())) {
                ((Label) n).setFont(InterfaceStyling.titleFontNonBold);
                ((Label) n).setTextFill(Paint.valueOf(defaultTextColor));

            }
        }
        //style the nutritional information
        browseMealNutritionOne.setFont(InterfaceStyling.largeTextFont);
        browseMealNutritionTwo.setFont(InterfaceStyling.largeTextFont);
    }

    /**
     * Setup the styling for the Meals Add Pane.
     */
    public void styleMealAddPane(){
        //set up the styling for the various nodes in the pane
        InterfaceStyling.setHighlightStyling(mealNameField, mealColor, defaultColor);
        InterfaceStyling.setHighlightStyling(searchIngredient, mealColor, defaultColor);
        InterfaceStyling.setHighlightStyling(methodField, mealColor, defaultColor);
        InterfaceStyling.setHighlightStyling(ingredientsList, mealColor, defaultColor);
        InterfaceStyling.setHighlightStyling(ingredientsForMeal, mealColor, defaultColor);
        InterfaceStyling.setHighlightStyling(ingredientQuantityInput, mealColor, defaultColor);
        InterfaceStyling.setHighlightStyling(mealsInputQuantityNumber, mealColor, defaultColor);
        InterfaceStyling.buttonStyle(btnAddIngredToMeal, mealColor, mealColorDark);
        InterfaceStyling.buttonStyle(btnRemoveIngredFromMeal, mealColor, mealColorDark);
        InterfaceStyling.buttonStyle(btnSaveMeal, mealColor, mealColorDark);
        methodField.setWrapText(true);

        //Style the labels and the text in this pane
        for (Node n : mealAddSubPane.getChildren()) {
            if (n.getClass().isInstance(new Label())) {
                ((Label) n).setFont(InterfaceStyling.titleFontNonBold);
                ((Label) n).setTextFill(Paint.valueOf(defaultTextColor));
            }
        }

        labelQuantityNumber.setFont(InterfaceStyling.systemFont);
        labelQuantityNumber.setTextFill(Paint.valueOf(defaultColor));
    }


    /**
     * Setups up a comboBox of tye Recipe to display the name of the Recipe in the drop down list cell and the
     * button Cell
     * @param genericCombo The comboBox to format
     */

    public void setupPlannerMealComboboxs(ComboBox<Recipe> genericCombo){
        genericCombo.setCellFactory(new Callback<ListView<Recipe>, ListCell<Recipe>>() {
            @Override
            public ListCell<Recipe> call(ListView<Recipe> recipeListView) {
                return new ListCell<Recipe>() {
                    @Override
                    protected void updateItem(Recipe recipe, boolean b) {
                        super.updateItem(recipe, b);
                        if (!b) {
                            setText(recipe.getName());
                            setFont(InterfaceStyling.textFieldFont);
                        }
                    }
                };
            }
        });

        genericCombo.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Recipe recipe, boolean b) {
                System.out.println("From: " + genericCombo.getId() + " B: " + b);
                super.updateItem(recipe, b);
                if (b) {
                    setText("");
                } else {
                    setText(recipe.getName());
                    setFont(InterfaceStyling.textFieldFont);
                    System.out.println("From: " + genericCombo.getId() + " Recipe: " + recipe.getName() + " " + recipe.toString());
                }

            }
        });
    }

    /**
     * Calls setupPlannerMealComboboxs no additional functionality. Added for naming purposes.
     * @param mealSelection The comboBox to format
     */

    public void setupMealSelectionCombobox(ComboBox<Recipe> mealSelection){
        setupPlannerMealComboboxs(mealSelection);
    }


    /**
     * Setup the three main menu buttons to change appearance when they are hovered over. A deeper dropshadow effect will
     * be added to the image on the button when the mouse is over the button and removed when the mouse is moved off the
     * button. This will indicate to the user that the button is currently selected
     */
    public void setupHoverMainMenuButtons(){
        ingredBtn.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean notHover, Boolean hover) {
                if (hover){
                    //increase the drop shadow effect if the mouse is hovering over the button
                    InterfaceStyling.dropShadowSelect(ingredBtn);
                } else {
                    //decrease the drop shadow effect if the mouse is no longer hovering over the button
                    InterfaceStyling.dropShadowDeselect(ingredBtn);
                }
            }
        });

        mealsBtn.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean notHover, Boolean hover) {
                if (hover){
                    InterfaceStyling.dropShadowSelect(mealsBtn);
                } else {
                    InterfaceStyling.dropShadowDeselect(mealsBtn);
                }
            }
        });

        plannerBtn.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean notHover, Boolean hover) {
                if (hover){
                    InterfaceStyling.dropShadowSelect(plannerBtn);
                } else {
                    InterfaceStyling.dropShadowDeselect(plannerBtn);
                }
            }
        });

    }

    /**
     * Setting Editable Property of the Browse Ingredients Pane for all the text fields
     * @param state set the edditable property to true or false
     */
    public void setEditOnIngredientsBrowseFields(Boolean state){
        ingredCalorieInputBrowse.setEditable(state);
        ingredSugarInputBrowse.setEditable(state);
        ingredFatInputBrowse.setEditable(state);
        ingredProteinInputBrowse.setEditable(state);
        ingredCarbsInputBrowse.setEditable(state);
        ingredFiberInputBrowse.setEditable(state);
        ingredQuantityNameInputBrowse.setEditable(state);
        ingredQuantityAmountInputBrowse.setEditable(state);
        updateIngredsBtn.setDisable(!state);
    }

    /********************************************************************************
     * Actions performed when main menu or sub menu button are clicked
     ********************************************************************************/

    /**
     * Main menu planner button clicked
     */
    @FXML
    public void plannerBtnClicked(){
        plannerPlanBtnClicked();
        //style the main menu pane to the planner color
        styleApp("-fx-background-color: #" + plannerColor);
    }

    /**
     * Planner plan / Calendar sub menu button clicked
     */
    @FXML
    public void plannerPlanBtnClicked(){
        //display the correct submenu (run here because plannerBtnClicked call this method)
        subMenuDisplay(PlannerSubMenuPane);
        PlannerPlanPane.toFront();
        MenuPane.toFront();
        //if the planner plan / Calendar pane has previously be viewed then select the previously selected day in the
        //weeklist listView, if not then select the first item in the weeklist listView.
        if (previouslySelected != null){
            weekList.getSelectionModel().select(previouslySelected);
        } else {
            weekList.getSelectionModel().selectFirst();
        }

        //load the correct meal selection in the comboBoxs for day
        plannerDisplayComboBoxs();
    }

    /**
     * Planner shoppinglist submenu button has been clicked
     */
    @FXML
    public void plannerShoppingListBtnClicked(){
        //display the correct panes
        subMenuDisplay(PlannerSubMenuPane);
        PlannerShoppingListPane.toFront();
        MenuPane.toFront();
        //Visibility of this label is dependent on if the shopping list is out of sync with the meal planner
        labelWarningShoppingList.setVisible(settings.isShoppingListOutOfSync());

        //Display the date and time that the shopping list was generated
        if (shoppingListIngredients.size() == 0) {
            labelGeneratedDateTime.setText("");
        } else {
            if (settings.getGeneratedShoppingListDate() != null){
                labelGeneratedDateTime.setText(settings.getGeneratedShoppingListDateAsString());
            } else {
                labelGeneratedDateTime.setText("");
            }
        }
    }

    /**
     * Planner cupboard submenu button clicked
     */
    @FXML
    public void plannerCupboardBtnClicked(){
        //display correct pane and subMenu pane
        subMenuDisplay(PlannerSubMenuPane);
        PlannerCupboardPane.toFront();
        MenuPane.toFront();
        loadIngredients();
    }

    /**
     * Main menu button for meals clicked
     */
    @FXML
    public void mealsBtnClicked(){
        subMenuDisplay(MealSubMenuPane);
        MealsBrowsePane.toFront();
        MenuPane.toFront();
        //style the main menu to the meals color
        styleApp("-fx-background-color: #" + mealColor);
        //goto the meal Browser Pane
        MealBrowseBtnClicked();
    }

    /**
     * Meal Browser Sub menu button clicked
     */
    @FXML
    public void MealBrowseBtnClicked(){
        //display the correct panes
        subMenuDisplay(MealSubMenuPane);
        MealsBrowsePane.toFront();
        MenuPane.toFront();
        //clear the browser fields for new selection of meals
        clearMealBrowserFields();
    }

    /**
     * Meal Add Sub menu button clicked
     */
    @FXML
    public void MealAddBtnClicked(){
        //display the correct panes
        subMenuDisplay(MealSubMenuPane);
        MealsAddPane.toFront();
        MenuPane.toFront();
        //load ingredients from the database ingredients that will be set to the ingredients All ingredients cupboard
        //ListView
        loadIngredients();
        searchIngredient.setText("");
        quantityNameLabel.setText("");
    }

    /**
     * Main menu ingredients button clicked.
     */
    @FXML
    public void ingredBtnClicked(){
        subMenuDisplay(IngredientsSubMenu);
        IngredientsBrowsePane.toFront();
        MenuPane.toFront();
        //style the main menu pane to the correct color
        styleApp("-fx-background-color: #" + ingredientColor);
        IngredBrowseBtnClicked();
    }

    /**
     * Ingredient browse pane button clicked
     */
    @FXML
    public void IngredBrowseBtnClicked(){
        subMenuDisplay(IngredientsSubMenu);
        IngredientsBrowsePane.toFront();
        MenuPane.toFront();
        loadIngredients();
        //clear the ingredient Browse Fields
        clearIngredientBrowseFields();
    }

    /**
     * Ingredients add subMenu button clicked
     */
    @FXML
    public void IngredAddBtnClicked(){
        subMenuDisplay(IngredientsSubMenu);
        IngredientsAddPane.toFront();
        MenuPane.toFront();
    }

    /**
     * Set the background color of the main menu pane and main menu buttons
     * @param backgroundColor A string of the background color
     */
    private void styleApp(String backgroundColor){
        MenuPane.setStyle(backgroundColor);
        ingredBtn.setStyle(backgroundColor);
        mealsBtn.setStyle(backgroundColor);
        plannerBtn.setStyle(backgroundColor);
    }

    /**
     * Clears the text fields of the Ingredient browse pane
     */
    public void clearIngredientBrowseFields(){
        ingredFiberInputBrowse.clear();
        ingredFatInputBrowse.clear();
        ingredCarbsInputBrowse.clear();
        ingredCalorieInputBrowse.clear();
        ingredProteinInputBrowse.clear();
        ingredSugarInputBrowse.clear();
        ingredQuantityAmountInputBrowse.clear();
        ingredQuantityNameInputBrowse.clear();
    }

    /**
     * Displays one of the three submenus and makes the other invisible
     * @param paneToView The subMenu pane to display
     */
    private void subMenuDisplay(Pane paneToView){
        IngredientsSubMenu.setVisible(false);
        PlannerSubMenuPane.setVisible(false);
        MealSubMenuPane.setVisible(false);
        paneToView.setVisible(true);
    }

    /**
     * Darkens the background color of a subMenu Button, call when a mouse pointer enters the buttons area
     */
    @FXML
    public void subMenuButtonDarkenColor(Event mouseEvent){
        Button thisButton = (Button) mouseEvent.getSource();
        thisButton.setStyle("-fx-background-color: #" + darkenSubMenuButtonColor);
    }

    /**
     * Reset the color of the submenu button, called when the mouse pointer exits the buttons area
     */
    @FXML
    public void subMenuButtonResetColor(Event mouseEvent){
        Button thisButton = (Button) mouseEvent.getSource();
        thisButton.setStyle("-fx-background-color: #" + standardSubMenuButtonColor);
    }

    /**
     * Filters the list of ingredients loaded from database based on what is typed into searchIngredient textfield
     * and displays the filtered results in ingredientsList ListView. This method is run everytime a key stroke is
     * registered in the searchIngredient textfield.
     */
    @FXML
    public void filterIngredients(){
        String searchText = searchIngredient.getText();
        List<Ingredient> filteredList = ingredientsFromDatabase.stream().filter(new Predicate<Ingredient>() {
            @Override
            public boolean test(Ingredient ingredient) {
                //inclusive of the upper cases makes it case insensitive
                if (ingredient.getName().toUpperCase().contains(searchText.toUpperCase())){
                    return true;
                } else {
                    return false;
                }
            }
        }).collect(Collectors.toList());
        filterObservableList = FXCollections.observableList(filteredList);
        ingredientsList.setItems(filterObservableList);
    }

    /**
     * Save a newly created meal entered in the meals Add pane to the database. This method runs when the save meal
     * button is clicked.
     */
    @FXML
    public void saveMeal(){
        String mealName = mealNameField.getText().trim();
        String method = methodField.getText();

        //if any of the information is not available then throw an error
        if (mealName.trim().equals("") || method.trim().equals("") || (newIngredients.size() == 0)){
            //no ingredients, or methods or meal name then display error box
            mealBox.errorDiaglogBox("Incomplete meal", "Please ensure that there is a meal name, " +
                    " meal ingredients and meal method entered");
        } else {
            //create  a recipe instance
            Recipe newRecipe = new Recipe(1, mealName, method, newIngredients);

            //create a new servcie to save the new meal to the database in a background thread
            CreateMealService service = new CreateMealService(newRecipe);
            if (service.getState() == Service.State.SUCCEEDED){
                service.reset();
                service.start();
            } else if (service.getState() == Service.State.READY){
                service.start();
            }

            //get the ID of the newly saved meal in the database and set it to the new Recipe
            service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {
                    int recipeId = service.getValue();
                    //if the ID is -1 then there has been an issue saving the meal
                    if (recipeId < 0) {
                        System.out.println("Problem saving meal to database");
                        mealBox.errorDiaglogBox("Saving Meal", "Problem saving meal to database," +
                                "please contact program administrator");
                    }
                    newRecipe.setId(recipeId);
                }
            });

            //clear the text areas
            mealNameField.clear();
            methodField.clear();
            newIngredients.clear();
            searchIngredient.clear();
            ingredientQuantityInput.clear();
            //this will unfilter the ingredients to add list
            ingredientsList.setItems(ingredientsFromDatabase);

            //Add the new meal / Recipe to the recipes List (no need to reloaded from database)
            recipesFromDatabase.add(newRecipe);
        }
    }

    /**
     * Save a newly enter ingredient created in the Ingredient add pane into the database. This method is run
     * when the save ingredient button is clicked in the add ingredient pane.
     */

    @FXML
    public void saveIngred(Event mouseEvent){

        String ingredientName;
        Double ingredientCalorie;
        Double ingredientProtien;
        Double ingredientCarbs;
        Double ingredientSugar;
        Double ingredientFiber;
        Double ingredientFat;
        String ingredQuantityName;
        Double ingredSingleQuantityAmount;

        //If any of the field are empty then the method will exit
        try{
            ingredientName = ingredNameInput.getText().trim();
            ingredientCalorie = Double.parseDouble(ingredCalorieInput.getText().trim());
            ingredientProtien = Double.parseDouble(ingredProteinInput.getText().trim());
            ingredientCarbs = Double.parseDouble(ingredCarbsInput.getText().trim());
            ingredientSugar = Double.parseDouble(ingredSugarInput.getText().trim());
            ingredientFiber = Double.parseDouble(ingredFiberInput.getText().trim());
            ingredientFat = Double.parseDouble(ingredFatInput.getText().trim());
            ingredQuantityName = ingredQuantityNameInput.getText().trim();
            ingredSingleQuantityAmount = Double.parseDouble(ingredQuantityAmountInput.getText().trim());
            if (ingredQuantityNameInput.getText().trim().equals("")){
                System.out.println("A quantity name needs to be entered");
                ingredientBox.errorDiaglogBox("Update ingredient", "No entry in the quantity name field");
                return;
            }
        } catch (Exception e){
            System.out.println("Not all the input fields had data input, so the ingredient was not saved");
            ingredientBox.errorDiaglogBox("Ingredient details entry", "Please ensure that all fields" +
                    " are filled out and have valid data");
            return;
        }

        //create new instance of ingredeint
        Ingredient newIngredient = new Ingredient(ingredientName, ingredientCalorie, ingredientProtien,
                ingredientCarbs, ingredientSugar, ingredientFiber, ingredientFat);

        newIngredient.setQuantityName(ingredQuantityName);
        newIngredient.setSingleQuantityInGrams(ingredSingleQuantityAmount);

        //create a new servcie to save created ingredient to the database in a background thread
        CreateIngredientService service = new CreateIngredientService(newIngredient);

        if (service.getState() == Service.State.SUCCEEDED){
            service.reset();
            service.start();
        } else if (service.getState() == Service.State.READY){
            service.start();
        }

        //clear the text areas
        ingredNameInput.clear();
        ingredCalorieInput.clear();
        ingredFatInput.clear();
        ingredFiberInput.clear();
        ingredSugarInput.clear();
        ingredCarbsInput.clear();
        ingredProteinInput.clear();
        ingredQuantityNameInput.clear();
        ingredQuantityAmountInput.clear();
    }

    /**
     * Add the selected ingredient in the ingredient list with its user defined quantity to the meal. Runs when
     * The add button in the Meals add pane is clicked.
     */

    @FXML
    public void addIngredientToMeal(){

        try{
            //get selected ingredient
            Ingredient ingred = ingredientsList.getSelectionModel().getSelectedItem();

            //no selection
            if (ingred == null){
                mealBox.errorDiaglogBox("Ingredient selection", "Please select an ingredient in " +
                        " order to add it to the meal");
            } else if (ingredientQuantityInput.getText().trim().equals("") && mealsInputQuantityNumber.getText().trim().equals("")){
                //no quantity entered
                mealBox.errorDiaglogBox("Ingredient quantity", "Please enter a valid quantity for" +
                        " selected ingredient");
            } else {
                //get quantity
                Double QuantityInGrams;
                if (!ingredientQuantityInput.getText().trim().equals("")){
                    //get the quantity of ingredient in grams
                    QuantityInGrams = Double.parseDouble(ingredientQuantityInput.getText().trim());
                } else {
                    QuantityInGrams = ingred.getSingleQuantityInGrams() *
                            Double.parseDouble(mealsInputQuantityNumber.getText().trim());
                }

                //create deep copy
                Ingredient deepCopyIngredient = new Ingredient(ingred);
                //add quantity to the deep copy
                deepCopyIngredient.setQuantityInGrams(QuantityInGrams);

                //add to the observable list that is set to the listView
                newIngredients.add(deepCopyIngredient);

                //clear the data input boxs
                mealsInputQuantityNumber.clear();
                ingredientQuantityInput.clear();

            }
        } catch (Exception e){
            System.out.println("No ingredient has been selected to be added: " + e.getMessage());
            mealBox.errorDiaglogBox("Add ingredient", "Please enter a valid ingredient quantity");
        }
    }


    /**
     * Removes the selected ingredient from the Meal Ingredients list. Method runs when remove button in the
     * meal add pane is clicked.
     */
    @FXML
    public void removeIngredFromMeal(){
        if (ingredientsForMeal.getSelectionModel().getSelectedItem() == null){
            mealBox.errorDiaglogBox("Remove ingredient", "Please select an ingredient to remove");
        } else {
            try{
                Ingredient ingredientToRemove = ingredientsForMeal.getSelectionModel().getSelectedItem();
                newIngredients.remove(ingredientToRemove);
            } catch (Exception e){
                System.out.println("Couldnt remove item from meal");
                mealBox.errorDiaglogBox("Remove ingredient", "Error removing ingredient");
            }
        }
    }


    public void loadIngredients(){
        //Create a service to run in a background thread to query and return all ingredients from the database
        LoadIngredientsService service = new LoadIngredientsService();
        if (service.getState() == Service.State.SUCCEEDED){
            service.reset();
            service.start();
        } else if (service.getState() == Service.State.READY){
            service.start();
        }

        //When the service has successfully run set the return ingredients to various listViews and comboBoxs where
        //ingredients from database are saved
        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                ingredientsFromDatabase = service.getValue();
                ingredientsList.setItems(ingredientsFromDatabase);
                ingredientsBrowseCombo.setItems(ingredientsFromDatabase);
                allIngredientsCupboardPane.setItems(ingredientsFromDatabase);
            }
        });
    }

    /**
     * Load the meals from the database into the application
     */

    public void loadMeals(){
        //Create a service to load all the Meals / Recipes from the database in a background thread
        LoadAllRecipesService service = new LoadAllRecipesService();

        //When the service is successful set the returned Recipes / Meals to various comboBoxes
        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                recipesFromDatabase = service.getValue();
                comboMealSelection.setItems(recipesFromDatabase);
                //A test
                breakfastCombo.setItems(recipesFromDatabase);
                lunchCombo.setItems(recipesFromDatabase);
                dinnerCombo.setItems(recipesFromDatabase);
            }
        });


        if (service.getState() == Service.State.SUCCEEDED){
            service.reset();
            service.start();
        } else if (service.getState() == Service.State.READY){
            service.start();
        }
    }

    /**
     * Displays the details of the selected Recipe / Meal in the Meals Browse Pane, including the
     * Ingredients, Method and Nutritional Details.
     * Method fires when a Recipe / Meal is selected from the comboMealSelection comboBox.
     */
    @FXML
    public void selectRecipeFromCombo(){
        Recipe selectedRecipe = comboMealSelection.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null){
            mealMethod.setText(selectedRecipe.getMethod());
            //get the list of ingredients
            ObservableList<Ingredient> mealsIngredients = FXCollections.observableList(selectedRecipe.getIngredients());

            //set the ingredients to the listView
            mealIngred.setItems(mealsIngredients);

            //calculate and display the nutritional information of the meal
            String lineOne = calculateNutritionLineOne(selectedRecipe);
            String lineTwo = calculateNutritionLineTwo(selectedRecipe);
            browseMealNutritionOne.setText(lineOne);
            browseMealNutritionTwo.setText(lineTwo);

        }
    }

    /**
     * Displays the selected ingredient information in the textfields of the browse ingredient pane.
     * When a ingredient is selected in the ingredientsBrowseCombo comboBox this method will run.
     */
    @FXML
    public void ingredientsBrowseSelect(){
        Ingredient selectedIngredient = ingredientsBrowseCombo.getSelectionModel().getSelectedItem();
        if (selectedIngredient != null){
            ingredCalorieInputBrowse.setText(Double.toString(selectedIngredient.getCalorie()));
            ingredSugarInputBrowse.setText(Double.toString(selectedIngredient.getSugar()));
            ingredProteinInputBrowse.setText(Double.toString(selectedIngredient.getProtein()));
            ingredFiberInputBrowse.setText(Double.toString(selectedIngredient.getFiber()));
            ingredCarbsInputBrowse.setText(Double.toString(selectedIngredient.getCarbs()));
            ingredFatInputBrowse.setText(Double.toString(selectedIngredient.getFat()));
            ingredQuantityNameInputBrowse.setText(selectedIngredient.getQuantityName());
            ingredQuantityAmountInputBrowse.setText(Integer.toString((int)
                    Math.round(selectedIngredient.getSingleQuantityInGrams())));
        }
    }

    /**
     * Updates the currently selected ingredient, in the ingredientsBrowseCombo if the edit toggle button is on, in the
     * meals database.
     */
    @FXML
    public void UpdateIngred(){
        Ingredient selectedIngredient = ingredientsBrowseCombo.getSelectionModel().getSelectedItem();

        //create an ingredient to roll back too, incase of an error
        Ingredient rollBack = new Ingredient(selectedIngredient);

        //update the ingredients information using the data in the textfields
        try{
            selectedIngredient.setCalorie(Double.parseDouble(ingredCalorieInputBrowse.getText().trim()));
            selectedIngredient.setProtein(Double.parseDouble(ingredProteinInputBrowse.getText().trim()));
            selectedIngredient.setCarbs(Double.parseDouble(ingredCarbsInputBrowse.getText().trim()));
            selectedIngredient.setSugar(Double.parseDouble(ingredSugarInputBrowse.getText().trim()));
            selectedIngredient.setFiber(Double.parseDouble(ingredFiberInputBrowse.getText().trim()));
            selectedIngredient.setFat(Double.parseDouble(ingredFatInputBrowse.getText().trim()));
            selectedIngredient.setSingleQuantityInGrams(Double.parseDouble(ingredQuantityAmountInputBrowse.getText().trim()));
            selectedIngredient.setQuantityName(ingredQuantityNameInputBrowse.getText().trim());

            //if no quantity data entered throw an error
            if (ingredQuantityNameInputBrowse.getText().trim().equals("")){
                System.out.println("A quantity name needs to be entered");
                ingredientBox.errorDiaglogBox("Update ingredient", "No entry in the quantity name field");
                rollBackIngredientBrowseFields(rollBack);
                return;
            }

            //Create a service instance to update the ingredient in the database
            Service ingredientUpdateService = new UpdateIngredientService(selectedIngredient);
            ingredientUpdateService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {
                    //set the right ingredient
                    ingredientsBrowseCombo.getSelectionModel().select(selectedIngredient);
                    //disable the edit function
                    ingredBrowseEditToggle.setSelected(false);
                }
            });

            //run the update ingredient service
            if (ingredientUpdateService.getState() == Service.State.SUCCEEDED){
                ingredientUpdateService.reset();
                ingredientUpdateService.start();
            } else if (ingredientUpdateService.getState() == Service.State.READY){
                ingredientUpdateService.start();
            }

        } catch (NumberFormatException n){
            //if non numeric information is entered into the textfields for numerical properties this error is thrown
            ingredientBox.errorDiaglogBox("Ingredient update", "Please ensure that all fields have valid" +
                    " data entered");
            rollBackIngredientBrowseFields(rollBack);
        } catch (Exception e){
            System.out.println("Error updating the ingredients");
            ingredientBox.errorDiaglogBox("Ingredient update", "Error when updating ingredient");
            rollBackIngredientBrowseFields(rollBack);
        }
    }

    /**
     * Rollback the textfields in the ingredients browse pane if an update ingredient action failed and make the
     * ingredient read only again
     */
    public void rollBackIngredientBrowseFields(Ingredient rollBack){
        ingredCalorieInputBrowse.setText(Double.toString(rollBack.getCalorie()));
        ingredProteinInputBrowse.setText(Double.toString(rollBack.getProtein()));
        ingredCarbsInputBrowse.setText(Double.toString(rollBack.getCarbs()));
        ingredSugarInputBrowse.setText(Double.toString(rollBack.getSugar()));
        ingredFiberInputBrowse.setText(Double.toString(rollBack.getFiber()));
        ingredFatInputBrowse.setText(Double.toString(rollBack.getFat()));
        ingredQuantityAmountInputBrowse.setText(Double.toString(rollBack.getSingleQuantityInGrams()));
        ingredQuantityNameInputBrowse.setText(rollBack.getQuantityName());
        ingredBrowseEditToggle.setSelected(false);
    }

    /**
     * Clears the fields in the meal browser pane
     */

    public void clearMealBrowserFields(){
        mealMethod.clear();
        browseMealNutritionOne.setText("");
        browseMealNutritionTwo.setText("");
        mealIngred.getItems().clear();
        comboMealSelection.getSelectionModel().clearSelection();
    }


    /**
     * Update the breakfast Meal / Recipe option for the selected day in the planner / calendar pane. This method is run when the
     * update button in the breakfast section of the pane is selected.
     */

    @FXML
    public void updateBreakfast(){
        //get the selection from the listView
        try{
            //get the selected day from the weeklist
            Days selectedDay = weekList.getSelectionModel().getSelectedItem();
             if (breakfastCombo.getSelectionModel().getSelectedItem() != null){
                Recipe newBreakfastRecipe = breakfastCombo.getSelectionModel().getSelectedItem();
                selectedDay.setBreakfast(newBreakfastRecipe);
            }
        } catch (Exception e) {
            System.out.println("Nothing selected");
            e.printStackTrace();
        }
        weekList.refresh();
        //shopping list is now out of sync with the planner
        plannerOutOfSyncWithShoppingList(true);
        saveMealPlanner();
    }

    /**
     * Update the lunch Meal / Recipe option for the selected day in the planner / calendar pane. This method is run when the
     * update button in the lunch section of the pane is selected.
     */
    @FXML
    public void updateLunch(){
        //get the selection from the listView
        try{
            //get the selected day from the weeklist
            Days selectedDay = weekList.getSelectionModel().getSelectedItem();
            if (lunchCombo.getSelectionModel().getSelectedItem() != null){
                Recipe newLunchRecipe = lunchCombo.getSelectionModel().getSelectedItem();
                selectedDay.setLunch(newLunchRecipe);
            }
        } catch (Exception e) {
            System.out.println("Nothing selected");
        }

        weekList.refresh();
        //shopping list is now out of sync with the planner
        plannerOutOfSyncWithShoppingList(true);
        saveMealPlanner();
    }

    /**
     * Update the Dinner Meal / Recipe option for the selected day in the planner / calendar pane. This method is run when the
     * update button in the Dinner section of the pane is selected.
     */
    @FXML
    public void updateDinner(){
        //get the selection from the listView
        try{
            //get the selected day from the weeklist
            Days selectedDay = weekList.getSelectionModel().getSelectedItem();
            if (dinnerCombo.getSelectionModel().getSelectedItem() != null){
                Recipe newDinnerRecipe = dinnerCombo.getSelectionModel().getSelectedItem();
                selectedDay.setDinner(newDinnerRecipe);
            }
        } catch (Exception e) {
            System.out.println("Nothing selected");
        }
        weekList.refresh();
        //shopping list is now out of sync with the planner
        plannerOutOfSyncWithShoppingList(true);
        saveMealPlanner();
    }

    /**
     * Set the setShoppingListOutOfSync setting in the Settings
     * @param a True if shopping list and planner are out of sync. False if not.
     */
    private void plannerOutOfSyncWithShoppingList(boolean a){
        settings.setShoppingListOutOfSync(a);
    }

    /**
     * Delete the set breakfast Recipe / Meal from the selected day in the planner pane. Method run when bin icon
     * in breakfast section is clicked.
     */

    @FXML
    public void clearBreakfastPlanner(){
        //get the day selection
        Days selectedDay = weekList.getSelectionModel().getSelectedItem();
        if (selectedDay != null){
            selectedDay.setBreakfast(null);
            breakfastCombo.getSelectionModel().clearSelection();
            weekList.refresh();
        } else {
            System.out.println("No Day Selection made");
        }
        //shopping list is now out of sync with the planner
        plannerOutOfSyncWithShoppingList(true);
        saveMealPlanner();
    }

    /**
     * Delete the set lunch Recipe / Meal from the selected day in the planner pane. Method run when bin icon
     * in lunch section is clicked.
     */
    @FXML
    public void clearLunchPlanner(){
        //get the day selection
        Days selectedDay = weekList.getSelectionModel().getSelectedItem();
        if (selectedDay != null){
            selectedDay.setLunch(null);
            lunchCombo.getSelectionModel().clearSelection();
            weekList.refresh();
        } else {
            System.out.println("No Day Selection made");
        }
        //shopping list is now out of sync with the planner
        plannerOutOfSyncWithShoppingList(true);
        saveMealPlanner();
    }

    /**
     * Delete the set Dinner Recipe / Meal from the selected day in the planner pane. Method run when bin icon
     * in Dinner section is clicked.
     */
    @FXML
    public void clearDinnerPlanner(){
        //get the day selection
        Days selectedDay = weekList.getSelectionModel().getSelectedItem();
        if (selectedDay != null){
            selectedDay.setDinner(null);
            dinnerCombo.getSelectionModel().clearSelection();
            weekList.refresh();
        } else {
            System.out.println("No Day Selection made");
        }
        //shopping list is now out of sync with the planner
        plannerOutOfSyncWithShoppingList(true);
        saveMealPlanner();
    }

    /**
     * Clear all the meals / Recipes set in all of the Days in the weekList there by clearing the planner of
     * all meals / Recipes. Method runs when the clear planner button in the planner plane is clicked.
     */
    @FXML
    public void clearPlanner(){

        String confirmationBoxTitle = "Clear Planner";
        String confirmationMessage = "Are you sure you want to clear the planner?";

        //If the user confirms to clear the planner from the dialog box
        if (plannerBox.confirmDiaglogBox(confirmationBoxTitle, confirmationMessage)){
            for (Days dm : weekList.getItems()){
                dm.setBreakfast(null);
                dm.setLunch(null);
                dm.setDinner(null);
            }
            breakfastCombo.getSelectionModel().clearSelection();
            lunchCombo.getSelectionModel().clearSelection();
            dinnerCombo.getSelectionModel().clearSelection();
            weekList.refresh();

            //if the shopping List is greater than 0 then the cleared planner will not be synced to the shopping List
            if (shoppingListIngredients.size() > 0){
                plannerOutOfSyncWithShoppingList(true);
            } else {
                plannerOutOfSyncWithShoppingList(false);
            }

            saveMealPlanner();
        }

    }

    /**
     * When a new breakfast selection is made in the breakfastCombo ComboBox then update the displayed nutrition
     * information to the new selection nutrition information
     */

    @FXML
    public void breakfastComboSelectionMade(){
        if (breakfastCombo.getSelectionModel().isEmpty()){
            clearBreakfastNutrition();
        } else {
            Recipe selectedRecipe = breakfastCombo.getSelectionModel().getSelectedItem();
            displayBreakfastNutrition(selectedRecipe);
        }
        totalDaysNutrition();
    }

    /**
     * When a new lunch selection is made in the lunchCombo ComboBox then update the displayed nutrition
     * information to the new selection nutrition information
     */

    @FXML
    public void lunchComboSelectionMade(){
        if (lunchCombo.getSelectionModel().isEmpty()){
            clearLunchNutrition();
        } else {
            Recipe selectedRecipe = lunchCombo.getSelectionModel().getSelectedItem();
            displayLunchNutrition(selectedRecipe);
        }
        totalDaysNutrition();
    }

    /**
     * When a new dinner selection is made in the dinnerCombo ComboBox then update the displayed nutrition
     * information to the new selection nutrition information
     */

    @FXML
    public void dinnerComboSelectionMade(){
        if (dinnerCombo.getSelectionModel().isEmpty()){
            clearDinnerNutrition();
        } else {
            Recipe selectedRecipe = dinnerCombo.getSelectionModel().getSelectedItem();
            displayDinnerNutrition(selectedRecipe);
        }
        totalDaysNutrition();
    }

    /**
     * Display the passed Meal / Recipe nutritional information in the breakfast section of the planner.
     * @param breakfast Recipe / Meal of which to display the nutritional information
     */

    public void displayBreakfastNutrition(Recipe breakfast){
        //calculate the nutritional information of the Recipe / Meal and return the information as a string
        String lineOne = calculateNutritionLineOne(breakfast);
        String lineTwo = calculateNutritionLineTwo(breakfast);
        //format and display the breakfast nutritional information text
        setUpNutritionLabel(breakfastNutritionOne, breakfastColor, lineOne);
        setUpNutritionLabel(breakfastNutritionTwo, breakfastColor, lineTwo);
    }

    /**
     * Display the passed Meal / Recipe nutritional information in the lunch section of the planner.
     * @param lunch Recipe / Meal of which to display the nutritional information
     */

    public void displayLunchNutrition(Recipe lunch){
        //calculate the nutritional information of the Recipe / Meal and return the information as a string
        String lineOne = calculateNutritionLineOne(lunch);
        String lineTwo = calculateNutritionLineTwo(lunch);
        //format and display the lunch nutritional information text
        setUpNutritionLabel(lunchNutritionOne, lunchColor, lineOne);
        setUpNutritionLabel(lunchNutritionTwo, lunchColor, lineTwo);
    }

    /**
     *  Display the passed Meal / Recipe nutritional information in the dinner section of the planner.
     * @param dinner Recipe / Meal of which to display the nutritional information
     */

    public void displayDinnerNutrition(Recipe dinner){
        //calculate the nutritional information of the Recipe / Meal and return the information as a string
        String lineOne = calculateNutritionLineOne(dinner);
        String lineTwo = calculateNutritionLineTwo(dinner);
        //format and display the lunch nutritional information text
        setUpNutritionLabel(dinnerNutritionOne, dinnerColor, lineOne);
        setUpNutritionLabel(dinnerNutritionTwo, dinnerColor, lineTwo);
    }

    /**
     * Format and display nutritional information in label
     * @param l1 Label where the information will be displayed
     * @param color Color of the text to be displayed
     * @param text Text to be displayed in the label
     */

    private void setUpNutritionLabel(Label l1, String color, String text){
        l1.setText(text);
        l1.setTextFill(Paint.valueOf(color));
        l1.setFont(InterfaceStyling.systemFont);
    }

    /**
     * Calculate half of the nutritional information (calories, sugar, protein) for the passed Recipe / Meal and
     * format this information into a string to return.
     * @param meal The Meal / Recipe to calculate the nutritional information for
     * @return The nutritional information formatted as a string
     */

    private String calculateNutritionLineOne(Recipe meal){
        int calories = (int) Math.round(meal.getTotalCalories());
        int sugar = (int) Math.round(meal.getTotalSugar());
        int protein = (int) Math.round(meal.getTotalProtein());
        String lineOne = "Calories " + calories + "KCal\t Sugar " + sugar + " g\t\t Protein " + protein + " g";
        return lineOne;
    }

    /**
     * Calculate the other half of the nutritional information (fat, carbs, fibre) for the passed Recipe / Meal and
     * format this information into a string to return.
     * @param meal The Meal / Recipe to calculate the nutritional information for
     * @return The nutritional information formatted as a string
     */

    private String calculateNutritionLineTwo(Recipe meal){
        int fat = (int) Math.round(meal.getTotalFat());
        int carbs = (int) Math.round(meal.getTotalCarbs());
        int fibre = (int) Math.round(meal.getTotalFibre());
        String lineTwo = String.format("Fibre %3d g \t\t Carbs %d g \t\t Fat %d g", fibre, carbs, fat);
        return lineTwo;
    }

    /**
     * Clear the nutritional information displayed in the breakfast section
     */
    public void clearBreakfastNutrition(){
        breakfastNutritionOne.setText("");
        breakfastNutritionTwo.setText("");
    }

    /**
     * Clear the nutritional information displayed in the lunch section
     */
    public void clearLunchNutrition(){
        lunchNutritionOne.setText("");
        lunchNutritionTwo.setText("");
    }

    /**
     * Clear the nutritional information displayed in the dinner section
     */
    public void clearDinnerNutrition(){
        dinnerNutritionOne.setText("");
        dinnerNutritionTwo.setText("");
    }

    /**
     * Clear the nutritional information displayed in the daily nutrition information section
     */
    public void clearTotalNutrition(){
        totalNutritionOne.setText("");
        totalNutritionTwo.setText("");
    }

    /**
     * Calculate the total nutritional information for all the set meals of the day. Display and format that
     * information.
     */
    public void totalDaysNutrition(){

        //if no meals are set clear the daily nutritional information
        if (breakfastCombo.getSelectionModel().isEmpty() && lunchCombo.getSelectionModel().isEmpty() &&
        dinnerCombo.getSelectionModel().isEmpty()){
            clearTotalNutrition();
            return;
        }

        double totalCalories = 0;
        double totalSugar = 0;
        double totalProtein = 0;
        double totalFibre = 0;
        double totalCarbs = 0;
        double totalFat = 0;

        //get breakfast nutritional information
        //if there is a selection priorities over saved meal
        if (!breakfastCombo.getSelectionModel().isEmpty()){
            Recipe breakfast = breakfastCombo.getSelectionModel().getSelectedItem();
            totalCalories = breakfast.getTotalCalories();
            totalCarbs = breakfast.getTotalCarbs();
            totalSugar = breakfast.getTotalSugar();
            totalProtein = breakfast.getTotalProtein();
            totalFibre = breakfast.getTotalFibre();
            totalFat = breakfast.getTotalFat();
        }

        //get lunch nutritional information
        //if there is a selection priorities over saved meal
        if (!lunchCombo.getSelectionModel().isEmpty()){
            Recipe lunch = lunchCombo.getSelectionModel().getSelectedItem();
            totalCalories += lunch.getTotalCalories();
            totalCarbs += lunch.getTotalCarbs();
            totalSugar += lunch.getTotalSugar();
            totalProtein += lunch.getTotalProtein();
            totalFibre += lunch.getTotalFibre();
            totalFat += lunch.getTotalFat();
        }

        //get dinner nutritional information
        //if there is a selection priorities over saved meal
        if (!dinnerCombo.getSelectionModel().isEmpty()){
            Recipe dinner = dinnerCombo.getSelectionModel().getSelectedItem();
            totalCalories += dinner.getTotalCalories();
            totalCarbs += dinner.getTotalCarbs();
            totalSugar += dinner.getTotalSugar();
            totalProtein += dinner.getTotalProtein();
            totalFibre += dinner.getTotalFibre();
            totalFat += dinner.getTotalFat();
        }

        //round the totals
        int calories = (int) Math.round(totalCalories);
        int sugar = (int) Math.round(totalSugar);
        int protein = (int) Math.round(totalProtein);
        int fibre = (int) Math.round(totalFibre);
        int carbs = (int) Math.round(totalCarbs);
        int fat = (int) Math.round(totalFat);

        //format information into strings
        String lineOne = "Calories " + calories + "KCal\t Sugar " + sugar + " g\t\t Protein " + protein + " g";
        String lineTwo = "Fibre " + fibre + " g\t\t\t Carbs " + carbs + " g\t\t Fat " + fat + " g";

        //format and display the information in labels
        setUpNutritionLabel(totalNutritionOne, plannerColor, lineOne);
        setUpNutritionLabel(totalNutritionTwo, plannerColor, lineTwo);

    }

    /**
     * Exit program when red cross in top right of the program clicked
     */
    @FXML
    public void btnExitClicked(){
        System.exit(1);
    }

    /**
     * Minimise program when the horizontal line in the top right of the program is clicked
     * @param event
     */
    @FXML
    public void minimiseWindow(ActionEvent event){
        Button clickedButton = (Button)event.getSource();
        Stage s1 = (Stage) clickedButton.getScene().getWindow();
        s1.setIconified(true);
    }

    /**
     * Generate a shopping list of ingredients for all the meals / Recipes set in the planner then display the shopping
     * list. If an ingredient exists in multiple meals than combine the quantity totals together and display ingredient
     * once in the shopping list. If the exclude cupboard stores checkbox is clicked then if the stores has more than
     * the required quantity of an ingredient in the shopping list then remove completely from the shopping list,
     * if the cupboard stores only has partial amounts of the required quantity of an ingredient then reduce the
     * quantity required in the shopping list appropriately.
     */
    @FXML
    public void generateShoppingList(){

        shoppingListIngredients.clear();
        //loop through all days of the weeklist
        for (Days dm : ObservableWeekList){
            //if breakfast is set add ingredients to shopping list
            if (dm.isBreakfastSet()){
                shoppingListIngredients.addAll(dm.getBreakfast().getIngredients());
            }
            //if lunch is set add ingredients to shopping list
            if (dm.isLunchSet()){
                shoppingListIngredients.addAll(dm.getLunch().getIngredients());
            }
            //if dinner is set add ingredients to shopping list
            if (dm.isDinnerSet()){
                shoppingListIngredients.addAll(dm.getDinner().getIngredients());
            }
        }

        //Sort list into alphabetical order and combine repeat ingredients together adding up their quantities
        if (shoppingListIngredients.size() > 0){
            //sort the order of the list into alphabetical by ingredient name
            shoppingListIngredients.sort( ((o1, o2) -> o1.getName().compareTo(o2.getName())));
            if (shoppingListIngredients.size() > 1){
                for (int i = 0; i < shoppingListIngredients.size() -1; i ++){
                    //get the unique ID of the ingredients to compare
                    int firstIngredientID = shoppingListIngredients.get(i).getId();
                    int secondIngredientID = shoppingListIngredients.get(i+1).getId();
                    //if the ingredients are the same. Add their quantities together and remove one of them
                    if (firstIngredientID == secondIngredientID){
                        double firstIngredientQuantity = shoppingListIngredients.get(i).getQuantityInGrams();
                        double secondIngredientQuantity = shoppingListIngredients.get(i+1).getQuantityInGrams();
                        shoppingListIngredients.get(i).setQuantityInGrams(firstIngredientQuantity +
                                                                            secondIngredientQuantity);
                        shoppingListIngredients.remove(i + 1);
                        //if an ingredient is removed from the list then i needs to be rolled back by one so that
                        //no ingredient is missed
                        i --;
                    }
                }
            }
        }

        //compare the cupboard ingredients list with shopping list. If the shopping list ingredient exists in the
        //cupboard stores then:
        //- If the cupboard stores has more than the required amount in shopping list, remove the ingredient from
        //  the shopping list
        //- If the cupboard stores only has some of quantity required in the shopping list, reduce the quantity in the
        //  the shopping list
        if (cupboardCheckBox.isSelected()){
            for (int z = 0; z < shoppingListIngredients.size(); z++){
                Ingredient shoppingIngredient = shoppingListIngredients.get(z);
                for (Ingredient cupboardIngredients: cupboardIngredients){
                    if (shoppingIngredient.getId() == cupboardIngredients.getId()){
                        //if the shopping list ingredients is already in the cupboard
                        if (cupboardIngredients.getQuantityInGrams() > shoppingIngredient.getQuantityInGrams()){
                            //if there is enough in the the cupboard remove item from the shopping list
                            shoppingListIngredients.remove(shoppingIngredient);
                            z --;
                        } else {
                            //if there isnt enough in the cupboard stores
                            //remove the cupboard amount from the shopping item
                            double newAmountInGrams = shoppingIngredient.getQuantityInGrams() 
                                    - cupboardIngredients.getQuantityInGrams();
                            shoppingIngredient.setQuantityInGrams(newAmountInGrams);
                        }
                    }
                }
            }
        }

        //When the shopping list is newly generated then the planner and shopping list are in sync
        plannerOutOfSyncWithShoppingList(false);
        //save when the shopping list was generated
        settings.setGeneratedShoppingList(LocalDateTime.now());
        //go to view the shopping list pane to view the shopping list straight away
        plannerShoppingListBtnClicked();

        //save the shopping list
        Data.<Ingredient>saveList(shoppingListIngredients, shoppingListFile);

    }


    /**
     * Filters the list of ingredients loaded from database based on what is typed into searchIngredientCupboard
     * textfield and displays the filtered results in allIngredientsCupboardPane ListView. This method is run everytime
     * a key stroke is registered in the searchIngredientCupboard textfield.
     */

    @FXML
    public void filterCupboardIngredients(){
        String searchText = searchIngredientCupboard.getText();
        List<Ingredient> filteredList = ingredientsFromDatabase.stream().filter(new Predicate<Ingredient>() {
            @Override
            public boolean test(Ingredient ingredient) {
                //inclusive of the upper cases makes it case insensitive
                if (ingredient.getName().toUpperCase().contains(searchText.toUpperCase())){
                    return true;
                } else {
                    return false;
                }
            }
        }).collect(Collectors.toList());
        filterObservableList = FXCollections.observableList(filteredList);
        allIngredientsCupboardPane.setItems(filterObservableList);
    }

    /**
     * Creates a deep copy of the selected ingredient from the allIngredientsCupboardPane and sets its quantity as
     * defined by the user. Adds this deep copied ingredient to the cupboardIngredients ListView. Method runs when the
     * add button in the planner cupboard pane is clicked
     */

    @FXML
    public void addIngredientToCupboard(){
        //Check if quantity has been entered
        if (ingredientQuantityInputCupboard.getText().trim().equals("") && cupboardQuantityNumber.getText().trim().equals("")){
            plannerBox.errorDiaglogBox("Enter Quantity", "Please enter a ingredient quantity");
        } else {
            try{
                Ingredient ingred = allIngredientsCupboardPane.getSelectionModel().getSelectedItem();
                if (ingred == null){
                    System.out.println("No ingredient selected");
                } else {
                    Double QuantityInGrams;
                    if (!ingredientQuantityInputCupboard.getText().trim().equals("")){
                        //get the quantity of ingredient in grams
                        QuantityInGrams = Double.parseDouble(ingredientQuantityInputCupboard.getText().trim());
                    } else {
                        //calculate the quantity in grams
                        QuantityInGrams = ingred.getSingleQuantityInGrams() *
                                Double.parseDouble(cupboardQuantityNumber.getText().trim());
                    }

                    //make a deep copy of the ingredient
                    Ingredient deepCopyIngredient = new Ingredient(ingred);
                    //add the user defined quantity to the deep copy
                    deepCopyIngredient.setQuantityInGrams(QuantityInGrams);

                    //add to the observable list that is set to the listView
                    cupboardIngredients.add(deepCopyIngredient);

                    //save the latest cupboard details to the file
                    Data.<Ingredient>saveList(cupboardIngredients, cupboardFile);

                    //clear the data input boxs
                    ingredientQuantityInputCupboard.clear();
                    cupboardQuantityNumber.clear();
                }
            } catch (Exception e){
                //Throw error if issue adding ingredient to cupboard, could be due to no quantity entered or no
                //ingredient selected
                System.out.println("No ingredient has been selected to be added (Cupboard Pane): " + e.getMessage());
                plannerBox.errorDiaglogBox("Error", "Error adding ingredient to cupboard, have you entered" +
                        " a validate quantity?");
            }
        }
    }

    /**
     * Remove the selected ingredient in the IngredientsInCupboard listView. Method runs when the remove button in the
     * planner cupboard pane is clicked.
     */
    @FXML
    public void removeIngredFromCupboard(){
        try{
            Ingredient ingredientToRemove = IngredientsInCupboard.getSelectionModel().getSelectedItem();
            cupboardIngredients.remove(ingredientToRemove);
            //save the latest cupboard details to the file
            Data.<Ingredient>saveList(cupboardIngredients, cupboardFile);
        } catch (Exception e){
            //no ingredient selected in the IngredientsInCupboard listView
            e.printStackTrace();
            System.out.println("Issue removing ingredient from cupboad: " + e.getMessage());
            plannerBox.errorDiaglogBox("Removing Ingredient", "There was an error when removing" +
                    "ingredient from cupboard list");
        }
    }

    /**
     * Clear all the ingredients from the Ingredients cupboard. Run when the clear cupboard button in the planner
     * cupboard pane is clicked. Asks for user confirmation via a dialog box before executing the clear.
     */
    @FXML
    public void clearCupboardIngredients(){

        String title = "Clear Cupboard";
        String message = "Are you sure you want to clear cupboard ingredients";
        boolean confirmClear = plannerBox.confirmDiaglogBox(title, message);
        if (confirmClear){
            if (cupboardIngredients.size() > 0){
                cupboardIngredients.clear();
                Data.<Ingredient>saveList(cupboardIngredients, cupboardFile);
            }
        }
    }

    /**
     * Clears the shopping list, asks for user confirmation before running via a dialog box. Runs when the clear list
     * button is clicked in the planner shopping list pane.
     */
    @FXML
    public void btnClearShoppingListClicked(){

        //run confirmation dialog box
        String title = "Clear ShoppingList";
        String message = "Are you sure you want to clear shopping list";
        boolean confirmClear = plannerBox.confirmDiaglogBox(title, message);

        if (confirmClear){
            shoppingListIngredients.clear();
            //no generated shopping list so no date of generated shopping list
            settings.setGeneratedShoppingList(null);
            //save the blank list
            Data.<Ingredient>saveList(shoppingListIngredients, shoppingListFile);
            //when the shopping list is cleared if the planner still has meals / Recipes in then
            //the shopping list and the planner are out of sync, set the warning and settings
            for (Days dm : ObservableWeekList){
                if (!dm.noMealsSet()){
                    settings.setShoppingListOutOfSync(true);
                    labelWarningShoppingList.setVisible(true);
                    return;
                }
            }
            //if there is no meals in the planner then the shopping list and the planner are in sync
            settings.setShoppingListOutOfSync(false);
            labelWarningShoppingList.setVisible(false);
        }
    }

    /**
     * Export the shopping list to a user define text file. The user will get a FileChooser window to select the
     * location and file name for the shopping list.
     */

    @FXML
    public void exportShoppingList(){

        //set up the file chooser window with title and allowable file extensions
        FileChooser saveFileWindow = new FileChooser();
        saveFileWindow.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Documents (*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("All files", "*.*"));
        saveFileWindow.setTitle("Save Shopping List");

        //open the file chooser
        File saveFile = saveFileWindow.showSaveDialog(PlannerPlanPane.getScene().getWindow());
        //if a file is choosen
        if (saveFile != null){
            //get file path
            String fileName = saveFile.getPath();
            try{
                //run static method to save the shopping list as a text file
                ExportShoppingList.writeToTextFile(shoppingListIngredients, fileName,
                        settings.getGeneratedShoppingListDateAsString());
            } catch (Exception e){
                //problem saving the shopping list
                System.out.println("Problem saving shopping list to text file");
                plannerBox.errorDiaglogBox("Saving Shopping List", "There was an issue saving the " +
                        "shopping list to a text file it maynot have saved");
            }
        } else {
            //If the file chooser is cancelled
            System.out.println("No file selected");
        }
    }

    /**
     * Add on and off focus styling to all the minimise and exit buttons used in the various different panes
     * of the program. This will enable the user to see where the mouse pointer is pointed.
     */

    public void setupWindowButtons(){
        focusPropertyButton(btnExitProgramPlannerPlanPane);
        focusPropertyButton(btnExitProgramPlannerShoppingListPane);
        focusPropertyButton(btnExitProgramPlannerCupboardPane);
        focusPropertyButton(btnMinimiseProgramPlannerPlanPlane);
        focusPropertyButton(btnMinimiseProgramPlannerShoppingListPane);
        focusPropertyButton(btnMinimiseProgramPlannerCupboardPane);
        focusPropertyButton(btnExitProgramMealsBrowsePane);
        focusPropertyButton(btnMinimiseProgramMealsBrowsePane);
        focusPropertyButton(btnExitProgramMealsAddPane);
        focusPropertyButton(btnMinimiseProgramMealsAddPane);
        focusPropertyButton(btnExitProgramIngredBrowse);
        focusPropertyButton(btnMinimiseProgramIngredBrowse);
        focusPropertyButton(btnExitProgramIngredAdd);
        focusPropertyButton(btnMinimiseProgramIngredAdd);

    }

    /**
     * Add dropshadow styling to a button if a mouse pointer is hovering over it
     * @param btn The button to style
     */

    public void focusPropertyButton(Button btn){
        btn.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1){
                    InterfaceStyling.dropShadowExitSelect(btn);
                } else {
                    InterfaceStyling.dropShadowExitDeselect(btn);
                }
            }
        });
    }

    /**
     * Style the listView listCells to display the Ingredient name
     * @param lv The listView to style
     */
    public void styleIngredientListCell(ListView<Ingredient> lv){
        Callback<ListView<Ingredient>, ListCell<Ingredient>> ingredientsBasicFormat =
                new Callback<ListView<Ingredient>, ListCell<Ingredient>>() {
            @Override
            public ListCell<Ingredient> call(ListView<Ingredient> ingredientListView) {
                ListCell<Ingredient> cell = new ListCell<>(){
                    @Override
                    protected void updateItem(Ingredient ingredient, boolean empty) {
                        super.updateItem(ingredient, empty);
                        if (empty){
                            setText(null);
                        } else {
                            setText(ingredient.getName());
                        }
                        setFont(InterfaceStyling.textFieldFont);
                    }
                };
                return cell;
            }
        };
        lv.setCellFactory(ingredientsBasicFormat);
    }

    /**
     * Style the listView listCells to display the Ingredient name and ingredient quantity (both the grams and the
     * number of its quantity name)
     * @param lv The listView to style
     */
    public void styleIngredientAddedListCell(ListView<Ingredient> lv){
        Callback<ListView<Ingredient>, ListCell<Ingredient>> ingredientsQuantityFormat = new Callback<ListView<Ingredient>, ListCell<Ingredient>>() {
            @Override
            public ListCell<Ingredient> call(ListView<Ingredient> ingredientListView) {
                ListCell<Ingredient> cell = new ListCell<>(){
                    @Override
                    protected void updateItem(Ingredient ingredient, boolean empty) {
                        super.updateItem(ingredient, empty);
                        if (empty){
                            setText(null);
                        } else {
                            String quantityName = ingredient.getQuantityName();
                            double quantityInGrams = ingredient.getQuantityInGrams();
                            double quantityRatio = (quantityInGrams / ingredient.getSingleQuantityInGrams());

                            //for formating. quantity in grams is to have no decimal places and the quantity
                            //ratio is to have a maximum of one decimal place
                            DecimalFormat df = new DecimalFormat("#.#");
                            DecimalFormat df2 = new DecimalFormat("#");

                            //eg if more than one egg, it should read eggs
                            if (quantityRatio > 1){
                                quantityName = quantityName + "s";
                            }

                            setText( ingredient.getName() + " ( " + df2.format(quantityInGrams) + " grams / "  +
                                    df.format(quantityRatio) + " " + quantityName + ")");
                        }
                        setFont(InterfaceStyling.textFieldFont);
                    }
                };
                return cell;
            }
        };
        lv.setCellFactory(ingredientsQuantityFormat);
    }

    /**
     * Set the labels text to equal the quantity name of the selected ingredient in the listView
     * @param lv The listView with the selected name
     * @param label The label that will display the quantity name
     */
    public void dynamicQuantityLabelSetUp(ListView<Ingredient> lv, Label label){
        lv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ingredient>() {
            //use the changeListener to determine when a new ingredient has been selected
            @Override
            public void changed(ObservableValue<? extends Ingredient> observableValue, Ingredient ingredient, Ingredient t1) {
                if (t1 != null){
                    //if the new ingredient selected is not null then
                    //get the Quantity name from the selected ingredient in the listView
                    Ingredient selectedIngredient = lv.getSelectionModel().getSelectedItem();
                    String quantityName = selectedIngredient.getQuantityName();
                    label.setText(quantityName);
                }
            }
        });
    }

    /**
     * Load the shopping List from the external file and display it in the shoppinglist listView
     */
    public void loadShoppingList(){
        try{
            //load the shopping list from the external file
            List<Ingredient> returnedList = Data.<Ingredient>loadList(shoppingListFile);
            if (returnedList != null){
                //convert list to an observableList
                shoppingListIngredients = FXCollections.observableList(returnedList);
                //set to the shopping list
                shoppingList.setItems(shoppingListIngredients);
            } else {
                System.out.println("No Shopping List Loaded ");
            }
        } catch (Exception e){
            System.out.println("Unable to load shopping list from file " + shoppingListFile +
                    ", the file may not exist");
            e.printStackTrace();
        }
    }

    /**
     * Save the planner to an external file
     */
    public void saveMealPlanner(){
        Data.<Days>saveList(ObservableWeekList, mealPlannerFile);
    }

    /**
     * Load the planner from an external file and set to the display in the planner pane weeklist
     */
    public void loadMealPlanner(){
        try{
            //load the planner list of Days
            List<Days> returnedList = Data.<Days>loadList(mealPlannerFile);
            if (returnedList != null){
                //set to weeklist
                ObservableWeekList = FXCollections.observableList(returnedList);
                weekList.setItems(ObservableWeekList);
            } else {
                System.out.println("No meal planner Loaded ");
            }
        } catch (Exception e){
            System.out.println("Unable to load meal planner from file " + shoppingListFile +
                    ", the file may not exist");
            e.printStackTrace();
        }
    }

    /**
     * Search a Recipe comboBox for a Recipe using the Recipe ID.
     * @param id The ID of the Recipe to find
     * @param combo The ComboBox to search for the Recipe
     * @return The recipe if it is found, null if no recipes in the comboBox have that ID
     */
    public Recipe findRecipeFromID(int id, ComboBox<Recipe> combo){
        //loop through all the Recipes in the ComboBox
        for (Recipe r: combo.getItems()){
            if (r.getId() == id){
                return r;
            }
        }
        return null;
    }

    /**
     * Set the Breakfast, lunch and Dinner comboBoxs in the planner pane to display the same Recipes / Meals of the
     * selected day in the weeklist listView.
     */
    public void plannerDisplayComboBoxs(){
        Days dm = weekList.getSelectionModel().getSelectedItem();
        if (dm.isBreakfastSet()){
            //find Recipe set for breakfast in the Days in the comboBox and display it in the comboBox
            Recipe breakfast = findRecipeFromID(dm.getBreakfast().getId(), breakfastCombo);
            breakfastCombo.getSelectionModel().select(breakfast);
        }

        if (dm.isLunchSet()){
            //find Recipe set for lunch in the Days in the comboBox and display it in the comboBox
            Recipe lunch = findRecipeFromID(dm.getLunch().getId(), lunchCombo);
            lunchCombo.getSelectionModel().select(lunch);
        }

        if (dm.isDinnerSet()){
            //find Recipe set for dinner in the Days in the comboBox and display it in the comboBox
            Recipe dinner = findRecipeFromID(dm.getDinner().getId(), dinnerCombo);
            dinnerCombo.getSelectionModel().select(dinner);
        }
    }

    /**
     * When exclude cupboard ingredients checkbox is selected / deselected set the setting for excluding cupboard
     * stores appropriately
     */
    @FXML
    public void updateExcludeCupboardStores(){
        if (cupboardCheckBox.isSelected()){
            settings.setExcludeCupboard(true);
        } else {
            settings.setExcludeCupboard(false);
        }
    }


}
