package org.example.TestCreation;

import java.util.ArrayList;

public class AssignmentAttribute implements Testable{
    private String name;
    private String type;
    private ArrayList<AccessFlags> accessFlags;

    public AssignmentAttribute(String name, String type) {
        this.name = name;
        this.type = type;
        this.accessFlags = new ArrayList<AccessFlags>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addAccessFlag(AccessFlags flag) {
        this.accessFlags.add(flag);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public ArrayList<AccessFlags> getAccessFlags() {
        return accessFlags;
    }

    public void generateTest() {
        // TODO
    }
}
