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
	System.out.println("Size the list of person: "+Persons.size());
	}
	public void showmenu(){
		System.out.println("\n---------- Menu------------");
		System.out.println("1. Wyswietl wielkosc list");
		System.out.println("2. Wyswietlenie listy osob");
		System.out.println("3. Wyswietlenie listy produktów");
		System.out.println("4. dodanie elementów do listy osob");
		System.out.println("5. dodanie elementów do listy produktów");
		System.out.println("6. edycja elementu na liscie produktow");
		System.out.println("7. edycja elementu na liscie osób");
		System.out.println("8. Wyszukiwanie elementu w listach");
		System.out.println("9. usuniêciê wiersza zawieraj¹cego podany element");
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

		System.out.print("Podaj imiê: ");a = in.readLine(); 
		System.out.print("Podaj nazwisko: ");b = in.readLine();
		//dodanie elementów do listy osób
		Persons.add(new Person(a,b));
	}
	public void addProduct(ArrayList<Product> products) throws IOException{
	System.out.print("Podaj nazwê: ");a = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produktów
	products.add(new Product(a,b));
	}
	public void editlistproducts(ArrayList<Product> products) throws IOException{
	System.out.println("Podaj nr elementu który chesz edytowac: "); fa = in.readLine();
	f = Integer.parseInt(fa);
	System.out.print("Podaj nazwê: ");a = in.readLine(); 
	System.out.print("Podaj opis: ");b = in.readLine();
	// dodanie elementu do listy produktów
	products.set(f,new Product(a,b));
	}
	public void editlistpersons(ArrayList<Person> Persons) throws IOException{
		System.out.println("Podaj nr elementu który chesz edytowac: "); fa = in.readLine();
		f = Integer.parseInt(fa);
		System.out.print("Podaj imie: ");a = in.readLine(); 
		System.out.print("Podaj nazwisko: ");b = in.readLine();
		// dodanie elementu do listy produktów
		Persons.set(f,new Person(a,b));
	}
	public void search(ArrayList<Person> Persons, ArrayList<Product> products) throws IOException {
		System.out.println("Podaj wyszukiwany element: ");
		a = in.readLine();
	             int pozycja = 0;
	             for(Person g : Persons) {
	                     if (g.getImie().contains(a)) {
	                             System.out.println("Osoba o imieniu: " + g.getImie() + " znajduje siê na pozycji " + pozycja + ". Na liœcie Osób" ); g.printPerson(); 
	                     }
	                     else if (g.getNazwisko().contains(a)) {
	                    	 System.out.println("Osoba o nazwisku: " + g.getNazwisko() + " znajduje siê na pozycji " + pozycja + ". Na liœcie Osób"); g.printPerson();
	                     }
	                     
	                     pozycja++;
	             }
	             pozycja = 0;
	             for(Product c : products) {
	            	 if (c.getName().contains(a)) {
	                     System.out.println("Produkt o Nazwie: " + c.getName() + " znajduje siê na pozycji " + pozycja + ". Na liœcie Produktów" ); c.printProduct(); 
	             }
	             else if (c.getInformation().contains(a)) {
	            	 System.out.println("Produkt gdzie w opisie zawarte jest s³owo: " + c.getInformation() + " znajduje siê na pozycji " + pozycja + ". Na liœcie Produktów" ); c.printProduct();
	             }
	             
	             pozycja++;
	             }
	             
	    /* 
		System.out.println("Podaj pierwzy cz³on listy(imie lub nazwe): "); 
		a = in.readLine();
		System.out.println("Podaj drugi cz³on listy(nazwisko lub opis): ");
		b = in.readLine();
		int firstOccurence = Persons.indexOf(new Person(a,b));
		if(firstOccurence != -1){
		  System.out.println("Element znajduje sie na liscie productów, znaleziono na pozycji " + firstOccurence); break;}
		else{
			firstOccurence = products.indexOf(new Product(a,b));
			if(firstOccurence != -1){
				  System.out.println("Element znajduje sie na liscie osób, znaleziono na pozycji " + firstOccurence); break;}
			else{
		  System.out.println("Nie znaleziono"); break; }
		}*/
	}
	public void delete(ArrayList<Person> Persons, ArrayList<Product> products) throws IOException{
		System.out.println("Podaj element który chcesz usun¹æ: ");
		a = in.readLine();
	             int pozycja = 0;
	             for(Person g : Persons) {
	                     if (g.getImie().equals(a)) {
	                             System.out.println("Osoba o imieniu: " + g.getImie() + " znajdowa³a siê na pozycji: " + pozycja + ". Na liœcie Osób " ); g.printPerson(); Persons.remove(pozycja);
	                             System.out.println("Zosta³ on usuniêty!!"); break;
	                     }
	                     else if (g.getNazwisko().equals(a)) {
	                    	 System.out.println("Osoba o nazwisku: " + g.getNazwisko() + " znajdowa³a siê na pozycji: " + pozycja + ". Na liœcie Osób "); g.printPerson(); Persons.remove(pozycja);
	                    	 System.out.println("Zosta³ on usuniêty!!"); break;
	                     }
	                     
	                     pozycja++;
	             }
	             pozycja = 0;
	             for(Product c : products) {
	            	 if (c.getName().equals(a)) {
	                     System.out.println("Produkt o Nazwie: " + c.getName() + " znajdowa³ siê na pozycji " + pozycja + ". Na liœcie Produktów"); c.printProduct(); products.remove(pozycja);
	                     System.out.println("Zosta³ on usuniêty!!"); break;
	             }
	             
	             
	             pozycja++;
	             }
	}
}
