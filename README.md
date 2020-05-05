# Meal Planner

![CalendarView](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/calendar.jpg?raw=true)
*Figure 1 Image of the Planners Calendar Section*

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

In the ingredients section of the application user can add, browser and edit ingredients. When the ingredients icon in the main menu is clicked, the sub menu (grey bar) will show options for the user to Add or to Browse Ingredients.

#### Add

![IngredientsAdd](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/ingredientsAdd.jpg?raw=true)
*Figure 2 Ingredients add section*

To add a new ingredient to the application users must fill out all the text fields in the add ingredients pane:
-	Ingredient Name 
-	Nutritional information of that ingredient per 100 grams; Calories (Kcal), Sugar (grams), Protein (grams), Fibre (grams), Carbs (grams) and Fat (grams).
-	Fixed Quantity Name, the name for one portion of that ingredient, for example for the ingredient Bread this would be Slice, for the ingredient Carrot this could be, A medium Carrot and for Chopped Tomatoes this would be a Tin. 
-	Quantity Amount, the amount in grams of that fixed quantity name. For example a tin of Chopped Tomatoes could be 400 g, Slice of Bread 36 grams. 

To save the newly entered ingredient in the application the user clicks ‘Save Ingredient’. Warning messages will be displayed if there is an error with the entered information.

![IngredientsAddError](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/ingredientsAddError.jpg?raw=true)

*Figure 3 Dialog box to indicate an error in adding a new Ingredient*

#### Browse

![IngredientsBrowse](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/ingredientsBrowse.jpg?raw=true)
*Figure 4 Ingredient browse section*

In the browse ingredients sub section, the user can use the dropdown box labelled Ingredient to select the ingredient they want to view. The ingredients information will then be displayed in the text fields below it. For information about the text fields see the ingredients add section above.

If the user wants to edit the ingredient’s information, they can click on the Edit button and change one or more text fields and click the ‘Update Ingredient’ button to save the updated ingredient information. 

Warning messages will be displayed if there is an error with the updated information.

![IngredientsBrowseError](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/ingredientsBrowseError.jpg?raw=true)

*Figure 5 Dialog box indicating an error editing the ingredient details*

### Meals

If the user clicks the Meals main menu button, represented by the cutlery icon, they will enter the meals section of the application. Here users can create meals and browse previously created meals. When the cutlery icon is clicked the sub menu (grey bar) will show options for the user to add meals or browse meals.

#### Add

![MealsAdd](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/mealsAdd.jpg?raw=true)
*Figure 6 Add meal section*

Users can create meals, to do so they must define:

-	Meal Name
-	Meal Ingredients
-	Meal Method

The meal name and meal method are simple text inputs. The meal ingredients is more complex, in the left hand list is a full list of ingredients that the user can scroll through, they can also type in some or all of the ingredients name in the search ingredients text field to filter the list of ingredients. 

![MealsAddFilterIngredients](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/mealsAddFilter.jpg?raw=true)
                                      *Figure 7 Using the search ingredient feature in add meals section*

Once the user has located the ingredient they want to add they select it and the quantity name for one portion will appear under set amount label. The user can then either add the quantity of the ingredient in grams or as number of portions. Once they click ‘Add’ button, the ingredient and the quantity of that ingredient will be displayed in the Meal ingredients list on the right. 

![MealsAddIngredientsAdd](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/mealsAddIngred.jpg?raw=true)
*Figure 8 Ingredient with a specified quantity added to the meal*

Ingredients can also be removed from the Meal Ingredients list by selecting the ingredient and clicking the ‘Remove’ button. 

![mealsAddComplete](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/mealsAddComplete.jpg?raw=true)
*Figure 9 Complete form for adding a meal*

Once all the fields have been completed click ‘Save Meal’ and the meal will be saved to the application. 

If there is an error when entering or saving meal information an error message dialog box will display.

![mealsAddError](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/mealsAddError.jpg?raw=true)

*Figure 10 Error message shown if meal is tried to be saved with fields incomplete*

#### Browse

The browse meals option gives users the ability to look at the details of all the meals that have been added to the application.

![mealsBrowse](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/mealsBrowse.jpg?raw=true)
*Figure 11 Browse the meals section*

The Select Meal drop down menu at the top of the page allows the user to select the meal that they want to view. The ingredients, method and the total nutritional information for that meal will then be displayed. 

### Planner

When the user selects the calendar icon in the main menu, they will go to the planner section of the program, where the sub menu (grey bar) will allow them to choose between Calendar, Shopping List and Cupboard options.

#### Calendar

![calendar](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/calendar.jpg?raw=true)
*Figure 12 Calendar planner section*

The Calendar section of the meal planner application allows the user to plan what meals they have for the week ahead. The calendar shows 7 days, Monday to Sunday, in a list format. For each day the user can set up to three meals: Breakfast, Lunch and Dinner. 

