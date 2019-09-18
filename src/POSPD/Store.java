package POSPD;

import java.util.*;

import POSDM.LoadStore;

/**
 * Store is the store we are currently working with.
 */
public class Store {

	/**
	 * number represents the number of the Store.
	 */
	private String number;
	/**
	 * name represents the name of the Store.
	 */
	private String name;
	private TreeMap<String,Cashier> cashiers;
	private ArrayList<Session> sessions;
	private TreeMap<String,TaxCategory> taxCategories;
	private TreeMap<String,Item> items;
	private TreeMap<String,UPC> upcs;
	private TreeMap<String,Register> registers;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Store is a default constructor. It initializes the attributes to default values.
	 */
	public Store() {
		cashiers=new TreeMap<String,Cashier>();
		items=new TreeMap<String,Item>();
		taxCategories=new TreeMap<String,TaxCategory>();
		upcs=new TreeMap<String,UPC>();
		registers =new TreeMap<String,Register>();
		taxCategories =new TreeMap<String,TaxCategory>();
		sessions=new ArrayList<Session>();
	}

	/**
	 * Store is a constructor with parameters. It initializes the attributes to the passed values.
	 * @param number number represents the store number.
	 * @param name name represents the store name.
	 */
	public Store(String number, String name) {
		this();
	    this.setName(name);
	    this.setNumber(number);
	}
	
	public  ArrayList<Session> getSessions()
	{
		return sessions;
	
	}
	
	public  TreeMap<String,TaxCategory> getTaxCategories()
	{
		return taxCategories;
	}
	
	public TreeMap<String,Item> getItems()
	{
		return items;
	}
	
	public TreeMap<String,Cashier> getCashiers()
	{
		return cashiers;
	}

	/**
	 * addItem adds an item to the store.
	 * @param item item represents an item.
	 */
	public void addItem(Item item) {
		if(item != null)
		{
			items.put(item.getNumber(), item);
		}
	}

	/**
	 * removeItem removes an item from the store..
	 * @param item item represents an item.
	 */
	public void removeItem(Item item) {
		if(item != null)
		{
			items.remove(item.getNumber());
		}
	}
	/**
	 * 
	 */
	public void load()
	{
		LoadStore.load(this);
	}

	/**
	 * addUPC adds UPC code of an item.
	 * @param upc upc represents the upc code of an item.
	 */
	public void addUPC(UPC upc) {
		
		if(upc != null)
		{
			upcs.put(upc.getUPC(), upc);
		}
	}

	/**
	 * removeUPC removes UPC code from the store.
	 * @param upc up represents the UPC code on the item.
	 */
	public void removeUPC(UPC upc) {
		upcs.remove(upc.getUPC());
	}

	/**
	 * addRegister adds register.
	 * @param register register represents a register in the store
	 */
	public void addRegister(Register register) {
		if(register!=null)
			registers.put(register.getNumber(), register);
	}

	/**
	 * removeRegister removes a register from the store.
	 * @param register register represents a register in the store.
	 */
	public void removeRegister(Register register) {
		registers.remove(register.getNumber());
	}

	/**
	 * addCashier adds a cashier.
	 * @param cashier cashier represents a cashier  in the store.
	 */
	public void addCashier(Cashier cashier) {
		if(cashier!=null)
			cashiers.put(cashier.getNumber(),cashier);
			
	}

	/**
	 * removeCashier removes cashier.
	 * @param cashier cashier represents a cashier in a store.
	 */
	public void removeCashier(Cashier cashier) {
		cashiers.remove(cashier.getNumber());
	}

	/**
	 * addSession adds a session
	 * @param session session represents the cashier's session in the store.
	 */
	public void addSession(Session session) {
		if(session!=null)
			sessions.add(session);
	}

	/**
	 * removeSession removes session.
	 * @param session session represents a session
	 */
	public void removeSession(Session session) {
	sessions.remove(session);
	}

