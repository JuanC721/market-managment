package model;

public class Product implements Comparable<Product>{
	//Associations
			
			private Category category;
			/*
			* this attribute contains the right object in the binary search tree type Product
			*/
			private Product right;
			/*
			* this attribute contains the left object in the binary search tree type Product
			*/
			private Product left;
		
		//Attributes
			/*
			 * this attribute contains the name of the product
			 */
			private String name;
			/*
			 * this attribute contains the description of the product
			 */
			private String description;
			/*
			 * this attribute contains the code of the product
			 */
			private int code;
			/*
			 * this attribute contains the price of the product
			 */
			private double price;
			/*
			 * this attribute contains the quantity of the product
			 */
			private int quantity;
			
		//Methods
			//Builder
			/*
			*This is the constructor of the Product class
			*@param the name of the distributor company. companyName != null
			*@param the code of the company. code != null
			*@param the name of the manager in the distributor company. distributorManagerName != null
			*@param the phone of the distributor company. distributorPhone != null
			*/
				public Product(Category category, String name, String description, int code, double price, int quantity){
					this.category =category; 
					this.name = name;
					this.description = description;
					this.code = code;
					this.price = price;
					this.quantity = quantity;
				}
			
			//Getters
				// no se como hacerlo, jaja salu2
				public Category getCategory() {
					return category;
				}
				/*
				 * this method allows get right object in the binary search tree 
				 */
				public Product getRight() {
					return right;
				}
				/*
				 * this method allows get left object in the binary search tree 
				 */
				public Product getLeft() {
					return left;
				}
				/*
				 * this method allows get the name of the product
				 */
				public String getName() {
					return name;
				}
				/*
				 * this method allows get the description of the product
				 */
				public String getDescription() {
					return description;
				}
				/*
				 * this method allows get the code of the product
				 */
				public int getCode() {
					return code;
				}
				/*
				 * this method allows get the price of the product
				 */
				public double getPrice() {
					return price;
				}
				/*
				 * this method allows get the quantity of the product
				 */
				public int getQuantity() {
					return quantity;
				}

			//Setters
				
				public void setCategory(Category category) {
					this.category = category;
				}
				/*
				 * this method allows change the right position in the binary search tree 
				 */
				public void setRight(Product right) {
					this.right = right;
				}
				/*
				 * this method allows change the left position in the binary search tree 
				 */
				public void setLeft(Product left) {
					this.left = left;
				}
				/*
				 * this method allows change the name of the product
				 */
				public void setName(String name) {
					this.name = name;
				}
				/*
				 * this method allows change the description of the product
				 */
				public void setDescription(String description) {
					this.description = description;
				}
				/*
				 * this method allows change the code of the product
				 */
				public void setCode(int code) {
					this.code = code;
				}
				/*
				 * this method allows change the price of the product
				 */
				public void setPrice(double price) {
					this.price = price;
				}
				/*
				 * this method allows change the quantity of the product
				 */
				public void setQuantity(int quantity) {
					this.quantity = quantity;
				}

			//Operational
				/*
				 * this method allows compare two objects type Product and return a number indicating who goes first and who goes last
				 * @param a product to compare. arg0 != null
				 * @return return 1 if the the actual product goes first, return -1 if the actual product goes last, return 0 if the products are the same
				 */
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