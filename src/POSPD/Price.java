package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Price represents an item's price.
 */
public class Price implements Comparable<Price>{

	/**
	 * price represents a price on item
	 */ 
	private BigDecimal price;
	/**
	 * effectiveDate represents the date on which the price starts to be used.
	 */
	private LocalDate effectiveDate;
	/**
	 * item represents an item
	 */
	private Item item;

	public BigDecimal getPrice() {
	   if(price !=null)
		    return this.price.setScale(2, RoundingMode.HALF_UP);
	   else 
		   return this.price = new BigDecimal("0").setScale(2,RoundingMode.HALF_UP);
	}
	public void setPrice(String price) {
	
	    this.price=new BigDecimal(price);	
}

	public LocalDate getEffectiveDate() {
		if(this.effectiveDate != null)
		     return this.effectiveDate;
		else 
			return this.effectiveDate =LocalDate.now();
	}
	public void setEffectiveDate(String date) {
		
		  this.effectiveDate=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
	}
	
	
	public boolean isPromo()
	{
		return false;
	}

	public Item getItem() {
		return this.item;
	}

	/**
	 * Price is a default constructor. It initializes the attributes to default.
	 */
	public Price() {
		//this.price = new BigDecimal("0");
		//this.effectiveDate =LocalDate.now();
	}

	/**
	 * Price is a constructor with parameters. It initializes the attributes to the passed values.
	 * @param price price represents the price of an item.
	 * @param effectiveDate effectiveDate represents the effective date when the price starts to be used.
	 */
	public Price(String price, String effectiveDate) {
		this.price = new BigDecimal(price);
		this.effectiveDate = LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yy"));
		
	}

	/**
	 * isEffectiveDate returns true if the date given is after the effective date.
	 * @param date date represents the date.
	 * @return represents the status after comparing the date to the effectiveDate.
	 */
	public boolean isEffectiveDate(LocalDate date) {
		return (this.effectiveDate.isBefore(date)||this.effectiveDate.isEqual(date));
	}

	/**
	 * calcAmountForQty calculates the amount for a given quantity of items.
	 * @param quantity quantity represents the item's quantity.
	 * @return represents the calculated amount.
	 */
	public BigDecimal calcAmountForQty(int quantity) {
		// TODO - implement Price.calcAmountForQty
		throw new UnsupportedOperationException();
	}

	/**
	 * compareTo compares a given price to the current price.
	 * @param price price represents the price of an item
	 */
	public int compareTo(Price price) {
		
		return this.effectiveDate.compareTo(price.getEffectiveDate());
		 

	}

	

	/**
	 * toString returns the string representation of attributes.
	 * @return represents the string representation of the attributes.
	 */
	public String toString() {
		return ""+price + " "+effectiveDate;
	}

}