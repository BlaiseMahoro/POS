package POSDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import POSPD.*;

public class LoadStore {
	
	public static void load(Store store)
	{
		
		String fileName ="StoreData_v2018.csv";
		String line = null;
		Sale currentSale= new Sale();
		Session currentSession=new Session();
		SaleLineItem currentSli=new SaleLineItem();
	    try 
	    {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	
	          String token[]=line.split(",");
	         
	        
	          if(token[0].equals("Store"))
	          {
	        	 
	           	  store.setName(token[1]);
	           	  //System.out.println(sto);
	          }
	          if(token[0].equals("TaxCategory"))
	          {
	        	  TaxCategory taxCat = new TaxCategory(token[1]);
	        	  taxCat.addTaxRate(new TaxRate(LocalDate.parse(token[3], DateTimeFormatter.ofPattern("M/d/yy")),new BigDecimal(token[2])));
	        	  store.addTaxCategory(taxCat);
	        	  
	          }
	          if(token[0].equals("Cashier"))
	          {
	        	 
	        	  Person person =new Person(token[2],token[4],token[8],token[3],token[5],token[6],token[7]);
	        	  Cashier cashier= new Cashier(token[1],person,token[9]);
	        	  store.addCashier(cashier);
	          }
	          if(token[0].equals("Item"))
	          {
	        	  UPC upc = new UPC(token[2]);
	        	  Item item=new Item(token[1],token[3],store.findTaxCategory(token[4]));
	        	  item.addUPC(upc);
	        	  upc.setItem(item);
	        	  item.addPrice(new Price(token[5],token[6]));
	        	  
	        	  if(token.length > 7)
	        	  {
	        		  item.addPrice(new PromoPrice(token[7],token[8],token[9]));
	        	  }
	        	  store.addUPC(upc);
	        	  store.addItem(item);
	        	  
	          }
	          if(token[0].equals("Register"))
	          {
	        	  store.addRegister(new Register(token[1]));
	          }
	          if(token[0].equals("Session"))
	          {
	        	  Session session= new Session(store.findCashierForNumber(token[1]),store.findRegister(token[2]));
	        	  store.findCashierForNumber(token[1]).addSession(session);
	        	  currentSession = session;
	        	  store.addSession(currentSession);
	        	  
	        	  
	          }
	          if(token[0].equals("Sale"))
	          {
	        	 
	        	 Sale sale= new Sale(token[1]);
	        	 currentSale = sale;
	        	 currentSession.addSale(currentSale);
	        	 
	          
	        }    
	        if(token[0].equals("SaleLineItem"))
	        {
	        	
	        	  currentSale.addSaleLineItem(new SaleLineItem(currentSale,store.findItemForNumber(token[1]),token[2]));
	        	  currentSli=new SaleLineItem(currentSale,store.findItemForNumber(token[1]),token[2]);
	        	  store.findItemForNumber(token[1]).addSli(currentSli);
	        }
	        if(token[0].equals("Payment"))
	        {
	        	if(token[1].equals("Credit"))
	        	{
	        	  Credit card = new Credit(token[4],token[5],token[6],token[2],token[3]);
	              currentSale.addPayment(card);
	        	  
	        	}
	        	if(token[1].equals("Cash"))
	        	{
	        		Cash cash= new Cash(new BigDecimal(token[2]),new BigDecimal(token[3]));
	        		 
		        	currentSale.addPayment(cash);
	        	}
	        	if(token[1].equals("Check"))
	        	{
	        		Check check =new Check(token[2],token[3],token[5],token[4],token[6]);
	        	
		        	currentSale.addPayment(check);
	        	}
	        }
	        
	       }
	    	
	        
	      // Always close files.
	      bufferedReader.close(); 
	     
	    }
	    
	    catch(FileNotFoundException ex) 
	    {
	      System.out.println( "Unable to open file '" +  fileName + "'");                
	    }
	    catch(IOException ex) 
	    {
	       System.out.println (  "Error reading file '" + fileName + "'");   	
	     }
	   
       
	       

	   // return store;

	}
}
