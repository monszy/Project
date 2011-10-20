package com.pl.monszy;

import java.util.ArrayList;
import java.util.List;
 
public class Person {
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
for(Product c : this.products)
{
c.printProduct();
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

}
