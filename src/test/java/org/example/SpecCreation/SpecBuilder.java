package org.example.SpecCreation;

import java.util.ArrayList;

import org.example.TestCreation.*;

public class SpecBuilder {
    private AssignmentSpec spec;

    public SpecBuilder() {
        this.spec = new AssignmentSpec();
    }

    public void reset() {
        this.spec = new AssignmentSpec();
    }

    // Add to AssignmentJavas
    public void addJava(String javaName) {
        AssignmentJava java = new AssignmentJava(javaName);
        spec.addSpecFile(java);
    }

    public void setJavaType(String javaName, String javaType) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            java.setJavaType(AssignmentJava.JavaType.valueOf(javaType.toUpperCase()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void setJavaAbstract(String javaName, boolean value) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            java.setAbstract(value);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    
    public void setJavaPublic(String javaName, boolean value) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            java.setPublic(value);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void addAttribute(String javaName, String attrName, String type, String className) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            AssignmentAttribute attr = new AssignmentAttribute(attrName, type, className);
            java.addProperty(attr);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void addMethod(String javaName, String methodName, String returnType, ItemVisibility visibility, String className, Boolean isFinal, Boolean isStatic) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            AssignmentMethod method = new AssignmentMethod(methodName, returnType, visibility, className, isFinal, isStatic);
            java.addProperty(method);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void addConstructor(String javaName, String className) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            AssignmentConstructor constructor = new AssignmentConstructor(className);
            java.addProperty(constructor);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    // Add to AssignmentJava.properties
    public void setPropertyVisibility(String javaName, String propertyName, String visibility) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            AssignmentProperty property = java.getProperty(propertyName);
            property.setVisibility(ItemVisibility.valueOf(visibility.toUpperCase()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void setPropertyFinal(String javaName, String propertyName, boolean value) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            AssignmentProperty property = java.getProperty(propertyName);
            property.setFinal(value);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void setPropertyStatic(String javaName, String propertyName, boolean value) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            AssignmentProperty property = java.getProperty(propertyName);
            property.setStatic(value);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    // Add to AssignmentMethods
    public void setMethodParameters(String javaName, String methodName, ArrayList<String> parameterTypes) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            AssignmentMethod method = java.getMethod(methodName);
            method.setParameterTypes(parameterTypes);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void setMethodAbstract(String javaName, String methodName, boolean value) {
        try {
            AssignmentJava java = spec.getJava(javaName);
            AssignmentMethod method = java.getMethod(methodName);
            method.setAbstract(value);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    // Add to AssignmentConstructors
    public void setConstructorParameters(AssignmentConstructor constructor, ArrayList<String> parameterTypes) {
        try {
            constructor.setParameterTypes(parameterTypes);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    
    public AssignmentSpec getSpec() {
        return spec;
    }
}