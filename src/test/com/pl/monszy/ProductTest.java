package test.com.pl.monszy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import com.pl.monszy.*;

public class ProductTest {
	
	ArrayList<Product> products = new ArrayList<Product>();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		products.add(new Product("Kojiak", "best film ever",
					ProductType.Film, 10));
	}

	@After
	public void tearDown() throws Exception {
		products.clear();
	}
	

	@Test
	public void testGetName() {
		assertTrue(products.get(0).getName().equals("Kojiak"));
	}

	@Test
	public void testSetName() {
		products.get(0).setName("Fuji");
		assertTrue(products.get(0).getName().equals("Fuji"));
	}

	@Test
	public void testGetInformation() {
	assertTrue(products.get(0).getInformation()
				.equals("best film ever"));
	}

	@Test
	public void testSetInformation() {
		products.get(0).setInformation("best film");
		assertTrue(products.get(0).getInformation().equals("best film"));
	}


	@Test
	public void testShowlistproducts() {
		
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
