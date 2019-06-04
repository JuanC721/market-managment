package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import customException.NotFoundException;

public class Distributor implements Serializable{
	
			
	//Associations
			/**
			 * this attribute contains next Distributor in the liked list
			 */
			private Distributor next;
			/**
			 * this attribute contains previous Distributor in the liked list
			 */
			private Distributor previous;
			/**
			 * this attribute contains root of the binary search tree type Producto of the Distributor class
			 */
			private Product root;
		
		//Attributes
			/**
			 * this attribute contains the name of the distributor 
			*/
			private String companyName;
			/**
			 * this attribute contains the code of the distributor 
			 */
			private String code;
			/**
			 * this attribute contains the name of the manager in the distributor company 
			 */
			private String distributorManagerName;
			/**
			 *this attribute contains the phone of the distributor 
			 */
			private String distributorPhone;
			/**
			 * this attribute contains all the products of the distributor company
			 */
			private ArrayList<Product> productsToShow;
		//Methods
			//Builder
			/**
			*This is the constructor of the Distributor class
			*@param the name of the distributor company. companyName != null
			*@param the code of the company. code != null
			*@param the name of the manager in the distributor company. distributorManagerName != null
			*@param the phone of the distributor company. distributorPhone != null
			*/
				public Distributor(String companyName, String code, String distributorManagerName, String distributorPhone) {
					this.companyName = companyName;
					this.code = code;
					this.distributorManagerName = distributorManagerName;
					this.distributorPhone = distributorPhone;
					this.productsToShow = new ArrayList<Product>();
					fill();
				}
			
			//Getters
				/**
				 * this method allows get the next object type Distributor from the linked list
				 * @return the next object type Distributor of the linked list
				 */
				public Distributor getNext() {
					return next;
				}
				/**
				 * this method allows get the previous object type Distributor from the linked list
				 * @return the previous object type Distributor of the liked list
				 */
				public Distributor getPrevious() {
					return previous;
				}
				/**
				 * this method allows get the root object type Product from binary search tree type Product
				 * @return the root of the binary search tree
				 */
				public Product getRoot() {
					return root;
				}
				/**
				 * this method allows get the company name 
				 * @return the attribute companyName of the class 
				 */
				public String getCompanyName() {
					return companyName;
				}
				/**
				 * this method allows get the company code 
				 * @return the attribute code of the class
				 */
				public String getCode() {
					return code;
				}
				/**
				 * this method allows get the company manager name 
				 * @return the attribute distributorManager of the class 
				 */
				public String getDistributorManagerName() {
					return distributorManagerName;
				}
				/**
				 * this method allows get the company phone 
				 * @return the attribute distributorPhone of the class
				 */
				public String getDistributorPhone() {
					return distributorPhone;
				}
				/**
				 * this method allows get the company products 
				 * @return the arrayList of the products of the distributor
				 */
				public ArrayList<Product> getProductsToShow() {
					return productsToShow;
				}

				

			//Setters
				/**
				 *this method allows change the relation with the next object type Distributor of the linked list type Distributor
				 * @param next
				 */
				public void setNext(Distributor next) {
					this.next = next;
				}
				/**
				 * this method allows change the relation with the previous object type Distributor of the linked list type Distributor
				 * @param previous != null;
				 */
				public void setPrevious(Distributor previous) {
					this.previous = previous;
				}
				/**
				 * this method allows change the root of the binary search tree type Product
				 * @param root != null.
				 */
				public void setRoot(Product root) {
					this.root = root;
				}
				/**
				 * this method allows change the name of the company
				 * @param companyName != null.
				 */
				public void setCompanyName(String companyName) {
					this.companyName = companyName;
				}
				/**
				 * this method allows change the code of the company
				 * @param code != null.
				 */
				public void setCode(String code) {
					this.code = code;
				}
				/**
				 * this method allows change the manager name of the company
				 * @param distributorManagerName != null.
				 */
				public void setDistributorManagerName(String distributorManagerName) {
					this.distributorManagerName = distributorManagerName;
				}
				/**
				 * this method allows change the phone of the company
				 * @param distributorPhone
				 */
				public void setDistributorPhone(String distributorPhone) {
					this.distributorPhone = distributorPhone;
				}

