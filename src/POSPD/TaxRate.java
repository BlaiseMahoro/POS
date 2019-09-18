package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * TaxRate represents a tax rate on an item.
 */
public class TaxRate implements Comparable<TaxRate>{

	//private TaxCategory taxCategory;
	/**
	 * taxRate represents the tax tax rate on an item.
	 */
	private BigDecimal taxRate;
	/**
	 * effectiveDate represents the effective date of a tax rate
	 */
	private LocalDate effectiveDate;

	public BigDecimal getTaxRate() {
		BigDecimal rate=null;
		if(taxRate !=null)
		    rate =this.taxRate.setScale(2,RoundingMode.HALF_UP);
		return rate;
	}

	public void setEffectiveDate(String date) {
		this.effectiveDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public void setTaxRate(String taxRate) {
		this.taxRate =new BigDecimal(taxRate);
	}

	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}
	
	
	public TaxRate() {
	
	}
	
	/**
	 * TaxRate is a default constructor.
	 * @param effectiveDate
	 * @param rate rate represents tax rate
	 */
	public TaxRate(LocalDate effectiveDate, BigDecimal rate) {
		this.effectiveDate =effectiveDate;
		this.taxRate =rate;
		
    }

	/**
	 * isEffective returns true if the tax rate is effective on a given and false otherwise
	 * @param date date represents the date.
	 */
	public Boolean isEffective(LocalDate date) {
		return(effectiveDate.equals(date)||effectiveDate.isBefore(date));
	}
	
	public int compareTo(TaxRate taxRate)
	{
		return this.taxRate.compareTo(taxRate.getTaxRate());
	}

	/**
	 * toString returns a string representation of attributes.
	 * @return represents the string representation of attributes retruned.
	 */
	public String toString() {
		return ""+taxRate.setScale(2, RoundingMode.HALF_UP)+" "+ effectiveDate;
	}

}