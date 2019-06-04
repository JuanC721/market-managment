package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import threads.CircleThread;

public class MenuAdministratorController {
	
	@FXML
	private Circle blueCircle;
	
	@FXML
	private AnchorPane circleAnchorPane;
	
	private CircleThread ct;
	
	private int speed;
	
	public MenuAdministratorController() {
		ct = new CircleThread(this);
		blueCircle = new Circle();
		circleAnchorPane = new AnchorPane();
    	ct.start();
    	speed = 3;
	}

    @FXML
    void exit(ActionEvent event) {
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
    }

    @FXML
    void openBillsWindow(ActionEvent event) {
    	try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(("Facturas.fxml")));
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
    void openDistributorWindow(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(("Distribuidores.fxml")));
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
    void openInventoryWindow(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(("Inventory.fxml")));
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
    
    public void moveBlueCircle() {
    	blueCircle.setLayoutX(blueCircle.getLayoutX()+speed);
    	if(blueCircle.getLayoutX() >= 410) {
    		speed = speed*-1;
    	}else if(blueCircle.getLayoutX() <= 0) {
    		speed = speed*-1;
    	}
    }

}
