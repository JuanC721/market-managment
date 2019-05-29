package main;

import customException.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    
    private Market m;

    @FXML
    void createManager(ActionEvent event) {
    	Manager marketManager = null;
    	if(validateManagerData() != null) {
    		marketManager = validateManagerData();
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
    				id = (int) Integer.parseInt(txtFldName.getText());
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
			alert.setContentText("La Contraseña debe contener al menos un numero");
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
