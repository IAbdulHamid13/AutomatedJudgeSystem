package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentClass extends AssignmentProperty{

    @Setter private String className;

    public AssignmentClass(){
        super();
        this.marksAwarded = 0;
    }

    public AssignmentClass(String className, int marksWorth){

        this.className = "org.example.AssignmentFiles." + className;
        this.marksWorth = marksWorth;
        this.marksAwarded = 0;

    }
    
    @Override
    public String getName(){
        return className;
    }

    @SuppressWarnings("unused")
    @Override
    public DynamicTest generateTest() {

        try{

            Class<?> c = Class.forName(className);

            marksAwarded = marksWorth;

            return dynamicTest("Class test for: " + className, () -> assertTrue(true));

        } catch(ClassNotFoundException e){

            return dynamicTest("Class test for: " + className, () -> assertTrue(false));

        }
        
    }
    
}
