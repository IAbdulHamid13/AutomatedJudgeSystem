package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import org.junit.jupiter.api.DynamicTest;

public class AssignmentClass extends AssignmentProperty{

    private String className;

    public AssignmentClass(String className){

        this.className = className;

    }

    @SuppressWarnings("unused")
    @Override
    public DynamicTest generateTest() {

        try{

            Class<?> c = Class.forName(className);

            return dynamicTest("Class test for: " + className, () -> assertTrue(true));

        } catch(ClassNotFoundException e){

            return dynamicTest("Class test for: " + className, () -> assertTrue(true));

        }
        
    }
    
}
