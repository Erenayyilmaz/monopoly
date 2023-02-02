package board_editor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BoardEditor {

    public static void createBoard() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Create new board");
        window.setMinWidth(250);

        // Form to enter properties of new board
        Label nameLabel = new Label("Name:");
        TextField nameInput = new TextField();
        Label priceLabel = new Label("Price:");
        TextField priceInput = new TextField();
        Label rentLabel = new Label("Rent:");
        TextField rentInput = new TextField();

        // Save button
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            saveBoard(nameInput.getText(), Integer.parseInt(priceInput.getText()), Integer.parseInt(rentInput.getText()));
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameLabel, nameInput, priceLabel, priceInput, rentLabel, rentInput, saveButton);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    private static void saveBoard(String name, int price, int rent) {
        // Code to save board properties to the database
    }
}
