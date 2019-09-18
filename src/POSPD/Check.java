package POSPD;

import java.math.BigDecimal;

/**
 * Check represents the payment by check.
 */
public class Check extends AuthorizedPayment {

	/**
	 * routingNumber represents the check's routing number
	 */
	private String routingNumber;
	/**
	 * accountNumber represents the account number.
	 */
	private String accountNumber;
	/**
	 * checkNumber represents the check number.
	 */
	private String checkNumber;

	public String getRoutingNumber() {
		return this.routingNumber;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public String getCheckNumber() {
		return this.checkNumber;
	}

	/**
	 * check is a default constructor. It initializes the attributes to default.
	 */
	public Check() {
		
	}

	/**
	 * Check is a constructor with parameters. It initializes the attributes to the passed values.
	 * @param amount amount represents the amount on the check
	 * @param accountNumber accountNumber represents the account number on the check.
	 */
	public Check(String amount, String amtTendered,String accountNumber,String routingNumber, String checkNumber ) {
		super(amount,amtTendered);
		this.accountNumber =accountNumber;
		
		this.checkNumber =checkNumber;
		this.routingNumber =routingNumber;
	}

	/**
	 * isAuthorized returns true if the the payment is authorized and false otherwise
	 * @return represents the decision.
	 */
	public Boolean isAuthorized() {
		// TODO - implement Check.isAuthorized
		throw new UnsupportedOperationException();
	}

	/**
	 * calcChange calculates and returns the change.
	 * @return represents the the calculated change.
	 */
	public BigDecimal calcChange() {
		// TODO - implement Check.calcChange
		throw new UnsupportedOperationException();
	}

	/**
	 * toString returns the string representation of object's attributes.
	 * @return represents the string representation of object's attributes.
	 */
	public String toString() {
		// TODO - implement Check.toString
		throw new UnsupportedOperationException();
	}

}