package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import customException.NotFoundException;

@SuppressWarnings("serial")
public class Market implements Serializable{
	//Associations
			/**
		 	** this is the relation with the Manager class
		 	**/
			private Manager manager;
			/**
			 ** this is the first element of the linked list of Distributor class
			 **/
			private Distributor firstDistributor;
			/**
			 ** this is the first element of the linked list of Costumer class
			 **/
			private Costumer firstCostumer;
			/**
			 ** this is the root of the binary search tree type Bill
			 **/
			private Bill billsRoot;
			
		//Attributes
			/**
			 ** this attribute contains the name of the market who is using the software 
			 **/
			private String MarketName;
			/**
			 ** this attribute contains the nit of the market is using the software
			 **/
			private int nit;
			/**
			 ** this attribute contains the phone of the market is using the software
			 **/
			private int phone;
			/**
			 ** this attribute contains the address of the market is using the software
			 **/
			private String addres;/**
			 ** this attribute contains the email address of the market is using the software
			 **/
			private String emailAddress;
			/**
			 ** this attribute contains the products of the market
			 **/
			private ArrayList<Product> inventory;
			/**
			 ** this attribute allows know if the inventory was refreshed for first time; 
			 **/
			private boolean refreshInventory; 
		//Methods
			//Builder
			/**
			**This is the constructor of the Market class
			**@param the name of the market. MarketName != null
			**@param the code of the market. nit != null
			**@param the phone of the market. phone != null
			**@param the address of the market. addres != null
			**@param the email address of the market. emailAddress != null
			**@param the manager of the market. manager != null
			**/
			public Market(String MarketName, int nit, int phone, String addres, String emailAddress, Manager manager){
					this.MarketName = MarketName;
					this.nit = nit;
					this.phone = phone;
					this.addres = addres;
					this.emailAddress = emailAddress;
					this.manager = manager;
					this.refreshInventory = true;
				}
		
