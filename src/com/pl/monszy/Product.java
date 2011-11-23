package com.pl.monszy;

import com.pl.monszy.PriceException;
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
	public ProductType productType;
	public double Price;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	String choiceString;
	String a = null;
	String b = null;
	String fa = null;
	int f = 0;
	int choice;
	public boolean backup;
	public boolean Discount;
	public int ProductPrice;

	public Product(String name, String information, ProductType productType,
			double Price) throws PriceException {

		this.productType = productType;
		this.name = name;
		this.information = information;
		this.Price = Price;
	}

	public Product(String name, String information, ProductType productType,
			double Price, ArrayList<Person> Persons) throws PriceException {
		PropertyConfigurator.configure("Log4J.properties");
		this.Discount = true;
		this.backup = false;
		this.ProductPrice = 20;
		this.productType = productType;
		this.name = name;
		this.information = information;
		
		this.Price = Price;
	}

	public void printProduct() {
		System.out.println("name: " + name + "\t information: " + information
				+ "\t Product type: " + productType + "\t Price: " + Price);
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
	public List<Person> Persons= new ArrayList<Person>();
	public void printPersons(){
	for(Person g : this.Persons)
	{
	g.printPerson();
	}
	}
	

	public static void showlistproducts(ArrayList<Product> products) {
		Person o = new Person("Jan", "Nowak", products);
		o.printProducts();
		logger.info("wyswietliles produkty");
	}

	public static void addProduct(ArrayList<Product> products, ArrayList<Product> AryProducts, String name, String description, ProductType type, int price)
			throws IOException, PriceException {
		
		logger.info("dodales produkt");
		
		if (price > 0) {
		// dodanie elementu do listy produkt�w
		products.add(new Product(name, description, type, price));
		AryProducts.add(new Product(name, description, type, price));
		logger.info("Product: " + name + " - added");
		}
		if (price <= 0)
			throw new PriceException("Price cannot by less than 0");
	}
	
			
		

	public static void editlistproducts(ArrayList<Product> products, int fc)
			throws IOException, PriceException {
		PropertyConfigurator.configure("Log4J.properties");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String a = null;
		String b = null;
		String c = null;
		ProductType d = null;
		int f = 0;

		for (int i = 1; i <= fc; i++) {
			System.out
					.println("Podaj element ktory chcesz edytowac na liscie productow: ");
			a = in.readLine();
			if ((equalProduct(products, a)) == null)
				System.out.println("nie ma takiego produktu na liscie");
			else {

				f = products.indexOf(searchProduct(products, a))+1;

				System.out.print("Podaj nazwe: ");
				c = in.readLine();
				System.out.print("Podaj opis: ");
				b = in.readLine();
				System.out.print("Podaj typ: ");
				d = ProductType.valueOf(in.readLine());
				System.out.print("Podaj cene produktu: ");
				String strprice = in.readLine();
				int price = Integer.parseInt(strprice);
				
				// dodanie elementu do listy produkt�w
				try {

					products.set(f, new Product(c, b, d, price));
				} catch (ArrayIndexOutOfBoundsException e) {

					System.out
							.println("Niepoprawny parametr, rozmiar tablicy to: "
									+ products.size());
					logger.error("Za duzy index list " + a
							+ " gdzie lista ma rozmiar" + products.size());
				}
			}

			logger.info("zedytowales liste produktow");
			}
	}

	public static void showsize(ArrayList<Person> Persons,
			ArrayList<Product> products) {
		System.out.println("Size the list of products: " + products.size());
		System.out.println("Size the list of persons: " + Persons.size());
	}

	public static List<Product> searchProduct(ArrayList<Product> products,
			String a) throws IOException {

		List<Product> results = new ArrayList<Product>();

		int pozycja = 0;
		for (Product c : products) {
			if (c.getName().contains(a)) {
				System.out.println("Produkt o Nazwie: " + c.getName()
						+ " znajduje sie na pozycji " + pozycja
						+ ". Na liscie Produktow");
				c.printProduct();
				results.add(c);
				return results;
			} else if (c.getInformation().contains(a)) {
				System.out
						.println("Produkt gdzie w opisie zawarte jest slowo: "
								+ c.getInformation()
								+ " znajduje sie na pozycji " + pozycja
								+ ". Na liscie Produktow");
				c.printProduct();
				results.add(c);
				return results;
			} else if (c.getProductType().equals(a)) {
				System.out.println("Produkt typu: " + c.getProductType()
						+ " znajduje sie na pozycji " + pozycja
						+ ". Na liscie Produktow");
				c.printProduct();
				results.add(c);
				return results;

			}

			pozycja++;
		}
		return null;
	}

	public static List<Product> equalProduct(ArrayList<Product> products,
			String a) throws IOException {

		List<Product> results = new ArrayList<Product>();

		for (Product c : products) {
			if (c.getName().contains(a)) {
				results.add(c);
				return results;
			} else if (c.getInformation().contains(a)) {
				results.add(c);
				return results;
			} else if (c.getProductType().equals(a)) {
				results.add(c);
				return results;

			}
		}
		return null;
	}

	public static void deleteProduct(ArrayList<Product> products, String a)
			throws IOException {
		int f = products.indexOf(searchProduct(products, a))+1;
		
		products.remove(f);

	}

	public boolean isBackup() {
		return backup;
	}

	public void setBackup(boolean backup) {
		this.backup = backup;
	}

	public boolean isDiscount() {
		return Discount;
	}

	public void setDiscount(boolean Discount) {
		this.Discount = Discount;
	}

	public int getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(int ProductPrice) {
		this.ProductPrice = ProductPrice;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double d) {
		Price = d;
	}

	
	
}
