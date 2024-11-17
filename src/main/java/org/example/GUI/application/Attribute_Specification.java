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
    private String attributeName;
    @FXML
    private String attributeClassType;
    @FXML
    private String attributeClassName;
    @FXML
    private String attributeVisibility;
    @FXML
    private int attributeMark;
    @FXML
    private CheckBox attributeFinal;
    @FXML
    private CheckBox attributeAbstract;
    
    private Stage stage;
	private Scene scene;
	private Parent root;

    public void submitAttribute(ActionEvent e){

    }

    public void cancelAttribute(ActionEvent e){
        
    }

    
}
