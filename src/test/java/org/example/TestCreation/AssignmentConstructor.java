package org.example.TestCreation;

import java.util.ArrayList;

import org.junit.jupiter.api.DynamicTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentConstructor implements Testable {
    private ArrayList<String> parameterTypes;

    public AssignmentConstructor() {
        this.parameterTypes = new ArrayList<String>();
    }

    public void addParameter(String parameter) {
        this.parameterTypes.add(parameter);
    }

    public DynamicTest generateTest() {
        // TODO
        return null;
    }
}
