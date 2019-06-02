package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

import customException.NotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Bill;
import model.Product;
import javafx.scene.control.Alert.AlertType;

public class VentaController{

    @FXML
    private ListView<String> listProducts;

    @FXML
    private TextField txtFldCodigoProducto;
    
    private ArrayList<Product> produtsBought;
    @FXML
    void addProduct(ActionEvent event){
    	try {
    		Main.getMarket().actualInventory();
    		Main.getMarket().f();
			int positionProduct = Main.getMarket().searchingByCode(Integer.parseInt(txtFldCodigoProducto.getText()));
			Product search = Main.getMarket().getInventory().get(positionProduct);
			System.out.println(search.getDescription());
			produtsBought.add(search);
			listProducts.getItems().add(search.getName()+" "+search.getCode()+" "+search.getPrice()+" "+search.getCategory().getDescription());
			
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
			alert.setContentText("el formato es incorrecto");
			alert.showAndWait();
			e.printStackTrace();
		} catch (NotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
			alert.setContentText("el producto no esta en la lista");
			alert.showAndWait();
			e.printStackTrace();
		}
    }

    @FXML
    void deleteProduct(ActionEvent event){
    	
    }

    @FXML
    void editProduct(ActionEvent event){

    }

    @FXML
    void finishBill(ActionEvent event){
    	Date actual = new Date();
    	Bill newSale = new Bill(actual,actual.getHours(),actual.getMinutes());
    	newSale.setProductsBought(produtsBought);
    	Main.getMarket().addBill(newSale);
    	newSale.totalCost();
    	String totalCost = newSale.getCost()+"";
    	listProducts.getItems().add(totalCost);
    	try {
			Main.getMarket().printReport("data/BillOne.txt", newSale);
		} catch (FileNotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
			alert.setContentText("el recibo no pudo ser creado");
			alert.showAndWait();
			e.printStackTrace();
			e.printStackTrace();
		}
    }
    @FXML
    void initialize() {
		produtsBought = new ArrayList<Product>();
	}
}