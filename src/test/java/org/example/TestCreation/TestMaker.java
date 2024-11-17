package org.example.TestCreation;

import java.util.ArrayList;

import org.junit.jupiter.api.DynamicTest;

public class TestMaker {
    private TestableIterator iterator;
    @SuppressWarnings("unused")
    private AssignmentSpec spec;

    public TestMaker(AssignmentSpec spec) {
        this.spec = spec;
        this.iterator = spec.getAssignmentItemIterator();
    }

    public ArrayList<ArrayList<DynamicTest>> createTests() {

        ArrayList<ArrayList<DynamicTest>> tests = new ArrayList<ArrayList<DynamicTest>>();

        while (iterator.hasNext()) {
            AssignmentJava next = iterator.next();
            tests.add(next.generateTests());
        }

        return tests;
    }
}
