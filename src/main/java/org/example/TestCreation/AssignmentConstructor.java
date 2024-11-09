package org.example.TestCreation;

import java.util.ArrayList;

public class AssignmentConstructor implements Testable {
    private ArrayList<String> parameterTypes;

    public AssignmentConstructor() {
        this.parameterTypes = new ArrayList<String>();
    }

    public void addParameter(String parameter) {
        this.parameterTypes.add(parameter);
    }

    public ArrayList<String> getParameters() {
        return parameterTypes;
    }

    public void generateTest() {
        // TODO
    }
}
