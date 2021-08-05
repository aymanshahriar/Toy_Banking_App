public abstract class BankAccount {

	private double balance;
	private String accountNumber;
	private Customer accountHolder;

	
	/**
	 * Returns the balance of the specific account
	 * @return the balance of the bank account
	 */
	public double getBalance(){
		return balance;
	}
	
	/**
	 * Returns the account number of the bank account
	 * @return the account number of thebankaccount
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Returns the information of the specific bank account in string format
	 * @return the account holder name, account holder ID, account number, and account balance (in that order)
	 */
	public String toString() {
		return "(" + this.accountHolder.getName() + " " + this.accountHolder.getID() +  ") " + accountNumber + ": " + Double.toString(balance);

	}
	
	/**
	 * Getter method for accountHolder
	 * @return the accountHolder
	 */
	public Customer getAccountHolder() {
		
		return this.accountHolder;
	}

	
	/** Deposits a specified amount (in double) into the balance of the bank account
	 *  This method will add the specified amount to the balance if and only if the specified amount is positive
	 * @param x the amount we want to deposit into the account
	 */

	public void deposit(double x) {
		if (x > 0.0)
			this.balance += x;
		else 
			System.out.print("Unexpected balance");		
		
	}
	
	/** Withdraws a specified amount from the account balance
	 * This method will subtract the specified amount from the account balance if and only is the current balance is bigger than or equal to 
	 * the amount specified.
	 * @param x the amount we wish to withdraw from the account balance 
	 */
	public void withdraw(double x) {
		if ((x <= balance) && (x > 0.0))	
			this.balance -= x;
		else
			System.out.println("Insufficient funds");
	}
	
	/**
	 * Setter method that sets the accountHolder to the specified customer
	 * @param holder the customer that we want to assign to accountHolder
	 */
	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}

	/**
	 * Transfers the specified amount from the current bank account to a recipient bank account
	 * @param amount the amount that we want to transfer
	 * @param recipientAccount the bank account that will recieve the amount (so it's balance will be increased by the amount)
	 */
	public void transfer(double amount, BankAccount recipientAccount) {
		if (this.balance >= amount) {
			this.withdraw(amount);
			recipientAccount.deposit(amount);
		}
	}	


	/**
	 * Constructor that takes in no parameters
	 * The balance will be set to deafault 0.0
	 * the accountNumber will be set to deafault "1111"
	 */
	public BankAccount() {
		this(0.0, "1111");
	
	}

	/** Constructor that takes in parameter for balance
	 * @param balance the balance that we want to initialize the bank account with
	 */
	public BankAccount(double balance) {
		/** for some reason we must NOT check if balance is negative */
		this(balance, "1111");
		
	}

	// new abstract method
	protected abstract double getMonthlyFeesAndInterest();
	
	// new method
	public void monthEndUpdate() {
                // the balance is allowed to become negative using this method, so should'nt use setBalance()
                this.balance += this.getMonthlyFeesAndInterest();
        }




	/** Constructor that takes start balance and accountNumber
	 * @param balance the double that we want to initialize the bank account with
	 * @param accountNumber the String that we want to initialize the bank account with
	 */
	public BankAccount(double balance, String accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	
	/** Copy constructor that takes a bankaccount, whose balance, account number and account holder are used to initialize the bank account
	 * @param b the account number whose attributes will be used to initialize the bank account
	 */
	public BankAccount(BankAccount b) {
		this(b.getBalance(), b.getAccountNumber());
		this.accountHolder = b.getAccountHolder();
	}


	/** constructor that takes a start accountHolder, balance
	 * @param accountHolder the accountholder that we will assign to to the new bank account's account holder
	 * @param balance the double that we want to initialize the bank account with
	 */
	public BankAccount(Customer accountHolder, double balance) {
		this.setAccountHolder(accountHolder);
		this.balance = balance;
		this.accountNumber = "1111";
		this.accountNumber = "1111";
	}	

}
