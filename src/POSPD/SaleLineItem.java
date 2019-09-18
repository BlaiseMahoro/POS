package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
//import java.time.LocalDate;

/**
 * SaleLineItem represents an item on the sale line.
 */
public class SaleLineItem {

	/**
	 * quantity represents the quantity of an item.
	 */
	private String quantity;
	/**
	 * item represents an item
	 */
	private Item item;
	
	private Sale sale;

	public String getQuantity() {
		return this.quantity;
	}
	public void setQuantity(String qty)
	{
		this.quantity=qty;
	}

	public Item getItem() {
		return this.item;
	}
	public void setItem(Item item) {
		this.item=item;
	}
	public Sale getSale()
	{
		return sale;
	}
	public void setSale(Sale sale)
	{
		this.sale= sale;
	}

	/**
	 * SaleLineItem is a default constructor. It initializes the saleLineItem class.
	 */
	public SaleLineItem() {
		
	}

	/**
	 * SaleLineItem is a constructor with parameters. It initializes the SaleLineItem object with passed values.
	 * @param itemNumber itemNumber represents the number of an item.
	 * @param quantity quantity is the quantity of an item.
	 */
	public SaleLineItem(Sale sale,Item item, String quantity) {
		this.item = item;
		this.quantity = quantity;
		this.sale=sale;
	}

	/**
	 * calcSubTotal calculates and returns the sub total.
	 * @return represents the calculated sub total.
	 */
	public BigDecimal calcSubTotal() {
		BigDecimal subTotal;
		subTotal=item.getPriceForDate(sale.getDateTime().toLocalDate()).multiply(new BigDecimal(this.quantity));
		return subTotal.setScale(2,RoundingMode.HALF_UP);
				}

	/**
	 * calcTax calculates and returns the tax on an item on the sale line.
	 * @return represents the tax calculated.
	 */
	public BigDecimal calcTax() {
		BigDecimal tax;
		tax = item.getTaxRateForDate(sale.getDateTime().toLocalDate()).multiply(this.calcSubTotal());
		return tax.setScale(2,RoundingMode.HALF_UP);
	}

	/**
	 * toString returns the string representation of the attributes.
	 * @return represents the returned string representation.
	 */
	public String toString() {
		return item.getNumber()+" "+item.getDescription()+" "+this.getQuantity()
		+" @$"+item.getPriceForDate(sale.getDateTime().toLocalDate())+ " "+calcSubTotal();
	}

}