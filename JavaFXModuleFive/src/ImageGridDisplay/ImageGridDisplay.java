package ImageGridDisplay;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ImageGridDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create images
        Image image1 = new Image("file:C:\\Java\\Pictures\\flag1.gif");
        Image image2 = new Image("file:C:\\Java\\Pictures\\flag2.gif");
        Image image3 = new Image("file:C:\\Java\\Pictures\\flag6.gif");
        Image image4 = new Image("file:C:\\Java\\Pictures\\flag7.gif");

        // Create image views
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        // Create grid pane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add image views to grid pane
        gridPane.add(imageView1, 0, 0);
        gridPane.add(imageView2, 1, 0);
        gridPane.add(imageView3, 0, 1);
        gridPane.add(imageView4, 1, 1);

        // Create scene
        Scene scene = new Scene(gridPane);

        // Set stage title and scene, then show the stage
        primaryStage.setTitle("Image Grid Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
