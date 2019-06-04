package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import threads.*;
import customException.NotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Bill;
import model.Costumer;
import model.Distributor;
import model.Product;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class VentaController{

	private Stage stage;
    @FXML
    private ListView<String> listProducts;

    @FXML
    private TextField txtFldCodigoProducto;
   
    @FXML
    private Label costumerLabel;
    
    @FXML
    private Label lblClock;
    
    @FXML
    private ArrayList<Product> produtsBought;
    
    private ClockThread t;
    
    private String infoCostumer;
    
    public VentaController(){
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
    		if(search.getQuantity()>0){
    			System.out.println(search.getDescription());
    			produtsBought.add(search);
    			listProducts.getItems().add(search.getName()+" "+search.getCode()+" "+search.getPrice()+" "+search.getCategory().getDescription());
    		}else{
    			Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
    			alert.setContentText("No queda de este producto en el inventario");
    			alert.showAndWait();
    		}
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
    	produtsBought.clear();
    	listProducts.getItems().clear();
    	costumerLabel.setText(" ");
    	txtFldCodigoProducto.clear();
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
    	if(infoCostumer != null) {
    		newSale.setInfoCostumer(infoCostumer);
    	}
    	try {
			Main.getMarket().printReport("data/BillOne.txt", newSale);
			Main.getMarket().refreshInventoryAfterASale(newSale);
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
    @FXML
    void regisCostumer(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 400);
    	Label sing = new Label();
    	sing.setText("Introduce los datos del nuevo afiliafo");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	genericText.setPromptText("nombre del usuario");
    	javafx.scene.control.TextField genericText1 = new javafx.scene.control.TextField();
    	genericText1.setPromptText("id del usuario");
    	javafx.scene.control.TextField genericText2 = new javafx.scene.control.TextField();
    	genericText2.setPromptText("Telefono del usurio");
    	javafx.scene.control.TextField genericText3 = new javafx.scene.control.TextField();
    	genericText3.setPromptText("correo electronico del usuario");
    	generic.getChildren().addAll(genericText,genericText1,genericText2,genericText3);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){  	
    			Main.getMarket().addCostumer(new Costumer(genericText.getText(), genericText1.getText(), genericText2.getText(), genericText3.getText()));		
    			costumerLabel.setText("Cliente: "+genericText.getText()+" id: "+genericText1.getText()+" phone: "+genericText2.getText()+"email: "+genericText3.getText());
    			infoCostumer = genericText.getText()+","+genericText1.getText()+","+genericText2.getText()+","+genericText3.getText();
    			genericStage.close();
    		}
    	
    	});
    }

    @FXML
    void searchCostumer(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the code of the costumer to find");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	generic.getChildren().add(genericText);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){
    			Costumer find;
				try {
					find = Main.getMarket().searchingCostumerById(genericText.getText());
					String costumerInfo = find.getName()+","+find.getId()+","+find.getPhone()+","+find.getAddres();
					costumerLabel.setText("name: "+find.getName()+" code:"+find.getId()+" telefono:"+find.getPhone()+" email: "+find.getAddres());
					infoCostumer = costumerInfo;
	    			genericStage.close();
				} catch (NotFoundException e) {
					Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Error");
		    		alert.setHeaderText(null);
					alert.setContentText("el cliente no esta en la lista");
					alert.showAndWait();
					
					e.printStackTrace();
				}   			
    		}
    	
    	});
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