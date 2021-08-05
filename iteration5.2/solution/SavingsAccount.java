public class SavingsAccount extends BankAccount {
	
	// instance variables
	private double annualInterestRate = 0.05 ;
	private double minimumBalance;

	/**
	 * Changes the instance variable annualInterestRate to the specified amount.
	 * @param n the amount that we want to set the annual interest rate to.
	 */
	public void setAnnualInterestRate(double n) {
		
		if ((n >= 0) && (n <= 1)) {
			this.annualInterestRate = n;
		}

	}
	/**
	 * Changes the instance variable minimumBalance to the specified amount.
	 * @param n the amount that we want to set the instance variable minimumBalance to.
	 *
	 */
	public void setMinimumBalance(double n) {
		this.minimumBalance = n;		
	}


    /**
     *
     * Returns the instance variable called annualInterestRate
     */
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}



	
	/**
         * Override the getMonthlyFeesAndInterest method such that it returns the monthly interest
         */
        @Override
        public double getMonthlyFeesAndInterest() {
		return (this.getBalance() * (annualInterestRate / 12));
	}

	

    /** This method overrides the withdraw method to makes sure we cannot withdraw 
     *  and exceed the minimum balance
     *  @param n the withdraw amount
     */
	@Override
	public void withdraw(double n) {
		if ((this.getBalance() - n) >= this.minimumBalance) {
			super.withdraw(n);
		}
	}


    
    /**
     * This is the default constructor for SavingsAccount and inherits the 
     * constructor from BankAccount.
     */
	public SavingsAccount() {
		super();
	}
    
    /**
     * This is the constructor for SavingsAccount if the user would like to set the annualInterestRate
     * @param annualInterestRate takes in a double which represents the initial annualInterestRate of the account
     */
	public SavingsAccount(double annualInterestRate) {
		super();
		this.setAnnualInterestRate(annualInterestRate);
	}

    /**
     * This is the constructor for SavingsAccount if the user would like to set the annualInterestRate,
     * balance and accountHolder
     * @param accountHolder this parameter takes in a customer from the Customer class
     * @param balance takes in a double which represents the initial balance of the accountHolder
     * @param annualInterestRate takes in a double which represents the initial annualInterestRate of the account
     */
	public SavingsAccount(Customer accountHolder, double balance, double annualInterestRate) {
		super(accountHolder, balance);
		this.setAnnualInterestRate(annualInterestRate);
	}


	// constructor that takes in balance and interest
	 public SavingsAccount(double balance, double annualInterestRate) {
                super(balance);
                this.setAnnualInterestRate(annualInterestRate);
        }

	// constructor that takes in customer and balance
	public SavingsAccount(Customer accountHolder, double balance) {
		super(accountHolder, balance);

	}








}
