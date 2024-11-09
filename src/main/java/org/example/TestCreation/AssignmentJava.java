package org.example.TestCreation;

import java.util.ArrayList;

public class AssignmentJava implements Testable {
    private String name;
    private ArrayList<Testable> properties;

    public AssignmentJava(String name) {
        this.name = name;
        this.properties = new ArrayList<Testable>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProperty(Testable property) {
        this.properties.add(property);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Testable> getProperties() {
        return properties;
    }

    public void generateTest() {
        // TODO
    }
}
