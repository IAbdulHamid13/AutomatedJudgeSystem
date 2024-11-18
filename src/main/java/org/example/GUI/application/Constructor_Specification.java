package org.example.GUI.application;

import java.io.IOException;

import com.itextpdf.forms.form.element.CheckBox;

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

public class Constructor_Specification extends Menu_Controller{


    
    @FXML
    private TextField constructorClassType;
    @FXML
    private TextField constructorClassName;
    @FXML
    private TextField constructorVisibility;
    @FXML
    private TextField constructorMark;
    
    
    private Stage stage;
	private Scene scene;
	private Parent root;

    public void submitConstructor(ActionEvent e){
		
        String type = constructorClassType.getText();
        String className = constructorClassName.getText();
        String visibility = constructorVisibility.getText();
        int mark = Integer.parseInt(constructorMark.getText());


    }

    public void cancelConstruct(ActionEvent e){
        
    }

    
}