	/**
	 * findItemForUPC finds an item with a given UPC.
	 * @param upc upc represents the item's UPC code.
	 * @return represents the found item.
	 */
	public Item findItemForUPC(String upc) 
	{

		
		 return items.get(upc);
		
	}
	/**
	 * finds and returns UPC
	 * @param upc
	 * @return UPC
	 */
   public UPC findUPC(String upc)
   {
	   return upcs.get(upc);
   }
	/**
	 * findItemForNumber find an item using its number
	 * @param number number represents the item's number.
	 * @return represents an item found.
	 */
	public Item findItemForNumber(String number)
	{
		
		 return items.get(number);
	}

	/**
	 * findCashierForNumber finds the cashier with a given number.
	 * @param number number represents cashier number.
	 * @return represents cashier in the store.
	 */
	public Cashier findCashierForNumber(String number) 
	{

		return cashiers.get(number);
		
	}
	/**
	 * prints all items
	 */
     public void itemsToString()
     {
    	 Set<String> keys= items.keySet();
 		Iterator<String> it=keys.iterator();
 		String key1;
 		
 		
 		while(it.hasNext())
 		{
 			key1 = it.next();
 			System.out.println(items.get(key1).toString());
 			
 		}
 		
 		
     }
     /**
      * prints all cashiers
      */
    public void cashiersToString()
    {
    	Set<String> keys= cashiers.keySet();
 		Iterator<String> it=keys.iterator();
 		String key1;
 		
 		
 		while(it.hasNext())
 		{
 			key1 = it.next();
 			System.out.println(cashiers.get(key1).toString());
 			
 		}
    }
    /**
     * Preints all registers
     */
    public void registersToString()
    {
    	Set<String> keys= registers.keySet();
 		Iterator<String> it=keys.iterator();
 		String key1;
 		
 		
 		while(it.hasNext())
 		{
 			key1 = it.next();
 			System.out.println(registers.get(key1).toString());
 			
 		}
    }
    /**
     * Prints all sessions
     */
    public void sessionsToString()
    {
    	
 		Iterator<Session> it=sessions.iterator();
 		Session session;
 		
 		int i=1;
 		while(it.hasNext())
 		{
 			session = it.next();
 			System.out.println("Session #"+i);
 			System.out.println(session.toString());
 			i++;
 		}
    }
	/**
	 * 
	 * @return registers
	 */
    public TreeMap<String,Register> getRegisters()
    {
    	return registers;
    }
    /**
	 * toString represents the string representation of object's attributes.
	 * @return represents the string representation of object's attributes.
	 */
	public String toString() {
		if(name!=null&&number!=null)
			System.out.println(name+" "+number);
		/*if(!items.isEmpty())
			//itemsToString();
		if(!cashiers.isEmpty())
			cashiersToString();
		if(!registers.isEmpty())
			registersToString();*/
		if(!sessions.isEmpty())
			sessionsToString();
		return "\n";
	}
	/**
	 * checks if the UPC exists
	 * @param upc
	 * @return
	 */
	public boolean upcFound(String upc)
	{
		boolean isFound=false;
		for(UPC uPC:upcs.values())
		{
			if(uPC.getUPC().equals(upc))
				isFound=true;
		}
		return isFound;	
	}

	/**
	 * addTaxCategory adds a tax category.
	 * @param taxCategory taxCategory represents the tax category.
	 */
	public void addTaxCategory(TaxCategory taxCategory) {
		taxCategories.put(taxCategory.getCategory(), taxCategory);
	}
	/**
	 * finds and returns a tax category
	 * @param taxCat
	 * @return taxCtegory
	 */
	public TaxCategory findTaxCategory(String taxCat)
	{
		return taxCategories.get(taxCat);
	}
	/**
	 * finds and returns a register
	 * @param number
	 * @return
	 */
    public Register findRegister(String number)
    {
    	return registers.get(number);
    }
	/**
	 * removeTaxCategory removes a tax category.
	 * @param taxCategory taxCategory represents the tax category.
	 */
	public void removeTaxCategory(TaxCategory taxCategory) {
		taxCategories.remove(taxCategory.getCategory());
	}

}
