package com.app.team19;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Risk Map Editor");
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add("application.css");
			
			
			MenuBar menuBar = new MenuBar();
			
			Menu menu= new Menu("File");
			
			MenuItem fileOpenMenuItem = new MenuItem("Open");
			menu.getItems().add(fileOpenMenuItem);
			fileOpenMenuItem.setOnAction(new FileOpenButtonListner());
	        
			menu.getItems().add(new MenuItem("Save"));
	        menu.getItems().add(new SeparatorMenuItem());
	        
	        MenuItem exitMenuItem = new MenuItem("Exit");
	        menu.getItems().add(exitMenuItem);
	        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
	        
	        menuBar.getMenus().add(menu);
	        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	        
	        root.getChildren().add(menuBar);
	    
	        primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
