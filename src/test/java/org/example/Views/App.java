package org.example.Views;

import java.util.ArrayList;

import org.example.TestCreation.AssignmentAttribute;
import org.example.TestCreation.AssignmentConstructor;
import org.example.TestCreation.AssignmentJava;
import org.example.TestCreation.AssignmentMethod;
import org.example.TestCreation.ItemVisibility;
import org.junit.jupiter.api.DynamicTest;

public class App {
    public static void main(String[] args) {

        //Testing attribute tests

        AssignmentJava assignment = new AssignmentJava("Calculator");

        AssignmentAttribute att1 = new AssignmentAttribute("brand", "class java.lang.String", "Calculator", ItemVisibility.PRIVATE, false, false);
        AssignmentAttribute att2 = new AssignmentAttribute("model", "int", "Calculator", ItemVisibility.PUBLIC, false, false);
        AssignmentAttribute att3 = new AssignmentAttribute("isScientific", "class java.lang.Boolean", "Calculator", ItemVisibility.PRIVATE, false, true);
        AssignmentAttribute att4 = new AssignmentAttribute("pizza", "int", "Calculator", ItemVisibility.PRIVATE, true, true);

        AssignmentMethod meth1 = new AssignmentMethod("add", "int", ItemVisibility.PUBLIC, "Calculator", false, false, false);
        AssignmentMethod meth2 = new AssignmentMethod("getBrand", "class java.lang.String", ItemVisibility.PRIVATE, "Calculator", true, false, false);
        AssignmentMethod meth3 = new AssignmentMethod("isScientific", "class java.lang.Boolean", ItemVisibility.PROTECTED,"Calculator", false, true, false);
        AssignmentMethod meth4 = new AssignmentMethod("useless", "void", ItemVisibility.PUBLIC, "Calculator", false, false, false);

        AssignmentMethod meth5 = new AssignmentMethod("doSomething", "int", ItemVisibility.PUBLIC,"MyInterface", false, false, false);

        AssignmentMethod meth6 = new AssignmentMethod("abstractMethod", "void", ItemVisibility.PUBLIC,"MyAbstractClass", false, false, true);
        AssignmentMethod meth7 = new AssignmentMethod("noneAbstractMethod", "void", ItemVisibility.PUBLIC,"MyAbstractClass", false, false, false);

        AssignmentConstructor constr1 = new AssignmentConstructor("Calculator", ItemVisibility.PUBLIC);
        AssignmentConstructor constr2 = new AssignmentConstructor("Calculator", ItemVisibility.PROTECTED);
        AssignmentConstructor constr3 = new AssignmentConstructor("Calculator", ItemVisibility.PRIVATE);

        // AssignmentClass class1 = new AssignmentClass("Calculator");

        

        constr2.addParameter("java.lang.String");
        constr3.addParameter("java.lang.Boolean");

        meth1.addParameter("int");
        meth1.addParameter("int");

        meth1.addTestParameter("int", "1");
        meth1.addTestParameter("int", "1");

        meth1.setExpectedValue(2);

        meth2.addParameter("class java.lang.String");
        meth3.addParameter("class java.lang.Boolean");

        assignment.addProperty(att1);
        assignment.addProperty(att2);
        assignment.addProperty(att3);
        assignment.addProperty(att4);

        assignment.addProperty(meth1);
        assignment.addProperty(meth2);
        assignment.addProperty(meth3);
        assignment.addProperty(meth4);

        assignment.addProperty(meth5);

        assignment.addProperty(meth6);
        assignment.addProperty(meth7);

        assignment.addProperty(constr1);
        assignment.addProperty(constr2);
        assignment.addProperty(constr3);

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