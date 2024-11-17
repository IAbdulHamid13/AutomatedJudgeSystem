package org.example.TestCreation;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AssignmentProperty implements Testable {
    protected String name;
    protected ItemVisibility visibility;
    protected boolean isFinal;
    protected boolean isStatic;
    protected int marksWorth;
    protected int marksAwarded;

    public AssignmentProperty() {
        this.visibility = ItemVisibility.PUBLIC;
        this.isFinal = false;
        this.isStatic = false;
        this.marksAwarded = 0;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getMarksWorth(){
        return marksWorth;
    }

    @Override
    public int getMarksAwarded(){
        return marksAwarded;
    }

    public abstract DynamicTest generateTest();
}