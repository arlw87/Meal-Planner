package home;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Create the custom ListCell for the meal planner list.
 * This class extends the ListCell and using the updateItem and createCell method it creates a customised
 * ListCell that displays the recipe names of breakfast, lunch and dinner from the DaysMeals, if set, in coloured
 * rectanglar shapes to make each recipe clearly represent what meal time (breakfast, lunch, dinner )
 * those recipes are set for.
 */

public class WeekCell extends ListCell<Days> {

    private String colorBreakfast;
    private String colorLunch;
    private String colorDinner;
    private String colorBreakfastLight;
    private String colorLunchLight;
    private String colorDinnerLight;
    private String weekCellFontColor;
    private double cellHeight;
    private double cellWidth;

    //final variables
    public static final int seperatorWidth = 200;
    public static final int seperatorHeight = 2;

    public WeekCell(String color1, String color2, String color3, String color4, String color5,
                    String color6, String color7, double height, double width) {
        super();
        colorBreakfast = color1;
        colorLunch = color2;
        colorDinner = color3;
        colorBreakfastLight = color4;
        colorLunchLight = color5;
        colorDinnerLight = color6;
        weekCellFontColor = color7;
        cellHeight = height;
        cellWidth = width;
    }

    /**
     * Customise how the listCell looks. Calling the createCell method with current daysMeals
     * that returns a VBox node, containing the daysMeal represented in graphical form
     * @param days
     * @param empty
     */
    @Override
    protected void updateItem(Days days, boolean empty) {
        super.updateItem(days, empty);
        if (empty){
            setText("");
        } else {
            setGraphic(createCell(days));
            setPrefHeight(cellHeight);
        }
    }

    /**
     * Using the current DaysMeals create a VBox that shows a single column table representing which and what meals have
     * been set for that day. At the top of the VBox will be the day and underneath that if a meal has been set,
     * its name will be displayed in a row of the VBox and highlighted with a defined color.
     * @param days
     * @return VBox representing which and what meals have been set for the day
     */
    private VBox createCell(Days days){

        //define the height and width of a VBox Row
        double mealHeight = Math.round(cellHeight / 5);
        double mealWidth = Math.round(cellWidth - 50);
        int mealTextSize = 12;

        VBox v1 = new VBox();
        v1.setAlignment(Pos.CENTER);

        //set Day Label
        Label l1 = new Label(days.getDay());
        l1.setFont(InterfaceStyling.titleFontNonBold);
        l1.setTextFill(Color.valueOf(weekCellFontColor));
        v1.getChildren().add(l1);

        //Setting Margins isnt possible so create a couple of seperator spaces using Regions
        Region seperatorRec = new Region();
        seperatorRec.setStyle("-fx-background-color: transparent;" + "-fx-min-width: " + seperatorWidth +
                "; -fx-min-height:" + seperatorHeight + "; " +
                "-fx-max-width: " + seperatorWidth + "; -fx-max-height: " + seperatorHeight + ";");

        Region seperatorRec2 = new Region();
        seperatorRec2.setStyle("-fx-background-color: transparent;" + "-fx-min-width: " + seperatorWidth +
                "; -fx-min-height:" + seperatorHeight + "; " +
                "-fx-max-width: " + seperatorWidth + "; -fx-max-height: " + seperatorHeight + ";");

        //if the daysMeal has a Recipe / Meal set for breakfast create a rectangle (Region) with that recipes name in
        // and add to the vbox
        if (days.isBreakfastSet()){
            //Breakfast Region
            Region rectOne = new Region();
            //Style the region using css with the appropriate colors and dimensions
            rectOne.setStyle("-fx-background-color: #" + colorBreakfastLight +
                    "; -fx-border-style: solid; -fx-border-width: 0 0 0 10; " +
                    "-fx-border-color: #" + colorBreakfast + " ; -fx-min-width: " + mealWidth +
                    "; -fx-min-height:" + mealHeight + "; -fx-max-width: " + mealWidth + "; " +
                    "-fx-max-height:" +  mealHeight + ";");

            //create a text node with the recipes name
            Text t1 = new Text(days.getBreakfast().getName());
            t1.setFont(InterfaceStyling.weekPlannerMealText);
            //stack the text onto the Region
            StackPane s1 = new StackPane(rectOne, t1);
            //Add stack to VBox along with a seperator space
            v1.getChildren().add(s1);
            v1.getChildren().add(seperatorRec);
        }

        //if the daysMeal has a Recipe set for lunch create a rectangle (Region) with that recipes name in and add
        // to the vbox
        if (days.isLunchSet()){
            //Lunch Region
            Region rectTwo = new Region();
            //Style the region using css with the appropriate colors and dimensions
            rectTwo.setStyle("-fx-background-color: #" + colorLunchLight +
                    "; -fx-border-style: solid; -fx-border-width: 0 0 0 10; " +
                    "-fx-border-color: #" + colorLunch + "; -fx-min-width: " + mealWidth + "; -fx-min-height:"
                    + mealHeight + "; -fx-max-width: " + mealWidth + ";" + "-fx-max-height: " + mealHeight + ";");

            //create a text node with the recipes name
            Text t2 = new Text(days.getLunch().getName());
            t2.setFont(InterfaceStyling.weekPlannerMealText);
            //stack the text onto the Region
            StackPane s2 = new StackPane(rectTwo, t2);
            //Add stack to VBox along with a seperator space
            v1.getChildren().add(s2);
            v1.getChildren().add(seperatorRec2);
        }

        //if the daysMeal has a Recipe set for dinner create a rectangle (Region) with that recipes name in and add
        // to the vbox
        if (days.isDinnerSet()){
            //Dinner Region
            Region rectThree = new Region();
            //Style the region using css with the appropriate colors and dimensions
            rectThree.setStyle("-fx-background-color: #" + colorDinnerLight +
                    "; -fx-border-style: solid; -fx-border-width: 0 0 0 10; " + "-fx-border-color: #" + colorDinner +
                    "; -fx-min-width:" + mealWidth + "; -fx-min-height: " + mealHeight + "; -fx-max-width:"
                    + mealWidth + "; -fx-max-height: " + mealHeight + ";");
            //create a text node with the recipes name
            Text t3 = new Text(days.getDinner().getName());
            t3.setFont(InterfaceStyling.weekPlannerMealText);
            //stack the text onto the Region
            StackPane s3 = new StackPane(rectThree, t3);
            //Add stack to VBox
            v1.getChildren().add(s3);
        }

        //configure and return the vBox
        v1.setAlignment(Pos.TOP_CENTER);
        return v1;
    }


}
