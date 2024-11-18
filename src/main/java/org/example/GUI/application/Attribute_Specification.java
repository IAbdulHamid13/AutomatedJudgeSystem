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

public class Attribute_Specification extends Menu_Controller{


    @FXML
    private TextField attributeName;
    @FXML
    private TextField attributeClassType;
    @FXML
    private TextField attributeClassName;
    @FXML
    private TextField attributeVisibility;
    @FXML
    private TextField attributeMark;
    @FXML
    private CheckBox attributeFinal;
    @FXML
    private CheckBox attributeAbstract;
    
    private Stage stage;
	private Scene scene;
	private Parent root;

    public void submitAttribute(ActionEvent e){
		String name = attributeName.getText();
        String type = attributeClassType.getText();
        String className = attributeClassName.getText();
        String visibility = attributeVisibility.getText();
        int mark = Integer.parseInt(attributeMark.getText());

        String isFinal = "false";
        String isAbstract = "false";

        if(attributeFinal.isEmpty()){
            isFinal = "false";
        }
        else
            isFinal = "true";
        
        if(attributeAbstract.isEmpty())
            isAbstract = "true";
        else
            isAbstract = "false";

    }

    public void cancelAttribute(ActionEvent e){
        
    }

    
}