			//Getters
				/**
				 ** this method allows get the relation manager From the class market
				 **/
				public Manager getManager() {
					return manager;
				}
				/**
				 ** this method allows get the relation with the Distributor class from the class market, and that is the first element of the linked list of distributors
				 **/
				public Distributor getFirstDistributor() {
					return firstDistributor;
				}
				/**
				 ** this method allows get the relation with the Costumer class from the class market, and that is the first element of the linked list of Costumer
				 **/
				public Costumer getFirstCostumer() {
					return firstCostumer;
				}
				/**
				 ** this method allows get this method allows get the relation with the Bill class from the class market, and that is the root element of the binary search tree of Bill
				
				 **/
				public Bill getBillsRoot() {
					return billsRoot;
				}
				/**
				 ** this method allows get the name of the company
				 **/
				public String getMarketName() {
					return MarketName;
				}
				/**
				 ** this method allows get the nit of the company
				 **/
				public int getNit() {
					return nit;
				}
				/**
				 ** this method allows get the phone of the company
				 **/
				public int getPhone() {
					return phone;
				}
				/**
				 ** this method allows get the address of the company
				 **/
				public String getAddres() {
					return addres;
				}
				/**
				 ** this method allows get the email address of the company
				 **/
				public String getemailAddress() {
					return emailAddress;
				}
				/**
				 ** 
				 **/
				public ArrayList<Product> getInventory() {
					return inventory;
				}
			//Setters
				/**
				 ** this method allows change the relation with the class Manager
				 **/
				public void setManager(Manager manager) {
					this.manager = manager;
				}
				/**
				 ** this method allows change the first element of the Distributor linked list
				 **/
				public void setFirstDistributor(Distributor firstDistributor) {
					this.firstDistributor = firstDistributor;
				}
				/**
				 ** this method allows change the first element of the Costumer linked list
				 **/
				public void setFirstCostumer(Costumer firstCostumer) {
					this.firstCostumer = firstCostumer;
				}
				/**
				 ** this method allows change the root element of the binary search tree with objects type bill
				 **/
				public void setBillsRoot(Bill billsRoot) {
					this.billsRoot = billsRoot;
				}
				/**
				 ** this method allows change the name of the company
				 **/
				public void setMarketName(String MarketName) {
					this.MarketName = MarketName;
				}
				/**
				 ** this method allows change the nit of the company
				 **/
				public void setNit(int nit) {
					this.nit = nit;
				}
				/**
				 ** this method allows change the phone of the company
				 **/
				public void setPhone(int phone) {
					this.phone = phone;
				}
				/**
				 ** this method allows change the address of the company
				 **/
				public void setAddres(String addres) {
					this.addres = addres;
				}
				/**
				 **** this method allows change the email address of the company
				 **/
				public void setEmailAddress(String emailAddress) {
					this.emailAddress = emailAddress;
				}
				/****
				 ** this method allows change the email of the company
				 **/
				public void setInventory(ArrayList<Product> inventory) {
					this.inventory = inventory;
				}
			//Operational
				/****
				 ** this method allows add a new distributor in the linked list of Distributors
				 ** @param the new distributor to add. newDistributor != null
				 ** <b>post</b> a new Object type distributor was added to the linked list of Distributor
				 **/
				public void addDistributor( Distributor newDistributor){
					if(firstDistributor == null) {
						firstDistributor = newDistributor;
					}else {
						Distributor current = firstDistributor;
						while(current.getNext() != null){
							current = current.getNext();
						}
						current.setNext(newDistributor);
						Distributor temp = current;
						current = current.getNext();
						current.setPrevious(temp);
					}
				}
				/**
				 ** this method allows add a new distributor in the linked list of Costumer
				 ** @param the new costumer to add. newCostumer != null
				 ** <b>post</b> a new Object type costumer was added to the linked list of Costumer</br> 
				 **/
				public void addCostumer( Costumer newCostumer){
					if(firstCostumer == null) {
						firstCostumer = newCostumer;
					}else {
						Costumer current = firstCostumer;
						while(current.getNext() != null){
							current = current.getNext();
						}
						current.setNext(newCostumer);
						Costumer temp = current;
						current = current.getNext();
						current.setPrevious(temp);
					}
				}
				/**
				 ** this method allows add a new distributor in the linked list of Distributors
				 ** @param the new bill to add at the binary search tree. newBill != null
				 ** <b>post</b> a new Object type Bill was added to the binary search tree</br> 
				 **/
				public void addBill(Bill newBill) {
					if(billsRoot == null) {
						billsRoot = newBill;
					}else {
						refreshInventoryAfterASale(newBill);
						addBill(billsRoot,newBill);
					}
				}/**
				 ** this recursive method allows add a new distributor in the linked list of Distributors
				 ** @param the reference bill to add a new bill at the binary search tree. current != null
				 ** @param the new bill to add at the binary search tree. newBill != null
				 ** <b>post</b> a new Object type Bill was added to the binary search tree</br> 
				 **/
				private void addBill(Bill current, Bill newBill) {
					if(current.compareTo(newBill) <= 0){
						if(current.getLeft() == null){
							current.setLeft(newBill);
						}else{
							addBill(current.getLeft(), newBill);
						}
					}else{
						if(current.getRight() == null) {
							current.setRight(newBill);
						}else{
							addBill(current.getRight(),newBill);
						}
					}
				}
				//metodos de ordenamiento para costumers
				/**
				 ** this method sort by name the liked list of costumers
				 ** <b>post:</b>the liked list of costumers was sorted by name </br>  
				 **/
				public void sortCostumerByName(){
						if(firstCostumer != null){
							boolean changed = true;
							while(changed) {
								Costumer current = firstCostumer;
								changed = false;
								while(current.getNext() != null) {
									Costumer next = current.getNext();
									if(current.getName().compareTo(next.getName())>0) {
										if(current.getPrevious()!=null) {
											current.getPrevious().setNext(next);
										}
										if(next.getNext()!=null) {
											next.getNext().setPrevious(current);
										}
										current.setNext(next.getNext());
										next.setPrevious(current.getPrevious());
										current.setPrevious(next);
										next.setNext(current);						
										if(current==firstCostumer) {
											firstCostumer = next;
										}
										changed = true;
									}else{
										current = current.getNext();
									}
								}
							}
						}
					}
				/**
				 ** this method sort by code the liked list of costumers
				 ** <b>post:</b>the liked list of costumers was sorted by code </br>  
				 **/
					public void sortCostumerBycode(){
						if(firstCostumer != null){
							boolean changed = true;
							while(changed) {
								Costumer current = firstCostumer;
								changed = false;
								while(current.getNext() != null) {
									Costumer next = current.getNext();
									if(current.getId().compareTo(next.getId())>0) {
										if(current.getPrevious()!=null) {
											current.getPrevious().setNext(next);
										}
										if(next.getNext()!=null) {
											next.getNext().setPrevious(current);
										}
										current.setNext(next.getNext());
										next.setPrevious(current.getPrevious());
										current.setPrevious(next);
										next.setNext(current);						
										if(current==firstCostumer) {
											firstCostumer = next;
										}
										changed = true;
									}else{
										current = current.getNext();
									}
								}
							}
						}
					}
					/**
					 ** this method sort by address the liked list of costumers
					 ** <b>post:</b>the liked list of costumers was sorted by address </br>  
					 **/
					public void sortCostumerByAddres(){
						if(firstCostumer != null){
							boolean changed = true;
							while(changed) {
								Costumer current = firstCostumer;
								changed = false;
								while(current.getNext() != null) {
									Costumer next = current.getNext();
									if(current.getAddres().compareTo(next.getAddres())>0) {
										if(current.getPrevious()!=null) {
											current.getPrevious().setNext(next);
										}
										if(next.getNext()!=null) {
											next.getNext().setPrevious(current);
										}
										current.setNext(next.getNext());
										next.setPrevious(current.getPrevious());
										current.setPrevious(next);
										next.setNext(current);						
										if(current==firstCostumer) {
											firstCostumer = next;
										}
										changed = true;
									}else{
										current = current.getNext();
									}
								}
							}
						}
					}
					/**
					 ** this method return a file with the information of a object type Bill
					 ** @param a object type Bill. newBill != null
					 **/
					public void printReport(String path, Bill newBill) throws FileNotFoundException{
						PrintWriter pw = new PrintWriter(new File(path));
						
						String repStr = newBill.getReport();
						pw.print(repStr);
						
						pw.close();
					}
					/**
					 ** this method create objects type Distributor from a text file
					 ** @param the path of the text file. path != null
					 ** @param a String who indicate the separator of the text file. step != null
					 ** <b>post:</b> a news objects type Distributors was add to the liked list of Distributor</br>
					 **/
					public void generateDistributors(String path, String step) throws IOException {
						File file = new File(path);
						FileReader fileReader = new FileReader(file);
						BufferedReader br = new BufferedReader(fileReader);
						String line = br.readLine();
						line = br.readLine();
						int cont = 1;
						while(line != null){
							String[] temporalDataArray = line.split(step);
							Distributor temporalNewDistributor = new Distributor(temporalDataArray[0],temporalDataArray[1],temporalDataArray[2],temporalDataArray[3]);
							temporalNewDistributor.generateProducts("data//path"+cont," ,");
							addDistributor(temporalNewDistributor);
							cont++;
							line = br.readLine();
						}
						fileReader.close();
						br.close();	
					}
					/**
					 ** this method search a Distributor by name 
					 ** @param the name of the company. name != null
					 ** @return the object type Distributor of the liked list with the name given in the param
					 **/
					public Distributor searchingDistributorName(String name) throws NotFoundException{
						Distributor found = null;
						Distributor current = firstDistributor;
						boolean flag = false;
						while(current!=null && !flag){
							if(current.getCompanyName().equalsIgnoreCase(name)){
								found = current;
								flag = true;
							}
							current = current.getNext();
						}
						if(found == null) {
							throw new NotFoundException();
						}
						
						return found;
					}
					//nuevos m�todos
					/**
					 ** this method refresh the inventory if you add a new Distributor
					 **/
					public void actualInventory(){
						Distributor current = firstDistributor;
						if(refreshInventory){
							while(current!=null){
								for(int i = 0; i<current.getProductsToShow().size(); i++) {
									inventory.add(current.getProductsToShow().get(i));
								}
								current = current.getNext();
							}
							refreshInventory = false;
						}else {
							while(current.getNext()!=null) {
								current = current.getNext();
							}
							for(int i = 0; i<current.getProductsToShow().size(); i++) {
								inventory.add(current.getProductsToShow().get(i));
							}
						}
					}
					/**
					 ** this method add more products to the market inventory
					 ** <b>pre:</b> the param distributor had at last a code or companyName</br> 
					 ** @param the distributor selected. x!=null
					 ** @param the code of the product . code != null
					 ** @param the quantity of the order. quantity != null
					 **/
					public void getMoreProducts(Distributor x,int code, int quantity) {
						Distributor current = firstDistributor;
						boolean flag = false;
						while(current!= null && !flag) {
							if(current.getCode().equals(x.getCode()) || current.getCompanyName().equals(x.getCompanyName())) {
								for(int i=0; i<current.getProductsToShow().size();i++) {
									if(current.getProductsToShow().get(i).getCode() == code) {
										int newQuantity = current.getProductsToShow().get(i).getQuantity()+quantity;
										current.getProductsToShow().get(i).setQuantity(newQuantity);
										flag = true;
									}
								}
							}
						}
						for(int i = 0; i<inventory.size() && flag == true;i++) {
							if(inventory.get(i).getCode()==code) {
								int InventoryQuantity = inventory.get(i).getQuantity();
								inventory.get(i).setQuantity(InventoryQuantity+quantity);
							}
						}
					}
					/**
					 ** this method refresh the inventory after a sale
					 **/
					public void refreshInventoryAfterASale(Bill sale) {
						for(int i = 0; i<sale.getProductsBought().size();i++) {
							if(sale.getProductsBought().get(i).equals(inventory.get(i))){
								int quantity = inventory.get(i).getQuantity()-1;
								inventory.get(i).setQuantity(quantity);
							}
						}
					}
					/**
					 ** this method sort by name the list of products
					 ** <b>post:</b>the list of products was sorted by name </br>  
					 **/
					public void sortProductByName() {
						//TODO puede que el m�todo falle
						int n = inventory.size();
						for (int i = 0; i <= n; i++) {
							for (int j = 0; j < n - i - 1; j++){
								if (inventory.get(j+1).getName().compareTo(inventory.get(j).getName())<0){
									Product temp = inventory.get(j); 
									inventory.set(j,inventory.get(j+1));
									inventory.set(j+1,temp);
								}
							}
						}
					}
					/**
					 ** this method sort by price the list of products
					 ** <b>post:</b>the list of products was sorted by price </br>  
					 **/
					public void sortProductByPrice() {
						int n = inventory.size();
						for (int i = 0; i <= n; i++) {
							for (int j = 0; j < n - i - 1; j++){
								if (inventory.get(j+1).getPrice()<inventory.get(j).getPrice()){
									Product temp = inventory.get(j); 
									inventory.set(j,inventory.get(j+1));
									inventory.set(j+1,temp);
								}
							}
						}	
					}
					/**
					 ** this method sort by quantity the list of products
					 ** <b>post:</b>the list of products was sorted by quantity </br>  
					 **/
					public void sortProductByQuantity() {
						for (int I = 0; I < inventory.size()-1; I++) {
							int minPosition = I;
							for (int J = I+1; J < inventory.size() ; J++) {
								if(inventory.get(J).getQuantity() < inventory.get(minPosition).getQuantity()) {
									minPosition = J;
								}else if(inventory.get(J).getQuantity() == inventory.get(minPosition).getQuantity()){
									if(inventory.get(J).getQuantity()<inventory.get(minPosition).getQuantity()){
										minPosition = J; 
									}
								}
							}
							Product temp = inventory.get(minPosition);
							inventory.set(minPosition, inventory.get(I));
							inventory.set(I, temp);
						}
					}
					/**
					 ** this method sort by code the list of products
					 ** <b>post:</b>the list of products was sorted by code </br>  
					 **/
					public void sortProductByCode() {
						Product temp;
						for(int i=1;i < inventory.size();i++){
							for (int j=0 ; j < inventory.size()- 1; j++){
								if (inventory.get(j).getCode() > inventory.get(j+1).getCode()){
									temp = inventory.get(j);
									inventory.set(j, inventory.get(j+1));
									inventory.set(j+1, temp);
								}
							}
						}
					}
					/**
					 ** this method find a product by name 
					 ** @param the name of the product search. name != null
					 ** @return a int with the position of the object
					 **/
					public int searchingByName(String name) throws NotFoundException {
						int posFind = -1;
						boolean found = false;
						for(int i = 0; i<inventory.size() && !found; i++) {
							if(inventory.get(i).getName().equalsIgnoreCase(name)) {
								found = true;
								posFind = i;
							}
						}if(posFind == -1) {
							throw new NotFoundException();
						}
						return posFind;
					}
					/**
					 ** this method find a product by code 
					 ** @param the name of the product search. code != null
					 ** @return a int with the position of the object
					 **/
					public int searchingByCode(int code) throws NotFoundException  {
						int posFind = -1;
						boolean found = false;
						for(int i = 0; i<inventory.size() && !found; i++) {
							if(inventory.get(i).getCode()==code) {
								found = true;
								posFind = i;
							}
						}if(posFind == -1) {
							throw new NotFoundException();
						}
						return posFind;
					}
					

					
}
