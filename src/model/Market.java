package model;

public class Market {
	
	//Associations
		private Manager manager;
		private Distributor firstDistributor;
		private Costumer firstCostumer;
		private Bill billsRoot;
		
	//Attributes
		private String MarketName;
		private int nit;
		private int phone;
		private String addres;
		private String emailAddress;
		
	//Methods
		//Builder
			public Market(String MarketName, int nit, int phone, String addres, String emailAddress, Manager manager){
				this.MarketName = MarketName;
				this.nit = nit;
				this.phone = phone;
				this.addres = addres;
				this.emailAddress = emailAddress;
				this.manager = manager;
			}
	
		//Getters
			public Manager getManager() {
				return manager;
			}
			
			public Distributor getFirstDistributor() {
				return firstDistributor;
			}
		
			public Costumer getFirstCostumer() {
				return firstCostumer;
			}
		
			public Bill getBillsRoot() {
				return billsRoot;
			}
		
			public String getMarketName() {
				return MarketName;
			}
		
			public int getNit() {
				return nit;
			}
		
			public int getPhone() {
				return phone;
			}
		
			public String getAddres() {
				return addres;
			}
		
			public String getemailAddress() {
				return emailAddress;
			}
		
		//Setters
			public void setManager(Manager manager) {
				this.manager = manager;
			}
			
			public void setFirstDistributor(Distributor firstDistributor) {
				this.firstDistributor = firstDistributor;
			}
	
			public void setFirstCostumer(Costumer firstCostumer) {
				this.firstCostumer = firstCostumer;
			}
		
			public void setBillsRoot(Bill billsRoot) {
				this.billsRoot = billsRoot;
			}
		
			public void setMarketName(String MarketName) {
				this.MarketName = MarketName;
			}
		
			public void setNit(int nit) {
				this.nit = nit;
			}
		
			public void setPhone(int phone) {
				this.phone = phone;
			}
		
			public void setAddres(String addres) {
				this.addres = addres;
			}
		
			public void setEmailAddress(String emailAddress) {
				this.emailAddress = emailAddress;
			}
		
		//Operational
		
}