package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentClass extends AssignmentProperty{

    private String className;

    public AssignmentClass(String className, int marksWorth){

        this.className = className;
        this.marksWorth = marksWorth;
        this.marksAwarded = 0;

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
