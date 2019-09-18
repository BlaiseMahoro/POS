package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Session represents a time session the cashier spends working.
 */
public class Session {

	/**
	 * startDateTime represent the date and time the cashier starts a session.
	 */
	private LocalDateTime startDateTime;
	/**
	 * endDateTime represents the time the cashier ends a session.
	 */
	private LocalDateTime endDateTime;
	/**
	 * sales represent sales in the store
	 */
	private ArrayList<Sale> sales;
	/**
	 * cashier represents the cashier in the store.
	 */
	private Cashier cashier;
	/**
	 * register represents a register in the store.
	 */
	private Register register;

	public LocalDateTime getStartDateTime() {
		return this.startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return this.endDateTime;
	}

	public ArrayList<Sale> getSales() {
		return this.sales;
	}

	public Cashier getCashier() {
		return this.cashier;
	}

	public Register getRegister() {
		return this.register;
	}
	public Session()
	{
		this.startDateTime=LocalDateTime.now();
		this.endDateTime =LocalDateTime.now();
		sales = new ArrayList<Sale>();
	}
	/**
	 * addSale adds a new sale to a session
	 * @param sale sale represents a sale made by the store.
	 */
	public void addSale(Sale sale) {
		if(sale!=null)
			sales.add(sale);
	}

	/**
	 * calcCashCountDiff calculates the difference in two given amounts.
	 * @param cash cash represents the amount of money.
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash) {
	
		return cash.subtract(getRegister().getCashDrawer().getCashAmount());
	}

	/**
	 * removeSale removes a sale.
	 * @param sale sale represents a sale made by the store.
	 */
	public void removeSale(Sale sale) {
		if(!sales.isEmpty())
			sales.remove(sale);
	}
	public BigDecimal SalesTotal()
	{
		BigDecimal amt = new BigDecimal("0");
		if(!sales.isEmpty())
		{
			for(Sale sale:sales)
			{
				amt=amt.add(sale.calcTotal());
			}
		}
		return amt.setScale(2,RoundingMode.HALF_UP);
	}

	/**
	 * Session initializes the session object to cashier and register passed to it.
	 * @param cashier cashier represents a cashier in the Store.
	 * @param register register represents a register in the store.
	 */
	public Session(Cashier cashier, Register register) {
		this();
		this.cashier=cashier;
		
		this.register = register;
		register.addSession(this);
	}
	public String salesToString()
	{
		Iterator<Sale> it =sales.iterator();
		Sale sale;
		String r="";
		while(it.hasNext())
		{
		  sale=it.next();
		  r+=sale.toString()+"\n";
		  
		}
		return r;
	}

	/**
	 * toString returns a string representation of the attributes.
	 * @return String represents the string representation to be returned.
	 */
	public String toString() {
		
		return "Cashier: "+ cashier.getPerson().getName()+" Register:"+this.register.getNumber()+
				"\nSale:" + this.salesToString();
	}

}