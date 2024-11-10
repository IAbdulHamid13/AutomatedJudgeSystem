package org.example.TestCreation;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AssignmentMethod extends AssignmentProperty {
    private String returnType;
    @Setter private ArrayList<String> parameterTypes;
    @Setter private boolean isAbstract;

    public AssignmentMethod(String name, String returnType) {
        super();
        this.name = name;
        this.returnType = returnType;
        this.parameterTypes = new ArrayList<String>();
        this.isAbstract = false;
    }

    public void addParameter(String parameter) {
        this.parameterTypes.add(parameter);
    }

    public void generateTest() {
        // TODO
    }
}