When the user clicks on a day in the list, they can then select what meal that want for breakfast by selecting a meal from the drop down box in the breakfast section, if they click update then that meal will then be set for that day and will be reflected in the calendar list. The same is true for selecting lunch and dinner for that day. If the user wants to change the meal they choosen they can simply choose another and click update to override it. If they want to delete it, they can click on the rubbish bin icon next to the update button.

![calendar2](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/calendar2.jpg?raw=true)
*Figure 13 Selecting a new meal for breakfast on Friday*

Users can then select another day in the calendar list and select and update the meals for that day.

The nutritional information of the meal that is selected will be displayed below the drop down list box and the combined nutritional information for all meals of that day is detailed in the daily nutritional information section.  

Once the user has completed their meal plan for the week they can then click on the ‘Generate Shopping List’ button to produce a shopping list of all the ingredients for the meals they have planned for, the application will then show the user their shopping list in the shopping list section. If the user wants to remove items from the shopping list they already have in the cupboard (See Cupboard section) then they can click the ‘Exclude Cupboard Stores’ checkbox before clicking ‘Generate Shopping List’.

If the user wants to clear the whole calendar they can click ‘Clear Calendar’ and confirm that they want to clear the whole calendar via a dialog box.

![calendarClearConfirm](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/calendarClearConfirm.jpg?raw=true)

*Figure 14 Confirmation dialog box if the user request to clear calendar*

#### Shopping List

When the user fills out some or all of the calendar planner and clicks ‘Generate Shopping List’ the application will gather all the ingredients and their quantities from the meals in the planner and create a shopping list for those meals. If one ingredient occurs in multiple meals, then their quantities are combined and the ingredient is only shown once in the list.

![shoppingList](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/shoppingList.jpg?raw=true)
*Figure 15 Shopping list section*

The date and time the shopping list was generated is displayed above the list. If after the shopping list has been generated the user edits the calendar in anyway, or either the shopping list or the calendar is cleared a warning message will be displayed next to the shopping list to notify the user that the shopping list may not reflect the ingredients of the meals in the current calendar. If the user wants to ensure the shopping list matches the current calendar view, they simply have to click ‘Generate Shopping List’ in the calendar section of the program again. 

![shoppingList2](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/shoppingList2.jpg?raw=true)
*Figure 16 Shopping list section showing warning that shopping list and calendar are out of sync*

The user can export the shopping list as a text file by clicking on the ‘Export’ button. 

![shoppingListExport](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/shoppingListExport.jpg?raw=true)
*Figure 17 Exporting the shopping list to a text file*

They are presented with a ‘Save Shopping List’ window where they can select the location and name the text file to save.

The user can also clear the shopping list by clicking the ‘Clear List’ button. They will be asked for confirmation below the list is cleared.

![shoppingListClear](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/shoppingListClear.jpg?raw=true)

*Figure 18 Confirmation dialog to clear shopping list*

#### Cupboard

![Cupboard](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/cupboard.jpg?raw=true)
*Figure 19 Cupboard section*

The cupboard sub section of the planner section is used to specify what ingredients the user already has in their stores. The user can choose to take account of this when they are generating the shopping list or not. If they do then if an ingredient on the shopping list is already in the cupboard then:

-	If there is a greater quantity of the ingredient in the cupboard than in the shopping list, then the item is removed from the shopping list
-	If there is a lesser quantity of the ingredient in the cupboard than is required for the shopping list then, the amount of the ingredient in the cupboard is removed from the amount of the ingredient in the shopping list, but the item will remain on the shopping list

Note, the ingredient quantities in the Cupboard will not be reduced when the shopping list is generated.

The interface of the Cupboard sub section is similar too part of the Add Meal interface. The user can select the ingredient that they have in their cupboard stores from the list of all ingredients on the left, they can also use the search ingredient text field to filter the list for ease of use.  

![CupboardSearch](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/cupboardSearch.jpg?raw=true)
*Figure 20 Searching for an ingredient to add to the cupboard*

Once the user selects the ingredient to add they must add a quantity either in grams or in portions for example a Tin and click the ‘Add’ button to include it into the Ingredients in Cupboard list. If a user wants to remove an ingredient from the Ingredients in Cupboard list they need to select the ingredient and click the ‘Remove’ button. 

The user can also clear the entire list of Ingredients in Cupboard by clicking the ‘Clear Cupboard’ button, if they do this they will be asked to confirm their choice. 

If an error is made when adding or removing an ingredient from the Ingredients in Cupboard list then they are notified via a dialog box. 

![CupboardError](https://github.com/arlw87/Meal-Planner/blob/master/ReadMe-Images/cupboardError.jpg?raw=true)

*Figure 21 Error dialog if no quantity specified when adding ingredient to cupboard*

## Other Information

The application saves the state of meal planner calendar list, the shopping list, the cupboard ingredients list and various settings, every time they are updated, in external files. The user can therefore close the application and know that when the application is opened again the program will be in the same state it was before it was closed.  




