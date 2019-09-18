package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

/**
 * Cashier represents a cashier at the Store.
 */
public class Cashier {

	/**
	 * number represents the Cashier number.
	 */
	private String number;
	/**
	 * password represent the cashier password.
	 */
	private String password;
	/**
	 * person represents a person in the store
	 */
	private Person person;
	/**
	 * sessions represents sessions in the store.
	 */
	private ArrayList<Session> sessions;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return this.person;
	}
	public void setPerson(Person person) {
		this.person=person;
	}
	public ArrayList<Session> getSessions() {
		return this.sessions;
	}

	/**
	 * Cashier initializes the cashier object to default.
	 */
	public Cashier() {
		this.number ="";
		this.password ="";
		this.person =new Person();
	}

	/**
	 * Cashier initializes the cashier object to the cashier number,password, and person.
	 * @param number number represents the cashier number.
	 *  
	 * @param person person represents the person in the store.
	 * @param password password represents the cashier password.
	 */
	public Cashier(String number, Person person, String password) {
		sessions=new ArrayList<Session>();
		this.number =number;
		this.password =password;
		this.person =person;
	}

	/**
	 * 
	 * @param session
	 */
	public void addSession(Session session) {
		sessions.add(session);
	}

	/**
	 * 
	 * @param session
	 */
	public void removeSession(Session session) {
		sessions.remove(session);
	}
	public BigDecimal TotalSalesforCashier(LocalDate date)
	{
		BigDecimal amt = new BigDecimal("0");
		if(!sessions.isEmpty())
		{
			for(Session session:sessions)
			{
				if(session.getEndDateTime().toLocalDate().isBefore(date)||session.getEndDateTime().toLocalDate().isEqual(date))
				amt=amt.add(session.SalesTotal());
			}
		}
		return amt.setScale(2,RoundingMode.HALF_UP);
	}

	/**
	 * 
	 * @param password
	 */
	public Boolean isAuthorized(String password) {
		return this.password.equals(password);
	}
	public int getNumberOfSales(LocalDate date)
	{
		int num=0;
		if(!sessions.isEmpty())
		{
			for(Session session:sessions)
			{
				if(!session.getSales().isEmpty()&&(session.getEndDateTime().toLocalDate().isBefore(date)||session.getEndDateTime().toLocalDate().isEqual(date)))
				   num+=session.getSales().size();
			}
		}
		return num;
	}

	/**
	 * toString returns a string representation of the attributes.
	 * @return String represents the string representation to be returned.
	 */
	public String toString() {
		return ""+person.getName()+" "+number;
	}

}