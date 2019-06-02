package testModel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import customException.NotFoundException;
import model.Bill;
import model.Category;
import model.Distributor;
import model.Manager;
import model.Market;
import model.Product;

class MarketTest {
	private Market marketTest;
	public void setupScenary1() {
		Manager manager = new Manager("juanito",1234,"juanitoElGigante@hotmail.com","trolazo111");
		Market init = new Market();
		init.setMarketName("marketExample");
		init.setAddres("carrera1");
		init.setPhone(312777891);
		init.setNit(23132);
		init.setEmailAddress("markerExample@live.com");
		init.setManager(manager);
		Distributor distributor1 = new Distributor("ejemploCompany","A0001","Alejo","3154567892");
		Distributor distributor2 = new Distributor("ejemploCompany2", "A0002", "Jairo", "3189020938");
		Product m = new Product(Category.Frutas, "M", "element M", 30, 1200, 10);
		Product a = new Product(Category.PatatasYLegumbres, "A", "element A", 10, 500, 20);
		Product z = new Product(Category.Harinas, "M", "element M", 50, 1200, 10);
		Product d = new Product(Category.Endulzantes, "D", "element D", 40, 10000, 15);
		Product o = new Product(Category.HierbasAromaticas,"O","element O",27,3000,9);
		distributor1.addProduct(m);
		distributor1.addProduct(a);
		distributor1.addProduct(z);
		distributor1.addProduct(d);
		distributor1.addProduct(o);
		Product f = new Product(Category.Endulzantes,"F","element F",7,5000,3);
		Product e = new Product(Category.AlimentosParaBebes,"E","element E",5,3000,5);
		Product n = new Product(Category.Pastas,"N","element N",1,8000,4);
		distributor2.addProduct(f);
		distributor2.addProduct(e);
		distributor2.addProduct(n);
		distributor1.fill();
		distributor2.fill();
		init.addDistributor(distributor1);
		init.addDistributor(distributor2);		
		marketTest = init;
	}
	@Test
	void sortProductByNameTest() {
		setupScenary1();
		marketTest.actualInventory();
		marketTest.sortProductByName();
		ArrayList<Product> inventory = marketTest.getInventory();
		String order = "A,D,E,F,M,M,N,O,Z";
		String[] letters = order.split(",");
		assertEquals(letters[0], inventory.get(0).getName(),"ordered");
		assertEquals(letters[1], inventory.get(1).getName(),"ordered");
		assertEquals(letters[2], inventory.get(2).getName(),"ordered");
		assertEquals(letters[3], inventory.get(3).getName(),"ordered");
		assertEquals(letters[4], inventory.get(4).getName(),"ordered");
		assertEquals(letters[5], inventory.get(5).getName(),"ordered");
		assertEquals(letters[6], inventory.get(6).getName(),"ordered");
		assertEquals(letters[7], inventory.get(7).getName(),"ordered");
	}
	@Test
	void sortProductByPriceTest() {
		setupScenary1();
		marketTest.actualInventory();
		marketTest.sortProductByPrice();
		ArrayList<Product> inventory = marketTest.getInventory();
		double[] numbers = {500,1200,1200,3000,3000,5000,8000,10000};
		assertEquals(numbers[0], inventory.get(0).getPrice(),"ordered");
		assertEquals(numbers[1], inventory.get(1).getPrice(),"ordered");
		assertEquals(numbers[2], inventory.get(2).getPrice(),"ordered");
		assertEquals(numbers[3], inventory.get(3).getPrice(),"ordered");
		assertEquals(numbers[4], inventory.get(4).getPrice(),"ordered");
		assertEquals(numbers[5], inventory.get(5).getPrice(),"ordered");
		assertEquals(numbers[6], inventory.get(6).getPrice(),"ordered");
		assertEquals(numbers[7], inventory.get(7).getPrice(),"ordered");

	}
	@Test
	void sortProductByQuantityTest() {
		setupScenary1();
		marketTest.actualInventory();
		marketTest.sortProductByQuantity();
		ArrayList<Product> inventory = marketTest.getInventory();
		int[] quantitys = {3,4,5,9,10,10,15,20};
		assertEquals(quantitys[0], inventory.get(0).getQuantity(),"ordered");
		assertEquals(quantitys[1], inventory.get(1).getQuantity(),"ordered");
		assertEquals(quantitys[2], inventory.get(2).getQuantity(),"ordered");
		assertEquals(quantitys[3], inventory.get(3).getQuantity(),"ordered");
		assertEquals(quantitys[4], inventory.get(4).getQuantity(),"ordered");
		assertEquals(quantitys[5], inventory.get(5).getQuantity(),"ordered");
		assertEquals(quantitys[6], inventory.get(6).getQuantity(),"ordered");
		assertEquals(quantitys[7], inventory.get(7).getQuantity(),"ordered");

	}
	@Test
	void sortProductByCodeTest() {
		setupScenary1();
		marketTest.actualInventory();
		marketTest.sortProductByCode();
		ArrayList<Product> inventory = marketTest.getInventory();
		int[] codes = {1,5,7,10,27,30,40,50};
		assertEquals(codes[0], inventory.get(0).getCode(),"ordered");
		assertEquals(codes[1], inventory.get(1).getCode(),"ordered");
		assertEquals(codes[2], inventory.get(2).getCode(),"ordered");
		assertEquals(codes[3], inventory.get(3).getCode(),"ordered");
		assertEquals(codes[4], inventory.get(4).getCode(),"ordered");
		assertEquals(codes[5], inventory.get(5).getCode(),"ordered");
		assertEquals(codes[6], inventory.get(6).getCode(),"ordered");
		assertEquals(codes[7], inventory.get(7).getCode(),"ordered");
	}
	
