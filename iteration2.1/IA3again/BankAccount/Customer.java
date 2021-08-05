public class Customer {
	
	// instance variables
	private String name;
	private int customerID;

	// getter methods
	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.customerID;
	}

	// setter methods
	public void setName(String n) {
		this.name = n;
	}

	public void setCustomerID(int x) {
		this.customerID = x;
	}


	// toString() method
	public String toString() {
		return name + " " + Integer.toString(customerID);
	}


	// constructors
	public Customer() {
		this.name = "placeholder";
		this.customerID = 0;
	}
	
	
	public Customer(String n, int ID) {
		this.name = n;
		this.customerID = ID;
	
	}


	// copy constructor
	public Customer(Customer toCopy) {
		this.name = toCopy.name;
		this.customerID = toCopy.customerID;
	}




}
