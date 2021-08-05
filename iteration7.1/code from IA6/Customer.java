
public class Customer {
	
	// instance variables
	private String name;
	private int customerID;

	
	
	/** 
	 * Constructor that takes no arguments and sets name to "placeholder"
	 */
	public Customer() {
		this("placeholder", 0);
	}
	
	/**
	 * Constructor that takes String and integer as argument and uses them to initialize name and customerID
	 * @param n the String value that the constructor assigns to name
	 * @param ID the int value that the constructor assigns to customerID
	 */
	public Customer(String n, int ID) {
		this.name = n;
		this.customerID = ID;
	
	}


	/** Copy constructor that takes another customer in argument and another customer object with the same attributes
	 * @param toCopy is the customer class whose instance variables we want to copy when creating the customer object
	 */
	public Customer(Customer toCopy) {
		this(toCopy.name, toCopy.customerID);
	}


	/**
	 * Getter method that returns private variable name in string format
	 * @return the instance variable name
	 */
	public String getName() {
		return this.name;
	}

	/** Getter method that returns the private vairable customerID as an integer
	 * @return the instance variable customerID
	 */
	public int getID() {
		return this.customerID;
	}

	/** Setter method that will change the value of the private variable name
	 * @param n the string that we want to assign to the instance variable name
	 */
	public void setName(String n) {
		this.name = n;
	}

	/**
	 * Setter method that will change the value of the private variable customerID
	 * @param x the integer that we want to assign to the instance variable customerID
	 */
	public void setCustomerID(int x) {
		this.customerID = x;
	}


	/**
	 * This method returns the instance variables name and customerID in string format
	 * @return the instance variables name and customerID in string form
	 */
	public String toString() {
		return name + " " + Integer.toString(customerID);
	}


	




}
