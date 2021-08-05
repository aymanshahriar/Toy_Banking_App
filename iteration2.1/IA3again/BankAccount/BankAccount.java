public class BankAccount {

	private double balance;
	private String accountNumber;
	private Customer accountHolder;

	// getter methods
	
	public double getBalance(){
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String toString() {
		return "(" + this.accountHolder.getName() + " " + this.accountHolder.getID() +  ") " + accountNumber + ": " + Double.toString(balance);

	}

	public Customer getAccountHolder() {
		
		return this.accountHolder;
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

	public void setAccountHolder(Customer holder) {
		this.accountHolder = holder;
	}

	// Transfer method
	public void transfer(double amount, BankAccount recipientAccount) {
		if (this.balance >= amount) {
			this.withdraw(amount);
			recipientAccount.deposit(amount);
		}
	}	


	// constructor that takes no parameters
	public BankAccount() {
		this.balance = 0.0;
		this.accountNumber = "1111";
	
	}

	// constructor that takes start balance
	public BankAccount(double x) {
		this.balance = x;
		/** for some reason we must NOT check if balance is negative */
		
		this.accountNumber = "1111";
		
	}


	// constructor that takes start balance and accountNumber
	public BankAccount(double x, String y) {
		this.balance = x;
		this.accountNumber = y;
		
			
	}
	
	// copy constructor
	public BankAccount(BankAccount b) {
		this.balance = b.getBalance();
		this.accountNumber = b.getAccountNumber();
		this.accountHolder = b.getAccountHolder();
	}


	// constructor that takes in accountHolder, balance
	public BankAccount(Customer holder, double b) {
		this.setAccountHolder(holder);
		this.balance = b;
	}	

}
