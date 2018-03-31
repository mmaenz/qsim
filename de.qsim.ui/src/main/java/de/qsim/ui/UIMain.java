package de.qsim.ui;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			URL resource = this.getClass().getResource("/fxml/UI.fxml");
			System.out.println(resource.getPath());
			Parent root = FXMLLoader.load(resource);
			Scene scene = new Scene(root, 1000, 600);
    
	        primaryStage.setTitle("FXML Welcome");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} 
	}
}