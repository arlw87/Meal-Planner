package home;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * Class with static methods and public constants to keep the styling of the GUI constant across the
 * program.
 */

public class InterfaceStyling {

    //Contants to set up the various fonts used in the program
    private static String standardFontFamily = "Helvetica";
    private static int standardFontSize = 12;
    public static final Font systemFont = Font.font(standardFontFamily, FontPosture.ITALIC, standardFontSize);
    private static int titleSize = 15;
    public static final Font titleFont = Font.font(standardFontFamily, FontWeight.BOLD, FontPosture.ITALIC, titleSize);
    public static final Font titleFontNonBold = Font.font(standardFontFamily, FontPosture.ITALIC, titleSize);
    public static final Font textFieldFont = Font.font(standardFontFamily, titleSize);
    private static int largeText = 16;
    public static final Font largeTextFont = Font.font(standardFontFamily, largeText);
    public static final Font weekPlannerMealText = Font.font(standardFontFamily, FontWeight.BOLD, standardFontSize);
    public static final Font buttonFont = Font.font(standardFontFamily, FontWeight.BOLD, FontPosture.ITALIC,
            standardFontSize);


    /**
     * A Method to set the appearance of textFields and to change their appearance then in focus
     * @param field - The field to style
     * @param selectColor - The color used in the fields border then it is in focus
     * @param deselectColor - The color used in the fields border then it is out of focus
     */
    public static void setHighlightStyling(TextField field, String selectColor, String deselectColor){

        field.setStyle("-fx-border-width: 1 1 1 1; -fx-border-color: #" + deselectColor + "; -fx-background-color: #ffffff");

        field.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldProperty, Boolean newProperty) {
                if (newProperty){
                    field.setStyle("-fx-border-width: 2 2 2 2; -fx-border-color: #" + selectColor + "; -fx-background-color: #ffffff");
                } else {
                    field.setStyle("-fx-border-width: 1 1 1 1; -fx-border-color: #" + deselectColor + "; -fx-background-color: #ffffff");
                }
            }
        });
        field.setFont(textFieldFont);
    }

    /**
     * A Method to set the appearance of comboBoxs and to change the appearance then in focus
     * @param comboBox - The comboBox to style
     * @param selectColor - The color used for the comboBoxs border when it is in foucs
     * @param deselectColor - The color used for the comboBoxs border when it is out of focus
     */
    public static void setHighlightStyling(ComboBox comboBox, String selectColor, String deselectColor){

        comboBox.setStyle("-fx-border-width: 1 1 1 1; -fx-border-color: #" + deselectColor +
                "; -fx-background-color: #ffffff");

        comboBox.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldProperty, Boolean newProperty) {
                if (newProperty){
                    comboBox.setStyle("-fx-border-width: 2 2 2 2; -fx-border-color: #" + selectColor +
                            "; -fx-background-color: #ffffff");
                } else {
                    comboBox.setStyle("-fx-border-width: 1 1 1 1; -fx-border-color: #" + deselectColor +
                            "; -fx-background-color: #ffffff");
                }
            }
        });
    }

    /**
     * A Method to set the appearance of text area and to change appearance of the text area when its in focus
     * @param area - The text area to style
     * @param selectColor - The color of the border when the text area is in focus
     * @param deselectColor - The color of the border when the text area is out of focus
     */
    public static void setHighlightStyling(TextArea area, String selectColor, String deselectColor){

        area.setStyle("-fx-border-width: 1 1 1 1; -fx-border-color: #" + deselectColor +
                "; -fx-background-color: #ffffff");

        area.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldProperty,
                                Boolean newProperty) {
                if (newProperty){
                    area.setStyle("-fx-border-width: 2 2 2 2; -fx-border-color: #" + selectColor +
                            "; -fx-background-color: #ffffff");
                } else {
                    area.setStyle("-fx-border-width: 1 1 1 1; -fx-border-color: #" + deselectColor +
                            "; -fx-background-color: #ffffff");
                }
            }
        });
    }

    /**
     * A Method to set the appearance of List View Area and to change appearance of the listView when its in focus
     * @param listViewArea - The listView to style
     * @param selectColor - The color of the border of the listView when in focus
     * @param deselectColor - The color of the border of the listView when out of focus
     */
    public static void setHighlightStyling(ListView listViewArea, String selectColor, String deselectColor){

        listViewArea.setStyle("-fx-border-width: 1 1 1 1; -fx-border-color: #" + deselectColor
                + "; -fx-background-color: #ffffff");

        listViewArea.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldProperty,
                                Boolean newProperty) {
                if (newProperty){
                    listViewArea.setStyle("-fx-border-width: 2 2 2 2; -fx-border-color: #" + selectColor +
                            "; -fx-background-color: #ffffff");
                } else {
                    listViewArea.setStyle("-fx-border-width: 1 1 1 1; -fx-border-color: #" + deselectColor +
                            "; -fx-background-color: #ffffff");
                }
            }
        });

    }

    /**
     * Applies a dropshadow effect to the image inside a button
     * @param focusedButton - The button with the image to apply a dropshadow too
     */

    public static void dropShadowSelect(Button focusedButton){
        DropShadow ds = new DropShadow();
        ds.setBlurType(BlurType.THREE_PASS_BOX);
        ds.setWidth(40);
        ds.setHeight(40);
        ds.setRadius(30);

        for (Node n: focusedButton.getChildrenUnmodifiable()){
            if (n.getClass().isInstance(new ImageView())){
                //increase the drop button
                n.setEffect(ds);
            }
        }
    }

    /**
     * Applies a lesser dropshadow effect to the image inside a button
     * @param focusedButton - The button with the image to apply a dropshadow too
     */

    public static void dropShadowDeselect(Button focusedButton){
        DropShadow ds = new DropShadow();
        ds.setBlurType(BlurType.THREE_PASS_BOX);
        ds.setWidth(21);
        ds.setHeight(21);
        ds.setRadius(10);

        for (Node n: focusedButton.getChildrenUnmodifiable()){
            if (n.getClass().isInstance(new ImageView())){
                //increase the drop button
                n.setEffect(ds);
            }
        }
    }

    /**
     * Style button. Set the style of the button to be different when hover property is true and when it is false
     * Style button will change color to indicate if the user's mouse is hovering over the button or not
     * @param b1 - button to be styled
     * @param color - color of the button when the mouse is not hovering over it
     * @param SelectColor - color of the button when the mouse is hovering over it
     */

    public static void buttonStyle(Button b1, String color, String SelectColor){
        String cssBackgroundcolor = "-fx-background-color: #" + color + ";";
        String cssSelectBackgroundcolor = "-fx-background-color: #" + SelectColor + ";";
        String cssBackgroundRadius = "-fx-background-radius: 0;";
        b1.setStyle(cssBackgroundcolor + cssBackgroundRadius);
        b1.setTextFill(Paint.valueOf("white"));
        b1.setFont(buttonFont);

        b1.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1){
                    b1.setStyle(cssSelectBackgroundcolor + cssBackgroundRadius);
                } else {
                    b1.setStyle(cssBackgroundcolor + cssBackgroundRadius);
                }
            }
        });
    }

    /**
     * Style a toggle button
     * @param b1 - Toggle button to be styled
     * @param color - color of the toggle button to be styled
     */

    public static void toggleButtonStyle(ToggleButton b1, String color){
        String cssBackgroundcolor = "-fx-background-color: #" + color + ";";
        String cssBackgroundRadius = "-fx-background-radius: 0;";
        b1.setStyle(cssBackgroundcolor + cssBackgroundRadius);
        b1.setTextFill(Paint.valueOf("white"));
         b1.setFont(buttonFont);
    }

    /**
     * Apply a drop shadow affect to an imageView inside a button
     * @param focusedButton - button with imageView
     */

    public static void dropShadowExitSelect(Button focusedButton){

        dropShadowDeselect(focusedButton);
    }

    /**
     * Remove a drop shadow affect completely from an imageView inside a button
     * @param focusedButton - button with imageView
     */

    public static void dropShadowExitDeselect(Button focusedButton){

        for (Node n: focusedButton.getChildrenUnmodifiable()){
            if (n.getClass().isInstance(new ImageView())){
                //increase the drop button
                n.setEffect(null);
            }
        }
    }
}
