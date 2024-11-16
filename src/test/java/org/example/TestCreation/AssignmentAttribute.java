package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentAttribute extends AssignmentProperty {
    private String type;
    private String className;
    

    public AssignmentAttribute(String name, String type, String className) {
        super();
        this.name = name;
        this.type = type;
        this.className = "org.example.AssignmentFiles." + className;
    }

    public DynamicTest generateTest() {
        //TODO: Insert code here

        try{
            
            Class<?> c = Class.forName(className);

            Field[] fields = c.getDeclaredFields();
            // Method[] methods = c.getMethods();

            // System.out.println("CLASS NAME: " + c.getName());

            // System.out.println("NUMBER OF FIELDS: " + fields.length);

            if(fields != null){

                for(Field f : fields){

                    String fieldType = f.getType().toString();
                        
                    // System.out.println("ACTUAL TYPE: " + fieldType);
                    // System.out.println("GIVEN TYPE: " + type);
                    // System.out.println("ACTUAL NAME: " + f.getName());
                    // System.out.println("GIVEN NAME: " + name);

                    // System.out.println("FIELD TOSTRING: " + f.toString());


                    if(f.getName().equals(name) && fieldType.equals(type)){

                        


                        return dynamicTest("Attribute test for: " + " " + type + " " + name, () -> assertTrue(true));

                    }

                }

            }
            
            return dynamicTest("Attribute test for: " + " " + type + " " + name, () -> assertTrue(false));


        } catch(ClassNotFoundException e){

            return dynamicTest("Attribute test for: " + " " + type + " " + name, () -> assertTrue(false));

        }

    }
}