	@Test 
	void searchingByNameTest() throws NotFoundException {
		setupScenary1();
		marketTest.actualInventory();
		int find = marketTest.searchingByName("A");
		int find2 = marketTest.searchingByName("F");
		ArrayList<Product> inventory = marketTest.getInventory();
		assertEquals("A", inventory.get(find).getName(),"ordered");
		assertEquals("F", inventory.get(find2).getName(),"ordered");
	}
	
	@Test 
	void searchingByCodeTest() throws NotFoundException{
		setupScenary1();
		marketTest.actualInventory();
		int find = marketTest.searchingByCode(10);
		int find2 = marketTest.searchingByCode(40);
		ArrayList<Product> inventory = marketTest.getInventory();
		assertEquals(10, inventory.get(find).getCode(),"ordered");
		assertEquals(40, inventory.get(find2).getCode(),"ordered");
	}
	@Test 
	void notFoundNameTest() throws NotFoundException {
		setupScenary1();
		try {
			marketTest.actualInventory();
			int find = marketTest.searchingByName("P");

			fail("the exception is not catch");
		}catch (NotFoundException e) {
			assertTrue(true, "catch");
		}
	}
	@Test 
	void notFoundCodeTest() throws NotFoundException {
		setupScenary1();
		try {
			marketTest.actualInventory();
			int find = marketTest.searchingByCode(0);
			fail("the exception is not catch");
		}catch (NotFoundException e) {
			assertTrue(true, "catch");
		}
	}
	@Test
	void getMoreProductTest() throws NotFoundException {
		setupScenary1();
		marketTest.actualInventory();
		Distributor x = new Distributor("companyExample2", "A0002", "managerexample", "3172893021");
		ArrayList<Product> inventory = marketTest.getInventory();
		marketTest.getMoreProducts(x, 1, 2);
		marketTest.actualInventory();
		int find = marketTest.searchingByCode(1);
		assertEquals(6,inventory.get(find).getQuantity(),"i");
		marketTest.getMoreProducts(x, 7, 4);
		marketTest.actualInventory();
		int find2 = marketTest.searchingByCode(7);
		assertEquals(7,inventory.get(find2).getQuantity(),"i");
	}
	@Test
	void refreshInventoryAfterASale() throws NotFoundException {
		setupScenary1();
		marketTest.actualInventory();
		Date f = new Date();
		Product code30 = new Product(Category.Frutas,"M", " ", 30, 1200, 1);
		Product code30two = new Product(Category.Frutas,"M", " ", 30, 1200, 1);
		Bill sale = new Bill(f,f.getHours(),f.getMinutes());
		sale.getProductsBought().add(code30);
		sale.getProductsBought().add(code30two);
		sale.totalCost();
		marketTest.refreshInventoryAfterASale(sale);
		int lol = marketTest.searchingByCode(30);
		Product lop = marketTest.getInventory().get(lol);
		assertEquals(8, lop.getQuantity());
	}
//	@Test
//	void loadTxt() {
//		setupScenary1();
//		try {
//			marketTest.generateDistributors("data\\distributors.txt", ",");
//			Distributor disti = marketTest.searchingDistributorName("colombina");
//			assertEquals("colombina", disti.getCompanyName());
//			disti.fill();
//			marketTest.actualInventory();	
//			int pos = disti.searchingByCode(1234);
//			Product x = disti.getProductsToShow().get(pos);
//			assertEquals("bombombum", x.getName());
//			assertEquals(1234, x.getCode());
//		} catch (IOException | NotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test
	void x() throws IOException {
		setupScenary1();
		marketTest.generateDistributors("data\\distributors.txt", ",");
		marketTest.actualInventory();
		marketTest.f();
	}

}
