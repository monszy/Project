package com.pl.monszy;

import java.util.ArrayList;
import java.util.List;
 
public class Osoba {
public String imie;
public String nazwisko;
public Osoba(String imie, String nazwisko)
{
this.imie=imie;
this.nazwisko=nazwisko;
}
public Osoba(String imie, String nazwisko, List<Car> cars)
{
this.imie=nazwisko;
this.nazwisko=nazwisko;
this.cars=cars;
}
public List<Car> cars= new ArrayList<Car>();
public void printCars(){
for(Car c : this.cars)
{
c.printCar();
}
}
}
