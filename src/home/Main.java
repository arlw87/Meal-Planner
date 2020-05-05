package home;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import home.model.Datasource;
import javafx.stage.StageStyle;

/**
 * Main entry point into the program
 */


public class Main extends Application {

    //for movable window
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));

        //make the window moveable when undecorated
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });


        primaryStage.setTitle("Meal Planner");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void testMethod(){
        Datasource test = Datasource.getInstance();
        test.createTables();
    }

    /**
     * Database actions to run when the program is first initialised
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init();
        //is the database cant open then throw an error and close
        if (!Datasource.getInstance().open()){
            System.out.println("Could Not open the database");
            Platform.exit();
        }
        //create tables if the database is new
        Datasource.getInstance().createTables();
    }

    /**
     * Actions to do when the program closes
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        //close the database
        Datasource.getInstance().close();
        super.stop();
    }
}