			//Operational
				/**
				 *this method find a product by name 
				 *@param the name of the product search. name != null
				 *@return a int with the position of the object
				 */
				public int searchingByName(String name) throws NotFoundException {
					int posFind = -1;
					boolean found = false;
					for(int i = 0; i<productsToShow.size() && !found; i++) {
						if(productsToShow.get(i).getName().equalsIgnoreCase(name)) {
							found = true;
							posFind = i;
						}
					}if(posFind == -1) {
						throw new NotFoundException();
					}
					return posFind;
				}
				/**
				 *this method find a product by code 
				 *@param the name of the product search. code != null
				 *@return a int with the position of the object
				 */
	
				public int searchingByCode(int code) throws NotFoundException{
					int posFind = -1;
					boolean found = false;
					for(int i = 0; i<productsToShow.size() && !found; i++) {
						if(productsToShow.get(i).getCode()==code) {
							found = true;
							posFind = i;
						}
					}if(posFind == -1) {
						throw new NotFoundException();
					}
					return posFind;
				}
				/**
				 *this method sort by name the list of products
				 *<b>post:</b>the list of products was sorted by name </br>  
				 */
				public void sortProductByName() {
					//TODO puede que el método falle
					productsToShow = (ArrayList<Product>) preorder();
					int n = productsToShow.size();
					for (int i = 0; i <= n; i++) {
						for (int j = 0; j < n - i - 1; j++){
							if (productsToShow.get(j+1).getName().compareTo(productsToShow.get(j).getName())<0){
								Product temp = productsToShow.get(j); 
								productsToShow.set(j,productsToShow.get(j+1));
								productsToShow.set(j+1,temp);
							}
						}
					}
				}
				/**
				 *this method sort by price the list of products
				 *<b>post:</b>the list of products was sorted by price </br>  
				 */
				public void sortProductByPrice() {
					productsToShow = (ArrayList<Product>) preorder();
					int n = productsToShow.size();
					for (int i = 0; i <= n; i++) {
						for (int j = 0; j < n - i - 1; j++){
							if (productsToShow.get(j+1).getPrice()<productsToShow.get(j).getPrice()){
								Product temp = productsToShow.get(j); 
								productsToShow.set(j,productsToShow.get(j+1));
								productsToShow.set(j+1,temp);
							}
						}
					}	
				}
				/**
				 *this method sort by quantity the list of products
				 *<b>post:</b>the list of products was sorted by quantity </br>  
				 */
				public void sortProductByQuantity() {
					productsToShow = (ArrayList<Product>) preorder(); 
					for (int I = 0; I < productsToShow.size()-1; I++) {
						int minPosition = I;
						for (int J = I+1; J < productsToShow.size() ; J++) {
							if(productsToShow.get(J).getQuantity() < productsToShow.get(minPosition).getQuantity()) {
								minPosition = J;
							}else if(productsToShow.get(J).getQuantity() == productsToShow.get(minPosition).getQuantity()){
								if(productsToShow.get(J).getQuantity()<productsToShow.get(minPosition).getQuantity()){
									minPosition = J; 
								}
							}
						}
						Product temp = productsToShow.get(minPosition);
						productsToShow.set(minPosition, productsToShow.get(I));
						productsToShow.set(I, temp);
					}
				}
				/**
				 *this method sort by code the list of products
				 *<b>post:</b>the list of products was sorted by code </br>  
				 */
				public void sortProductByCode() {
					productsToShow = (ArrayList<Product>) preorder(); 
					Product temp;
					for(int i=1;i < productsToShow.size();i++){
						for (int j=0 ; j < productsToShow.size()- 1; j++){
							if (productsToShow.get(j).getCode() > productsToShow.get(j+1).getCode()){
								temp = productsToShow.get(j);
								productsToShow.set(j, productsToShow.get(j+1));
								productsToShow.set(j+1, temp);
							}
						}
					}
				}

