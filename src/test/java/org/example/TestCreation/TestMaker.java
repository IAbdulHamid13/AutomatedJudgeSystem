package org.example.TestCreation;

import java.util.ArrayList;

import org.junit.jupiter.api.DynamicTest;

import lombok.Setter;

public class TestMaker {
    private TestableIterator iterator;
    
    @Setter private AssignmentSpec spec;

    public TestMaker(){
        this.iterator = spec.getAssignmentItemIterator();
    }

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
