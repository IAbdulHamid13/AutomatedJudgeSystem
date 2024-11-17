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
    private ItemVisibility visibility;
    private ArrayList<String> parameterTypes;

    public AssignmentConstructor(String className, ItemVisibility visibility) {
        this.className = "org.example.AssignmentFiles." + className;
        this.parameterTypes = new ArrayList<String>();
        this.visibility = visibility;
    }

    public void addParameter(String parameter) {
        this.parameterTypes.add(parameter);
    }

    public DynamicTest generateTest() {

        try{

            Class<?> c = Class.forName(className);
            
            String properName = visibility.toString().toLowerCase() + " " + className +"(";

            for(int i = 0;i < parameterTypes.size();i++){

                String p = parameterTypes.get(i);

                if(p.equals("int")){
                    
                    properName = properName + "int";
                }
                else if(p.equals("java.lang.String")){
                    
                    properName = properName + "java.lang.String";
                }
                else if(p.equals("java.lang.Boolean")){
                    
                    properName = properName + "java.lang.Boolean";
                }

                if(i != parameterTypes.size() - 1)
                    properName = properName + ",";

            }

            properName = properName + ")";

            Constructor<?>[] constructors = c.getDeclaredConstructors();


            for(Constructor<?> constr : constructors){

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
