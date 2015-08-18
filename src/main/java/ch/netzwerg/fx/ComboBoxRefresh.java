package ch.netzwerg.fx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static javafx.collections.FXCollections.observableArrayList;

public class ComboBoxRefresh extends Application {

    private static final class Dog {

        private final String name;

        public Dog(String name) {
            this.name = name;
        }
    }

    private static final class DogListCell extends ListCell<Dog> {
        @Override
        public void updateItem(Dog item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText("");
            } else {
                setText(item.name);
            }
        }
    }

    private static List<Dog> createThreeDogs() {
        return range(0, 3).mapToObj(i -> new Dog("Buddy " + i)).collect(toList());
    }

    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<Dog> items = observableArrayList(createThreeDogs());
        ComboBox<Dog> comboBox = new ComboBox<>(items);
        comboBox.setPrefWidth(400);
        comboBox.setCellFactory(listView -> new DogListCell());
        comboBox.setButtonCell(new DogListCell());

        Button button = new Button("Refresh");
        button.setOnAction(event -> {
            List<Dog> newItems = createThreeDogs();
            items.setAll(newItems);
        });

        VBox box = new VBox(10, comboBox, button);
        box.setPadding(new Insets(10));

        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }

}
