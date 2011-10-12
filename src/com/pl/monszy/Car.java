package com.pl.monszy;


public class Car {
public String marka;
public String nr;
public Car(String marka, String nr){
this.marka=marka;
this.nr=nr;
}
public void printCar()
{
System.out.println("Marka: "+marka+"\t nr: "+nr);
}
 
}
