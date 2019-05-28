package model;

import java.util.ArrayList;

public class Distributor {

	//Associations
		private Distributor next;
		private Distributor previous;
		private Product root;
	
	//Attributes
		private String companyName;
		private String code;
		private String distributorManagerName;
		private String distributorPhone;
		private ArrayList<Product> productsToShow;
	//Methods
		//Builder
			public Distributor(String companyName, String code, String distributorManagerName, String distributorPhone) {
				this.companyName = companyName;
				this.code = code;
				this.distributorManagerName = distributorManagerName;
				this.distributorPhone = distributorPhone;
			}
		
		//Getters
			public Distributor getNext() {
				return next;
			}
			
			public Distributor getPrevious() {
				return previous;
			}
			
			public Product getRoot() {
				return root;
			}
			
			public String getCompanyName() {
				return companyName;
			}
			
			public String getCode() {
				return code;
			}
			
			public String getDistributorManagerName() {
				return distributorManagerName;
			}
			
			public String getDistributorPhone() {
				return distributorPhone;
			}
			
			public ArrayList<Product> getProductsToShow() {
				return productsToShow;
			}

			

		//Setters
			public void setNext(Distributor next) {
				this.next = next;
			}

			public void setPrevious(Distributor previous) {
				this.previous = previous;
			}

			public void setRoot(Product root) {
				this.root = root;
			}

			public void setCompanyName(String companyName) {
				this.companyName = companyName;
			}

			public void setCode(String code) {
				this.code = code;
			}

			public void setDistributorManagerName(String distributorManagerName) {
				this.distributorManagerName = distributorManagerName;
			}

			public void setDistributorPhone(String distributorPhone) {
				this.distributorPhone = distributorPhone;
			}

		//Operational
}