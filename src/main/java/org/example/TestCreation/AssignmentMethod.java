package org.example.TestCreation;

import java.util.ArrayList;

public class AssignmentMethod implements Testable{
    private String name;
    private String returnType;
    private ArrayList<String> parameterTypes;
    private ArrayList<AccessFlags> accessFlags;

    public AssignmentMethod(String name, String returnType) {
        this.name = name;
        this.returnType = returnType;
        this.parameterTypes = new ArrayList<String>();
        this.accessFlags = new ArrayList<AccessFlags>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public void addParameter(String parameter) {
        this.parameterTypes.add(parameter);
    }

    public void addAccessFlag(AccessFlags flag) {
        this.accessFlags.add(flag);
    }

    public String getName() {
        return name;
    }

    public String getReturnType() {
        return returnType;
    }

    public ArrayList<String> getParameters() {
        return parameterTypes;
    }

    public ArrayList<AccessFlags> getAccessFlags() {
        return accessFlags;
    }

    public void generateTest() {
        // TODO
    }
}
