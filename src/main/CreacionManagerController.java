package main;

import java.io.IOException;

import customException.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import model.Manager;
import model.Market;

public class CreacionManagerController {

    @FXML
    private TextField txtFldName;

    @FXML
    private TextField txtFldAddress;

    @FXML
    private TextField txtFldID;

    @FXML
    private TextField txtFldPassword;
   
    @FXML
    private Button btnCrearManager;
    
    @FXML
    public void createManager(ActionEvent event) throws IOException{
    	Manager marketManager = null;
    	if(validateManagerData() != null) {
    		marketManager = validateManagerData();
    	
	    	Parent root = FXMLLoader.load(getClass().getResource("CreacionMarket.fxml"));
	    	Scene rootScene = new Scene(root);
	    	//This line gets the Stage information
	    	Stage window = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    	
	    	window.setScene(rootScene);
	    	CreacionMarketController cmc = new CreacionMarketController(marketManager);
	    	window.show();
    	}
    }
    	
    public Manager validateManagerData() {
    	Manager m =  null;
    	String name;
		String address;
		int id;
		String password;
    	try {
    		
    		m = new Manager( (txtFldName.getText()), (Integer) (Integer.parseInt(txtFldID.getText())), txtFldPassword.getText(), txtFldAddress.getText());
    		if(txtFldName.getText().isEmpty()) {
    			throw new NotFoundException();
    		}else {
    			name = txtFldName.getText();
    		}
    		
    		if(txtFldAddress.getText().isEmpty()) {
    			throw new NotFoundException();
    		}else {
    			address = txtFldAddress.getText();
    		}
    		
    		if(txtFldID.getText().isEmpty() || !checkIdWithCaracters(txtFldID.getText())) {
    			throw new NotFoundException();
    		}else {
    			try {
    				id = (int) Integer.parseInt(txtFldID.getText());
    			}catch(NumberFormatException e) {
    				e.printStackTrace();
    			} 
    		}
    		
    		if(txtFldPassword.getText() == null ||  checkInvalidPassword(txtFldPassword.getText()) ) {
					throw new IncorrectPassWordException(m);
    		}else {
    			password = txtFldPassword.getText();
    		}
    	
    	}catch(NotFoundException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
			alert.setContentText("Por favor llene los campos debidamente");
			alert.showAndWait();
    	}catch(IncorrectPassWordException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
			alert.setContentText("La Contrase�a debe contener al menos un numero");
			alert.showAndWait();
    	}
    	
    	return m;
    }
    
    public boolean checkInvalidPassword(String password) {
		boolean flag = true;
		for(int i = 0; i < password.length() ; i++ ) {
			if(Character.isDigit(password.charAt(i))) {
				flag = false;
			}
		}
		if(flag == true) {
			return flag;
		}
		return flag;
	}
    
    public boolean checkIdWithCaracters(String id) {
    	boolean valid = true;
    		for(int i = 0 ; i < id.length() ; i++) {
    			if(Character.isAlphabetic(id.charAt(i)) || Character.isWhitespace(id.charAt(i))) {
    				valid = false;
    			}
    		}
    	return valid;
    }

}
