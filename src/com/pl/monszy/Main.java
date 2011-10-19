package com.pl.monszy;

import java.util.ArrayList;
import java.util.List;
 
public class Main {
 
public static void main(String[] args){
List<Product> products= new ArrayList<Product>();
products.add(new Product("Film","best film ever"));
products.add(new Product("Koadak","some best film"));
products.add(new Product("Fuji","p"));

List<Person> Persons= new ArrayList<Person>();
Persons.add(new Person("Jan","Nowak"));
Persons.add(new Person("Gabrys","Szmel"));


Person o= new Person("Jan","Nowak",products);
o.printProducts();

Product d= new Product("Film","best film ever");
d.printPersons();

System.out.println("Size the list of products: "+products.size());
System.out.println("Size the list of person: "+Persons.size());
}


}
