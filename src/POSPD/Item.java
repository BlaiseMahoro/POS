package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

/**
 * Item class represents an item in the store.
 */
public class Item {

	/**
	 * number represents item number.
	 */
	private String number;
	/**
	 * description represents the item description
	 */
	private String description;
	/**
	 * uPCs represents UPC codes of items.
	 */
	private TreeMap<String,UPC> uPCs;
	/**
	 * prices represents prices in the store
	 */
	private TreeSet<Price> prices;
	/**
	 * taxCategories represents tax categories on items
	 */
	private TaxCategory taxCategory;
	/**
	 * saleLineItems represents items on the sale line.
	 */
	private ArrayList<SaleLineItem> saleLineItems;

	public String getNumber() {
		return this.number;
	}

	public String getDescription() {
		return this.description;
	}
	
	public void setNumber(String number ) {
		this.number=number;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	

    
	public TreeMap<String,UPC> getUPCs() {
		return this.uPCs;
	}

	public TreeSet<Price> getPrices() {
		return this.prices;
	}
	
	public TaxCategory getTaxCategory() {
		return this.taxCategory;
	}
	public void setTaxCategory(TaxCategory taxCat) {
		this.taxCategory=taxCat;
	}
	

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return this.saleLineItems;
	}

	/**
	 * Item initializes attributes to default values.
	 */
	public Item() {
		saleLineItems = new ArrayList<SaleLineItem>();
		uPCs= new TreeMap<String,UPC>();
		prices =new TreeSet<Price>();
		
	}

	/**
	 * 
	 * @param number number represent the item number.
	 * @param description description represents the item description.
	 */
	public Item(String number, String description,TaxCategory taxCategory) {
		this();
		this.number=number;
		this.description =description;
		this.taxCategory =taxCategory;
	}

	/**
	 * addPrice adds the item's price.
	 * @param price price represents the price of an item.
	 */
	public void addPrice(Price price) {
		if(price!=null)
			this.prices.add(price);
	}

	/**
	 * addUPC adds the item UPC code.
	 * @param upc upc represents the UPC code on the item package.
	 */
	public void addUPC(UPC upc) {
		if(upc!=null)
			this.uPCs.put(upc.getUPC(), upc);
	}
	

	/**
	 * removePrice removes the price.
	 * @param price price represents the item's price.
	 */
	public void removePrice(Price price) {
		if(price!=null)
			prices.remove(price);
	}

	/**
	 * removeUPC removes the item's UPC code.
	 * @param upc upc represents the UPC code of an item.
	 */
	public void removeUPC(UPC upc) {
		if(upc!=null)
			uPCs.remove(upc.getUPC());
	}

	public void addSli(SaleLineItem Sli)
	{
		this.saleLineItems.add(Sli);
	}
	/**
	 * getPriceForDate returns the price of an item at a given item.
	 * @param date date represents the date.
	 * @return represents the price of an item at a given item.
	 */
	public BigDecimal getPriceForDate(LocalDate date) {
		Iterator<Price> it=prices.iterator();
		Price price;
		//Price currentPrice = new Price();
		BigDecimal bg = new BigDecimal("0");
		while(it.hasNext())
		{
			
			price = it.next();
			if(price.isEffectiveDate(date))
			{
				bg =price.getPrice();
			
			}
			
		}
		return bg.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * getTaxRateForDate returns the tax rate for a given date.
	 * @param date date represents the date.
	 * @return represents the tax rate returned.
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		return this.taxCategory.getTaxRateForDate(date);
	}

	/**
	 * calcAmountForDateQty calculates and returns the amount for  a given quantity on a given date.
	 * @param date date represents date
	 * @param quantity quantity represents the quantity of an item.
	 * @return represents the amount for  a given quantity on a given date.
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, String quantity) {
		BigDecimal amount;
		amount = this.getPriceForDate(date).multiply(new BigDecimal(quantity));
		return amount;
	}
	public String priceToString()
	{
		Iterator<Price> it = prices.iterator();
		
		String r=" ";
		while(it.hasNext())
		{
			Price price = it.next();
			r+=price.toString();
		}
		return r;
	}
	public String upcToString()
	{
		Set<String> keys= uPCs.keySet();
		Iterator<String> it=keys.iterator();
		String key1;
		String r="";
		
		while(it.hasNext())
		{
			key1 = it.next();
			r+=uPCs.get(key1).toString();
			r+=" ";
		}
		return r;
		
	}
	public int  soldCount(LocalDate date)
	{
		
		int count=0;
		if(!getSaleLineItems().isEmpty())
		{
			for(SaleLineItem sli:getSaleLineItems())
		    {
			    if(sli.getSale().getDateTime().toLocalDate().isBefore(date)||sli.getSale().getDateTime().toLocalDate().isEqual(date))
			        count+=Integer.parseInt(sli.getQuantity());
		     }
		}
		return count;
	}

	/**
	 * toString converts attributes into a string representation.
	 * @return represents the string representation of the attributes.
	 */
	
	public String toString() {
		
		return ""+this.number+" "+this.description+" "+upcToString()+" "+getPriceForDate(LocalDate.now())+" "+taxCategory.toString();
								
	}

}