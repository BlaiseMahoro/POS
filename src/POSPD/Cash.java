package POSPD;

import java.math.BigDecimal;

/**
 * Cash represents cash payments to the store.
 */
public class Cash extends Payment {

	/**
	 * Cash is a default constructor. It initializes the attributes to default.
	 */
	public Cash() {
		super();
		
	}

	/**
	 * 
	 * @param amount
	 * @param amtTendered amtTendered represents the total amount paid to the store.
	 */
	public Cash(BigDecimal amount, BigDecimal amtTendered) {
		super(amount.toString(),amtTendered.toString());
	
		
	}

	/**
	 * calcChange calculates and returns the change.
	 * @return represents the calculated change
	 */
	public BigDecimal calcChange() {
		return amtTendered.subtract(amount);
	}

	/**
	 * countsAsCash returns true if the payment is counted as cash and false otherwise.
	 * @return represents the decision.
	 */
	public Boolean countsAsCash() {
		return true;
	}

	/**
	 * toString returns the string representation of object's attributes.
	 * @return represents the string representation of the object's attributes.
	 */
	public String toString() {
		// TODO - implement Cash.toString
		throw new UnsupportedOperationException();
	}

}