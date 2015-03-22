package ch.netzwerg.fx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RGBMixerFX extends Application {

    private static final Insets PADDING = new Insets(50);
    private static final String FONT_SIZE_STYLE = "-fx-font-size: 40";

    private final Slider redSlider = createSlider();
    private final Slider greenSlider = createSlider();
    private final Slider blueSlider = createSlider();

    private final ObjectBinding<Paint> colorBinding = Bindings.createObjectBinding(() -> {
        int red = redSlider.valueProperty().intValue();
        int green = greenSlider.valueProperty().intValue();
        int blue = blueSlider.valueProperty().intValue();
        return Color.rgb(red, green, blue);
    }, redSlider.valueProperty(), greenSlider.valueProperty(), blueSlider.valueProperty());

    @Override
    public void start(Stage stage) throws Exception {
        Rectangle colorBox = new Rectangle();
        colorBox.setArcWidth(20);
        colorBox.setArcHeight(20);
        colorBox.fillProperty().bind(colorBinding);

        VBox redControl = createColorControl("Rot", redSlider);
        VBox greenControl = createColorControl("Grün", greenSlider);
        VBox blueControl = createColorControl("Blau", blueSlider);

        VBox colorControls = new VBox(redControl, greenControl, blueControl);
        colorControls.setSpacing(30);
        colorControls.setPadding(PADDING);

        VBox root = new VBox(colorControls, colorBox);
        root.setPadding(PADDING);

        Scene scene = new Scene(root);

        colorBox.widthProperty().bind(colorControls.widthProperty());
        colorBox.heightProperty().bind(scene.heightProperty().divide(2));

        stage.setTitle("Rot / Grün/ Blau Mischer");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }


    private static Slider createSlider() {
        return new Slider(0, 255, 0);
    }

    private static VBox createColorControl(String name, Slider slider) {
        Label nameLabel = new Label(name);
        nameLabel.setPrefWidth(100);
        nameLabel.setStyle(FONT_SIZE_STYLE);

        Label valueLabel = new Label("0");
        valueLabel.setStyle(FONT_SIZE_STYLE);
        valueLabel.setAlignment(Pos.CENTER_RIGHT);
        valueLabel.setPrefWidth(100);
        valueLabel.setPadding(new Insets(0, 10, 0, 0));

        valueLabel.textProperty().bind(Bindings.format("%.0f", slider.valueProperty()));

        BorderPane pane = new BorderPane();
        pane.setLeft(new HBox(nameLabel, valueLabel));
        pane.setCenter(slider);

        return new VBox(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }

}