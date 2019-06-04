package main;

import customException.NotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Bill;
import model.Distributor;
import model.Product;

public class FacturasController {
	
	private Stage stage;
    @FXML
    private Label lblProductsOf;

    @FXML
    private TableView<Bill> listBills;

    @FXML
    void goBackAdministratorMenu(ActionEvent event) {
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

    @FXML
    void refresh(ActionEvent event) {
    	Main.getMarket().actualInventory();
    	listBills.getItems().clear();
//    	COLUMNA DE CODIGO
    	TableColumn<Bill, String> codeColumn = new TableColumn<>("Codigo");
    	codeColumn.setMinWidth(100);
    	codeColumn.setCellValueFactory(new PropertyValueFactory<Bill, String>("code"));
//   	COLUMNA DE PRECIO
    	TableColumn<Bill, String> priceColumn = new TableColumn<>("Precio");
    	priceColumn.setMinWidth(100);
    	priceColumn.setCellValueFactory(new PropertyValueFactory<Bill, String>("cost"));  	
    	listBills.getColumns().addAll(codeColumn,priceColumn);
    	Main.getMarket().preorder();
    	ObservableList<Bill> x = FXCollections.observableArrayList(Main.getMarket().getBillsToShow());
    	listBills.setItems(x);
    }

    @FXML
    void searchBillsByCode(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the code of the distributor to find");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	generic.getChildren().add(genericText);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){
				try {
					int find = Main.getMarket().searchingBillByCode(genericText.getText());
	    			ObservableList<Bill> x = FXCollections.observableArrayList(Main.getMarket().getBillsToShow().get(find));
	    			listBills.setItems(x);
	    			genericStage.close();
				} catch (NotFoundException e) {
					Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Error");
		    		alert.setHeaderText(null);
					alert.setContentText("el recibo no esta en la lista");
					alert.showAndWait();
					e.printStackTrace();
					e.printStackTrace();
				}
   			
    		}
    	
    	});
    }

    @FXML
    void showBillDetail(ActionEvent event) {

    }

    @FXML
    void sortBillsByCode(ActionEvent event) {
    	Main.getMarket().sortBillsByCode();
    	ObservableList<Bill> x = FXCollections.observableArrayList(Main.getMarket().getBillsToShow());
    	listBills.setItems(x);
    }
    @FXML
    void sortBillsByPrice(ActionEvent event) {
    	Main.getMarket().sortBillsByPrice();
    	ObservableList<Bill> x = FXCollections.observableArrayList(Main.getMarket().getBillsToShow());
    	listBills.setItems(x);
    }

}
