package org.example.SpecCreation;

import org.example.TestCreation.AssignmentSpec;

public class AssignmentSpecBuilder {
    private AssignmentSpec spec;
    private SpecBuildingStrategy strategy;
    private enum Strategies {
        USER, FILE
    }

    public AssignmentSpecBuilder() {
        this.spec = new AssignmentSpec();
    }

    public void setStrategy(Strategies selection) {
        switch (selection) {
            case USER:
                this.strategy = new UserSpecCreation(spec);
                break;
            case FILE:
                this.strategy = new FileParseSpecCreation(spec);
                break;
        }
    }
}
