package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import customException.*;

public class CreacionMarketController {

    @FXML
    private TextField txtFldName;

    @FXML
    private TextField txtFldNit;

    @FXML
    private TextField txtFldPhone;

    @FXML
    private TextField txtFldAddress;

    @FXML
    private TextField txtFldEmail; 
    
    @FXML
    void createMarket(ActionEvent event) {
	    	try {
    			if(validateMarketData()) {
	    			initializateMarket();
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
	    		}else {
	    			cleanFields();
	    			
	    		}
	    	}catch(EmptyFieldException e) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Error");
	    		alert.setHeaderText(null);
				alert.setContentText(e.getMessage());
				alert.showAndWait();
	    	}catch(FieldTypedIncorrectly e) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Error");
	    		alert.setHeaderText(null);
				alert.setContentText(e.getMessage());
				alert.showAndWait();
	    	}
    }
    
    public void initializateMarket() {
    	String MarketName = txtFldName.getText();
    	int nit = Integer.parseInt(txtFldNit.getText());
    	int phone = Integer.parseInt(txtFldPhone.getText());
    	String address = txtFldAddress.getText();
    	String email = txtFldEmail.getText();
    	
 
    	Main.getMarket().setMarketName(MarketName);
    	Main.getMarket().setNit(nit);
    	Main.getMarket().setPhone(phone);
    	Main.getMarket().setAddres(address);
    	Main.getMarket().setEmailAddress(email);
    }

    public boolean validateMarketData() throws EmptyFieldException, FieldTypedIncorrectly, EmptyFieldException{
    	boolean isValid = true;
    	//Chequeo si el nombre del Market ingresado es valido
    	if(txtFldName.getText().isEmpty()) {
    		isValid = false;
    		throw new EmptyFieldException("Nombre");
    	}
    	
	//Chequeo si el nit ingresado es valido
    	if(txtFldNit.getText().isEmpty() ) {
    		isValid = false;
    		throw new EmptyFieldException("Nit");
    	}else if(checkIfIsFreeOfCaractersOrHaveSpaces(txtFldNit.getText())){
    		isValid = false;
    		throw new FieldTypedIncorrectly("Nit", "Este debe contener unicamente numeros sin espacios");
    	}
	
	//Chequeo si el telefono ingresado es valido
    	if(txtFldPhone.getText().isEmpty()) {
    		isValid = false;
    		throw new EmptyFieldException("Telefono");
    	}else if(checkIfIsFreeOfCaractersOrHaveSpaces(txtFldPhone.getText())){
    		isValid = false;
    		throw new FieldTypedIncorrectly("Telefono", "Este debe contener unicamente numeros sin espacios");
    	}
    	
    //Chequeo si la direccion ingresada es valida
    	if(txtFldAddress.getText().isEmpty()) {
    		isValid = false;
    		throw new EmptyFieldException("Direccion");
    	}
    	
	//Chequeo si el email ingresado es valido
    	if(txtFldEmail.getText().isEmpty()) {
    		isValid = false;
    		throw new EmptyFieldException("Email");
    	}
    	return isValid;
    }
    
    public boolean checkIfIsFreeOfCaractersOrHaveSpaces(String x) {
    	boolean freeOfCaracters = false;
    		for(int i = 0 ; i < x.length() ; i++) {
    			if(Character.isAlphabetic(x.charAt(i)) || Character.isWhitespace(x.charAt(i))) {
    				freeOfCaracters = true;
    			}
    		}
    	return freeOfCaracters;
    }
    
    public void cleanFields() {
    	txtFldName.clear();
    	txtFldNit.clear();
    	txtFldPhone.clear();
    	txtFldAddress.clear();
    	txtFldEmail.clear();
    }
}



