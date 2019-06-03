package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import threads.*;
import customException.NotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Bill;
import model.Product;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class VentaController{

    @FXML
    private ListView<String> listProducts;

    @FXML
    private TextField txtFldCodigoProducto;
    
    @FXML
    private Label lblClock;
    
    @FXML
    private ArrayList<Product> produtsBought;
    
    private ClockThread t;
    
    public VentaController() {
    	lblClock = new Label();
    	startClock();
    }
    
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
    	/**try {
			t.join();
			t.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
    	
    }
    
    @FXML
    void goBackLogin(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(("Login.fxml")));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
    }

    
    public void startClock() {
    	t = new ClockThread(this);
    	t.start();
    }
    
    public void updateTime(String time) {
    	lblClock.setText(time);
    }
    
    @FXML
    void initialize() {
		produtsBought = new ArrayList<Product>();
		
	}
}