package ColorChangingCircle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class ColorChangingCircle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create a circle with initial fill color white
        Circle circle = new Circle(100, Color.WHITE);
        
        // Set stroke properties for the circle (black outline)
        circle.setStroke(Color.BLACK);          // Set stroke color
        circle.setStrokeWidth(2);                // Set stroke width
        circle.setStrokeType(StrokeType.OUTSIDE);// Set stroke type
        
        // Set event handler for mouse press
        circle.setOnMousePressed(e -> {
            circle.setFill(Color.BLACK);         // Change fill color to black
        });
        
        // Set event handler for mouse release
        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.WHITE);         // Change fill color to white
        });
        
        // Create a stack pane and add the circle to it
        StackPane root = new StackPane();
        root.getChildren().add(circle);
        
        // Create a scene with the stack pane as root and set its dimensions
        Scene scene = new Scene(root, 200, 200);
        
        // Set the scene to the primary stage and show it
        primaryStage.setScene(scene);
        primaryStage.setTitle("Color Changing Circle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
