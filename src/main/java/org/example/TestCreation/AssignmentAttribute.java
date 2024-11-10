package org.example.TestCreation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentAttribute extends AssignmentProperty {
    private String type;

    public AssignmentAttribute(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }

    public void generateTest() {
        //TODO: Insert code here
    }
}
