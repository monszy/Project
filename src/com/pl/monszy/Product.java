package com.pl.monszy;

import java.util.ArrayList;
import java.util.List;


public class Product {
public String name;
public String information;

public Product(String name, String information){
this.name=name;
this.information=information;
}
public Product(String name, String information, ArrayList<Person> Persons)
{
this.name=name;
this.information=information;
this.Persons=Persons;
}
public void printProduct()
{
System.out.println("name: "+name+"\t information: "+information);
}
 

public List<Person> Persons= new ArrayList<Person>();
public void printPersons(){
for(Person g : this.Persons)
{
g.printPerson();
}
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
public List<Person> getPersons() {
	return Persons;
}
public void setPersons(List<Person> persons) {
	Persons = persons;
}
}