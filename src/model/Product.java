package model;

public class Product implements Comparable<Product>{

	//Associations
		private Category category;
		private Product right;
		private Product left;
	
	//Attributes
		private String name;
		private String description;
		private int code;
		private double price;
		private int quantity;
		
	//Methods
		//Builder
			public Product(Category category, String name, String description, int code, double price, int quantity){
				this.category =category; 
				this.name = name;
				this.description = description;
				this.code = code;
				this.price = price;
				this.quantity = quantity;
			}
		
		//Getters
			public Category getCategory() {
				return category;
			}

			public Product getRight() {
				return right;
			}

			public Product getLeft() {
				return left;
			}

			public String getName() {
				return name;
			}

			public String getDescription() {
				return description;
			}

			public int getCode() {
				return code;
			}

			public double getPrice() {
				return price;
			}

			public int getQuantity() {
				return quantity;
			}

		//Setters
			public void setCategory(Category category) {
				this.category = category;
			}

			public void setRight(Product right) {
				this.right = right;
			}

			public void setLeft(Product left) {
				this.left = left;
			}

			public void setName(String name) {
				this.name = name;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public void setCode(int code) {
				this.code = code;
			}

			public void setPrice(double price) {
				this.price = price;
			}

			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}

		//Operational
			@Override
			public int compareTo(Product arg0){
				int resul = 0;
				if(name.compareTo(arg0.getName())>0) {
					resul = 1;
				}else if(name.compareTo(arg0.getName())<0) {
					resul = -1;
				}else {
					resul = 0;
				}
				return resul;
			}
}