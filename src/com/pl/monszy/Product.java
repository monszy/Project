package com.pl.monszy;


public class Product {
public String marka;
public String nr;
public Product(String marka, String nr){
this.marka=marka;
this.nr=nr;
}
public void printCar()
{
System.out.println("Marka: "+marka+"\t nr: "+nr);
}
 
}
