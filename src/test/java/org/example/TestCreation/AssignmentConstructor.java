package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentConstructor implements Testable {
    private String className;
    private ArrayList<String> parameterTypes;

    public AssignmentConstructor(String className) {
        this.className = "org.example.AssignmentFiles." + className;
        this.parameterTypes = new ArrayList<String>();
    }

    public void addParameter(String parameter) {
        this.parameterTypes.add(parameter);
    }

    public DynamicTest generateTest() {
        // TODO

        try{

            Class<?> c = Class.forName(className);
            
            // ArrayList<Class<?>> parameterClassList = new ArrayList<Class<?>>();
            String properName = "public " + className +"(";

            for(int i = 0;i < parameterTypes.size();i++){

                String p = parameterTypes.get(i);

                if(p.equals("int")){
                    // parameterClassList.add(Integer.class);
                    properName = properName + "int";
                }
                else if(p.equals("String")){
                    // parameterClassList.add(String.class);
                    properName = properName + "String";
                }
                else if(p.equals("Boolean")){
                    // parameterClassList.add(Boolean.class);
                    properName = properName + "Boolean";
                }

                if(i != parameterTypes.size() - 1)
                    properName = properName + ",";

            }

            properName = properName + ")";

            // System.out.println("parameterClassList TOSTRING: " + parameterClassList.toString());
            // System.out.println("parameterTypes TOSTRING: " + parameterTypes);

            Constructor<?>[] constructors = c.getConstructors();


            for(Constructor<?> constr : constructors){

                // System.out.println("ACTUAL CONSTRUCTOR NAME: " + constr.toString());
                // System.out.println("GIVEN CONSTRUCTOR NAME: " + properName);

                //Since the name contrains parameter types we can return test based on soley this

                if(constr.toString().equals(properName))
                    return dynamicTest("Constructor test for " + className + " ", () -> assertTrue(true));

            }

            return dynamicTest("Constructor test for " + className + " ", () -> assertTrue(false));

        } catch(ClassNotFoundException e){
            
            return dynamicTest("Constructor test for " + className + " ", () -> assertTrue(false));

        }
    }
}