package com.pl.monszy;

import com.pl.monszy.Wyjatek;	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;


public class Product {
	private static Logger logger = Logger.getLogger(Main.class);
	
public String name;
public String information;
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

String choiceString;
 String a = null;
 String b = null;
 String fa = null;
int f = 0;
int choice;

public Product(String name, String information){
	PropertyConfigurator.configure("Log4J.properties");
this.name=name;
this.information=information;
}
public Product(String name, String information, ArrayList<Person> Persons)
{
this.name=name;
this.information=information;
this.Persons=Persons;
}
public void printProduct()
{
System.out.println("name: "+name+"\t information: "+information);
}
 

public List<Person> Persons= new ArrayList<Person>();
public void printPersons(){
for(Person g : this.Persons)
{
g.printPerson();
}
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getInformation() {
	
	
	return information;
}
public void setInformation(String information) {
	this.information = information;
}
public List<Person> getPersons() {
	return Persons;
}
public void setPersons(List<Person> persons) {
	Persons = persons;
}
public static void showlistproducts(ArrayList<Product> products){
	Person o= new Person("Jan","Nowak",products);
	o.printProducts(); 
	logger.info("wy�wietli�e� produkty");
}
public static void addProduct(ArrayList<Product> products) throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	logger.info("dodales produkt");
	String a = null;
	String b = null;
	
	System.out.print("Podaj nazw�: ");a = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produkt�w
	products.add(new Product(a,b));
	}
	public static void editlistproducts(ArrayList<Product> products, int fc) throws IOException{
		PropertyConfigurator.configure("Log4J.properties");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		String a = null;
		String b = null;
		String c = null;
		int f = 0;
		
		
		for (int i = 1; i <= fc; i++ ){
			System.out.println("Podaj element ktory chcesz edytowac na liscie productow: ");
			a = in.readLine();
	
	f = products.indexOf(searchProduct(products, a));
	System.out.print("Podaj nazw�: ");c = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produkt�w
	try {
		
		products.set(f,new Product(c,b));
	  } catch (ArrayIndexOutOfBoundsException e) {
		  
		  System.out.println("Niepoprawny parametr, rozmiar tablicy to: "+ products.size());
		  logger.error("Za duzy index list "+ a +" gdzie lista ma rozmiar"+ products.size());
	  }
}
	
		
	logger.info("zedytowales liste produktow");
	}
	public static void showsize(ArrayList<Person> Persons, ArrayList<Product> products) {
		System.out.println("Size the list of products: "+products.size());
		System.out.println("Size the list of persons: "+Persons.size());
		}
		
	
	
		
		public static Object searchPerson(ArrayList<Person> Persons, String a) throws IOException {
			
			
			
		             int pozycja = 0;
		
		             for(Person g : Persons) {
		                     if (g.getImie().contains(a)) {
		                             System.out.println("Osoba o imieniu: " + g.getImie() + " znajduje si� na pozycji " + pozycja + ". Na li�cie Os�b" ); g.printPerson();
		                             return g;
		                     }
		                     else if (g.getNazwisko().contains(a)) {
		                    	 System.out.println("Osoba o nazwisku: " + g.getNazwisko() + " znajduje si� na pozycji " + pozycja + ". Na li�cie Os�b"); g.printPerson();
		                    	 return g;
		                     }
		                     
		                     pozycja++;
		             }
		             return null;
		}  
		             public static Object searchProduct(ArrayList<Product> products, String a) throws IOException {
		             int pozycja = 0;
		             for(Product c : products) {
		            	 if (c.getName().contains(a)) {
		                     System.out.println("Produkt o Nazwie: " + c.getName() + " znajduje si� na pozycji " + pozycja + ". Na li�cie Produkt�w" ); c.printProduct(); 
		                     return c;
		             }
		             else if (c.getInformation().contains(a)) {
		            	 System.out.println("Produkt gdzie w opisie zawarte jest s�owo: " + c.getInformation() + " znajduje si� na pozycji " + pozycja + ". Na li�cie Produkt�w" ); c.printProduct();
		            	 return c;
		             }
		             
		             pozycja++;
		             }
		             return null;
		             }    
		             
		
		public static void deletePerson(ArrayList<Person> Persons, String a) throws IOException{
					            		           
		                     Persons.remove(searchPerson(Persons, a));
		                     		                    
		                
		             }
		public static void deleteProduct(ArrayList<Product> products, String a) throws IOException{
	           
            products.remove(searchProduct(products, a));
            		                    
       
    }
		}
