package main;

import customException.EmptyFieldException;
import customException.IncorrectPassWordException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Distributor;

public class LoginController {

    @FXML
    private Label lblWelcome;

    @FXML
    private TextField txtFldUserName;

    @FXML
    private TextField txtFldPassword;
    
    static TableView<Distributor> f;
    @FXML
    void ingresarInfoAdmin(ActionEvent event) {
    	try {
    		if(validateInfoAdmin()) {
    			try {
    				initializate();
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
    		
    	}catch(EmptyFieldException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}catch(IncorrectPassWordException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}catch(Exception e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error xd");
    		alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    	
    }
    
    public boolean validateInfoAdmin() throws EmptyFieldException, Exception, IncorrectPassWordException{
    	boolean valid = true;
    	//Chequeo si el ID ingresado es valido
    		if(txtFldUserName.getText().isEmpty()) {
    			valid = false;
    			throw new EmptyFieldException("ID", "El usuario es el ID del manager");
    		}else if( !(txtFldUserName.getText().equals(String.valueOf(Main.getMarket().getManager().getId()))) ) {
    			valid = false;
    			throw new Exception("error");
    		}
    	//Chequeo si la contraseña ingresada es valida
    		if(txtFldPassword.getText().isEmpty()) {
    			valid = false;
    			throw new EmptyFieldException("Contraseña");
    		}else if( !(txtFldPassword.getText().equals(Main.getMarket().getManager().getPassword())) ) {
    			valid = false;
    			throw new IncorrectPassWordException(IncorrectPassWordException.INCORRECT_INPUT);
    		}
    	return valid;
    }

    @FXML
    void openSellsWindow(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(("Venta.fxml")));
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
    //nuevos metodos
    
    public void initializate(){
    	TableView<Distributor> listDistributors = new TableView<Distributor>();
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
    	f = listDistributors;
    }
}