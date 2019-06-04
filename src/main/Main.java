package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Market;

public class Main extends Application{ 
	
	
	private static Market market;
	private static FileManager x;
	@Override
	public void start(Stage stage) throws Exception {
		init();
		Parent root;
		if(market.getManager() == null) {
			root = FXMLLoader.load(getClass().getResource("CreacionManager.fxml"));
		}else {
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(e -> closeProgram());
	}
	
	public static void main(String[] args) {
		market = new Market();
		x = new FileManager();
		launch(args);
	}

	public static Market getMarket() {
		return market;
	}
	public static void setMarket(Market markett) {
		market = markett;
	}
	public void closeProgram(){
		try {
			x.saveMarketData("data\\market", Main.getMarket());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init(){
		File market = new File("data\\market");
		if(market.exists()){
			System.out.println("l");
			Main.setMarket(x.loadMarketData("data\\market"));
		}
	}
}
