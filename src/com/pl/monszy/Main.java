package com.pl.monszy;

import java.util.ArrayList;
import java.util.List;
 
public class Main {
 
public static void main(String[] args){
List<Product> products= new ArrayList<Product>();
products.add(new Product("BMW","gda1234"));
products.add(new Product("Alfa Romeo","gda4567"));
products.add(new Product("Mercedes","abc1234"));
Person o= new Person("Jan","Nowak",products);
o.printCars();
}
}
