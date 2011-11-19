package com.pl.monszy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;



public class Person {
	private static Logger logger = Logger.getLogger(Main.class);
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	String choiceString;
	String a = null;
	String b = null;
	String fa = null;
	int f = 0;
	int choice;
	public String imie;
	public String nazwisko;

	public Person(String imie, String nazwisko) {
		PropertyConfigurator.configure("Log4J.properties");
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	

	public Person(String imie, String nazwisko, ArrayList<Product> products) {
		PropertyConfigurator.configure("Log4J.properties");
		this.imie = imie;
		this.nazwisko = nazwisko;
		Person.products = products;
	}

	public void printPerson() {
		System.out.println("imie: " + imie + "\t nazwisko: " + nazwisko + "\t produkty: " + products);
	}

	
	
	
	
	public static ArrayList<Product> products = new ArrayList<Product>();
	public void printProducts() {
		int pozycja = 1;
		for (Product c : Person.products)

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
		Person.products = products;
	}

	public static void addPerson(ArrayList<Person> Persons) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//ArrayList<Product> Produkciki;
		String a = null;
		String b = null;

		System.out.print("Podaj imie: ");
		a = in.readLine();
		System.out.print("Podaj nazwisko: ");
		b = in.readLine();
	//	Product.showlistproducts(products);
		
		// dodanie element�w do listy os�b
		Persons.add(new Person(a, b));
	}
	
		
	

	public static void editlistPersons(ArrayList<Person> Persons, int fc)
			throws IOException {
		PropertyConfigurator.configure("Log4J.properties");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String a = null;
		String b = null;
		String c = null;
		int f = 0;

		for (int i = 1; i <= fc; i++) {
			System.out
					.println("Podaj element ktory chcesz edytowac na liscie osob: ");
			a = in.readLine();
			if ((equalPerson(Persons, a)) == null)
				System.out.println("nie ma takiej osoby na liscie");
			else {

				f = Persons.indexOf(searchPerson(Persons, a));

				System.out.print("Podaj imie: ");
				c = in.readLine();
				System.out.print("Podaj nazwisko: ");
				b = in.readLine();

				try {

					Persons.set(f, new Person(c, b));
				} catch (ArrayIndexOutOfBoundsException e) {

					System.out
							.println("Niepoprawny parametr, rozmiar listy to: "
									+ Persons.size());
					logger.error("Za duzy index list " + a
							+ " gdzie lista ma rozmiar" + Persons.size());
				}
			}

			logger.info("zedytowales liste osob");
		}
	}

	public static List<Person> searchPerson(ArrayList<Person> Persons, String a)
			throws IOException {
		int pozycja = 0;
		List<Person> results = new ArrayList<Person>();
		for (Person c : Persons) {
			if (c.getImie().contains(a)) {
				System.out.println("Osoba o imieniu: " + c.getImie()
						+ " znajduje sie na pozycji " + pozycja
						+ ". Na liscie osob");
				c.printPerson();
				results.add(c);
				return results;
			} else if (c.getNazwisko().contains(a)) {
				System.out.println("Osoba o nazwisku: " + c.getNazwisko()
						+ " znajduje sie na pozycji " + pozycja
						+ ". Na liscie Osob");
				c.printPerson();
				results.add(c);
				return results;
			}

			pozycja++;
		}
		return null;
	}

	public static List<Person> equalPerson(ArrayList<Person> Persons, String a)
			throws IOException {
		List<Person> results = new ArrayList<Person>();
		for (Person c : Persons) {
			if (c.getImie().contains(a)) {

				results.add(c);
				return results;
			} else if (c.getNazwisko().contains(a)) {

				results.add(c);
				return results;
			}
		}
		return null;
	}

	public static void deletePerson(ArrayList<Person> Persons, String a)
			throws IOException {
		int f = Persons.indexOf(searchPerson(Persons, a))+1;
		Persons.remove(f);

	}
}
