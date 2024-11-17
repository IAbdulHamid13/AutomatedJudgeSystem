package org.example.GUI.application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class Assignment_Controller extends Menu_Controller{
	@FXML
	public void openDirectory(ActionEvent e) {
		
		
		Window window = ((Node) (e.getSource())).getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(window);
		e.consume();
		
		}
	
		
	}
	
	
	
	

