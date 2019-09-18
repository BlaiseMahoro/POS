package POSHI;




import POSPD.*;
import POSTest.Test;
/**
 * starts the application
 * @author Blaise Mahoro
 *
 */
public class POSStart {

	public static void main(String[] args) {
		Store myStore= new Store();
		myStore.load();
		/*
		Test.ItemsTest(myStore);
		Test.cashiersTest(myStore);
		Test.registersTest(myStore);
		Test.storeTest(myStore);*/
		POSFrame.run(myStore);
	
		

	}

}
