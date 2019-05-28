package model;

public class Costumer {
	
	//Associations
		private Costumer previous;
		private Costumer next;
	
	//Attributes
		private String name;
		private String id;
		private int phone;
		private String addres;
	
	//Methods
		//Builder
			public Costumer(String name, String id, int phone, String addres) {
				this.name = name;
				this.id = id;
				this.phone = phone;
				this.addres = addres;
			}

			public Costumer getPrevious() {
				return previous;
			}

			public Costumer getNext() {
				return next;
			}

			public String getName() {
				return name;
			}

			public String getId() {
				return id;
			}

			public int getPhone() {
				return phone;
			}

			public String getAddres() {
				return addres;
			}

		//Getters
			
}