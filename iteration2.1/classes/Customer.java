public class Customer {

	// instance variables
	private String name;
	private int customerID;

	// getter methods
	public String getName() {
		return name;		// or should it be this.name?
	}

	public int getID() {
		return customerID;
	}

	// setter methods
	public void setName(String n) {
		this.name = n;
	}

	public void setCustomerID(int x) {
		this.customerID = x;
	}

	// toString method
	public String toString() {
		return this.name + " " + this.customerID;
	}


	// constructors
	
	Customer() {
	
	}


	Customer(String name, int id) {
		this.setName(name);
		this.setCustomerID(id);
	}


	Customer(Customer oldCustomer) {
		this.setName(oldCustomer.getName());
                this.setCustomerID(oldCustomer.getID());

	}




}
