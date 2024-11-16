package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AssignmentMethod extends AssignmentProperty {
    private String className;
    private String returnType;
    @Setter private ArrayList<String> parameterTypes;
    @Setter private boolean isAbstract;

    public AssignmentMethod(String name, String returnType, String className) {
        super();
        this.name = name;
        this.returnType = returnType;
        this.className = "org.example.AssignmentFiles." + className;
        this.parameterTypes = new ArrayList<String>();
        this.isAbstract = false;
    }

    public void addParameter(String parameter) {
        this.parameterTypes.add(parameter);
    }

    public DynamicTest generateTest() {
        // TODO

        try{

            Class<?> c = Class.forName(className);
            
            Method[] methods = c.getDeclaredMethods();

            if(methods != null){

                for(Method m : methods){

                    //Get parameter types and put into array

                    ArrayList<String> parameterArrayList = new ArrayList<String>();

                    for(Class<?> p : m.getParameterTypes()){

                        parameterArrayList.add(p.toString());

                    }
                    
                        
                    // System.out.println("ACTUAL RETURN TYPE: " + m.getReturnType().toString());
                    // System.out.println("GIVEN RETURN TYPE: " + returnType);
                    // System.out.println("ACTUAL NAME: " + m.getName());
                    // System.out.println("GIVEN NAME: " + name);
                    // System.out.println("ACTUAL PARAMETER TYPE: " + parameterArrayList);
                    // System.out.println("GIVEN PARAMETER TYPE: " + parameterTypes);

                    // if(m.getName().equals(name))
                    //     System.out.println("NAMES EQUAL");
                    
                    // if(parameterArrayList.equals(parameterTypes))
                    //     System.out.println("PARAMTERES EQUAL");

                    // if(m.getReturnType().toString().equals(returnType))
                    //     System.out.println("RETURN TYPE EQUAL");

                    if(m.getName().equals(name) && m.getReturnType().toString().equals(returnType) && parameterArrayList.equals(parameterTypes)){

                        return dynamicTest("Method test for " + className + "." + name + " ", () -> assertTrue(true));

                    }

                }

            }
            
            return dynamicTest("Method test for " + className + "." + name + " ", () -> assertTrue(false));

        } catch(ClassNotFoundException e){

            return dynamicTest("Method test for " + className + "." + name + " ", () -> assertTrue(false));

        }

    }
}
