package org.example.TestCreation;

import java.util.List;

public class AssignmentItemIterator implements TestableIterator {
    private List<AssignmentJava> items;
    private int current;

    public AssignmentItemIterator(List<AssignmentJava> items) {
        this.items = items;
        this.current = 0;
    }

    public AssignmentJava next() {
        if (!hasNext())
            return null;
        
        AssignmentJava next = items.get(current++);
        return next;
    }

    public boolean hasNext() {
        return (current < items.size());
    }
}
