package ch.netzwerg.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class ResizableCanvasFX extends Application {

    private static final double WIDTH = 200;
    private static final double HEIGHT = 200;

    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();

        Plot plot = new Plot(WIDTH, HEIGHT);
        plot.widthProperty().bind(root.widthProperty());
        plot.heightProperty().bind(root.heightProperty());

        root.getChildren().add(plot);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Platform.setImplicitExit(true);
        launch(args);
    }

    private static class Plot extends Canvas {

        public Plot(double width, double height) {
            super(width, height);

            widthProperty().addListener(l -> repaint());
            heightProperty().addListener(l -> repaint());

            repaint();
        }

        @Override
        public boolean isResizable() {
            return true;
        }

        @Override
        public double prefWidth(double height) {
            return getWidth();
        }

        @Override
        public double prefHeight(double width) {
            return getHeight();
        }

        public void repaint() {
            GraphicsContext gc = getGraphicsContext2D();
            gc.setFill(Color.PINK);
            gc.fillRect(0, 0, getWidth(), getHeight());
        }

    }

}
