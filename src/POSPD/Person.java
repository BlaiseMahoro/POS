package POSPD;

/**
 * Person represents a normal person.
 */
public class Person {

	/**
	 * name is the name of the person.
	 */
	private String name;
	/**
	 * address is the physical address of the person.
	 */
	private String address;
	/**
	 * sSN is the Social Security Number of the person.
	 */
	private String sSN;
	/**
	 * cashier represents a cashier in the store.
	 */
	private String state;
	private String city;
	private String zip;
	private Cashier cashier;
	
	private String phone;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}
    public String getPhone()
    {
    	return this.phone;
    }
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getSSN() {
		return this.sSN;
	}

	public void setSSN(String sSN) {
		this.sSN = sSN;
	}
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip =zip;
	}
	

	

	public Cashier getCashier() {
		return this.cashier;
	}

	/**
	 * Person initializes a person object to default.
	 */
	public Person() {
		this.name = "";
		this.address="";
		this.phone ="";
		this.sSN ="";
		this.city="";
		this.state="";
		this.zip="";
	}

	/**
	 * Person initializes the person object with passed name and address.
	 * @param name name is the name of the person.
	 * @param address address is the address of the person
	 */
	public Person(String name, String address,String phone, String sSN, String city, String state,String zip) {
		this.name = name;
		this.address=address;
		this.phone =phone;
		this.sSN =sSN;
		this.city=city;
		this.state=state;
		this.zip=zip;
		//this.cashier=cashier;
	}

	/**
	 * toString returns a string representation of the attributes.
	 * @return String represents the string representation to be returned.
	 */
	public String toString() {
		return name;
	}

}