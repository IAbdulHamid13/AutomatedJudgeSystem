package org.example.TestCreation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AssignmentProperty implements Testable {
    protected String name;
    protected ItemVisibility visibility;
    protected boolean isFinal;
    protected boolean isStatic;

    public AssignmentProperty() {
        this.visibility = ItemVisibility.PUBLIC;
        this.isFinal = false;
        this.isStatic = false;
    }

    public abstract void generateTest();
}