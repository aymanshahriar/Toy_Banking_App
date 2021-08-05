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

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import java.io.PrintWriter;
import java.io.FileOutputStream;

import java.util.Random;


public class BankingApp extends Application{


	// instance variables
	private SavingsAccount account;
	private double amount;
	private String fileName;
	private Customer customer;

	private Scene mainScene;
	private Scene sideScene;


	/**
	 * The main method only contains the launch method, which is inherited from Application class
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
		try{
			// instantiate the account variable		
			fileName = "file.txt";
			FileReader freader = new FileReader(fileName);
			BufferedReader breader = new BufferedReader(freader);
			// the first line is balance
			String balance = breader.readLine();
			// the second line is accounNumber
			String accountNumber = breader.readLine();
			// the third line is Customer name
			String customerName = breader.readLine();
			// the fourth line is Customer id
			String customerID = breader.readLine();

			// use the file to create bankaccount and customer
			customer = new Customer(customerName, Integer.parseInt(customerID));
			account = new SavingsAccount(customer, Double.parseDouble(balance), 0.05);
			breader.close();
		}
		// if file is not found, create a new account by asking for customer name
		catch(IOException ioe) {
			AccountCreator c = new AccountCreator();
			c.display();
			String customerName = c.getName();
			Random r = new Random();
			int customerID = r.nextInt(9000) + 1000;
                        customer = new Customer(customerName, customerID);
                        account = new SavingsAccount(customer, 0.0, 0.5);
			
			// write down details of new account in file
			saveToFile();


		
		}
		


		// set title of stage
		primaryStage.setTitle("My Bank");
		
		// create all the required nodes (buttons, labels, textfield);
		Label accountHolderLabel =  new Label("Account Holder: " + customer.getName() );
		Label balanceLabel = new Label("Balance: " + account.getBalance());

		Label amountLabel = new Label("Enter Amount:");
		TextField textField = new TextField();

		// create deposit button and handle deposit action		
		Button depositButton = new Button("Deposit");
		depositButton.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (isDouble(textField.getText(), "deposit")) {
					amount = Double.valueOf(textField.getText());
					account.deposit(amount);
					balanceLabel.setText("Balance: " + account.getBalance());
				}
				
				// write the new bank balance into file	
				saveToFile();	
				
				// clear the textfield
				textField.clear();
			}
		}		
		);


		// create withdraw button and handle withdraw
		Button withdrawButton = new Button("Withdraw");
		
		withdrawButton.setOnAction( new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                                if (isDouble(textField.getText(), "withdraw")) {
					amount = Double.valueOf(textField.getText());
                                	account.withdraw(amount);
                               	 	balanceLabel.setText("Balance: " + account.getBalance());
				}
				
				// write the new bank balance into file
                               	saveToFile();			
				// clear the text field
				textField.clear();
			}
                }

                );



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
		mainScene = new Scene(borderPane, 500, 300);

		// add scene to primarystage, show the primarystage
		primaryStage.setScene(mainScene);
		primaryStage.show();

	}

	/**
	 * method checks if the amount entered for deposit/withdrawl is valid
	 * @param input the amount entered for deposit/witdrawl
	 * @param depositOrWithdraw specifies if amount entered is for deposit or withdrawl
	 * @return boolean is true when the amount entered is valid
	 */
	public boolean isDouble(String input, String depositOrWithdraw) {
		try {
			Double amount = Double.parseDouble(input);
			if (amount >= 0.0) {
				if (depositOrWithdraw.equals("withdraw")) {
					if ((account.getBalance() - amount) >= account.getMinimumBalance()) {
						return true;
					}
					else {
						AlertBox.display("withdrawl amount cannot exceed minimum balance");
						return false;
					}
				}
				return true;
				
			}
			else {
				AlertBox.display("please enter a positive number for deposit or withdrawl");
				return false;
			}
		}
		catch(NumberFormatException e) {
			AlertBox.display("please enter a number for deposit or withdrawl");
			return false;
		}
	}

	/**
	 * Method that saves the information of the account into the file
	 */
	public void saveToFile() {
		PrintWriter outputStream = null;
		try {
                  	outputStream = new PrintWriter(fileName);
                     	outputStream.println(account.getBalance());
                       	outputStream.println(account.getAccountNumber());
                       	outputStream.println(customer.getName());
                      	outputStream.println(customer.getID());
             	}
               	catch(IOException ioe) {
                	System.out.println("Error in attempting to modify new deposit amount");
              	}

             	outputStream.close();	
	}



}
