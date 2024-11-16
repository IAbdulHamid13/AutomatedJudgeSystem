package org.example.Views;

import java.util.ArrayList;

import org.example.TestCreation.AssignmentAttribute;
import org.example.TestCreation.AssignmentJava;
import org.junit.jupiter.api.DynamicTest;

public class App {
    public static void main(String[] args) {

        //Testing attribute tests

        AssignmentJava assignment = new AssignmentJava("Calculator");

        AssignmentAttribute att1 = new AssignmentAttribute("brand", "class java.lang.String", "Calculator");
        AssignmentAttribute att2 = new AssignmentAttribute("model", "int", "Calculator");
        AssignmentAttribute att3 = new AssignmentAttribute("isScientific", "class java.lang.Boolean", "Calculator");

        assignment.addProperty(att1);
        assignment.addProperty(att2);
        assignment.addProperty(att3);

        ArrayList<DynamicTest> tests = assignment.generateTests();

        for(int i = 1;i < tests.size();i++){

            DynamicTest t = tests.get(i);

            System.out.println("Name: " + t.getDisplayName());

            try{

                t.getExecutable().execute();
                System.out.println("Test case passed!");

            } catch(Throwable throwable){

                System.out.println("Test case failed!");

            }

        }

    }
}