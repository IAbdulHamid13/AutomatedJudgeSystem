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
    private Class<?> returnType;
    @Setter private ArrayList<Class<?>> parameterTypes;
    @Setter private boolean isAbstract;

    public AssignmentMethod(String name, Class<?> returnType, String className) {
        super();
        this.name = name;
        this.returnType = returnType;
        this.className = className;
        this.parameterTypes = new ArrayList<Class<?>>();
        this.isAbstract = false;
    }

    public void addParameter(Class<?> parameter) {
        this.parameterTypes.add(parameter);
    }

    public DynamicTest generateTest() {
        // TODO

        try{

            Class<?> c = Class.forName(className);

            Method[] methods = c.getMethods();

            if(methods != null){

                for(Method m : methods){

                    if(m.getName().equals(name) && m.getReturnType().equals(returnType) && m.getParameterTypes().equals(parameterTypes.toArray()) && Modifier.isAbstract(m.getModifiers())){

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
