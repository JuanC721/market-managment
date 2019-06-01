package main;

import java.util.InputMismatchException;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Label lblWelcome;

    @FXML
    private TextField txtFldUserName;

    @FXML
    private TextField txtFldPassword;
    
    @FXML
    void ingresarInfoAdmin(ActionEvent event) {
    	try {
    		if(validateInfoAdmin()) {
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
    		
    	}
    	
    }
    
    public boolean validateInfoAdmin() throws EmptyFieldException, Exception, IncorrectPassWordException{
    	boolean valid = true;
    	//Chequeo si el ID ingresado es valido
    		if(txtFldUserName.getText().isEmpty()) {
    			valid = false;
    			throw new EmptyFieldException("ID", "El usuario es el ID del manager");
    		}else if( !(txtFldUserName.getText().equals(Main.getMarket().getManager().getName())) ) {
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
    	
    }

}