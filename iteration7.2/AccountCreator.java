import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class AccountCreator {
	
	String name;

        public void display() {
	
		Stage window = new Stage();

                //Block events to other windows
                window.initModality(Modality.APPLICATION_MODAL);
                window.setMinWidth(400);
		
		Label prompt = new Label();
                prompt.setText("File not found. Enter name of customer");
		
		TextField textField = new TextField();

                Button button = new Button("Enter");
                button.setOnAction(e -> {
			name = textField.getText();
			window.close();
		});

		VBox layout = new VBox(20);
                layout.getChildren().addAll(prompt, textField, button);
                layout.setAlignment(Pos.CENTER);

                // display the window and wait for it to be closed before returning
                Scene scene = new Scene(layout, 500, 300);
                window.setScene(scene);
                window.showAndWait();
	
	
	}


	public String getName() {
		return this.name;
	}




}	
