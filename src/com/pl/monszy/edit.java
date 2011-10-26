package com.pl.monszy;


import java.io.*;
import java.util.*;

public class edit  {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 
	String choiceString;
	String a = null;
	String b = null;
	String fa = null;
	int f = 0;
	int choice;
	
	
	
	public void showsize(ArrayList<Person> Persons, ArrayList<Product> products) {
	System.out.println("Size the list of products: "+products.size());
	System.out.println("Size the list of persons: "+Persons.size());
	}
	public void showmenu(){
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
	}
	public void showlistperson(ArrayList<Person> Persons){
		Product d= new Product("Film","best film ever", Persons);
		d.printPersons(); 
	}
	public void showlistproducts(ArrayList<Product> products){
		Person o= new Person("Jan","Nowak",products);
		o.printProducts(); 
	}
	public void addPerson(ArrayList<Person> Persons) throws IOException{

		System.out.print("Podaj imi�: ");a = in.readLine(); 
		System.out.print("Podaj nazwisko: ");b = in.readLine();
		//dodanie element�w do listy os�b
		Persons.add(new Person(a,b));
	}
	public void addProduct(ArrayList<Product> products) throws IOException{
	System.out.print("Podaj nazw�: ");a = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produkt�w
	products.add(new Product(a,b));
	}
	public void editlistproducts(ArrayList<Product> products) throws IOException{
	System.out.println("Podaj nr elementu kt�ry chesz edytowac: "); fa = in.readLine();
	f = Integer.parseInt(fa);
	System.out.print("Podaj nazw�: ");a = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produkt�w
	products.set(f,new Product(a,b));
	}
	public void editlistpersons(ArrayList<Person> Persons) throws IOException{
		System.out.println("Podaj nr elementu kt�ry chesz edytowac: "); fa = in.readLine();
		f = Integer.parseInt(fa);
		System.out.print("Podaj imie: ");a = in.readLine(); 
		System.out.print("Podaj nazwisko: ");b = in.readLine();
		// dodanie elementu do listy produkt�w
		Persons.set(f,new Person(a,b));
	}
	public void search(ArrayList<Person> Persons, ArrayList<Product> products) throws IOException {
		System.out.println("Podaj wyszukiwany element: ");
		a = in.readLine();
	             int pozycja = 0;
	             for(Person g : Persons) {
	                     if (g.getImie().contains(a)) {
	                             System.out.println("Osoba o imieniu: " + g.getImie() + " znajduje si� na pozycji " + pozycja + ". Na li�cie Os�b" ); g.printPerson(); 
	                     }
	                     else if (g.getNazwisko().contains(a)) {
	                    	 System.out.println("Osoba o nazwisku: " + g.getNazwisko() + " znajduje si� na pozycji " + pozycja + ". Na li�cie Os�b"); g.printPerson();
	                     }
	                     
	                     pozycja++;
	             }
	             pozycja = 0;
	             for(Product c : products) {
	            	 if (c.getName().contains(a)) {
	                     System.out.println("Produkt o Nazwie: " + c.getName() + " znajduje si� na pozycji " + pozycja + ". Na li�cie Produkt�w" ); c.printProduct(); 
	             }
	             else if (c.getInformation().contains(a)) {
	            	 System.out.println("Produkt gdzie w opisie zawarte jest s�owo: " + c.getInformation() + " znajduje si� na pozycji " + pozycja + ". Na li�cie Produkt�w" ); c.printProduct();
	             }
	             
	             pozycja++;
	             }
	             
	   
	}
	public void delete(ArrayList<Person> Persons, ArrayList<Product> products) throws IOException{
		System.out.println("Podaj element kt�ry chcesz usun��: ");
		a = in.readLine();
	             int pozycja = 0;
	             for(Person g : Persons) {
	                     if (g.getImie().equals(a)) {
	                             System.out.println("Osoba o imieniu: " + g.getImie() + " znajdowa�a si� na pozycji: " + pozycja + ". Na li�cie Os�b " ); g.printPerson(); Persons.remove(pozycja);
	                             System.out.println("Zosta� on usuni�ty!!"); break;
	                     }
	                     else if (g.getNazwisko().equals(a)) {
	                    	 System.out.println("Osoba o nazwisku: " + g.getNazwisko() + " znajdowa�a si� na pozycji: " + pozycja + ". Na li�cie Os�b "); g.printPerson(); Persons.remove(pozycja);
	                    	 System.out.println("Zosta� on usuni�ty!!"); break;
	                     }
	                     
	                     pozycja++;
	             }
	             pozycja = 0;
	             for(Product c : products) {
	            	 if (c.getName().equals(a)) {
	                     System.out.println("Produkt o Nazwie: " + c.getName() + " znajdowa� si� na pozycji " + pozycja + ". Na li�cie Produkt�w"); c.printProduct(); products.remove(pozycja);
	                     System.out.println("Zosta� on usuni�ty!!"); break;
	             }
	             
	             
	             pozycja++;
	             }
	}
}
