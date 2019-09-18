package POSPD;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Register represents a register in the Store.
 */
public class Register {

	/**
	 * number represents the register and number.
	 */
	private String number;
	/**
	 * cashDrawer represents the cashDrawer in the store.
	 */
	private CashDrawer cashDrawer;
	
	private ArrayList<Session> sessions;

	public String getNumber() {
		return this.number;
	}
	public void setNumber(String number)
	{
		this.number =number;
	}

	public CashDrawer getCashDrawer() {
		return this.cashDrawer;
	}
    public void setCashDrawer(CashDrawer cashDrawer)
    {
    	this.cashDrawer=cashDrawer;
    }
	/**
	 * Register initializes the register object to default.
	 */
	public Register() {
		sessions = new ArrayList<Session>();
		cashDrawer=new CashDrawer(new BigDecimal("0.00"),0);
	}
	

	/**
	 * Register initializes the register object to the passed number.
	 * @param number number represents the register number.
	 */
	public Register(String number) {
	this();
	this.number =number;
	
	}
    public  void addSession(Session session)
    {
    	sessions.add(session);
    }
	/**
	 * toString represents the class attribute into a string.
	 * @return String represents the string representation to be returned.
	 */
	public String toString() {
		return this.number;
	}
	public  ArrayList<Session> getSessions()
	{
		return sessions;
	}
    public boolean IsRegisterUsed()
    {
    	boolean status = false;
    	if(!this.getSessions().isEmpty())
    	{
    		status=true;
    	}
    	return status;
    }

}