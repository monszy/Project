package test.com.pl.monszy;

import static org.junit.Assert.*;

import java.io.IOException;
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
		Person o = new Person("Jan", "Nowak", products);
		o.printProducts();		
	}

	@Test
	public void testAddProduct() {
		assertTrue(products.size() == 1);
	}
	
	/*@Test
	public void testEditlistproducts() throws PriceException, IOException {
		
		System.out.println("Przy zmianie prosze podac cene 12 aby test przeszedl poprawnie");
		Product.editlistproducts(products, 1);		
		assertTrue(products.get(0).getPrice() == 12);
			
	}*/

	@Test
	public void testShowsize() {
		assertTrue(products.size() == 1);
		
	}

	@Test
	public void testSearchProduct() throws IOException {
		assertNotNull(products.get(0));
		assertEquals(products.get(0).getName(), (Product.searchProduct(products, "Kojiak")).get(0).getName());
		assertSame(products.get(0).getName(), (Product.searchProduct(products, "Kojiak")).get(0).getName());
		assertEquals(products.get(0).getInformation(), (Product.searchProduct(products, "Kojiak")).get(0).getInformation());
		assertSame(products.get(0).getProductPrice(), (Product.searchProduct(products, "Kojiak")).get(0).getProductPrice());
		assertEquals(products.get(0).getProductType(), (Product.searchProduct(products, "Kojiak")).get(0).getProductType());
	}

	@Test
	public void testEqualProduct() throws IOException {
		assertNotNull(products.get(0));
		assertEquals(products.get(0).getName(), (Product.equalProduct(products, "Kojiak")).get(0).getName());
		assertSame(products.get(0).getName(), (Product.equalProduct(products, "Kojiak")).get(0).getName());
		assertEquals(products.get(0).getInformation(), (Product.equalProduct(products, "Kojiak")).get(0).getInformation());
		assertSame(products.get(0).getProductPrice(), (Product.equalProduct(products, "Kojiak")).get(0).getProductPrice());
		assertEquals(products.get(0).getProductType(), (Product.equalProduct(products, "Kojiak")).get(0).getProductType());
		
	}

	@Test
	public void testDeleteProduct() throws PriceException, IOException {
		products.add(new Product("Fuji", "best ever",
				ProductType.Camera, 120));
		assertTrue(products.size() == 2);	
		Product.deleteProduct(products, "Kojiak");		
		assertTrue(products.size() == 1);
	}

	@Test
	public void testIsBackup() {
		assertTrue(products.get(0).isBackup()==false);
	}

	@Test
	public void testSetBackup() {
		products.get(0).setDiscount(true);
		assertTrue(products.get(0).isDiscount()==true);
	}

	@Test
	public void testIsDiscount() {
		assertTrue(products.get(0).isDiscount()==false);
		
	}

	@Test
	public void testSetDiscount() {
		products.get(0).setDiscount(true);
		assertTrue(products.get(0).isDiscount()==true);
	}

	@Test
	public void testGetProductPrice() {
		assertTrue(products.get(0).getProductPrice() == 0);
	}

	@Test
	public void testSetProductPrice() {
		products.get(0).setProductPrice(10);
		assertTrue(products.get(0).getProductPrice() == 10);
	}

	@Test
	public void testGetProductType() {
		assertTrue(products.get(0).getProductType().equals(ProductType.Film));
	}

	@Test
	public void testSetProductType() {
		products.get(0).setProductType(ProductType.Camera);
		assertTrue(products.get(0).getProductType().equals(ProductType.Camera));
	}

	@Test
	public void testGetPrice() {
		assertTrue(products.get(0).getPrice() == 10);
	}

	@Test
	public void testSetPrice() {
		products.get(0).setPrice(20);
		assertTrue(products.get(0).getPrice() == 20);
	}

}
