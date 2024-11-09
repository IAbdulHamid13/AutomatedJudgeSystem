package org.example.SpecCreation;

import org.example.TestCreation.AssignmentSpec;

public abstract class SpecBuildingStrategy {
    private AssignmentSpec spec;

    public SpecBuildingStrategy(AssignmentSpec spec) {
        this.spec = spec;
    }
}
