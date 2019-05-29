package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Manager;
import model.Market;
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
    
    private Market market;
    
    private Manager manager;
    
    @FXML
    public void createMarket(ActionEvent event) {
    		
    }
    
    public CreacionMarketController(Manager manager) {
    	this.manager = manager;
    }
    
    public void validateMarketData() {
    	String marketName;
    	int nit;
    	int phone;
    	String address;
    	String email;
    	try {
	    	if(txtFldName.getText().isEmpty()) {
	    		throw new NotFoundException();
	    	}else {
	    		marketName = txtFldName.getText();
	    	}
	    	
	    	if(txtFldNit.getText().isEmpty() || !doesStringIsFreeOfCaracters(txtFldNit.getText())) {
	    		throw new NotFoundException();
	    	}else {
	    		nit = Integer.parseInt(txtFldNit.getText());
	    	}
	    	
	    	if(txtFldPhone.getText().isEmpty() || !doesStringIsFreeOfCaracters(txtFldNit.getText())) {
	    		throw new NotFoundException();
	    	}else {
	    		phone = Integer.parseInt(txtFldPhone.getText());
	    	}
	    	
	    	if(txtFldAddress.getText().isEmpty()) {
	    		throw new NotFoundException();
	    	}else {
	    		address = txtFldAddress.getText();
	    	}
	    	
	    	if(txtFldEmail.getText().isEmpty()) {
	    		throw new NotFoundException();
	    	}else {
	    		email = txtFldEmail.getText();
	    	}		
    	}catch(NotFoundException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
			alert.setContentText("Por favor llene los campos debidamente\n\tEn los campos: Nit y Telefono , solo deben ir caracteres numericos");
			alert.showAndWait();
    	}
    }
    
    public boolean doesStringIsFreeOfCaracters(String x) {
    	boolean freeOfCaracters = true;
    		for(int i = 0 ; i < x.length() ; i++) {
    			if(Character.isAlphabetic(x.charAt(i)) || Character.isWhitespace(x.charAt(i))) {
    				freeOfCaracters = false;
    			}
    		}
    	return freeOfCaracters;
    }
    
    
}