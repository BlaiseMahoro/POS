package POSPD;

import java.math.BigDecimal;

/**
 * Payment represents a payment made to the store.
 */
public abstract class Payment {

	/**
	 * amount represents the amount paid
	 */
	protected BigDecimal amount;
	/**
	 * amtTendered the total amount paid
	 */
	protected BigDecimal amtTendered;

	public Payment()
	{
		
	}
	public Payment(String amount, String amtTendered)
	{
		this.amount=new BigDecimal(amount);
		this.amtTendered=new BigDecimal(amtTendered);
	}
	public BigDecimal getAmount() {
		return this.amount;
	}

	public BigDecimal getAmtTendered() {
		return this.amtTendered;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void getAmtTendered(BigDecimal amountTendered) {
		this.amtTendered=amountTendered;
	}
	/**
	 * calcChange calculates and returns the change.
	 * @return represents the calculated change.
	 */
	public BigDecimal calcChange() {
		return amtTendered.subtract(amount);
	}

	/**
	 * countsAsCash returns true if the amount counts as cash and false otherwise.
	 * @return represents the status.
	 */
	public abstract Boolean countsAsCash() ;

}