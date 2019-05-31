package testModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import customException.NotFoundException;
import model.Category;
import model.Distributor;
import model.Product;

class DistributorTest {
	private Distributor distributorTest;
	public void setupScenary2() {
		Distributor distributor1 = new Distributor("ejemploCompany","A0001","Alejo","3154567892");
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
		distributor1.fill();
		distributorTest = distributor1;
	}
	@Test
	void sortProductByNameTest() {
		setupScenary2();
		
		distributorTest.sortProductByName();
		ArrayList<Product> products = distributorTest.getProductsToShow();
		String order = "A,D,M,M,O";
		String[] letters = order.split(",");
		assertEquals(letters[0], products.get(0).getName(),"ordered");
		assertEquals(letters[1], products.get(1).getName(),"ordered");
		assertEquals(letters[2], products.get(2).getName(),"ordered");
		assertEquals(letters[3], products.get(3).getName(),"ordered");
		assertEquals(letters[4], products.get(4).getName(),"ordered");
	
	}
	@Test
	void sortProductByPriceTest() {
		setupScenary2();
		distributorTest.sortProductByPrice();
		ArrayList<Product> products = distributorTest.getProductsToShow();
		double[] numbers = {500,1200,1200,3000,10000};
		assertEquals(numbers[0], products.get(0).getPrice(),"ordered");
		assertEquals(numbers[1], products.get(1).getPrice(),"ordered");
		assertEquals(numbers[2], products.get(2).getPrice(),"ordered");
		assertEquals(numbers[3], products.get(3).getPrice(),"ordered");
		assertEquals(numbers[4], products.get(4).getPrice(),"ordered");
		

	}
	@Test
	void sortProductByQuantityTest() {
		setupScenary2();
		distributorTest.sortProductByQuantity();
		ArrayList<Product> products = distributorTest.getProductsToShow();
		int[] quantitys = {9,10,10,15,20};
		assertEquals(quantitys[0], products.get(0).getQuantity(),"ordered");
		assertEquals(quantitys[1], products.get(1).getQuantity(),"ordered");
		assertEquals(quantitys[2], products.get(2).getQuantity(),"ordered");
		assertEquals(quantitys[3], products.get(3).getQuantity(),"ordered");
		assertEquals(quantitys[4], products.get(4).getQuantity(),"ordered");
		

	}
	@Test
	void sortProductByCodeTest() {
		setupScenary2();
		distributorTest.sortProductByCode();
		ArrayList<Product> products = distributorTest.getProductsToShow();
		int[] codes = {10,27,30,30,40};
		assertEquals(codes[0], products.get(0).getCode(),"ordered");
		assertEquals(codes[1], products.get(1).getCode(),"ordered");
		assertEquals(codes[2], products.get(2).getCode(),"ordered");
		assertEquals(codes[3], products.get(3).getCode(),"ordered");
		assertEquals(codes[4], products.get(4).getCode(),"ordered");
		
	}
	
	@Test 
	void searchingByNameTest() throws NotFoundException {
		setupScenary2();
		int find = distributorTest.searchingByName("A");
		int find2 = distributorTest.searchingByName("M");
		ArrayList<Product> products = distributorTest.getProductsToShow();
		assertEquals("A", products.get(find).getName(),"ordered");
		assertEquals("M", products.get(find2).getName(),"ordered");
	}
	
	@Test 
	void searchingByCodeTest() throws NotFoundException{
		setupScenary2();
		
		int find = distributorTest.searchingByCode(10);
		int find2 = distributorTest.searchingByCode(40);
		ArrayList<Product> products = distributorTest.getProductsToShow();
		assertEquals(10, products.get(find).getCode(),"ordered");
		assertEquals(40, products.get(find2).getCode(),"ordered");
	}
	@Test 
	void notFoundNameTest() throws NotFoundException{
		setupScenary2();
		try {
			int find = distributorTest.searchingByName("P");
			fail("the exception is not catch");
		}catch (NotFoundException e) {
			assertTrue(true, "catch");
		}
	}
	@Test 
	void notFoundCodeTest() throws NotFoundException {
		setupScenary2();
		try {
			int find = distributorTest.searchingByCode(0);
			fail("the exception is not catch");
		}catch (NotFoundException e) {
			assertTrue(true, "catch");
		}
	}
}
