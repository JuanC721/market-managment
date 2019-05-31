package model;
import java.util.ArrayList;
import java.util.Date;
public class Bill implements Comparable<Bill>{
	
	//Associations
			/**
	 		** this attribute contains the name of the costumer
	 		**/
			private Date dateOfSale;
			/**
			** this attribute contains the right object in the binary search tree type Bill
			**/
			private Bill right;
			/**
			** this attribute contains the left object in the binary search tree type Bill
			**/
			private Bill left;
			/**
			 ** this attribute contains a list with all the items bought
			 **/
			private ArrayList<Product> productsBought;
		
		//Attributes
			/**
			 ** this attribute contains the hour of the sale of the product/s in the Bill
			 **/
			private int hourOfSale;
			/**
			 ** this attribute contains the minute of sale of the product/s in the bill
			 **/
			private int minuteOfSale;
			/**
			 ** this attribute contains the total cost of products in the bill
			 **/
			private double cost;
		
		
		//Methods
			//Builder
				/**
				**This is the constructor of the Costumer class
				**@param the date of the sale. dateOfSale != null
				**@param the hour of the sale. hourOfSale != null
				**@param the minute of the sale. minuteOfSale != null
				**@param the total cost of the sale. cost != null
				**/
				public Bill(Date dateOfSale, int hourOfSale, int minuteOfSale) {
					this.dateOfSale = dateOfSale;
					this.hourOfSale = hourOfSale;
					this.minuteOfSale = minuteOfSale;
					this.productsBought = new ArrayList<Product>();
				}
			
			//Getters
				/**
				 * this method allows get the date of sale 
				 * @return the attribute dateOfTheSale of the clas
				 */
				public Date getDateOfSale() {
					return dateOfSale;
				}
				/**
				 * this attribute contains the right object in the binary search tree type Product
				 * @return the attribute right of the class
				 */
				public Bill getRight() {
					return right;
				}
				/**
				 * this attribute contains the left object in the binary search tree type Product
				 * @return the attribute left of the class
				 */
				public Bill getLeft() {
					return left;
				}
				/**
				 * this method allows get the list of the products bought 
				 * @return the attribute productdBought of the class
				 */
				public ArrayList<Product> getProductsBought() {
					return productsBought;
				}
				/**
				 * this method allows get the hour of sale
				 * @return the attribute hourOfSale of the class
				 */
				public int getHourOfSale() {
					return hourOfSale;
				}
				/**
				 * this method allows get the minute of sale 
				 * @return the attribute minuteOfSale of the class
				 */
				public int getMinuteOfSale() {
					return minuteOfSale;
				}
				/**
				 * this method allows get the total cost of sale 
				 * @return the attribute cost of the class
				 */
				public double getCost() {
					return cost;
				}

			//Setters
				/**
				 * this method allows change date of the sale
				 * @param dateOfSale != null.
				 */
				public void setDateOfSale(Date dateOfSale) {
					this.dateOfSale = dateOfSale;
				}
				/**
				 * this method allows change right object in the binary search tree
				 * @param right != null.
				 */ 
				public void setRight(Bill right) {
					this.right = right;
				}
				/**
				 * this method allows change left object in the binary search tree 
				 * @param left != null.
				 */
				public void setLeft(Bill left) {
					this.left = left;
				}
				/**
				 * this method allows change the hour of the sale
				 * @param hourOfSale != null.
				 */
				public void setHourOfSale(int hourOfSale) {
					this.hourOfSale = hourOfSale;
				}
				/**
				 * this method allows change the minute of the sale
				 * @param minuteOfSale != null.
				 */
				public void setMinuteOfSale(int minuteOfSale) {
					this.minuteOfSale = minuteOfSale;
				}
				/**
				 * this method allows change the total cost of the sale
				 * @param cost != null.
				 */
				public void setCost(double cost) {
					this.cost = cost;
				}
			
			//Operational
				/**
				 ** this method allows compare two objects type Bill and return a number indicating who goes first and who goes last
				 ** @param a Bill to compare. arg0 != null
				 ** @return return 1 if the the actual Bill goes first, return -1 if the actual Bill goes last, return 0 if the Bills are the same
				 **/
				@Override
				public int compareTo(Bill arg0) {
					// TODO Auto-generated method stub
					int resul = 0;
					if(hourOfSale>arg0.getHourOfSale()) {
						resul = 1;
					}else if(hourOfSale<arg0.getHourOfSale()) {
						resul = -1;
					}else {
						if(minuteOfSale>arg0.minuteOfSale) {
							resul = 1;
						}else if(minuteOfSale<arg0.minuteOfSale) {
							resul = -1;
						}else {
							resul = 0;
						}
					}
					return resul;
				}
	
				/**
				 ** this method do a report of all the attributes of the Bill
				 ** @return a String with all the attributes of the Bill
				 **/
				public String getReport() {
					String retu = "";
					String products = "";
					for(int i = 0; i<productsBought.size();i++) {
						products += i+1+". "+productsBought.get(i).getName()+"\n";
					}
					retu = "cost:"+cost+"products:\n"+products+"date of sale:"+dateOfSale.toString();
					return retu;
				}
				/**
				 ** this method calculate the total cost of the products bought
				 ** @return the total price of the products in the sale
				 **/
				 public void totalCost() {
					 double total = 0;
					 for(int i = 0; i<productsBought.size();i++) {
					 	total += productsBought.get(i).getPrice();
					 }					 
					 cost= total;
				 }
				 //nuevo
				 
				 public void f(){
					 for(int i = 0; i<productsBought.size();i++) {
						 System.out.println(productsBought.get(i).getCode());
					 }
					 System.out.println(cost);
				 }
				 


	
}