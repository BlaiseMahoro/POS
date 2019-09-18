package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Sale represents the sale made by the Store
 */
public class Sale {

	/**
	 * dateTime represents the time and date the sale was made
	 */
	private LocalDateTime dateTime;
	/**
	 * taxFree represents whether or not the sale has tax.
	 */
	private Boolean taxFree;
	/**
	 * saleLineItems represents an item on the sale line.
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * payments represents the payments made to the store
	 */
	private ArrayList<Payment> payments;

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public Boolean getTaxFree() {
		return this.taxFree;
	}
	public void setTaxFree(boolean taxFree) {
		this.taxFree= taxFree;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return this.saleLineItems;
	}

	public ArrayList<Payment> getPayments() {
		return this.payments;
	}

	/**
	 * String represents the string representation to be returned.
	 */
	public Sale() {
		saleLineItems = new ArrayList<SaleLineItem>();
		payments = new ArrayList<Payment>();
		this.dateTime =LocalDateTime.now();
		this.taxFree=false;
	}

	/**
	 * Sale initializes the attributes to the parameters passed.
	 * @param taxFree taxFree represents if the sale is tax free or not.
	 */
	public Sale(String taxFree) {
		this();
		
		if(taxFree.toUpperCase().equals("Y"))
			this.taxFree=true;
		else 
		    this.taxFree= false;
	}

	/**
	 * AddPayment adds a payment to a sale.
	 * @param payment payment represents a payment made.
	 */
	public void addPayment(Payment payment) {
		if(payment!= null)
			this.payments.add(payment);
	}

	/**
	 * removePayment removes a payment from the sale.
	 * @param payment payment represents the payment made in a sale.
	 */
	public void removePayment(Payment payment) {
		if(payment!=null)
			this.payments.remove(payment);
	}

	/**
	 * addSaleLineItem adds a sale line item.
	 * @param sli sli represents a sale line item.
	 */
	public void addSaleLineItem(SaleLineItem sli) {
		if(sli!=null)
			this.saleLineItems.add(sli);
	}

	/**
	 * removeSaleLineItem removes a sale line item from the sale
	 * @param sli sli represents a sale line item in the sale
	 */
	public void removeSaleLineItem(SaleLineItem sli) {
		if(sli!=null&&!this.saleLineItems.isEmpty())
			this.saleLineItems.remove(sli);
	}

	/**
	 * calcTotal calculate the total amount.
	 * @return represents a total amount
	 */
	public BigDecimal calcTotal() {
		return this.calcSubTotal().add(this.calcTax());
	}

	/**
	 * calcSubTotal calculates the sub total.
	 * @return represents a calculated sub total.
	 */
	public BigDecimal calcSubTotal() {
		BigDecimal subTotal = new BigDecimal("0.00");
		Iterator<SaleLineItem> it= saleLineItems.iterator();
		SaleLineItem sli;
		while(it.hasNext())
		{
		  sli=it.next();
		  subTotal=subTotal.add(sli.calcSubTotal());
		}
		return subTotal.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * calcTax calculate tax.
	 * @return represents the amount of tax.
	 */
	public BigDecimal calcTax() {
		BigDecimal tax = new BigDecimal("0.00");
		if(!this.getTaxFree())
		{
		
		Iterator<SaleLineItem> it= saleLineItems.iterator();
		SaleLineItem sli;
		while(it.hasNext())
		{
		  sli=it.next();
		  tax=tax.add(sli.calcTax());
		  
		}
		}
		return tax.setScale(2,RoundingMode.HALF_UP);
	}

	/**
	 * getTotalPayments returns the total payment.
	 * @return represents total payment.
	 */
	public BigDecimal getTotalPayments() {
		BigDecimal totalPayment = new BigDecimal("0.00");
		Iterator<Payment> it= payments.iterator();
		Payment payment;
		while(it.hasNext())
		{
		  payment=it.next();
		  totalPayment=totalPayment.add(payment.getAmount());
		  
		}
		return totalPayment.setScale(2,RoundingMode.HALF_UP);
	}

	/**
	 * isPaymentEnough returns true if the payment is greater than total amount and false otherwise.
	 * @return represents the status.
	 */
	public Boolean isPaymentEnough() {
		Boolean status= true;
		if(this.getTotalPayments().compareTo(this.calcTotal())==-1)
			status=false;
		
		return status;
		
		
	}
	

	/**
	 * calcAmount calculates the amount.
	 * @param amtTendered AmtTendered represents the amount tendered.
	 */
	public BigDecimal calcAmount(BigDecimal amtTendered) {
		BigDecimal amtNeeded = this.calcTotal().subtract(this.getTotalPayments());
		if(amtNeeded.compareTo(amtTendered)>0)
			 amtNeeded = amtTendered;
		
		return amtNeeded;
				
		
	}
	public  BigDecimal remainingPay()
	{
		BigDecimal needed = new BigDecimal("0");
		if(!isPaymentEnough())
		{
			needed = calcTotal().subtract(calcAmtTendered());
		}
		return needed.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * calcChange calculates the balance to be refunded.
	 * @return represents the balance after the sale.
	 */
	public BigDecimal calcChange() {
		return this.calcAmtTendered().subtract(this.calcTotal());
		
	}

	/**
	 * calcAmtTendered calculates the amount tendered.
	 * @return represents the amount tendered.
	 */
	public BigDecimal calcAmtTendered() {
		BigDecimal amtTendered = new BigDecimal("0.00");
		Iterator<Payment> it= payments.iterator();
		Payment payment;
		while(it.hasNext())
		{
		  payment=it.next();
		  amtTendered=amtTendered.add(payment.getAmtTendered());
		  
		}
		return amtTendered.setScale(2,RoundingMode.HALF_UP);
		
	}

	public String sliToString()
	{
		Iterator<SaleLineItem> it= saleLineItems.iterator();
		String r="";
		SaleLineItem sli;
		while(it.hasNext())
		{
		  sli=it.next();
		  r+=sli.toString();
		  r+="\n";
		}
		return r;
	}
	/**
	 * toString returns the string representation of the object attributes.
	 * @return represents the string representation of the object attributes.
	 */
	public String toString() {
		//sliToString();
		return "Total: "+this.calcAmtTendered()+"\nDate: "+this.dateTime+ "\n SubTotal= "+this.calcSubTotal()+" Tax = "+this.calcTax()+" Total= "+this.calcTotal()+
				" Payment = "+this.getTotalPayments()+" change= "+this.calcChange()+" \n"+this.sliToString();
		
	}

}