package org.example.GUI.application;


import java.io.IOException;

import org.example.TestCreation.AssignmentJava;
import org.example.TestCreation.AssignmentSpec;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Specification_Controller extends Menu_Controller{
	@FXML
	private TextField nameSubmit;

	@FXML
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	public String javaName;
	public String attributeName;
	public void submitJavaName(ActionEvent a) throws IOException {
		//java file name is acepted from input and to be passed to assignmentJava
		javaName = nameSubmit.getText();
		System.out.println(javaName);

		root = FXMLLoader.load(getClass().getResource("/Java_Specification.fxml"));
		stage = (Stage)((Node)a.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void createObject(){

		AssignmentSpec j1 = new AssignmentSpec();

	}	
	
	
	
}
