import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

	public static void display(String message) {
		Stage window = new Stage();

		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(400);

		Label errorMessage = new Label();
		errorMessage.setText(message);

		Button button = new Button("Try again");
		button.setOnAction(e -> window.close());

		VBox layout = new VBox(20);
		layout.getChildren().addAll(errorMessage, button);
		layout.setAlignment(Pos.CENTER);

		// display the window and wait for it to be closed before returning
		Scene scene = new Scene(layout, 500, 300);
		window.setScene(scene);
		window.showAndWait();
	
	
	}







}
