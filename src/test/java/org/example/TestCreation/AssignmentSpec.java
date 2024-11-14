package org.example.TestCreation;

import java.util.ArrayList;

public class AssignmentSpec implements TestableContainer {
    private ArrayList<AssignmentJava> specFiles;

    public AssignmentSpec() {
        this.specFiles = new ArrayList<AssignmentJava>();
    }

    public AssignmentSpec(ArrayList<AssignmentJava> specFiles) {
        this.specFiles = specFiles;
    }

    public void addSpecFile(AssignmentJava specFile) {
        this.specFiles.add(specFile);
    }

    public AssignmentJava getJava(String javaName) {
        for (AssignmentJava java : specFiles) {
            if (java.getName().equals(javaName))
                return java;
        }
        return null;
    }
    
    public TestableIterator getAssignmentItemIterator() {
        return new AssignmentItemIterator(specFiles);
    }
}
