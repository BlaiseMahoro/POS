/**

 * 
 */
package POSTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import POSPD.*;
/**
 * @author Blaise Mahoro
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void ItemsTest(Store store) {
		
        //AC # 1
		System.out.println("===============================================");
		System.out.println("AC #1");
		System.out.println("Items");
		
        
        store.itemsToString();
        System.out.println("===============================================");
	}
	public static void cashiersTest(Store store1)
	{
		
		System.out.println("AC #2");
		System.out.println("Cashiers");
		
		store1.cashiersToString();
		 System.out.println("===============================================");
	}
	public static void registersTest(Store store)
	{
		
		System.out.println("AC #3");
		System.out.println("Registers");
		store.registersToString();;
		
		System.out.println("===============================================");
	}
	public static void storeTest(Store store)
	{
		System.out.println("AC #4");
		System.out.println("Sessions");
	    //System.out.println(session.calcTotal());
		System.out.print(store.toString());
	
		
	}

}
