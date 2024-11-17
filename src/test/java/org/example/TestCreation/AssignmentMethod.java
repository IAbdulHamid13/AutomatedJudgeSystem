package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AssignmentMethod extends AssignmentProperty {
    private String className;
    private String returnType;
    @Setter private Object expectedValue;
    @Setter private ArrayList<String> parameterTypes;
    @Setter private boolean isAbstract;
    private ArrayList<Object> testParams;

    public AssignmentMethod(String name, String returnType, ItemVisibility visibility, String className, Boolean isFinal, Boolean isStatic, Boolean isAbstract, int marks) {
        super();
        this.name = name;
        this.returnType = returnType;
        this.visibility = visibility;
        this.className = "org.example.AssignmentFiles." + className;
        this.parameterTypes = new ArrayList<String>();
        this.isAbstract = isAbstract;
        this.isFinal = isFinal;
        this.isStatic = isStatic;
        testParams = new ArrayList<Object>();
        this.marks = marks;
    }

    public void setExpectedValue(String type, String value){

        if(type.equals("int")){

            //Initialise int var

            expectedValue = (int)expectedValue;

            expectedValue = Integer.valueOf(value);

        }
        else if(type.equals("String")){

            //Add var to trueParams list

            expectedValue = (String)expectedValue;

            expectedValue = value;
            
        }
        else if(type.equals("Boolean")){

            //Initialise Boolean var

            expectedValue = (Boolean)expectedValue;

            expectedValue = Boolean.valueOf(value);
            
        }

    }

    public void addParameter(String parameter) {
        this.parameterTypes.add(parameter);
    }

    public void addTestParameter(String type, String value){

        if(type.equals("int")){

            //Initialise int var

            int var = Integer.valueOf(value);

            //Add var to trueParams list

            testParams.add(var);

        }
        else if(type.equals("String")){

            //Add var to trueParams list

            testParams.add(value);
            
        }
        else if(type.equals("Boolean")){

            //Initialise Boolean var

            Boolean var = Boolean.valueOf(value);

            //Add var to trueParams list

            testParams.add(var);
            
        }

    }

    public DynamicTest generateTest() {

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

                    String methodString = m.toString();

                    if(m.getName().equals(name) && m.getReturnType().toString().equals(returnType) && parameterArrayList.equals(parameterTypes) && areModifiersEqual(methodString)){

                        if(testParams.size() != 0 && expectedValue != null){
                            try{

                                //Get instance to invoke method

                                Object instance = c.getDeclaredConstructor().newInstance();

                                //If invoking the method returns the expected value, pass test case

                                if(m.invoke(instance, testParams.toArray()).equals(expectedValue))
                                    return dynamicTest("Method test for " + className + "." + name + " ", () -> assertTrue(true));

                            }catch(Exception e){

                                return dynamicTest("Method test for " + className + "." + name + " ", () -> assertTrue(false));

                            }

                            

                        }
                        else
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
        
        if(isAbstract && !methodString.contains("abstract"))
            return false;
        else if(!isAbstract && methodString.contains("abstract"))
            return false;

        
        if(visibility == ItemVisibility.PRIVATE && methodString.contains("private")){

            return true;

        }
        if(visibility == ItemVisibility.PUBLIC && methodString.contains("public")){
            
            return true;

        }
        if(visibility == ItemVisibility.PROTECTED && methodString.contains("protected")){

            return true;
        }


        return false;

    }

}
