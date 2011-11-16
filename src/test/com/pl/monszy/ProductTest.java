package test.com.pl.monszy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import com.pl.monszy.*;

public class ProductTest {

	Person person = new Person("Szymon", "Stasiak");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		person.addProduct("Fuji", "Dobry film nie jest z³y", ProductType.Film,
				10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProductStringStringProductType() {
		fail("Not yet implemented");
	}

	@Test
	public void testProductStringStringProductTypeArrayListOfPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintPersons() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		assertTrue(person.getProducts().get(0).getName().equals("Kojiak"));
	}

	@Test
	public void testSetName() {
		person.getProducts().get(0).setName("Kojiak");
		assertTrue(person.getProducts().get(0).getName().equals("Kojiak"));
	}

	@Test
	public void testGetInformation() {
		assertTrue(person.getProducts().get(0).getInformation()
				.equals("best film ever"));
	}

	@Test
	public void testSetInformation() {
		person.getProducts().get(0).setInformation("best film");
		assertTrue(person.getProducts().get(0).getInformation().equals("best film"));
	}

	@Test
	public void testGetPersons() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPersons() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowlistproducts() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditlistproducts() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowsize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsBackup() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBackup() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCleanBox() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCleanBox() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProductBoxColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProductBoxColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProductType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProductType() {
		fail("Not yet implemented");
	}

}
