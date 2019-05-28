package model;

public class Manager {
	
	//Associations
		public Market manager;
	
	//Attributes
		private String name;
		private int id;
		private String password;
		private String address;
	
	//Methods
		//Builder
			public Manager(String name, int id, String password, String address, Market manager) {
				this.name = name;
				this.id = id;
				this.password = password;
				this.address = address;
				this.manager = manager;
			}
		//Getters
			public Market getManager() {
				return manager;
			}
	
			public String getName() {
				return name;
			}
	
			public int getId() {
				return id;
			}
	
			public String getPassword() {
				return password;
			}
	
			public String getAddress() {
				return address;
			}
				
			
		//Setters
			public void setManager(Market manager) {
				this.manager = manager;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			public void setId(int id) {
				this.id = id;
			}
			
			public void setPassword(String password) {
				this.password = password;
			}
			
			public void setAddress(String address) {
				this.address = address;
			}

}