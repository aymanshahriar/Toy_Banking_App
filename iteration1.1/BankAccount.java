public class BankAccount {

	private double balance;
	private String accountNumber;

	// getter methods
	
	public double getBalance(){
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String toString() {
		return accountNumber + ": " + Double.toString(balance);
	}
	
	// setter methods

	public void deposit(double x) {
		if (x > 0.0)
			this.balance += x;
		else 
			System.out.print("Unexpected balance");		
		
	}
	
	public void withdraw(double x) {
		if ((x <= balance) && (x > 0.0))	
			this.balance -= x;
		else
			System.out.println("Insufficient funds");
	}	

	// constructor that takes no parameters
	BankAccount() {
		this.balance = 0.0;
		this.accountNumber = "1111";
	}

	// constructor that takes start balance
	BankAccount(double x) {
		this.balance = x;
		/** for some reason we must NOT check if balance is negative */
		
		this.accountNumber = "1111";
			
	}


	// constructor that takes start balance and accountNumber
	BankAccount(double x, String y) {
		this.balance = x;
		this.accountNumber = y;
	}
	


}
