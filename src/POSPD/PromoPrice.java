package POSPD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




/**
 * PromoPrice represents the promo price on an item.
 */
public class PromoPrice extends Price {

	/**
	 * endDate represents the deadline for a particular promo price.
	 */
	private LocalDate endDate;

	public LocalDate getEndDate() {
		return this.endDate;
	}

	/**
	 * PromoPrice is a default constructor. It initializes the attributes to default.
	 */
	public PromoPrice() {
		this.endDate =LocalDate.now();
	}

	/**
	 * PromoPrice is a constructor with parameters. It initializes the attributes to the passed values.
	 * @param price price represents the promo price of an item.
	 * @param effectiveDate effectiveDate represents the effective date on which the promo price is imposed.
	 * @param endDate endDate represents the end date of a promo price.
	 */
	public PromoPrice(String price,String  effectiveDate, String endDate) {
		
		super(price,effectiveDate);
		this.endDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("M/d/yy"));
	}
	
   public void setEndDate(String date) {
	this.endDate=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
	}
   public boolean isPromo()
   {
	   return true;
   }


	/**
	 * isEffective returns true if the given date is between the effectiveDate and endDate.
	 * @param date date represents the date.
	 * @return represents the decision.
	 */
	public boolean isEffectiveDate(LocalDate date) {
		return date.isBefore(endDate)&&(getEffectiveDate().isBefore(date)||getEffectiveDate().equals(date));
	}

	/**
	 * compareTo compares the promo price and the normal price and returns the diference.
	 * @param price price represents the price of an item.
	 * @return represents the difference between the price and promo price.
	 */
	public int compareTo(Price price) {
		return super.compareTo(price);
		
			
	}

	/**
	 * toString returns the string representation of object's attributes.
	 * @return represents the string representation of object's attributes.
	 */
	public String toString() {
		return this.getPrice().toString()+" "+ this.getEffectiveDate()+" thru "+ this.endDate;
		
	}

}