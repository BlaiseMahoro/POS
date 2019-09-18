package POSPD;

/**
 * AuthorizedPayment represents the authorized payment to the store.
 */
public abstract class  AuthorizedPayment extends Payment {

	/**
	 * AuthorizationCode represents the payment authorization code.
	 */
	private String authorizationCode;

	public String getAuthorizationCode() {
		return this.authorizationCode;
	}
	public void setAuthorizationCode(String authorizationCode)
	{
		this.authorizationCode= authorizationCode;
	}
	public AuthorizedPayment()
	{
		
	}

	public AuthorizedPayment(String amount, String amtTendered)
	{
		super(amount,amtTendered);
		//this.authorizationCode=authorizationCode;
		
	}
	/**
	 * isAuthorized returns true if the payment is authorized and false otherwise.
	 * @return represents the status.
	 */
	public abstract Boolean isAuthorized();

	/**
	 * countsAsCash returns true if the payment is counted as cash and false otherwise.
	 * @return represents the status.
	 */
	public   Boolean countsAsCash() {
		return false;
	}

}