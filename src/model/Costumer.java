package model;

import java.io.Serializable;

public class Costumer implements Serializable{		
		//Associations
			/**
	 		*this attribute contains previous Costumer in the liked list
	 		*/
			private Costumer previous;
			/**
	 		*this attribute contains next Costumer in the liked list
	 		*/
			private Costumer next;
		
		//Attributes
			/**
			 *this attribute contains the name of the costumer
			 */
			private String name;
			/**
			 *this attribute contains the id of the costumer
			 */
			private String id;
			/**
			 *this attribute contains the phone of the costumer
			 */
			private String phone;
			/**
			 *this attribute contains the address of the costumer
			 */
			private String addres;
			//nuevo attributo
			/**
			 * this attribute contains the points of the costumer
			 */
			private int points;
		
		//Methods
			//Builder
				/**
				*This is the constructor of the Costumer class
				*@param the name of the costumer. name != null
				*@param the code of the costumer. id != null
				*@param the phone of the costumer. phone != null
				*@param the address of the costumer. addres != null
				*/
				public Costumer(String name, String id, String phone, String addres){
					this.name = name;
					this.id = id;
					this.phone = phone;
					this.addres = addres;
				}
				

			//Getters
				/**
				 * this method allows get the previous position in the liked list
				 * @return Costumer
				 */
				public Costumer getPrevious() {
					return previous;
				}
				/**
				 * this method allows get the next object type Costumer from the linked list
				 * @return Costumer
				 */
				public Costumer getNext() {
					return next;
				}
				/**
				 *this method allows get the costumer name 
				 *@return the name attribute of the class
				 */
				public String getName() {
					return name;
				}
				/**
				 * this method allows get the costumer id 
				 * @return the id attribute of the class
				 */
				public String getId() {
					return id;
				}
				/**
				 * this method allows get the costumer phone 
				 * @return the phone attribute of the class
				 */
				public String getPhone() {
					return phone;
				}
				/**
				 * this method allows get the costumer address 
				 * @return the attribute addres of the class
				 */
				public String getAddres() {
					return addres;
				}
			
			//Setters

				/**
				 * this method allows change the relation with the previous object type Distributor of the linked list type Distributor
				 * @param previous
				 */
				public void setPrevious(Costumer previous) {
					this.previous = previous;
				}
				/**
				 * this method allows change the relation with the next object type Distributor of the linked list type Distributor
				 * @param next
				 */
				public void setNext(Costumer next) {
					this.next = next;
				}

				//m�todos nuevos
				public int getPoints() {
					return points;
				}

				public void setPoints(int points) {
					this.points = points;
				}
				
				public void actualPoints(int totalCost){
					points += (totalCost/500);
				}
}