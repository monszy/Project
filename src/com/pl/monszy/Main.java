package com.pl.monszy;

import java.io.*;
import java.util.*;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import com.pl.monszy.PriceException;
import events.*;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws IOException, PriceException {
		PropertyConfigurator.configure("Log4J.properties");

		// tworzenie biektu do odczytania z consoli (bufferedReader)
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String choiceString;
		int choice;
		String a = null;
		String fb = null;
		int fc = 0;
		ArrayList<Product> AryProducts = new ArrayList<Product>();
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			products.add(new Product("Kojiak", "best film ever",
					ProductType.Film, 10));
			products.add(new Product("Koadak", "some best film",
					ProductType.Camera, 40));
			products.add(new Product("Alpina", "best camera in the world",
					ProductType.Camera, 120));
		} catch (PriceException exception) {
			logger.error(exception);
		}
        
		ArrayList<Person> Persons = new ArrayList<Person>();
		Persons.add(new Person("Jan", "Nowak", products));
		Persons.add(new Person("Gabrys", "Szmel", products));

		IProductProcesses backupProduct = new BackupProduct();
		ProcesProduct procesProduct = new ProcesProduct();
		IProductProcesses discountProduct = new DiscountProduct();
		IProductProcesses changeProductPrice = new ChangeProductPrice();

		System.out.println("Product processes Film type");
		Product.equalProduct(products, "Kojiak").get(0).setDiscount(false);
		System.out.println("Kojiak set Discount before - "
				+ Product.equalProduct(products, "Kojiak").get(0).isDiscount());
		System.out.println("Kojiak Product Price before - "
				+ Product.equalProduct(products, "Kojiak").get(0)
						.getProductPrice());
		System.out.println("Kojiak Backup Product before - "
				+ Product.equalProduct(products, "Kojiak").get(0).isBackup());

		procesProduct.addProcess(discountProduct);
		procesProduct.addProcess(changeProductPrice);
		procesProduct.addProcess(backupProduct);
		procesProduct.executeProcesses(Product.equalProduct(products,
				"Kojiak"));
		System.out.println("Kojiak Discount after - "
				+ Product.equalProduct(products, "Kojiak").get(0).isDiscount());
		System.out.println("Kojiak Product Price after - "
				+ Product.equalProduct(products, "Kojiak").get(0)
						.getProductPrice());
		System.out.println("Kojiak Backup Product after - "
				+ Product.equalProduct(products, "Kojiak").get(0).isBackup());

		do {
			pouse.Sec(4);
			// wyswietlenie menu

			System.out.println("\n---------- Menu------------");
			System.out.println("1. Wyswietl wielkosc list");
			System.out.println("2. Wyszukiwanie elementow w listach");
			System.out.println("3. Wyswietlenie listy produktow");
			System.out.println("4. dodanie elementow do listy osob");
			System.out.println("5. dodanie elementow do listy produktow");
			System.out.println("6. edycja elementow na liscie produktow");
			System.out.println("7. edycja elementow na liscie osob");			
			System.out
					.println("8. usuniecie wiersza zawierajacego podany element");
			System.out.println("10. Quit");
			System.out.println("Co wybierasz? : ");
			System.out.flush();
			choiceString = in.readLine();

			choice = Integer.parseInt(choiceString);
			switch (choice) {

			case 1:
				// wy�wietlenie wielko�ci list
				Product.showsize(Persons, products);
				break;
			case 2:
				System.out.println("Podaj wyszukiwany element: ");
				a = in.readLine();
				System.out
						.println("Na ktorej z list chcesz go wyszukiwac? \n1. Lista Produktow \n2. Lista osob: ");
				fb = in.readLine();
				fc = Integer.parseInt(fb);
				if (fc == 1) {
					Product.searchProduct(products, a);
				} else {
					Person.searchPerson(Persons, a);
				}
				
				break;
			case 3:
				// wy�wietlenie listy produkt�w
				Product.showlistproducts(products);
				Person.showlistPerson(Persons);
				break;
			case 4:
				Person.addPerson(Persons);
				break;
			case 5:
				Product.addProduct(products, AryProducts);
				break;
			case 6:

				System.out.println("Ile produktow chcesz edytowac?: ");
				fb = in.readLine();
				fc = Integer.parseInt(fb);
				Product.editlistproducts(products, fc);
				break;
			case 7:

				System.out.println("Ile osob chcesz edytowac?: ");
				fb = in.readLine();
				fc = Integer.parseInt(fb);
				Person.editlistPersons(Persons, fc);
				break;
			
			case 8:

				System.out
						.println("Z ktorej z list chcesz usunac? \n1. Lista produktow \n2. Lista osob: ");
				fb = in.readLine();
				fc = Integer.parseInt(fb);
				if (fc == 1) {
					System.out
							.println("Podaj element ktory chcesz usunac z listy produktow: ");
					a = in.readLine();
					Product.deleteProduct(products, a);
					
				} else {
					System.out
							.println("Podaj element ktory chcesz usunac z listy osob: ");
					a = in.readLine();
					Person.deletePerson(Persons, a);

				}

				break;
			
			
			case 10: // exit
				System.exit(0);

			default:
				System.out.println("\nProsze wybrac z menu (1-10) \n");
			}
		} while (choice != 10);
	}

}
