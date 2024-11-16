package org.example.Views;

import java.util.ArrayList;

import org.example.TestCreation.AssignmentAttribute;
import org.example.TestCreation.AssignmentJava;
import org.example.TestCreation.AssignmentMethod;
import org.junit.jupiter.api.DynamicTest;

public class App {
    public static void main(String[] args) {

        //Testing attribute tests

        AssignmentJava assignment = new AssignmentJava("Calculator");

        AssignmentAttribute att1 = new AssignmentAttribute("brand", "class java.lang.String", "Calculator");
        AssignmentAttribute att2 = new AssignmentAttribute("model", "int", "Calculator");
        AssignmentAttribute att3 = new AssignmentAttribute("isScientific", "class java.lang.Boolean", "Calculator");

        AssignmentMethod meth1 = new AssignmentMethod("add", "int", "Calculator");
        AssignmentMethod meth2 = new AssignmentMethod("getBrand", "class java.lang.String", "Calculator");
        AssignmentMethod meth3 = new AssignmentMethod("isScientific", "class java.lang.Boolean", "Calculator");

        meth1.addParameter("int");
        meth1.addParameter("int");

        assignment.addProperty(att1);
        assignment.addProperty(att2);
        assignment.addProperty(att3);

        assignment.addProperty(meth1);
        assignment.addProperty(meth2);
        assignment.addProperty(meth3);

        ArrayList<DynamicTest> tests = assignment.generateTests();

        for(int i = 1;i < tests.size();i++){

            DynamicTest t = tests.get(i);

            System.out.println("Name: " + t.getDisplayName());

            try{

                t.getExecutable().execute();
                System.out.println("Test case passed!\n");

            } catch(Throwable throwable){

                System.out.println("Test case failed!\n");

            }

        }

    }
}