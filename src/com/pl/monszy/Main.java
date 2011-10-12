package com.pl.monszy;

import java.util.ArrayList;
import java.util.List;
 
public class Main {
 
public static void main(String[] args){
List<Car> cars= new ArrayList<Car>();
cars.add(new Car("BMW","gda1234"));
cars.add(new Car("Alfa Romeo","gda4567"));
cars.add(new Car("Mercedes","abc1234"));
Osoba o= new Osoba("Jan","Nowak",cars);
o.printCars();
}
}
