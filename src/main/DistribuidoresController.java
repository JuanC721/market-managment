package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class DistribuidoresController {

    @FXML
    private Label lblProductsOf;

    @FXML
    private TableView<?> listDistributors;
    
    @FXML
    void addDistributor(ActionEvent event) {

    }
    
    @FXML
    void goBackAdministratorMenu(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(("MenuAdministrator.fxml")));
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
    void showDistributorSelectedProducts(ActionEvent event) {
    	
    }
    
    @FXML
    void searchDistributor(ActionEvent event) {

    }

    @FXML
    void sortDistributorsByCode(ActionEvent event) {

    }

    @FXML
    void sortDistributorsByCompany(ActionEvent event) {

    }

}
