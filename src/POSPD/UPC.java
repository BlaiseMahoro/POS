package POSPD;

/**
 * UPC class represents an item's UPC code.
 */
public class UPC {

	/**
	 * uPC represents the UPC Code on an item.
	 */
	private String uPC;
	private Item item;

	public String getUPC() {
		String r ="";
		if(uPC!=null)
			r=this.uPC;
			
		return r;
	}

	public void setUPC(String upc) {
		this.uPC=upc;
	}
	public Item getItem()
	{
		return item;
		
	}
	public void setItem(Item item)
	{
		this.item = item;
	}
	/**
	 * UPC initializes UPC Attributes to default values.
	 */
	public UPC() {
		//item = new Item();
	}

	/**
	 * UPC initializes UPC Attributes to passed values.
	 * @param upC uPC represents UPC code on items
	 */
	public UPC(String upC) {
		this.uPC=upC;
	}
    
	/**
	 * toString returns the string representation of attributes.
	 * @return represents the string representation of attributes to be returned.
	 */
	public String toString() {
		return this.uPC;
	}

}