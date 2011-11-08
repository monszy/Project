package com.pl.monszy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

 
public class Person {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 
	String choiceString;
	String a = null;
	String b = null;
	String fa = null;
	int f = 0;
	int choice;
public String imie;
public String nazwisko;
public Person(String imie, String nazwisko)
{
this.imie=imie;
this.nazwisko=nazwisko;
}
public Person(String imie, String nazwisko, ArrayList<Product> products)
{
this.imie=imie;
this.nazwisko=nazwisko;
this.products=products;
}
public void printPerson()
{
System.out.println("imie: "+imie+"\t nazwisko: "+nazwisko);
}
public ArrayList<Product> products= new ArrayList<Product>();
public void printProducts(){
int	pozycja = 1;
for(Product c : this.products)

{
System.out.print(pozycja + " ");
c.printProduct();
pozycja++;
}
}
public String getImie() {
	return imie;
}
public void setImie(String imie) {
	this.imie = imie;
}
public String getNazwisko() {
	return nazwisko;
}
public void setNazwisko(String nazwisko) {
	this.nazwisko = nazwisko;
}
public ArrayList<Product> getProducts() {
	return products;
}
public void setProducts(ArrayList<Product> products) {
	this.products = products;
}
public static void addPerson(ArrayList<Person> Persons) throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	String a = null;
	String b = null;
	
	System.out.print("Podaj imie: ");a = in.readLine(); 
	System.out.print("Podaj nazwisko: ");b = in.readLine();
	//dodanie element�w do listy os�b
	Persons.add(new Person(a,b));
}
public static void showlistperson(ArrayList<Person> Persons){
	Product d= new Product("Film","best film ever", Persons);
	d.printPersons(); 
}
public static void editlistpersons(ArrayList<Person> Persons) throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	String a = null;
	String b = null;
	String fa = null;
	int f = 0;
	int fc = 100;
	String fb = null;
	System.out.println("Ile osob chcesz edytowac?: "); fb = in.readLine();
	fc = Integer.parseInt(fb);
	for (int i = 0; i <= fc; i++ ){
	System.out.println("Podaj nr elementu kt�ry chesz edytowac: "); fa = in.readLine();
	f = Integer.parseInt(fa);
	System.out.print("Podaj imie: ");a = in.readLine(); 
	System.out.print("Podaj nazwisko: ");b = in.readLine();
	// dodanie elementu do listy produkt�w
	Persons.set(f,new Person(a,b));
}
}
}
