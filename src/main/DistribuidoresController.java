package main;

import java.io.IOException;

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
import model.Distributor;

public class DistribuidoresController {

	private Stage stage;
    @FXML
    private Label lblProductsOf;

    @FXML
    private TableView<Distributor> listDistributors;

	@FXML
    void addDistributor(ActionEvent event) {

    }
    private static Distributor distributorToShow;
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
    void showDistributorSelectedProducts(ActionEvent event){
    	if(listDistributors.getSelectionModel().isEmpty()) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Debe seleccionar primero distribuidor");
			alert.showAndWait();
    	}
    	else {
    		distributorToShow = listDistributors.getSelectionModel().getSelectedItem();
    		try {
    			FXMLLoader loader = new FXMLLoader();
    			loader.setLocation(getClass().getResource(("ProductsOfADistributor.fxml")));
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
    }
    
    @FXML
    void refresh(ActionEvent event) {
    	listDistributors.getItems().clear();
//    	COLUMNA DE CODIGO
    	TableColumn<Distributor, String> codeColumn = new TableColumn<>("Codigo");
    	codeColumn.setMinWidth(100);
    	codeColumn.setCellValueFactory(new PropertyValueFactory<Distributor, String>("code"));
//		COLUMNA DE COMPAÑIA
    	TableColumn<Distributor, String> companyColumn = new TableColumn<>("Compañia");
    	companyColumn.setMinWidth(100);
    	companyColumn.setCellValueFactory(new PropertyValueFactory<Distributor, String>("companyName"));
//    	COLUMNA DE MANAGER
    	TableColumn<Distributor, String> managerColumn = new TableColumn<>("Administrador");
    	managerColumn.setMinWidth(100);
    	managerColumn.setCellValueFactory(new PropertyValueFactory<Distributor, String>("distributorManagerName"));
//   	COLUMNA DE TELEFONO
    	TableColumn<Distributor, String> phoneColumn = new TableColumn<>("telefono");
    	phoneColumn.setMinWidth(100);
    	phoneColumn.setCellValueFactory(new PropertyValueFactory<Distributor, String>("distributorPhone"));
    	listDistributors.getColumns().addAll(codeColumn,companyColumn,managerColumn,phoneColumn);
    	Main.getMarket().distributorToArrayList();
    	ObservableList<Distributor> x = FXCollections.observableArrayList(Main.getMarket().getDistributorsToShow());
    	listDistributors.setItems(x);
    }
    @FXML
    void searchCode(ActionEvent event) {
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
//    			initTime = System.currentTimeMillis();
    			Distributor find;
				try {
					find = Main.getMarket().searchingDistributorCode(genericText.getText());
	    			ObservableList<Distributor> x = FXCollections.observableArrayList(find);
	    			listDistributors.setItems(x);
	    			genericStage.close();
				} catch (NotFoundException e) {
					Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Error");
		    		alert.setHeaderText(null);
					alert.setContentText("el distribuidor no esta en la lista");
					alert.showAndWait();
					e.printStackTrace();
					e.printStackTrace();
				}
    			
//    			endTime = System.currentTimeMillis();
//    			AlertTime();    			
    		}
    	
    	});
    }

    @FXML
    void searchName(ActionEvent event) {
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
//    			initTime = System.currentTimeMillis();
    			Distributor find;
				try {
					find = Main.getMarket().searchingDistributorName(genericText.getText());
	    			ObservableList<Distributor> x = FXCollections.observableArrayList(find);
	    			listDistributors.setItems(x);
	    			genericStage.close();
				} catch (NotFoundException e) {
					Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Error");
		    		alert.setHeaderText(null);
					alert.setContentText("el distribuidor no esta en la lista");
					alert.showAndWait();
					
					e.printStackTrace();
				}
//    			endTime = System.currentTimeMillis();
//    			AlertTime();    			
    		}
    	
    	});
    }
    
    @FXML
    void sortDistributorsByCode(ActionEvent event) {
    	Main.getMarket().sortDistributorByCode();
    	Main.getMarket().distributorToArrayList();
    	ObservableList<Distributor> x = FXCollections.observableArrayList(Main.getMarket().getDistributorsToShow());
    	listDistributors.setItems(x);
    }

    @FXML
    void sortDistributorsByCompany(ActionEvent event) {
    	Main.getMarket().sortDistributorByName();
    	Main.getMarket().distributorToArrayList();
    	ObservableList<Distributor> x = FXCollections.observableArrayList(Main.getMarket().getDistributorsToShow());
    	listDistributors.setItems(x);
    }
   
    public TableView<Distributor> getListDistributors() {
 		return listDistributors;
 	}

 	public void setListDistributors(TableView<Distributor> listDistributors) {
 		this.listDistributors = listDistributors;
 	}

	public static Distributor getDistributorToShow() {
		return distributorToShow;
	}

	public static void setDistributorToShow(Distributor distributorToShow) {
		DistribuidoresController.distributorToShow = distributorToShow;
	}
}
