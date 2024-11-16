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

    public AssignmentMethod(String name, String returnType, ItemVisibility visibility, String className, Boolean isFinal, Boolean isStatic) {
        super();
        this.name = name;
        this.returnType = returnType;
        this.visibility = visibility;
        this.className = "org.example.AssignmentFiles." + className;
        this.parameterTypes = new ArrayList<String>();
        this.isAbstract = false;
        this.isFinal = isFinal;
        this.isStatic = isStatic;
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
                    
                    // System.out.println("METHOD TOSTRING: " + m.toString());

                    String methodString = m.toString();

                    // if(methodString.contains("public") && visibility.equals(ItemVisibility.PUBLIC)){
                    //     System.out.println("METHOD IS PUBLIC");
                    // }
                    // else if(methodString.contains("private") && visibility.equals(ItemVisibility.PRIVATE)){
                    //     System.out.println("METHOD IS PRIVATE");
                    // }
                    // else if(methodString.contains("protected") && visibility.equals(ItemVisibility.PROTECTED)){
                    //     System.out.println("METHOD IS PROTECTED");
                    // }

                    // if(methodString.contains("final")){
                    //     System.out.println("METHOD IS FINAL");
                    // }

                    // if(methodString.contains("static")){
                    //     System.out.println("METHOD IS STATIC");
                    // }
                        
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

                    // String[] methodDetails = m.getName().split(" ");

                    // String methodName = methodDetails[1];

                    // if(modifiersEqual(methodString, "final", isFinal))
                    //     System.out.println("MODIFER FINAL FOUND " + m.toString());
                    // else
                    //     System.out.println("MODIFIER NOT FOUND " + m.toString());

                    // if(modifiersEqual(methodString, "static", isStatic))
                    //     System.out.println("MODIFER STATIC FOUND " + m.toString());
                    // else
                    //     System.out.println("MODIFIER NOT FOUND " + m.toString());
                    
                    // if(modifiersEqual2("private")){
                    //     System.out.println("PRIVACY MODICKIERS EQUAL");
                    // }

                    // if(modifiersEqual2("public")){
                    //     System.out.println("PRIVACY MODICKIERS EQUAL");
                    // }

                    // if(modifiersEqual2("protected")){
                    //     System.out.println("PRIVACY MODICKIERS EQUAL");
                    // }

                    // if(areModifiersEqual(methodString))
                    //     System.out.println("MODIFIERS EQUAL");
                    // else
                    //     System.out.println("MODIFIERS NOT EQUAL");

                    // System.out.println("\n\n");

                    if(m.getName().equals(name) && m.getReturnType().toString().equals(returnType) && parameterArrayList.equals(parameterTypes) && areModifiersEqual(methodString)){

                        return dynamicTest("Method test for " + className + "." + name + " ", () -> assertTrue(true));

                    }

                }

            }
            
            return dynamicTest("Method test for " + className + "." + name + " ", () -> assertTrue(false));

        } catch(ClassNotFoundException e){

            return dynamicTest("Method test for " + className + "." + name + " ", () -> assertTrue(false));

        }

    }

    private Boolean areModifiersEqual(String methodString){

        // System.out.println("Function entered!");

        if(isFinal && !methodString.contains("final")){
            return false;
        }
        else if(!isFinal && methodString.contains("final"))
            return false;

        if(isStatic && !methodString.contains("static")){
            return false;
        }
        else if(!isStatic && methodString.contains("static"))
            return false;
        
        // if(isFinal && methodString.contains("final"))
        //     System.out.println("It's actually final");
        
        // if(isStatic && methodString.contains("static"))
        //     System.out.println("It's actually static");

        
        if(visibility == ItemVisibility.PRIVATE && methodString.contains("private")){

            // System.out.println("Is final: " + isFinal);
            // System.out.println("Is static: " + isStatic);
            return true;
        }
        if(visibility == ItemVisibility.PUBLIC && methodString.contains("public")){

            // System.out.println("Is final: " + isFinal);
            // System.out.println("Is static: " + isStatic);
            return true;
        }
        if(visibility == ItemVisibility.PROTECTED && methodString.contains("protected")){

            // System.out.println("Is final: " + isFinal);
            // System.out.println("Is static: " + isStatic);
            return true;
        }


        return false;

    }

}
