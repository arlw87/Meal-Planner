module MealPlanner {
    requires javafx.fxml;
    requires javafx.controls;
    opens home;
    opens home.model;
    requires java.sql;
}