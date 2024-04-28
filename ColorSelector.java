package ColorSelector;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorSelector extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create sliders for red, green, blue, and opacity
        Slider redSlider = createSlider(0, 255, 0, "Red");
        Slider greenSlider = createSlider(0, 255, 0, "Green");
        Slider blueSlider = createSlider(0, 255, 0, "Blue");
        Slider opacitySlider = createSlider(0, 100, 100, "Opacity");

        // Create labels for the sliders
        Label redLabel = new Label("Red");
        Label greenLabel = new Label("Green");
        Label blueLabel = new Label("Blue");
        Label opacityLabel = new Label("Opacity");

        // Create label to display selected color
        Label colorLabel = new Label("Selected Color");
        colorLabel.setStyle("-fx-font-size: 20;");

        // Set initial color
        updateColor(redSlider, greenSlider, blueSlider, opacitySlider, colorLabel);

        // Add listener to sliders to update color label
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(redSlider, greenSlider, blueSlider, opacitySlider, colorLabel));
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(redSlider, greenSlider, blueSlider, opacitySlider, colorLabel));
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(redSlider, greenSlider, blueSlider, opacitySlider, colorLabel));
        opacitySlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(redSlider, greenSlider, blueSlider, opacitySlider, colorLabel));

        // Create layout
        VBox root = new VBox(10);
        root.getChildren().addAll(redLabel, redSlider, greenLabel, greenSlider, blueLabel, blueSlider, opacityLabel, opacitySlider, colorLabel);
        root.setPadding(new Insets(20));

        // Set scene
        Scene scene = new Scene(root, 275, 350);

        // Set stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Color Selector");
        primaryStage.show();
    }

    private Slider createSlider(double min, double max, double initialValue, String label) {
        Slider slider = new Slider(min, max, initialValue);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit((max - min) / 5);
        slider.setBlockIncrement((max - min) / 20);
        slider.setPrefWidth(200);
        slider.setMinWidth(200);
        slider.setMaxWidth(200);

        // Create a tooltip to display the current value of the slider
        Tooltip tooltip = new Tooltip();
        slider.setTooltip(tooltip);

        // Set tooltip text for the slider
        tooltip.setText(label);

        return slider;
    }

    private void updateColor(Slider redSlider, Slider greenSlider, Slider blueSlider, Slider opacitySlider, Label colorLabel) {
        Color color = Color.rgb((int) redSlider.getValue(), (int) greenSlider.getValue(), (int) blueSlider.getValue(), opacitySlider.getValue() / 100.0);
        String colorHex = String.format("#%02X%02X%02X", (int) redSlider.getValue(), (int) greenSlider.getValue(), (int) blueSlider.getValue());
        colorLabel.setTextFill(color);
        colorLabel.setText("Selected Color: " + colorHex);

        // Update tooltip to display the current value of the slider
        Tooltip redTooltip = (Tooltip) redSlider.getTooltip();
        Tooltip greenTooltip = (Tooltip) greenSlider.getTooltip();
        Tooltip blueTooltip = (Tooltip) blueSlider.getTooltip();
        Tooltip opacityTooltip = (Tooltip) opacitySlider.getTooltip();

        redTooltip.setText("Red: " + (int) redSlider.getValue());
        greenTooltip.setText("Green: " + (int) greenSlider.getValue());
        blueTooltip.setText("Blue: " + (int) blueSlider.getValue());
        opacityTooltip.setText("Opacity: " + (int) opacitySlider.getValue() + "%");
    }

    public static void main(String[] args) {
        launch(args);
    }
}