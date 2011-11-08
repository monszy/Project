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

	
	
	ArrayList<Product> products= new ArrayList<Product>();
	products.add(new Product("Film","best film ever"));
	products.add(new Product("Koadak","some best film"));
	products.add(new Product("Fuji","p"));

	ArrayList<Person> Persons= new ArrayList<Person>();
	Persons.add(new Person("Jan","Nowak"));
	Persons.add(new Person("Gabrys","Szmel"));


do
{
	pouse.Sec(6);
//wyï¿½wietlenie menu

	System.out.println("\n---------- Menu------------");
	System.out.println("1. Wyswietl wielkosc list");
	System.out.println("2. Wyswietlenie listy osob");
	System.out.println("3. Wyswietlenie listy produktï¿½w");
	System.out.println("4. dodanie elementï¿½w do listy osob");
	System.out.println("5. dodanie elementï¿½w do listy produktï¿½w");
	System.out.println("6. edycja elementu na liscie produktow");
	System.out.println("7. edycja elementu na liscie osï¿½b");
	System.out.println("8. Wyszukiwanie elementu w listach");
	System.out.println("9. usuniï¿½ciï¿½ wiersza zawierajï¿½cego podany element");
	System.out.println("10. Quit");
	System.out.println("Co wybierasz? : ");
System.out.flush();
choiceString = in.readLine();


try
{
	choice = Integer.parseInt(choiceString);
	
	  
}
 catch(Exception e) 
   { 

	logger.error("Wyj¹tek, musisz podac inta a nie...: "+e.getMessage());
}	
choice = Integer.parseInt(choiceString);
switch (choice)
{
 

case 1:
	// wyï¿½wietlenie wielkoï¿½ci list
	Product.showsize(Persons, products); break;
case 2:
	// wyï¿½wietlenie listy Osï¿½b
	Person.showlistperson(Persons);
	break;
case 3:
	// wyï¿½wietlenie listy produktï¿½w
	Product.showlistproducts(products);
	break;
case 4:
	Person.addPerson(Persons);
	break;
case 5:
	Product.addProduct(products);
	break;
case 6:
	Product.editlistproducts(products);
	break;
case 7:
	Person.editlistpersons(Persons);
	break;
case 8:
	Product.search(Persons, products);
	break;
case 9:
	Product.delete(Persons, products);
             break;
	
case 10: //exit
System.exit(0);
 
default:
System.out.println("\nProsze wybrac z menu (1-10) \n");}
}
while(choice!= 10);
}
	 
}

