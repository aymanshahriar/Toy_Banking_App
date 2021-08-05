public class BankAccount {
	
	// instance variables

	private double balance = 0.0;
	private String accountNumber = "1111" ;
	private Customer accountHolder;

	// getter methods
	
	public double getBalance(){
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public Customer getAccountHolder() {
		return this.accountHolder;
	}
	
	// toString() method

	public String toString() {
		return "(" + accountHolder + ") " + accountNumber + ": " + Double.toString(balance);
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

	public void setAccountHolder(Customer c) {
		this.accountHolder = c;
	}	

	// constructor that takes no parameters
	BankAccount() {
		this.deposit(0.0);
	}

	// constructor that takes start balance
	BankAccount(double x) {
		this.balance = x;
		/** for some reason we must NOT check if balance is negative */
	
			
	}


	// constructor that takes start balance and accountNumber
	BankAccount(double x, String y) {
		if (x > 0)
			this.deposit(x);
		this.accountNumber = y;
	}

	// constructor that only takes BankAccount (copy constructor?)
	BankAccount(BankAccount b) {
		this.deposit(b.getBalance());   	
		this.accountNumber = b.getAccountNumber();
		//this.accountHolder.setName(b.accountHolder.getName());
		//this.accountHolder.setCustomerID(b.accountHolder.getID());	
		this.accountHolder = b.getAccountHolder();			//// this method gave a lot of "null pointer exception"
										//// errors. then I added the second last two lines but	
										//// it still didnt work. Then I added the last line and it worked

	}
	
	// constructor that takes accountHolder and balance
	BankAccount(Customer c, double b) {
		this.setAccountHolder(c);
		this.balance = b;
	}
	


	// transfer method
	public void transfer(double amount, BankAccount recipientAccount) {
		
		if (this.balance >= amount) {
			this.withdraw(amount);
			recipientAccount.deposit(amount);
		}
	}








}
