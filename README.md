# Meal Planner

![CalendarView](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/calendar.jpg?raw=true)

## Introduction

A Meal Planner application built in Java, JavaFX and SQL that can:
-	Add, Browse and Edit Ingredients
-	Create and browse Meals
-	Create a meal plan with up to 3 meals a day for up to 7 days
-	Generate a shopping list of ingredients for that meal plan
-	Choose to exclude ingredients already in cupboard stores from that shopping list
-	Export the shopping list to a text file
-	Save the application state for future use
The meal planner application with built using Java 11.0.4, JavaFX-11 and sqlite-jdbc-3.30.1 for the database functionality. Using Intellij, SceneBuilder and DB Browser (SQLite). 

## Application Walk Through

The meal planner application main menu located on the left of the app has three options to choose from:
1.	Ingredients (apple icon)
2.	Meals (cutlery icon) 
3.	Planner (calendar icon). 

### Ingredients

In the ingredients section of the application user can add, browser and edit ingredients. When the ingredients icon in the main menu is click, the sub menu (grey bar) will show options for the user to Add or to Browse Ingredients.

#### Add

![IngredientsAdd](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/ingredientsAdd.jpg?raw=true)

To add a new ingredient to the application users must fill out all the text fields in the add ingredients pane:
-	Ingredient Name 
-	Nutritional information of that ingredient per 100 grams; Calories (Kcal), Sugar (grams), Protein (grams), Fibre (grams), Carbs (grams) and Fat (grams).
-	Fixed Quantity Name, the name for one portion of that ingredient, for example for the ingredient bread this would be Slice, for the ingredient Carrot this could be, A medium Carrot and for chopped tomatoes this would be a Tin. 
-	Quantity Amount, the amount in grams of that fixed quantity name. For example a tin of chopped tomatoes could be 400 g, Slice of bread 36 grams. 
To save the newly entered ingredient in the application the user clicks ‘Save Ingredient’. Warning messages will be displayed if there is an error with the entered information.

![IngredientsAddError](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/ingredientsAddError.jpg?raw=true)

#### Browse

![IngredientsBrowse](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/ingredientsBrowse.jpg?raw=true)

In the browse ingredients sub section, the user can use the dropdown box labelled Ingredient to select the ingredient they want to view. The ingredients information will then be displayed in the text fields below it. For information about the text fields see the ingredients add section above.
If the user wants to edit the ingredient’s information, they can click on the Edit button and change one or more text fields and click the ‘Update Ingredient’ button to save the updated ingredient information. 
Warning messages will be displayed if there is an error with the updated information.

![IngredientsBrowseError](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/ingredientsBrowseError.jpg?raw=true)
