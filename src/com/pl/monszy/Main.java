package com.pl.monszy;


import java.io.*;
import java.util.*;

public class Main {
	
	
	 public static void main(String[] args) throws IOException
{
	
	
	//tworzenie biektu do odczytania z consoli (bufferedReader)
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 
	String choiceString;
	String a = null;
	String b = null;
	String fa = null;
	int f = 0;
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
//print out a menu
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

//zamiana string na int
choice = Integer.parseInt(choiceString);
switch (choice)
{
 

case 1:
	// wy�wietlenie wielko�ci list
	System.out.println("Size the list of products: "+products.size());
	System.out.println("Size the list of person: "+Persons.size());
	break;
case 2:
	// wy�wietlenie listy Os�b
	Product d= new Product("Film","best film ever", Persons);
	d.printPersons(); 
	break;
case 3:
	// wy�wietlenie listy produkt�w
	Person o= new Person("Jan","Nowak",products);
	o.printProducts();
	break;
case 4:
	System.out.print("Podaj imi�: ");a = in.readLine(); 
	System.out.print("Podaj nazwisko: ");b = in.readLine();
	//dodanie element�w do listy os�b
	Persons.add(new Person(a,b));
	break;
case 5:
	System.out.print("Podaj nazw�: ");a = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produkt�w
	products.add(new Product(a,b));
	break;
case 6:
	System.out.println("Podaj nr elementu kt�ry chesz edytowac: "); fa = in.readLine();
	f = Integer.parseInt(fa);
	System.out.print("Podaj nazw�: ");a = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produkt�w
	products.set(f,new Product(a,b));
	break;
case 7:
	System.out.println("Podaj nr elementu kt�ry chesz edytowac: "); fa = in.readLine();
	f = Integer.parseInt(fa);
	System.out.print("Podaj imie: ");a = in.readLine(); 
	System.out.print("Podaj nazwisko: ");b = in.readLine();
	// dodanie elementu do listy produkt�w
	Persons.set(f,new Person(a,b));
	break;
case 8:
	System.out.println("Podaj wyszukiwany element: ");
	a = in.readLine();
             int pozycja = 0;
             for(Person g : Persons) {
                     if (g.getImie().contains(a)) {
                             System.out.println("Osoba o imieniu: " + g.getImie() + " znajduje si� na pozycji " + pozycja ); g.printPerson(); 
                     }
                     else if (g.getNazwisko().contains(a)) {
                    	 System.out.println("Osoba o nazwisku: " + g.getNazwisko() + " znajduje si� na pozycji " + pozycja ); g.printPerson();
                     }
                     
                     pozycja++;
             }
             pozycja = 0;
             for(Product c : products) {
            	 if (c.getName().contains(a)) {
                     System.out.println("Produkt o Nazwie: " + c.getName() + " znajduje si� na pozycji " + pozycja ); c.printProduct(); 
             }
             else if (c.getInformation().contains(a)) {
            	 System.out.println("Produkt gdzie w opisie zawarte jest s�owo: " + c.getInformation() + " znajduje si� na pozycji " + pozycja ); c.printProduct();
             }
             
             pozycja++;
             }
             break;
    /* 
	System.out.println("Podaj pierwzy cz�on listy(imie lub nazwe): "); 
	a = in.readLine();
	System.out.println("Podaj drugi cz�on listy(nazwisko lub opis): ");
	b = in.readLine();
	int firstOccurence = Persons.indexOf(new Person(a,b));
	if(firstOccurence != -1){
	  System.out.println("Element znajduje sie na liscie product�w, znaleziono na pozycji " + firstOccurence); break;}
	else{
		firstOccurence = products.indexOf(new Product(a,b));
		if(firstOccurence != -1){
			  System.out.println("Element znajduje sie na liscie os�b, znaleziono na pozycji " + firstOccurence); break;}
		else{
	  System.out.println("Nie znaleziono"); break; }
	}*/
case 9:
	
case 10: //exit
System.exit(0);
 
default:
System.out.println("\nProsze wybrac z menu (1-10) \n");}
}
while(choice!= 10);
}
}

