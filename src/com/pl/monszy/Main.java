package com.pl.monszy;


import java.io.*;
import java.util.*;

public class Main {
	
	
	 public static void main(String[] args) throws IOException
{
	
	
	//tworzenie biektu do odczytania z consoli (bufferedReader)
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 
	String choiceString;
	int choice;

	edit mmo = new edit();
	
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
//wyœwietlenie menu
mmo.showmenu();
 
System.out.flush();
choiceString = in.readLine();

//zamiana string na int
choice = Integer.parseInt(choiceString);
switch (choice)
{
 

case 1:
	// wyœwietlenie wielkoœci list
	mmo.showsize(Persons, products); break;
case 2:
	// wyœwietlenie listy Osób
	mmo.showlistperson(Persons);
	break;
case 3:
	// wyœwietlenie listy produktów
	mmo.showlistproducts(products);
	break;
case 4:
	mmo.addPerson(Persons);
	break;
case 5:
	mmo.addProduct(products);
	break;
case 6:
	mmo.editlistproducts(products);
	break;
case 7:
	mmo.editlistpersons(Persons);
	break;
case 8:
	mmo.search(Persons, products);
	break;
case 9:
	mmo.delete(Persons, products);
             break;
	
case 10: //exit
System.exit(0);
 
default:
System.out.println("\nProsze wybrac z menu (1-10) \n");}
}
while(choice!= 10);
}
}

