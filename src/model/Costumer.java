package model;

public class Costumer {		
		//Associations
			/*
	 		* this attribute contains previous Costumer in the liked list
	 		*/
			private Costumer previous;
			/*
	 		* this attribute contains next Costumer in the liked list
	 		*/
			private Costumer next;
		
		//Attributes
			/*
			 * this attribute contains the name of the costumer
			 */
			private String name;
			/*
			 * this attribute contains the id of the costumer
			 */
			private String id;
			/*
			 * this attribute contains the phone of the costumer
			 */
			private int phone;
			/*
			 * this attribute contains the address of the costumer
			 */
			private String addres;
		
		//Methods
			//Builder
				/*
				*This is the constructor of the Costumer class
				*@param the name of the costumer. name != null
				*@param the code of the costumer. id != null
				*@param the phone of the costumer. phone != null
				*@param the address of the costumer. addres != null
				*/
				public Costumer(String name, String id, int phone, String addres) {
					this.name = name;
					this.id = id;
					this.phone = phone;
					this.addres = addres;
				}
				

			//Getters
				/*
				 * this method allows get the previous object type Costumer from the linked list
				 */
				public Costumer getPrevious() {
					return previous;
				}
				/*
				 * this method allows get the next object type Costumer from the linked list
				 */
				public Costumer getNext() {
					return next;
				}
				/*
				 * this method allows get the costumer name 
				 */
				public String getName() {
					return name;
				}
				/*
				 * this method allows get the costumer id 
				 */
				public String getId() {
					return id;
				}
				/*
				 * this method allows get the costumer phone 
				 */
				public int getPhone() {
					return phone;
				}
				/*
				 * this method allows get the costumer addres 
				 */
				public String getAddres() {
					return addres;
				}
			
			//Setters

				/*
				 * this method allows change the relation with the previous object type Distributor of the linked list type Distributor
				 */
				public void setPrevious(Costumer previous) {
					this.previous = previous;
				}
				/*
				 * this method allows change the relation with the next object type Distributor of the linked list type Distributor
				 */
				public void setNext(Costumer next) {
					this.next = next;
				}
}