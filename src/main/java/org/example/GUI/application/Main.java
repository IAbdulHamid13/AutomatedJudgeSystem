package org.example.GUI.application;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.input.KeyCombination;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.paint.Color;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {

		try {
	
			Parent root = FXMLLoader.load(Main.class.getResource("/Main_Specification.fxml"));
			Scene scene = new Scene(root);

			Image icon = new Image("/sky_lemur_logo_ai.jpeg");
			stage.getIcons().add(icon);

			stage.setTitle("Assignment Marking Program");

			stage.setFullScreen(true);
			stage.setFullScreenExitHint("THERE IS NO ESCAPE >:( , unless you press esc");

			stage.setScene(scene);

			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
