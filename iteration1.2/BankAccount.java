public class BankAccount {

	/** This is a class which creates bankAccount objects which act like Bank Accounts and each 
	bankAccount object has a balance and a 4 digit account number. This class contains the 
	methods to deposit, withdraw, return balance, return account number and the ability to 
	return the balance and account number into a single string.
	**/
	
	private double balance; //creates a private double variable named balance and stores the balance
	private String accountNumber; //creates a private String variable named accountNumber which stores a 4 digit number
	
	
	/** This method returns the private variable named balance
	*	and returns it
	*	@return the instance variable balance
	**/
	public double getBalance() { 
		return balance;
	}	
	
	/** This method returns the private variable named accountNumber
	*	and returns ii
	*	@return the instance variable accountNumber
	**/
	public String getAccountNumber() { 
		return accountNumber;
	}

	/** This method returns a string which contains the accountNumber and balance.
	* 	Example: "1111: 242"
	*	@param void
	*	@return instance variable accountNumber and class variable balance in string form
	**/
	public String toString() {	
		String stringout = accountNumber + ": " + balance;
		return stringout;
	}
		
	/** This method will deposit amount d if and only if the deposit amount d is bigger than 0,
	*	otherwise the balance will not change.
	*	@param d the deposit amount
	*	@return void
	**/
	public void deposit(double d) { 
		this.balance = balance; 					//retrieves the instance variable named balance.
		if (d >= 0) {								//if balance is bigger or equal to zero
			balance += d;							//then add balance d
		}
		else if (d < 0) {							//else if the balance is smaller than zero
			balance = balance;						//then balance will not change
		}
	}

	/**	This method will withdraw amount w if and only if the withdraw about is bigger 
	*	than zero and the balance is more or equal to the withdraw amount.
	*	@param w the withdraw amount
	*	@return void
	**/
	public void withdraw(double w) { 
		if (w < 0) {								//If w is smaller than zero
			balance = balance;						//then balance will not change
		}
		else if (w >= 0 && w <= balance) {			//Else if w is bigger or equal to zero and more or equal to balance
			balance -= w;							//then balance will be withdrawn
		}
		else if (w > balance) {						//if withdraw amount is bigger than balance
			balance = balance;						//then balance does not change.
		}
	}

	/** Default constructor for BankAccount class which initializes default 
	*	values for the variables if balance and bankAccount number is not provided
	*	@param void
	*	@return void
	**/
	public BankAccount() { 
		balance = 0.0;								//sets instance variable balance to zero
		accountNumber = "1111";						//sets instance variable bankAccount to "1111"
	}

	/**	This constructor overloads the default constructor and will initialize
	*	the bankAccount number, and will set the balance to the provided balance
	*	@param balance the initial balance for the account
	*	@return void
	**/	
	public BankAccount(double balance) { 
		this.balance = balance;						//sets the instance variable named balance to the parameter's balance
		accountNumber = "1111";						//sets instance variable bankAccount to "1111"
		
	}	
	
	/**	This constructor overloads the default constructor and will set the
	*	instance variable balance to the balance provided and the accountNumber to the 
	*	accountNumber provided in the parameter.
	*	@param balance the initial balance for the account
	*	@param accountNumber the accountNumber associated with the bank account
	*	@return void
	**/	
	public BankAccount(double balance, String accountNumber) { 
		this.balance = balance;						//sets the instance variable named balance to the parameter's balance
		this.accountNumber = accountNumber;			//sets the instance accountNumber to the accountNumber provided.
	}
}
