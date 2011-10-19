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
public Person(String imie, String nazwisko, List<Product> products)
{
this.imie=imie;
this.nazwisko=nazwisko;
this.products=products;
}
public void printPerson()
{
System.out.println("imie: "+imie+"\t nazwisko: "+nazwisko);
}
public List<Product> products= new ArrayList<Product>();
public void printProducts(){
for(Product c : this.products)
{
c.printProduct();
}
}

}
