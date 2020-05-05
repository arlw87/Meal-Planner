package home;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;

/**
 * Creates error and confirmation dialog boxes to allow the application to either highlight an issue, such as missing
 * data in a entry field or to ask for confirmation from the user for an operation. The styling of the dialog boxes
 * is defined when the object is instantiated and the dialog boxes can be styled to match the look of the page that
 * the dialog boxes are called from. For example, if the meal planner section calls a dialog box, the meal planner
 * icon and color scheme is used in the dialog box.
 */

public class InformationBox {

    private Pane referencePane;
    private String color;
    private String highlightColor;
    private String imageRef;
    private final int xPos = 50;
    private final int yPos = 150;


    public InformationBox(Pane aPane, String col1, String col2, String imagePath){
        referencePane = aPane;
        color = col1;
        highlightColor = col2;
        imageRef = imagePath;
    }

    /**
     * Creates and displays a confirmation dialog box.
     * @param title Title on the dialog box
     * @param message Message in the dialog box
     * @return true if yes is clicked, false if no is clicked.
     */
    public boolean confirmDiaglogBox(String title, String message){
        Alert confirm = new Alert(Alert.AlertType.NONE, "", ButtonType.YES, ButtonType.NO);

        //get main window location
        Point2D mainWindowLoc = mainWindowCenterPos();

        //set Position of the dialogue box
        double startX = mainWindowLoc.getX() - xPos;
        double startY = mainWindowLoc.getY() - yPos;

        confirm.setX(startX);
        confirm.setY(startY);
        confirm.setTitle(title);
        confirm.setHeaderText(message);

        //style the dialog box
        DialogPane dialogPane = confirm.getDialogPane();
        //removes the default styling of the dialog box
        dialogPane.getStyleClass().remove("alert");

        //remove the icon in the dialog title bar
        confirm.initStyle(StageStyle.UTILITY);

        try{
            //add an icon to the dialog box
            Image im1 = new Image(getClass().getResourceAsStream(imageRef));
            StackPane stackPane = new StackPane(new ImageView(im1));
            stackPane.setAlignment(Pos.CENTER);
            dialogPane.setGraphic(stackPane);
        } catch (Exception e){
            e.printStackTrace();
        }

        //get header label
        GridPane gp = (GridPane)dialogPane.lookup(".header-panel");
        //format all labels in the header panel
        gp.getChildren().forEach((Node n) -> {
            if (n.getClass().isInstance(new Label())){
                ((Label) n).setFont(InterfaceStyling.titleFont);
                ((Label) n).setWrapText(true);
            }
        });

        //get buttons using lookups
        ButtonBar buttonBar = (ButtonBar)dialogPane.lookup(".button-bar");
        buttonBar.getButtons().forEach((b)-> InterfaceStyling.buttonStyle((Button) b, color, highlightColor));

        //set dimensions of dialog box
        dialogPane.setPrefWidth(300);

        if (confirm.showAndWait().get() == ButtonType.YES){
            System.out.println("Yes was clicked");
            return true;
        } else {
            System.out.println("No was selected or Box was cancelled");
            return false;
        }
    }

    /**
     * Create and display an information / Error dialog box
     * @param title Title of the dialog box
     * @param message Message in the dialog box
     */
    public void errorDiaglogBox(String title, String message){
        Alert error = new Alert(Alert.AlertType.ERROR);

        //get main window location
        Point2D mainWindowLoc = mainWindowCenterPos();

        //set Position of the dialogue box
        double startX = mainWindowLoc.getX() - xPos;
        double startY = mainWindowLoc.getY() - yPos;

        error.setX(startX);
        error.setY(startY);
        error.setTitle(title);
        error.setHeaderText(message);

        //style the dialog box
        DialogPane dialogPane = error.getDialogPane();
        //removes the default styling of the dialog box
        dialogPane.getStyleClass().remove("alert");

        error.initStyle(StageStyle.UTILITY);

        try{
            //add an icon to the dialog box
            Image im1 = new Image(getClass().getResourceAsStream(imageRef));
            StackPane stackPane = new StackPane(new ImageView(im1));
            stackPane.setAlignment(Pos.CENTER);
            dialogPane.setGraphic(stackPane);
        } catch (Exception e){
            e.printStackTrace();
        }

        //get header label
        GridPane gp = (GridPane)dialogPane.lookup(".header-panel");
        //format all labels in the header panel
        gp.getChildren().forEach((Node n) -> {
            if (n.getClass().isInstance(new Label())){
                ((Label) n).setFont(InterfaceStyling.titleFont);
                ((Label) n).setWrapText(true);
            }
        });

        //get buttons using lookups
        ButtonBar buttonBar = (ButtonBar)dialogPane.lookup(".button-bar");
        buttonBar.getButtons().forEach((b)-> InterfaceStyling.buttonStyle((Button) b, color, highlightColor));

        //set dimensions of dialog box
        dialogPane.setPrefWidth(300);

        error.showAndWait();
    }

    /**
     * Determine the center X and Y position of the main window
     * @return A Point2D representing the x and y position of the main window
     */
    private Point2D mainWindowCenterPos(){

        Scene thisScene = referencePane.getScene();
        //System.out.println("Pos X: " + thisScene.getWindow().getX() + "Pos Y: " + thisScene.getWindow().getY());
        double PosX = thisScene.getWindow().getX();
        double PosY = thisScene.getWindow().getY();

        double HalfWidth = thisScene.getWindow().getWidth() / 2;
        double HalfHeight = thisScene.getWindow().getHeight() / 2;

        return new Point2D(PosX + HalfWidth, PosY + HalfHeight);
    }
}
