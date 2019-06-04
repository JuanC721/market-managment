package main;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Category;
import model.Distributor;
import model.Product;

public class InventoryController {

	private Stage stage;
    @FXML
    private Label lblProductsOf;

    @FXML
    private TableView<Product> listInventory;

    @FXML
    void goBackAdministratorMenu(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(("MenuAdministrador.fxml")));
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
    void refresh(ActionEvent event) {
    	Main.getMarket().actualInventory();
    	listInventory.getItems().clear();
//    	COLUMNA DE NOMBRE
    	TableColumn<Product, String> nameColumn = new TableColumn<>("Nombre");
    	nameColumn.setMinWidth(100);
    	nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
//    	COLUMNA DE CODIGO
    	TableColumn<Product, String> codeColumn = new TableColumn<>("Codigo");
    	codeColumn.setMinWidth(100);
    	codeColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("code"));
//   	COLUMNA DE PRECIO
    	TableColumn<Product, String> priceColumn = new TableColumn<>("Precio");
    	priceColumn.setMinWidth(100);
    	priceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
//    	COLUMNA DE CANTIDAD
    	TableColumn<Product, String> quantityColumn = new TableColumn<>("Cantidad");
    	quantityColumn.setMinWidth(100);
    	quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));
    	listInventory.getColumns().addAll(nameColumn,codeColumn,priceColumn,quantityColumn);
    	Main.getMarket().distributorToArrayList();
    	ObservableList<Product> x = FXCollections.observableArrayList(Main.getMarket().getInventory());
    	listInventory.setItems(x);
    }

    @FXML
    void searchInventoryByCode(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the code of the distributor to find");
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
    		;
				try {
					int found = Main.getMarket().searchingByCode(Integer.parseInt(genericText.getText()));
	    			ObservableList<Product> x = FXCollections.observableArrayList(Main.getMarket().getInventory().get(found));
	    			listInventory.setItems(x);
	    			genericStage.close();
				} catch (NotFoundException e) {
					Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Error");
		    		alert.setHeaderText(null);
					alert.setContentText("el producto no esta en la lista");
					alert.showAndWait();
					
					e.printStackTrace();
				}
    			 			
    		}
    	
    	});
    }

    @FXML
    void searchInventoryByName(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the code of the distributor to find");
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
    		;
				try {
					int found = Main.getMarket().searchingByName(genericText.getText());
	    			ObservableList<Product> x = FXCollections.observableArrayList(Main.getMarket().getInventory().get(found));
	    			listInventory.setItems(x);
	    			genericStage.close();
				} catch (NotFoundException e) {
					Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Error");
		    		alert.setHeaderText(null);
					alert.setContentText("el producto no esta en la lista");
					alert.showAndWait();
					
					e.printStackTrace();
				}
    			 			
    		}
    	
    	});
    }

    @FXML
    void sortInventoryByCode(ActionEvent event) {
    	Main.getMarket().actualInventory();
    	Main.getMarket().sortProductByCode();
    	ObservableList<Product> x = FXCollections.observableArrayList(Main.getMarket().getInventory());
    	listInventory.setItems(x);
    }

    @FXML
    void sortInventoryByName(ActionEvent event) {
    	Main.getMarket().actualInventory();
    	Main.getMarket().sortProductByName();;
    	ObservableList<Product> x = FXCollections.observableArrayList(Main.getMarket().getInventory());
    	listInventory.setItems(x);
    }
    @FXML
    void sortInventoryByPrice(ActionEvent event) {
    	Main.getMarket().actualInventory();
    	Main.getMarket().sortProductByPrice();
    	ObservableList<Product> x = FXCollections.observableArrayList(Main.getMarket().getInventory());
    	listInventory.setItems(x);
    }

    @FXML
    void sortInventoryByQuantity(ActionEvent event) {
    	Main.getMarket().actualInventory();
    	Main.getMarket().sortProductByQuantity();
    	ObservableList<Product> x = FXCollections.observableArrayList(Main.getMarket().getInventory());
    	listInventory.setItems(x);
    }


}
