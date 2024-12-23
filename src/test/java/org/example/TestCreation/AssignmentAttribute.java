package org.example.TestCreation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentAttribute extends AssignmentProperty {
    @Setter private String type;
    @Setter private String className;

    public AssignmentAttribute(){
        super();
        this.marksAwarded = 0;
    }
    

    public AssignmentAttribute(String name, String type, String className, ItemVisibility visibility, Boolean isFinal, Boolean isStatic, int marksWorth) {
        super();
        this.name = name;
        this.type = type;
        this.className = "org.example.AssignmentFiles." + className;
        this.visibility = visibility;
        this.isFinal = isFinal;
        this.isStatic = isStatic;
        this.marksWorth = marksWorth;
        this.marksAwarded = 0;
    }

    public DynamicTest generateTest() {

        try{
            
            Class<?> c = Class.forName(className);

            Field[] fields = c.getDeclaredFields();

            if(fields != null){

                for(Field f : fields){

                    String fieldType = f.getType().toString();

                    String modifierString = Modifier.toString(f.getModifiers());

                    if(f.getName().equals(name) && fieldType.equals(type) && areModifiersEqual(modifierString)){

                        marksAwarded = marksWorth;

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

        Boolean isStringFinal = modifierString.contains("final");
        Boolean isStringStatic = modifierString.contains("static");

        if(isStringFinal == isFinal && isStringStatic == isStatic){

            if(visibility == ItemVisibility.PRIVATE && modifierString.contains("private")){

                return true;
            }
            if(visibility == ItemVisibility.PUBLIC && modifierString.contains("public")){
    
                return true;

            }
            if(visibility == ItemVisibility.PROTECTED && modifierString.contains("protected")){
    
                return true;

            }

        }
    
    
        return false;

    }
}
