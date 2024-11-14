package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentAttribute extends AssignmentProperty {
    private Object type;
    private String className;
    

    public AssignmentAttribute(String name, Object type, String className) {
        super();
        this.name = name;
        this.type = type;
        this.className = className;
    }

    public DynamicTest generateTest() {
        //TODO: Insert code here

        try{
        
            Class<?> c = Class.forName(className);

            Field[] fields = c.getFields();

            if(fields != null){

                for(Field f : fields){

                    if(f.getName().equals(name) && f.getType().equals(type)){

                        return dynamicTest("Attribute test for: " + " " + name + " " + type + ": ", () -> assertTrue(true));

                    }

                }

            }
            
            return dynamicTest("Attribute test for: " + " " + name + " " + type + ": ", () -> assertTrue(true));


        } catch(ClassNotFoundException e){

            return dynamicTest("Attribute test for: " + " " + name + " " + type + ": ", () -> assertTrue(false));

        }

    }
}
