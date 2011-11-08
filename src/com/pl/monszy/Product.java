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
	logger.info("wyœwietli³eœ produkty");
}
public static void addProduct(ArrayList<Product> products) throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	logger.info("dodales produkt");
	String a = null;
	String b = null;
	
	System.out.print("Podaj nazwï¿½: ");a = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produktï¿½w
	products.add(new Product(a,b));
	}
	public static void editlistproducts(ArrayList<Product> products) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		logger.info("zedytowales liste produktow");
		
		String a = null;
		String b = null;
		String fa = null;
		int f = 0;
		
	System.out.println("Podaj nr elementu ktï¿½ry chesz edytowac: "); fa = in.readLine();
	f = Integer.parseInt(fa);
	System.out.print("Podaj nazwï¿½: ");a = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produktï¿½w
	products.set(f,new Product(a,b));
	}
	public static void showsize(ArrayList<Person> Persons, ArrayList<Product> products) {
		System.out.println("Size the list of products: "+products.size());
		System.out.println("Size the list of persons: "+Persons.size());
		}
		
	
	
		
		public static int search(ArrayList<Person> Persons, ArrayList<Product> products) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			String a = null;
			
			System.out.println("Podaj wyszukiwany element: ");
			a = in.readLine();
		             int pozycja = 0;
		
		             for(Person g : Persons) {
		                     if (g.getImie().contains(a)) {
		                             System.out.println("Osoba o imieniu: " + g.getImie() + " znajduje siï¿½ na pozycji " + pozycja + ". Na liï¿½cie Osï¿½b" ); g.printPerson(); 
		                     }
		                     else if (g.getNazwisko().contains(a)) {
		                    	 System.out.println("Osoba o nazwisku: " + g.getNazwisko() + " znajduje siï¿½ na pozycji " + pozycja + ". Na liï¿½cie Osï¿½b"); g.printPerson();
		                     }
		                     
		                     pozycja++;
		             }
		             pozycja = 0;
		             for(Product c : products) {
		            	 if (c.getName().contains(a)) {
		                     System.out.println("Produkt o Nazwie: " + c.getName() + " znajduje siï¿½ na pozycji " + pozycja + ". Na liï¿½cie Produktï¿½w" ); c.printProduct(); 
		             }
		             else if (c.getInformation().contains(a)) {
		            	 System.out.println("Produkt gdzie w opisie zawarte jest sï¿½owo: " + c.getInformation() + " znajduje siï¿½ na pozycji " + pozycja + ". Na liï¿½cie Produktï¿½w" ); c.printProduct();
		             }
		             
		             pozycja++;
		             }
		           return pozycja;
		   
		}
		public static void delete(ArrayList<Person> Persons, ArrayList<Product> products) throws IOException{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			
			String a = null;
			
		
			System.out.println("Podaj element ktory chcesz usunac: ");
			try
			{
				a = in.readLine(); 
				if(a == null) 
				    throw new IOException("Musisz podac element jaki chcesz usunac"); 
			}
			 catch(Wyjatek e) 
			   { 
				logger.info(e.getMessage());
			}
			
		             int pozycja = 0;
		             for(Person g : Persons) {
		                     if (g.getImie().equals(a)) {
		                             System.out.println("Osoba o imieniu: " + g.getImie() + " znajdowaï¿½a siï¿½ na pozycji: " + pozycja + ". Na liï¿½cie Osï¿½b " ); g.printPerson(); Persons.remove(pozycja);
		                             System.out.println("Zostaï¿½ on usuniï¿½ty!!"); break;
		                     }
		                     else if (g.getNazwisko().equals(a)) {
		                    	 System.out.println("Osoba o nazwisku: " + g.getNazwisko() + " znajdowaï¿½a siï¿½ na pozycji: " + pozycja + ". Na liï¿½cie Osï¿½b "); g.printPerson(); Persons.remove(pozycja);
		                    	 System.out.println("Zostaï¿½ on usuniï¿½ty!!"); break;
		                     }
		                     
		                     pozycja++;
		             }
		             pozycja = 0;
		             for(Product c : products) {
		            	 if (c.getName().equals(a)) {
		                     System.out.println("Produkt o Nazwie: " + c.getName() + " znajdowaï¿½ siï¿½ na pozycji " + pozycja + ". Na liï¿½cie Produktï¿½w"); c.printProduct(); products.remove(pozycja);
		                     System.out.println("Zostaï¿½ on usuniï¿½ty!!"); break;
		             }
		             
		             
		             pozycja++;
		             }
		}
}