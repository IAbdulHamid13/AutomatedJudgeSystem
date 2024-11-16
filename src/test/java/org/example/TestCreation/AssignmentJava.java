package org.example.TestCreation;

import java.util.ArrayList;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentJava implements Testable {
    private JavaType javaType;
    private String name;
    private boolean isAbstract;
    private boolean isPublic;
    private ArrayList<Testable> properties;

    public static enum JavaType {
        CLASS, INTERFACE
    }

    public AssignmentJava(String name) {
        this.javaType = JavaType.CLASS;
        this.name = name;
        this.properties = new ArrayList<Testable>();
        // this.properties.add(new AssignmentConstructor()); //why does this exist??
        this.isAbstract = false;
        this.isPublic = true;
    }

    public void addProperty(Testable property) {
        this.properties.add(property);
    }

    public AssignmentMethod getMethod(String methodName) {
        for (Testable prop : properties) {
            if (prop instanceof AssignmentMethod) {
                AssignmentMethod method = (AssignmentMethod) prop;
                if (method.getName().equals(methodName))
                    return method;
            }
        }
        return null;
    }

    public AssignmentAttribute getAttribute(String attrName) {
        for (Testable prop : properties) {
            if (prop instanceof AssignmentAttribute) {
                AssignmentAttribute attr = (AssignmentAttribute) prop;
                if (attr.getName().equals(attrName))
                    return attr;
            }
        }
        return null;
    }

    public AssignmentProperty getProperty(String propertyName) {
        for (Testable prop : properties) {
            if (prop instanceof AssignmentProperty) {
                AssignmentProperty property = (AssignmentProperty) prop;
                if (property.getName().equals(propertyName))
                    return property;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AssignmentJava) {
            AssignmentJava other = (AssignmentJava) obj;
            if (this.name.equals(other.getName()))
                return true;
            return false;
        }
        throw new IllegalArgumentException();
    }

    public DynamicTest generateTest() {
        // TODO: Good luck anwar :)

        ArrayList<DynamicTest> tests = new ArrayList<DynamicTest>();

        for (Testable item : properties) {
            
            tests.add(item.generateTest());

        }

        return null;
    }

    public ArrayList<DynamicTest> generateTests() {
        // TODO: Good luck anwar :)

        ArrayList<DynamicTest> tests = new ArrayList<DynamicTest>();

        for (Testable item : properties) {
            
            tests.add(item.generateTest());

        }

        return tests;
    }
}