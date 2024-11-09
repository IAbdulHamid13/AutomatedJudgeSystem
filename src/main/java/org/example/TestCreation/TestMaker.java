package org.example.TestCreation;

public class TestMaker {
    private TestableIterator iterator;
    @SuppressWarnings("unused")
    private AssignmentSpec spec;

    public TestMaker(AssignmentSpec spec) {
        this.spec = spec;
        this.iterator = spec.getAssignmentItemIterator();
    }

    public void createTests() {
        while (iterator.hasNext()) {
            Testable next = iterator.next();
            next.generateTest();
        }
    }
}
