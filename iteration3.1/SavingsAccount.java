public class SavingsAccount extends BankAccount {
	
	// instance variables
	private double annualInterestRate = 0.05 ;
	private double minimumBalance;

	// getter metods
	public void setAnnualInterestRate(double n) {
		
		if ((n >= 0) && (n <= 1)) {
			this.annualInterestRate = n;
		}

	}
	
	public void setMinimumBalance(double n) {
		this.minimumBalance = n;		
	}

	// setter methods
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}

	
	// methods

	public void depositMonthlyInterest() {
		deposit(this.getBalance() * (annualInterestRate / 12));
	}

	// override the withdraw method to makes sure we cannot withdraw and exceed minimum balance;
	public void withdraw(double n) {
		if ((this.getBalance() - n) >= this.minimumBalance) {
			super.withdraw(n);
		}
	}













}
