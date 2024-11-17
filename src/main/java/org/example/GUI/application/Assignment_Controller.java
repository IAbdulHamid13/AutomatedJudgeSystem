package org.example.GUI.application;

import java.io.File;

import org.example.FileExtraction.ZipFileExtractor;
import org.example.FileExtraction.ZipExtractor;
import org.example.FileExtraction.ZipFileFilter;

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
			//add a method to pass zip to testing
			ZipFileFilter zipTester = new ZipFileFilter();
			Boolean isZipFile = zipTester.accept(file.getName());
			if (isZipFile){
				try {
					System.out.println("Processing ZIP file: " + file.getName());
					handleZipFile(file); // Call helper method for ZIP extraction - it tries for a grouped and then single 
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Error processing file: " + ex.getMessage());
				}
			}
			else{
				System.out.println("Unsupported file type: " + file.getName());
				System.out.println("Unsupported file type selected: " + file.getName());
				return;       //add error handling here if you like
			}
			

		}

	
		private void handleZipFile(File zipFile) throws Exception {
			Boolean passed = false;
			try{
				ZipFileExtractor zipExtractor = new ZipFileExtractor(null, 4096);  // Use to extract the grouped file (zip containing zips) (change parameters, just used random values)
				zipExtractor.extract(zipFile.getAbsolutePath(), "src\\main\\java\\org\\example\\AssignmentFiles");
				passed = true;
			}catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Error processing file: " + ex.getMessage());   //catch so that it doesn't return
			}
			if(!passed){
				ZipExtractor zipExtractor = new ZipExtractor("src\\main\\java\\org\\example\\AssignmentFiles", 4096);   //if not passed, ie exception 
				zipExtractor.extractZipFile(zipFile.getAbsolutePath());                             // for single submission 
			}
		}

		
	}
	
	
	
	

