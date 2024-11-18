package org.example.GUI.application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Menu_Controller {
	@FXML
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void menuCreateSpecifications(ActionEvent e) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("/Main_Specification.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void menuUploadAssignments(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Main_UploadFile.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void menuGenerateReport(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Main_Report.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void menuHelp(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Main_Help.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void menuExit(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Main_Exit.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.close();
	}
}
