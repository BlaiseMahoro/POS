package POSPD;

import java.math.BigDecimal;

/**
 * CashDrawer represents a cash drawer in the store.
 */
public class CashDrawer {

	/**
	 * cashAmount represents the amount of money in the drawer.
	 */
	private BigDecimal cashAmount;
	/**
	 * position represents the position of the drawer.
	 */
	private int position;

	public BigDecimal getCashAmount() {
		return this.cashAmount;
	}

	public int getPosition() {
		return this.position;
	}
	public CashDrawer(BigDecimal cash, int position)
	{
		this.cashAmount=cash;
		this.position =position;
	}

	/**
	 * addCash add money to the Drawer.
	 * @param cash cash represents money.
	 */
	public void addCash(BigDecimal cash) {
		cashAmount=cashAmount.add(cash);
	}

	/**
	 * removeCash removes money from the drawer.
	 * @param cash cash represents money.
	 */
	public void removeCash(BigDecimal cash) {
      cashAmount =cashAmount.subtract(cash);
	}

	/**
	 * toString returns a string representation of the attributes.
	 * @return String represents the string representation to be returned.
	 */
	public String toString() {
		return ""+cashAmount;
		
	}

}