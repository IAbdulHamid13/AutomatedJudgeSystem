package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentAttribute extends AssignmentProperty {
    private String type;
    private String className;
    

    public AssignmentAttribute(String name, String type, String className, ItemVisibility visibility, Boolean isFinal, Boolean isStatic) {
        super();
        this.name = name;
        this.type = type;
        this.className = "org.example.AssignmentFiles." + className;
        this.visibility = visibility;
        this.isFinal = isFinal;
        this.isStatic = isStatic;
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

                    String modifierString = Modifier.toString(f.getModifiers());

                    // System.out.println("FIELD MODIFIERS for " + f.getName() + ": " + modifierString);

                    // System.err.println("Are modifiers equal?" + areModifiersEqual(modifierString));

                    // if(modifierString.contains("private") && visibility == ItemVisibility.PRIVATE)
                    //     System.out.println("ITS PRIVATE");

                    //  System.out.println("\n\n");

                    if(f.getName().equals(name) && fieldType.equals(type) && areModifiersEqual(modifierString)){

                        return dynamicTest("Attribute test for: " + " " + type + " " + name, () -> assertTrue(true));

                    }

                }

            }
            
            return dynamicTest("Attribute test for: " + " " + type + " " + name, () -> assertTrue(false));


        } catch(ClassNotFoundException e){

            return dynamicTest("Attribute test for: " + " " + type + " " + name, () -> assertTrue(false));

        }

    }

    private Boolean areModifiersEqual(String modifierString){

        // String s = visibility.toString();

        // if(isStatic)
        //     s = s + " static";
        // if(isFinal)
        //     s = s + " final";
        
        // System.out.println("S IS EQUAL TO THIS: " + s);

        Boolean isStringFinal = modifierString.contains("final");
        Boolean isStringStatic = modifierString.contains("static");

        if(isStringFinal == isFinal && isStringStatic == isStatic){

            if(visibility == ItemVisibility.PRIVATE && modifierString.contains("private")){

                // System.out.println("Is final: " + isFinal);
                // System.out.println("Is static: " + isStatic);
                return true;
            }
            if(visibility == ItemVisibility.PUBLIC && modifierString.contains("public")){
    
                // System.out.println("Is final: " + isFinal);
                // System.out.println("Is static: " + isStatic);
                return true;
            }
            if(visibility == ItemVisibility.PROTECTED && modifierString.contains("protected")){
    
                // System.out.println("Is final: " + isFinal);
                // System.out.println("Is static: " + isStatic);
                return true;
            }

        }
    
    
        return false;

        // System.out.println("Function entered!");

        // if(isFinal && !modifierString.contains("final")){
        //     return false;
        // }
        // else if(!isFinal && modifierString.contains("final"))
        //     return false;

        // if(isStatic && !modifierString.contains("static")){
        //     return false;
        // }
        // else if(!isStatic && modifierString.contains("static"))
        //     return false;
        
        // System.out.println("Function made it this far...");
        
        // if(visibility == ItemVisibility.PRIVATE && modifierString.contains("private")){

        //     System.out.println("Is final: " + isFinal);
        //     System.out.println("Is static: " + isStatic);
        //     return true;
        // }
        // if(visibility == ItemVisibility.PUBLIC && modifierString.contains("public")){

        //     System.out.println("Is final: " + isFinal);
        //     System.out.println("Is static: " + isStatic);
        //     return true;
        // }
        // if(visibility == ItemVisibility.PROTECTED && modifierString.contains("protected")){

        //     System.out.println("Is final: " + isFinal);
        //     System.out.println("Is static: " + isStatic);
        //     return true;
        // }


        // return false;

    }
}
