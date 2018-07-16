package demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = new VBox() {{
            getChildren().add(createList());
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private Node createList() {
        return new ListView<String>() {{
            setCellFactory(param -> new ButtonCell());
            setItems(FXCollections.observableArrayList("Apple", "Orange", "Banaca"));
        }};
    }
}

class ButtonCell extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(new HBox() {{
                getChildren().add(new Label(item));
                getChildren().add(new Pane() {{
                    HBox.setHgrow(this, Priority.ALWAYS);
                }});
                getChildren().add(new Button("+") {{
                    setOnAction(event -> System.out.println("Clicked on item: " + item));
                }});
            }});
        }
    }
}