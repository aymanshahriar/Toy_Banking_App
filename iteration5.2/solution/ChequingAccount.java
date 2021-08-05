/**
 * This class is the chequing account that inherits bankaccount
 */
public class ChequingAccount extends BankAccount {


	// instance variables
	private double overdraftFee;
	private double overdraftAmount;

	/**
	 * constructor that takes balance, account holder, and overdraftfee
	 * @param accountHolder the customer of this chequing account
	 * @param startBalance the initial balance
	 * @param overdraftFee the initial overdraftFee
	 */
	public ChequingAccount(Customer accountHolder, double startBalance, double overdraftFee) {
		super(accountHolder, startBalance);
		this.setOverdraftFee(overdraftFee);
	}


	
	/**
	 * getter method that returns overdraftFee
	 * @return the instance variable overdraftFee
	 */
	public double getOverdraftFee() {
		return this.overdraftFee;
	}
	
	/**
	 * setter method that sets the overdraftFee
	 * @param d the double that we want to change overdraftFee into
	 */
	public void setOverdraftFee(double d) {
		if (d >= 0) {
			this.overdraftFee = d;
		}
		else {
			this.overdraftFee = 1;
		}
	}
	/**
         * getter method that returns overdraftAmount
         * @return the instance variable overdraftAmount
         */

	public double getOverdraftAmount() {
		return this.overdraftAmount;
	}
	
	/**
         * setter method that sets the overdraftAmount
         * @param d the double that we want to change overdraftAmount into
         */

	public void setOverdraftAmount(double d) {
		if (d >= 0) {
                        this.overdraftAmount = d;
                }

	}


	/**
	 * checks if the account has sufficient funds to withdraw the specified amount
	 * @param amount the amount we want to withdraw
	 * @return a boolean statement that says if we can withdraw the amount or not
	 */
	@Override
	public boolean sufficientFunds(double amount) {
		if (amount <= (this.getBalance() + this.overdraftAmount)) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * withdraws the specified amount from balance
	 * @param amount the amount we want to withdraw
	 */
	@Override
	public void withdraw(double amount) {
		// if the amount to withdraw is bigger than balance but less than balance and overdraft amountcombined:
		if ((amount > this.getBalance()) && (this.sufficientFunds(amount))) {
			super.withdraw(amount + this.overdraftFee);
		}
		// if the amount to withdraw is less than balance, just do simple withdraw via parent withdraw method:
		else if (amount <= this.getBalance()) {
			super.withdraw(amount);
		}
		
	}

	/**
	 * calculates and returns the monthly fees and interest
	 * @return the monthly fees and interest
	 */
	@Override
	public double getMonthlyFeesAndInterest() {
		if (this.getBalance() >= 0) {
			return 0.0;
		}
		else {
			return (this.getBalance() * 0.2);
		}
	
	}




}
