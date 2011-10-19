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
public Person(String imie, String nazwisko, List<Product> cars)
{
this.imie=nazwisko;
this.nazwisko=nazwisko;
this.cars=cars;
}
public List<Product> cars= new ArrayList<Product>();
public void printCars(){
for(Product c : this.cars)
{
c.printCar();
}
}
}
