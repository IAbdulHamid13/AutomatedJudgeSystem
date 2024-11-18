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

public class Method_Specification extends Menu_Controller{


    @FXML
    private TextField methodName;
    @FXML
    private TextField methodReturnType;
    @FXML
    private TextField methodClassName;
    @FXML
    private TextField methodVisibility;
    @FXML
    private TextField methodMark;
    @FXML
    private CheckBox methodStatic;
    @FXML
    private CheckBox methodFinal;
    @FXML
    private CheckBox methodAbstract;
    
    
    private Stage stage;
	private Scene scene;
	private Parent root;

    public void submitMethod(ActionEvent e){
		String name = methodName.getText();
        String type = methodReturnType.getText();
        String className = methodClassName.getText();
        String visibility = methodVisibility.getText();
        int mark = Integer.parseInt(methodMark.getText());

        String isFinal = "false";
        String isAbstract = "false";
        String isStatic = "false";

        if(methodFinal.isEmpty()){
            isFinal = "false";
        }
        else
            isFinal = "true";
        
        if(methodAbstract.isEmpty())
            isAbstract = "true";
        else
            isAbstract = "false";
        if(methodStatic.isEmpty())
            isStatic = "true";
        else
            isStatic = "false";

    }

    public void cancelMethod(ActionEvent e){
        
    }

    
}
