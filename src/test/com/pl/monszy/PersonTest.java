package test.com.pl.monszy;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pl.monszy.Person;
import com.pl.monszy.Product;
import com.pl.monszy.ProductType;


public class PersonTest {
	
	ArrayList<Person> Persons = new ArrayList<Person>();
	ArrayList<Product> products = new ArrayList<Product>();
	@Before
	public void setUp() throws Exception {
		Persons.add(new Person("Szymon", "Stasiak"));
		products.add(new Product("Kojiak", "best film ever",
				ProductType.Film, 10));
		products.add(new Product("Fuji", "so hard",
				ProductType.Camera, 120));
	}

	@After
	public void tearDown() throws Exception {
		Persons.clear();
	}
	
	@Test
	public void testGetImie() {
		assertTrue(Persons.get(0).getImie().equals("Szymon"));
	}

	@Test
	public void testSetImie() {
		Persons.get(0).setImie("Objezyswiat");
		assertTrue(Persons.get(0).getImie().equals("Objezyswiat"));
	}

	@Test
	public void testGetNazwisko() {
		assertTrue(Persons.get(0).getNazwisko().equals("Stasiak"));
	}

	@Test
	public void testSetNazwisko() {
		Persons.get(0).setImie("Nowak");
		assertTrue(Persons.get(0).getImie().equals("Nowak"));
	}

	

	@Test
	public void testSetProducts() {
		Persons.get(0).setProducts(products);
		assertTrue(Persons.get(0).getProducts().equals(products));
	}

	@Test
	public void testAddPerson() {
		assertTrue(Persons.size() == 1);
	}



	/*@Test
	public void testEditlistPersons() throws IOException {
		System.out.println("Przy zmianie prosze podac imie Zbyszek aby test przeszedl poprawnie");
		Person.editlistPersons(Persons, 1);		
		assertTrue(Persons.get(0).getImie() == "Zbyszek");
	}*/

	@Test
	public void testSearchPerson() throws IOException {
		assertNotNull(Persons.get(0));
		
		assertTrue(Persons.get(0).getImie() == Person.searchPerson(Persons, "Szymon").get(0).getImie());
		assertSame(Persons.get(0).getNazwisko() , Person.searchPerson(Persons, "Stasiak").get(0).getNazwisko());
		assertEquals(Persons.get(0).getImie() , Person.searchPerson(Persons, "Szymon").get(0).getImie());
	}

	@Test
	public void testEqualPerson() throws IOException {
		
		assertNotNull(Persons.get(0));
		assertTrue(Persons.get(0).getImie() == Person.equalPerson(Persons, "Szymon").get(0).getImie());
		assertSame(Persons.get(0).getNazwisko() , Person.equalPerson(Persons, "Stasiak").get(0).getNazwisko());
		assertEquals(Persons.get(0).getImie() , Person.equalPerson(Persons, "Szymon").get(0).getImie());
	}

	@Test
	public void testDeletePerson() throws IOException {
		Persons.add(new Person("Jan","Nowak"));
		assertTrue(Persons.size() == 2);	
		Person.deletePerson(Persons, "Szymon");		
		assertTrue(Persons.size() == 1);
	}

}
