package com.pl.monszy;



import java.io.*;
import java.util.*;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import com.pl.monszy.Wyjatek;	


public class Main {
	private static Logger logger = Logger.getLogger(Main.class);
	
	

	public static void main(String[] args) throws IOException
{
		PropertyConfigurator.configure("Log4J.properties");
	
	//tworzenie biektu do odczytania z consoli (bufferedReader)
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 
	String choiceString;
	int choice;
	String a = null;
	String fb = null;
	int fc = 0;
	
	
	ArrayList<Product> products= new ArrayList<Product>();
	products.add(new Product("Film","best film ever"));
	products.add(new Product("Koadak","some best film"));
	products.add(new Product("Fuji","p"));

	ArrayList<Person> Persons= new ArrayList<Person>();
	Persons.add(new Person("Jan","Nowak"));
	Persons.add(new Person("Gabrys","Szmel"));


do
{
	pouse.Sec(4);
//wy�wietlenie menu

	System.out.println("\n---------- Menu------------");
	System.out.println("1. Wyswietl wielkosc list");
	System.out.println("2. Wyswietlenie listy osob");
	System.out.println("3. Wyswietlenie listy produkt�w");
	System.out.println("4. dodanie element�w do listy osob");
	System.out.println("5. dodanie element�w do listy produkt�w");
	System.out.println("6. edycja elementu na liscie produktow");
	System.out.println("7. edycja elementu na liscie os�b");
	System.out.println("8. Wyszukiwanie elementu w listach");
	System.out.println("9. usuni�ci� wiersza zawieraj�cego podany element");
	System.out.println("10. Quit");
	System.out.println("Co wybierasz? : ");
System.out.flush();
choiceString = in.readLine();


try
{
	choice = Integer.parseInt(choiceString);
	throw new Wyjatek("Int?");
	  
}
 catch(Exception e) 
   { 

	logger.error("Wyj�tek, musisz podac inta a nie...: "+e.getMessage());
}	
choice = Integer.parseInt(choiceString);
switch (choice)
{
 

case 1:
	// wy�wietlenie wielko�ci list
	Product.showsize(Persons, products); break;
case 2:
	// wy�wietlenie listy Os�b
	Person.showlistperson(Persons);
	break;
case 3:
	// wy�wietlenie listy produkt�w
	Product.showlistproducts(products);
	break;
case 4:
	Person.addPerson(Persons);
	break;
case 5:
	Product.addProduct(products);
	break;
case 6:
	
	System.out.println("Ile produktow chcesz edytowac?: "); fb = in.readLine();
	fc = Integer.parseInt(fb);
	Product.editlistproducts(products, fc);
	break;
case 7:
	Person.editlistpersons(Persons);
	break;
case 8:

	
	System.out.println("Podaj wyszukiwany element: ");
	a = in.readLine();
	Product.searchPerson(Persons, a);
	break;
case 9:

	
	System.out.println("Podaj element ktory chcesz usunac z : ");
	a = in.readLine();
	Product.deletePerson(Persons, a);
             break;
	
case 10: //exit
System.exit(0);
 
default:
System.out.println("\nProsze wybrac z menu (1-10) \n");}
}
while(choice!= 10);
}
	 
}

