package main;

import customException.EmptyFieldException;
import customException.FieldTypedIncorrectly;
import customException.IncorrectPassWordException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Manager;

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
    
    private Manager manager;
    
    @FXML
    void createManager(ActionEvent event) {
    	try {
    		if(validateManagerData()) {
    			initializateManager();
        		try {
        			FXMLLoader loader = new FXMLLoader();
        			loader.setLocation(getClass().getResource(("CreacionMarket.fxml")));
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
    	}catch(IncorrectPassWordException e) {
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
    
    public void initializateManager() {
    	String name = txtFldName.getText();
    	int id = Integer.parseInt(txtFldID.getText());
    	String password = txtFldPassword.getText();
    	String address = txtFldAddress.getText();
    	manager = new Manager(name, id, password, address);
    	Main.getMarket().setManager(manager);
    }
    
    public boolean validateManagerData() throws EmptyFieldException, IncorrectPassWordException, FieldTypedIncorrectly{
    	boolean isValid = true;
    		//Chequeo de si el nombre del manager es valido
	    		if(txtFldName.getText().isEmpty()) {
	    			isValid = false;
	    			throw new EmptyFieldException("Nombre");
	    		}
	    		
    		//Chequeo de si la direccion del manager es valido
	    		if(txtFldAddress.getText().isEmpty()) {
	    			isValid = false;
	    			throw new EmptyFieldException("Direccion");
	    		}
    		
    		//Chequeo de si el ID del manager es valido
	    		if(txtFldID.getText().isEmpty()) {
	    			isValid = false;
	    			throw new EmptyFieldException("ID");
	    		}else if(checkIfHaveCaracters(txtFldID.getText())) {
	    			isValid = false;
	    			throw new FieldTypedIncorrectly("ID", "El ID debe contener solamente numeros.");
	    		}
	    		
    		//Chequeo de si la contraseña del manager es valido
	    		if(txtFldPassword.getText().isEmpty()) {
	    			isValid = false;
	    			throw new EmptyFieldException("Contraseña");
	    		}else if( !checkIfHaveAtLeastOneNumber(txtFldPassword.getText()) ){
	    			isValid = false;
	    			throw new IncorrectPassWordException(IncorrectPassWordException.WRONG_FORMAT);
	    		}
	    		
    		
    	return isValid;
    }
    
    public boolean checkIfHaveAtLeastOneNumber(String password) {
		boolean flag = false;
		for(int i = 0; i < password.length() ; i++ ) {
			if(Character.isDigit(password.charAt(i))) {
				flag = true;
			}
		}
		if(flag == true) {
			return flag;
		}
		return flag;
	}
    
    public boolean checkIfHaveCaracters(String id) {
    	boolean valid = false;
    		for(int i = 0 ; i < id.length() ; i++) {
    			if(Character.isAlphabetic(id.charAt(i)) || Character.isWhitespace(id.charAt(i))) {
    				valid = true;
    			}
    		}
    	return valid;
    }
    
    public void cleanFields() {
    	txtFldName.clear();
    	txtFldAddress.clear();
    	txtFldID.clear();
    	txtFldPassword.clear();
    }
}
