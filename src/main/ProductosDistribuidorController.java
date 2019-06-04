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
import model.Category;
import model.Costumer;
import model.Distributor;
import model.Product;

public class ProductosDistribuidorController {

	private Stage stage;
    @FXML
    private Label lblProductsOf;

    @FXML
    private TableView<Product> listProducts;
    
    private boolean flag = true;
    @FXML
    void addProductToInventory(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Escoja");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	Button nuevoAlDistribuidor = new Button();
    	nuevoAlDistribuidor.setText("agregar un nuevo producto al distribuidor");
    	Button existenteAlDistribuidor = new Button();
    	existenteAlDistribuidor.setText("pedir mas productos");
    	generic.getChildren().addAll(nuevoAlDistribuidor,existenteAlDistribuidor);
    	genericStage.setScene(scene);
    	genericStage.show();
    	nuevoAlDistribuidor.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){
    			Stage genericStage = new Stage();
    	    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	    	genericStage.initOwner(stage);
    	    	VBox generic = new VBox(20);
    	    	Scene scene = new Scene(generic, 300, 400);
    	    	Label sing = new Label();
    	    	sing.setText("Introduce los datos del nuevo producto");
    	    	generic.getChildren().add(sing);
    	    	generic.setAlignment(Pos.CENTER);
    	    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	    	genericText.setText("nombre del producto");
    	    	javafx.scene.control.TextField genericText1 = new javafx.scene.control.TextField();
    	    	genericText1.setText("descripcion del producto");
    	    	javafx.scene.control.TextField genericText2 = new javafx.scene.control.TextField();
    	    	genericText2.setText("codigo del producto");
    	    	javafx.scene.control.TextField genericText3 = new javafx.scene.control.TextField();
    	    	genericText3.setText("precio del producto");
    	    	javafx.scene.control.TextField genericText4 = new javafx.scene.control.TextField();
    	    	genericText4.setText("cantidad del producto");
    	    	generic.getChildren().addAll(genericText,genericText1,genericText2,genericText3,genericText4);
    	    	Button ok = new Button();
    	    	ok.setText("OK");
    	    	generic.getChildren().add(ok);
    	    	genericStage.setScene(scene);
    	    	genericStage.show();
    	    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    	    		@Override
    	    		public void handle(ActionEvent arg0){  	
    	    			Product nuevo = new Product(Category.AlimentosParaBebes , genericText.getText(), genericText1.getText(), Integer.parseInt(genericText2.getText()), Double.parseDouble(genericText3.getText()), Integer.parseInt(genericText4.getText()));
    	    			DistribuidoresController.getDistributorToShow().addProduct(nuevo);
    	    			Main.getMarket().newProduct(DistribuidoresController.getDistributorToShow());
    	    			genericStage.close();
    	    		}
    	    	
    	    	});
    		}
    		});
    	existenteAlDistribuidor.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent arg0){
    			Stage genericStage = new Stage();
    	    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	    	genericStage.initOwner(stage);
    	    	VBox generic = new VBox(20);
    	    	Scene scene = new Scene(generic, 300, 200);
    	    	Label sing = new Label();
    	    	sing.setText("Introduce the code of product");
    	    	generic.getChildren().add(sing);
    	    	generic.setAlignment(Pos.CENTER);
    	    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	    	genericText.setText("codigo del producto");
    	    	javafx.scene.control.TextField genericText1 = new javafx.scene.control.TextField();
    	    	genericText1.setText("cantidad del pedido");
    	    	generic.getChildren().addAll(genericText,genericText1);
    	    	Button ok = new Button();
    	    	ok.setText("OK");
    	    	generic.getChildren().add(ok);
    	    	genericStage.setScene(scene);
    	    	genericStage.show();
    	    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    	    		@Override
    	    		public void handle(ActionEvent arg0){
    	    			try {
							Main.getMarket().getMoreProducts(DistribuidoresController.getDistributorToShow(), Integer.parseInt(genericText.getText()), Integer.parseInt(genericText1.getText()));
						} catch (NumberFormatException | NotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    	    		}
    	    	
    	    	});
    		}
    		});
    	
    }

    @FXML
    void goBackDistributors(ActionEvent event) {
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
    void refresh(ActionEvent event) {
    	if(flag) {
    		init();
    	}else{
    		ObservableList<Product> x = FXCollections.observableArrayList(DistribuidoresController.getDistributorToShow().getProductsToShow());
        	listProducts.setItems(x);
    	}
    }
    public void init() {
    	listProducts.getItems().clear();
//    	COLUMNA DE NOMBRE
    	TableColumn<Product, String> nameColumn = new TableColumn<>("Nombre");
    	nameColumn.setMinWidth(100);
    	nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
//    	COLUMNA DE CODIGO
    	TableColumn<Product, String> codeColumn = new TableColumn<>("Codigo");
    	codeColumn.setMinWidth(100);
    	codeColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("code"));
//   	COLUMNA DE PRECIO
    	TableColumn<Product, String> priceColumn = new TableColumn<>("Precio");
    	priceColumn.setMinWidth(100);
    	priceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
//    	COLUMNA DE CANTIDAD
    	TableColumn<Product, String> quantityColumn = new TableColumn<>("Cantidad");
    	quantityColumn.setMinWidth(100);
    	quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));
    	listProducts.getColumns().addAll(nameColumn,codeColumn,priceColumn,quantityColumn);
    	ObservableList<Product> x = FXCollections.observableArrayList(DistribuidoresController.getDistributorToShow().getProductsToShow());
    	listProducts.setItems(x);
    }
    

}
