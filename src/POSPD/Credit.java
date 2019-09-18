package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Credit represents a credit card payment.
 */
public class Credit extends AuthorizedPayment {

	/**
	 * cardType represent the type of the card.
	 */
	private String cardType;
	/**
	 * acctNumber represents the account number of the credit card.
	 */
	private String acctNumber;
	/**
	 * expireDate represents the credit card expiry  date.
	 */
	private LocalDate expireDate;

	public String getCardType() {
		return this.cardType;
	}

	public String getAcctNumber() {
		return this.acctNumber;
	}

	public LocalDate getExpireDate() {
		return this.expireDate;
	}
	public void setCardType(String cardType) {
		this.cardType=cardType;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber= acctNumber;
	}

	
	

	/**
	 * Credit is a default constructor. It initializes the credit card to default values.
	 */
	public Credit() {
		super();
	}

	/**
	 * Credit is a constructor with parameters. It initializes the attributes to passed values.
	 * @param cardType cardType represents the type of the credit card
	 * @param acctNumber acctNumber represents the account number on the credit card.
	 * @param expireDate expireDate represents the expiry date of the card.
	 */
	public Credit(String cardType, String acctNumber, String expireDate,
			String amount, String amtTendered) {
		super(amount,amtTendered);
		this.cardType=cardType;
		this.acctNumber=acctNumber;
		this.expireDate=LocalDate.parse(expireDate,DateTimeFormatter.ofPattern("dd/M/yyyy"));
	}

	/**
	 * isAuthorized returns true if the  payment is authorized and false otherwise.
	 * @return represents the decision
	 */
	public Boolean isAuthorized() {
		return LocalDate.now().isBefore(expireDate);
	}

	/**
	 * calcChange calculates and returns the change.
	 */
	public BigDecimal calcChange() {
		// TODO - implement Credit.calcChange
		throw new UnsupportedOperationException();
	}

	/**
	 * toString represents the string representation of object's attributes.
	 * @return represents the string representation of object's attributes.
	 */
	public String toString() {
		// TODO - implement Credit.toString
		throw new UnsupportedOperationException();
	}

}