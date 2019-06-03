package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Market;

public class Main extends Application{ 
	
	
	private static Market market;
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root;
		if(market.getManager() == null) {
			root = FXMLLoader.load(getClass().getResource("CreacionManager.fxml"));
		}else {
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		market = new Market();
		launch(args);
	}

	public static Market getMarket() {
		return market;
	}
}