				/**
				 *this method return a list with all the elements of the binary search tree
				 *@return a list with all the object type Product of the binary search tree
				 */
				public List<Product> preorder(){
					return preorder(root);  
				}
				 
				/**
				 *this recursive method return one list type Product
				 *@param the current object Product of the binary search tree. current  != null
				 *@return a return a list with all the object type Product of the binary search tree 
				 */
				private List<Product> preorder(Product current){
					List<Product> lis= new ArrayList<Product>();
					if(current != null){
//						System.out.println("off");
						
						lis.add(current);
						List<Product> lis2 = preorder(current.getLeft());
						List<Product> lis3 = preorder(current.getRight());
						lis.addAll(lis2);
						lis.addAll(lis3);
					}
					return lis;
				}
			   
			

			    
				/**
				 *this method allows add a new object type Product in the binary search tree of products
				 *@param a object type Product. newOne != null
				 *<b>post:</b> a new object type Product was add in the binary search tree
				 */
				public void addProduct(Product newOne) {
					addProduct(newOne, root);
				}
				
				/**
				 *this recursive method allows add a new object type Product in the binary search tree of products sorting by name
				 *@param the current object type Product of the binary search tree. current != null
				 *@param a object type Product. newOne != null
				 *<b>post:</b> a new object type Product was add in the binary search tree
				 */
				public void addProduct(Product newOne, Product current) {
					if(root == null){
						root = newOne;
					}
					else {
//						System.out.println(current.getCode());
						if(newOne.compareTo(current) <= 0) {
							if(current.getLeft() == null) {
								current.setLeft(newOne);
							}else{
								
								addProduct(newOne, current.getLeft());
							}
						}else{
							if(current.getRight() == null) {
								current.setRight(newOne);
							} else {
								addProduct(newOne, current.getRight());
							}
						}
						
					}
				}
				/**
				 *this method generate products from a txt
				 */
				public void generateProducts(String path, String step)  throws IOException{
					File file = new File(path);
					FileReader fileReader = new FileReader(file);
					BufferedReader br = new BufferedReader(fileReader);
					String line = br.readLine();
//					Random ran = new Random();
					while(line != null){
//						int random = ran.nextInt(22);
						String[] temporalDataArray = line.split(",");
						Category c = null;
						if(verifyValidCategory(temporalDataArray[0]) != null) {
							c = verifyValidCategory(temporalDataArray[0]);
						}
						Product temporalNewProduct = new Product(Category.ConfiteriaDulce,temporalDataArray[1],temporalDataArray[2],Integer.parseInt(temporalDataArray[3]), Double.parseDouble(temporalDataArray[4]),Integer.parseInt(temporalDataArray[5]));
						System.out.println(temporalNewProduct.getName());
						addProduct(temporalNewProduct);
						line = br.readLine();
					}
					fill();
					fileReader.close();
					br.close();		
				}
				/**
				 *this method verify a correct category
				 *@param categoryToCheck is a String with the name of one value of the enum Category. categoryToCheck!=null
				 *@return a value
				 */
				public Category verifyValidCategory(String categoryToCheck) {
					Category c = null;
					for(Category cgy : Category.values()) {
						if(cgy.getDescription().equals(categoryToCheck)){
							c = cgy;
						}
					}
					return c;
				}
				/**
				 *this method allows fill the arrayList of productsToShow contained in the binary search tree
				 */
				public void fill() {
					productsToShow.clear();
					List<Product> ñ = preorder();
					for(int i = 0; i<ñ.size();i++){
						productsToShow.add(i,ñ.get(i));
					}
				}
				
				public void f() {
					for(int i = 0; i<productsToShow.size();i++) {
						System.out.println(productsToShow.get(i).getName());
					}
				}
				
				
}