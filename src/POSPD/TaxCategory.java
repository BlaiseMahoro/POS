package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

/**
 * TaxCategory represents a tax category.
 */
public class TaxCategory {

	/**
	 * category represents the tax category of a particular.
	 */
	private String category;
	/**
	 * taxRates represents the tax rates in the store
	 */
	private TreeSet<TaxRate> taxRates;

	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
		 this.category = category;
	}
	

	public TreeSet<TaxRate> getTaxRates() {
		return this.taxRates;
	}

	/**
	 * TaxCategory is a default constructor. It initializes the attributes to default values.
	 */
	public TaxCategory() {
		taxRates=new TreeSet<TaxRate>();
		
	}

	/**
	 * TaxCategory is a constructor with parameters. It initializes the attributes to the passed arguments.
	 * @param category Category represents the tax category on an item.
	 */
	public TaxCategory(String category) {
		this();
		this.category =category;
		
	}

	/**
	 * getTaxRateForDate returns the tax rate on a given date.
	 * @param date date represents the date
	 * @return represents the tax rate on a given date.
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		Iterator<TaxRate> it= taxRates.iterator();
		
		
		BigDecimal bg = null;
		while(it.hasNext())
		{
			TaxRate taxRate= it.next();
			if(taxRate.isEffective(date))
				bg=taxRate.getTaxRate();
		}
		return bg.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * addTaxRate  adds a new tax rate
	 * @param taxRate taxRate represents a tax rate on an item.
	 */
	public void addTaxRate(TaxRate taxRate) {
		taxRates.add(taxRate);
		}

	/**
	 * toString returns a string representation of attributes.
	 * @return represents the string representation of the attributes to be returned.
	 */
	public String toString() {
		return category;
	}

	/**
	 * removeTaxRate removes a tax rate.
	 * @param taxRate taxRate represents the tax rate
	 */
	public void removeTaxRate(TaxRate taxRate) {
		taxRates.remove(taxRate);
	}

}