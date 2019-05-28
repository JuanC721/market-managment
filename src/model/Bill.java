package model;

import java.util.ArrayList;
import java.util.Date;

public class Bill implements Comparable<Bill>{
	//Associations
		private Date dateOfSale;
		private Bill right;
		private Bill left;
		private ArrayList<Product> productsBought;
	
	//Attributes
		private int hourOfSale;
		private int minuteOfSale;
		private double cost;
	
	
	//Methods
		//Builder
			public Bill(Date dateOfSale, int hourOfSale, int minuteOfSale, double cost) {
				this.dateOfSale = dateOfSale;
				this.hourOfSale = hourOfSale;
				this.minuteOfSale = minuteOfSale;
				this.cost = cost;
			}
		
		//Getters
			public Date getDateOfSale() {
				return dateOfSale;
			}

			public Bill getRight() {
				return right;
			}

			public Bill getLeft() {
				return left;
			}

			public ArrayList<Product> getProductsBought() {
				return productsBought;
			}

			public int getHourOfSale() {
				return hourOfSale;
			}

			public int getMinuteOfSale() {
				return minuteOfSale;
			}

			public double getCost() {
				return cost;
			}

		//Setters
			public void setDateOfSale(Date dateOfSale) {
				this.dateOfSale = dateOfSale;
			}

			public void setRight(Bill right) {
				this.right = right;
			}

			public void setLeft(Bill left) {
				this.left = left;
			}

			public void setHourOfSale(int hourOfSale) {
				this.hourOfSale = hourOfSale;
			}

			public void setMinuteOfSale(int minuteOfSale) {
				this.minuteOfSale = minuteOfSale;
			}

			public void setCost(double cost) {
				this.cost = cost;
			}
		
		//Operational
			@Override
			public int compareTo(Bill arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
	
}