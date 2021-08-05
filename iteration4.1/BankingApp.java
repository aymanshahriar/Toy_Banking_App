/**
 * This is a banking application program that opens up a javafx window 
 * and displays banking details of a certain account with the option
 * to deposit or withdraw
 */
 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label.*; 
import javafx.geometry.*;

public class BankingApp extends Application{


	/**
	 * The main method only constins the launch method, which is inherited from Application class
	 */

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * In a javafx program, the start method contains the main implementation 
	 * for the GUI
	 * @param primaryStage the main stage of the javafx application. The "stage" is the entire window, and
	 * "scene" is the content inside the window
	 */
	public void start(Stage primaryStage) {
		
		// set title if stage
		primaryStage.setTitle("My Bank");
		
		// create all the required nodes (buttons, labels, textfield);
		Label accountHolderLabel =  new Label("Account Holder: John Doe");
		Label balanceLabel = new Label("Balance: 0.0");

		Label amountLabel = new Label("Enter Amount:");
		TextField textField = new TextField();

		Button depositButton = new Button("Deposit");
		Button withdrawButton = new Button("Withdraw");
		
		// add nodes into specific layouts, then embed all these layouts into BorderPane
		VBox topPortion = new VBox();
		topPortion.getChildren().addAll(accountHolderLabel, balanceLabel);
		topPortion.setAlignment(Pos.CENTER);
		topPortion.setSpacing(5);    // alters the spacing BETWEEN the two labels

		HBox centerPortion = new HBox();
		centerPortion.getChildren().addAll(amountLabel, textField);
		centerPortion.setAlignment(Pos.CENTER);

		HBox bottonPortion = new HBox();
		bottonPortion.getChildren().addAll(depositButton, withdrawButton);
		bottonPortion.setAlignment(Pos.CENTER);


		// embed all these layouts into borderpane
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topPortion);
		borderPane.setCenter(centerPortion);
		borderPane.setBottom(bottonPortion);
		
		
		// create scene, add borderpane layout into scene
		Scene scene = new Scene(borderPane, 400, 200);

		// add scene to primarystage, show the primarystage
		primaryStage.setScene(scene);
		primaryStage.show();

	}





}
