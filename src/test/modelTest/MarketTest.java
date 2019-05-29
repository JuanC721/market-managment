package modelTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import customException.NotFoundException;
import model.Category;
import model.Distributor;
import model.Manager;
import model.Market;
import model.Product;

class MarketTest {

	private Market marketTest;
	public void setupScenary1() {
		Manager manager = new Manager("juanito",1234,"juanitoElGigante@hotmail.com","trolazo111");
		Market init = new Market("marketExample",23132,312777891,"carrera1","markerExample@live.com",manager);
		Distributor distributor1 = new Distributor("ejemploCompany","A0001","Alejo","3154567892");
		Distributor distributor2 = new Distributor("ejemploCompany2", "A0002", "Jairo", "3189020938");
		Product m = new Product(Category.Frutas, "M", "element M", 30, 1200, 10);
		Product a = new Product(Category.PatatasYLegumbres, "A", "element A", 10, 500, 20);
		Product z = new Product(Category.Harinas, "M", "element M", 30, 1200, 10);
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
		int[] codes = {1,5,7,10,27,30,30,40};
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
}
